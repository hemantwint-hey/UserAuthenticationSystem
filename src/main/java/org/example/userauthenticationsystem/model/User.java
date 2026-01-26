package org.example.userauthenticationsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @NotBlank
    String name;

    @Column(unique = true, nullable = false)
    @NotBlank
    @Email(message = "Please enter the valid email")
    String email;

    @NotBlank
    String password;

}
