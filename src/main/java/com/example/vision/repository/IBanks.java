package com.example.vision.repository;

import com.example.vision.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBanks extends JpaRepository<Banks, Integer> {
}