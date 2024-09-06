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

    @Column(name = "bank_code", nullable = false)
    private String bank_code;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "user_email", nullable = false)
    private String user_email;

    @Column(name = "credit_score", nullable = false)
    private Integer credit_score;
}
