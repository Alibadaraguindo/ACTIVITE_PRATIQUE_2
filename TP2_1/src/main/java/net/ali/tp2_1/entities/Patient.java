package net.ali.tp2_1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.Builder;

import java.util.Date;

@Entity


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Patient {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private Date dateNaissance;
    private boolean malade;
    private int score;

}
