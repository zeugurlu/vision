package com.example.vision.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
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
