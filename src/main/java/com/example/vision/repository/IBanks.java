package com.example.vision.repository;

import com.example.vision.entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBanks extends JpaRepository<Banks, Integer> {

    @Query(value = "SELECT * FROM banks WHERE user_email = ?1", nativeQuery = true)
    List<Banks> findBanksByEmail(String user_email);

    @Query(value = "SELECT SUM(credit_score) FROM banks WHERE user_email = ?1", nativeQuery = true)
    Long totalCredits(String user_email);

}
