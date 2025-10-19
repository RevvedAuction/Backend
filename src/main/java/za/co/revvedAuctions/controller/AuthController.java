package za.co.revvedAuctions.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.co.revvedAuctions.dto.LoginRequest;
import za.co.revvedAuctions.dto.RegisterDTO;
import za.co.revvedAuctions.dto.VerifyUserDTO;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.payload.LoginMessage;
import za.co.revvedAuctions.service.implementation.AuthService;
import za.co.revvedAuctions.service.implementation.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JWTService jwtService;
    private final AuthService authService;

    public AuthController(JWTService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
        User registeredUser = authService.register(registerDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest) {
        try {
            User authenticatedUser = authService.authenticate(loginRequest);
            String jwtToken = jwtService.generateToken(authenticatedUser);
            LoginMessage response = new LoginMessage(jwtToken, jwtService.getExpirationTime());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }


    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDTO verifyUserDTO) {
        try {
            authService.verifyUser(verifyUserDTO);
            return ResponseEntity.ok("Account verified successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try {
            authService.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code sent");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
