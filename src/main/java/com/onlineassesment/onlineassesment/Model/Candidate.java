package com.onlineassesment.onlineassesment.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidate {
    
     
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String gender;
    private String phone;
    @Column(name="score")
    private Integer score;
}
