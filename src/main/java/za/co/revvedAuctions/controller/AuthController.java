//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.controller;

import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.dto.VerifyUserDto;
import com.example.demo.model.User;
import com.example.demo.responses.LoginResponse;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/auth"})
@RestController
public class AuthController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping({"/signup"})
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = this.authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping({"/login"})
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = this.authenticationService.authenticate(loginUserDto);
        String jwtToken = this.jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, this.jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping({"/verify"})
    public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDto verifyUserDto) {
        try {
            this.authenticationService.verifyUser(verifyUserDto);
            return ResponseEntity.ok("Account verified successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping({"/resend"})
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try {
            this.authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code sent");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
