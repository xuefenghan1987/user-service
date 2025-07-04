package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserAuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;
}
