package com.example.SpringApp.controller;

import com.example.SpringApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
