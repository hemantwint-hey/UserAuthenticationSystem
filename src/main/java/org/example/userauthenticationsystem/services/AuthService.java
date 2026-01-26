package org.example.userauthenticationsystem.services;

import org.example.userauthenticationsystem.payload.AuthResponse;
import org.example.userauthenticationsystem.payload.LoginRequest;
import org.example.userauthenticationsystem.payload.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
