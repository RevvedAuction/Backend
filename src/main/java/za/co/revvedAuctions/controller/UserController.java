package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.dto.LoginRequest;
import za.co.revvedAuctions.dto.UserDTO;
import za.co.revvedAuctions.payload.LoginMessage;
import za.co.revvedAuctions.service.implementation.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getUserID(),
                user.getUserType(),
                user.getUserFullName(),
                user.getUserEmail(),
                user.getUserPassword()
        );
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = new User.Builder()
                .setUserType(userDTO.getUserType())
                .setUserFullName(userDTO.getUserFullName())
                .setUserEmail(userDTO.getUserEmail())
                .setUserPassword(userDTO.getUserPassword())
                .build();

        User savedUser = userService.create(user);
        return new ResponseEntity<>(mapToDTO(savedUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = new User.Builder()
                .setUserEmail(loginRequest.getUserEmail())
                .setUserPassword(loginRequest.getUserPassword())
                .build();

        LoginMessage loginMessage = userService.loginUser(loginRequest);
        return ResponseEntity.ok(loginMessage);
    }




}
