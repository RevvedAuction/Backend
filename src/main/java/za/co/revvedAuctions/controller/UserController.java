package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = service.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Read user by ID
    @GetMapping("/read/{userId}")
    public ResponseEntity<User> read(@PathVariable("userId") Long userId) {
        User user = service.read(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update user
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> update(@PathVariable("userId") Long userId, @RequestBody User updatedUser) {
        User existingUser = service.read(userId);
        if (existingUser != null) {
            User savedUser = service.update(updatedUser);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> delete(@PathVariable("userId") Long userId) {
        boolean deleted = service.delete(userId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all users
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}

