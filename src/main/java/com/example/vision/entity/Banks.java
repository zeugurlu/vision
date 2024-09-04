package com.example.vision.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Banks {
    @Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", unique = true, nullable = false)
    private Integer user_id;

    @Column(name = "user_email", unique = true, nullable = false)
    private String user_email;

    @Column(name = "credit_score", nullable = false)
    private Integer credit_score;
}
