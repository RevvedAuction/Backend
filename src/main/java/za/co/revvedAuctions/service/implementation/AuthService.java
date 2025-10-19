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

    public User register(RegisterDTO input) {
        if (userRepository.findByUserEmail(input.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }

        String verificationCode = generateVerificationCode();

        User user = new User.Builder()
                .setUserFullName(input.getUserFullName())
                .setUserEmail(input.getEmail())
                .setUserPassword(passwordEncoder.encode(input.getPassword()))
                .setVerificationCode(verificationCode)
                .setVerificationCodeExpiresAt(LocalDateTime.now().plusMinutes(15))
                .setEnabled(false)
                .build();

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
        User user = userRepository.findByUserEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

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
                        <h2 style="color: #333;">Welcome to Revved Auctions!</h2>
                        <p style="font-size: 16px;">Your verification code is:</p>
                        <h3 style="background:#222;color:#fff;padding:10px;width:fit-content;">
                            """ + user.getVerificationCode() + """
                        </h3>
                        <p>This code will expire in 15 minutes.</p>
                    </body>
                </html>
                """;

        try {
            emailService.sendVerificationEmail(user.getUserEmail(), subject, htmlMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send verification email");
        }
    }

    private String generateVerificationCode() {
        int code = new Random().nextInt(900000) + 100000;
        return String.valueOf(code);
    }

    public User loadUserByEmail(String email) {
        return userRepository.findByUserEmail(email)
                .orElse(null);
    }

}
