package org.example.userauthenticationsystem.services;

import org.example.userauthenticationsystem.model.User;
import org.example.userauthenticationsystem.payload.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO createUser(User user);
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id,User user);
    void deleteUser(Long id);

}
