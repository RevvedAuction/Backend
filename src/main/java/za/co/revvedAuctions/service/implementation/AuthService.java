package za.co.revvedAuctions.service.implementation;

import jakarta.mail.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.dto.LoginRequest;
import za.co.revvedAuctions.dto.RegisterDTO;
import za.co.revvedAuctions.dto.VerifyUserDTO;
import za.co.revvedAuctions.repository.UserRepository;
import za.co.revvedAuctions.service.EmailService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            EmailService emailService
    ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public User signup(RegisterDTO input) {
        if (userRepository.findByUserEmail(input.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }

        User user = new User();
        user.setUserName(input.getUsername());
        user.setUserEmail(input.getEmail());
        user.setUserPassword(passwordEncoder.encode(input.getPassword()));
        user.setVerificationCode(generateVerificationCode());
        user.setVerificationCodeExpiresAt(LocalDateTime.now().plusMinutes(15));
        user.setEnabled(false);

        userRepository.save(user);
        sendVerificationEmail(user);
        return user;
    }


    public User authenticate(LoginRequest input) {
        User user = userRepository.findByUserEmail(input.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.isEnabled()) {
            throw new RuntimeException("Account not verified. Please verify your account.");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUserEmail(),
                        input.getUserPassword()
                )
        );

        return user;
    }

    public void verifyUser(VerifyUserDTO input) {
        Optional<User> optionalUser = userRepository.findByUserEmail(input.getEmail());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = optionalUser.get();

        if (user.getVerificationCodeExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Verification code has expired");
        }

        if (!user.getVerificationCode().equals(input.getVerificationCode())) {
            throw new RuntimeException("Invalid verification code");
        }

        user.setEnabled(true);
        user.setVerificationCode(null);
        user.setVerificationCodeExpiresAt(null);
        userRepository.save(user);
    }

    public void resendVerificationCode(String email) {
        User user = userRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.isEnabled()) {
            throw new RuntimeException("Account is already verified");
        }

        user.setVerificationCode(generateVerificationCode());
        user.setVerificationCodeExpiresAt(LocalDateTime.now().plusHours(1));
        userRepository.save(user);

        sendVerificationEmail(user);
    }

    private void sendVerificationEmail(User user) {
        String subject = "Account Verification";
        String htmlMessage = """
                <html>
                  <body style="font-family: Arial, sans-serif;">
                    <div style="background-color: #f5f5f5; padding: 20px;">
                      <h2 style="color: #333;">Welcome to Revved Auctions!</h2>
                      <p style="font-size: 16px;">Enter the verification code below to continue:</p>
