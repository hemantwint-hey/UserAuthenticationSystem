package org.example.userauthenticationsystem.controller;

import jakarta.validation.Valid;
import org.example.userauthenticationsystem.model.User;
import org.example.userauthenticationsystem.payload.UserDTO;
import org.example.userauthenticationsystem.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody User user){
        UserDTO createdUser=userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get All User
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get User  by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id )
    {
            UserDTO user = userService.getUserById(id);
            return ResponseEntity.ok(user);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id,
            @RequestBody User user
    ){
        UserDTO updateUser=userService.updateUser(id,user);
        return ResponseEntity.ok(updateUser);
    }

    // Delete User

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
