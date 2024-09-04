package com.example.vision.repository;

import com.example.vision.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsers extends JpaRepository<Users, Integer> {
}