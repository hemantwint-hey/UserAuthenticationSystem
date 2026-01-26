package org.example.userauthenticationsystem.services;

import org.example.userauthenticationsystem.model.User;
import org.example.userauthenticationsystem.payload.AuthResponse;
import org.example.userauthenticationsystem.payload.LoginRequest;
import org.example.userauthenticationsystem.payload.RegisterRequest;
import org.example.userauthenticationsystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        // check if email is valid
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already Exist");
        }
        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);
        return new AuthResponse("User registered successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {
       User user=userRepository.findByEmail(request.getEmail())
               .orElseThrow(()-> new RuntimeException("Invalid email"));
        if(!user.getPassword().equals(request.getPassword()))throw new RuntimeException("Invalid Password");

        return new AuthResponse("Login Successful");
    }
}
