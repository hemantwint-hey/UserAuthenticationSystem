package org.example.userauthenticationsystem.services;

import org.example.userauthenticationsystem.model.User;
import org.example.userauthenticationsystem.payload.UserDTO;
import org.example.userauthenticationsystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements  UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::maptoDTO)
                .collect(Collectors.toList());
    }

    // create user
    @Override
    public UserDTO createUser(User user) {
        User savedUser=userRepository.save(user);
        return maptoDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found with id:"+ id));

        return maptoDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, User user) {
        User existingUser=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found with id:"+ id));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        User updatedUser=userRepository.save(existingUser);

        return maptoDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found please enter the valid id"+ id));
        userRepository.delete(user);
    }

    private UserDTO maptoDTO(User user){
        UserDTO dto=new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
