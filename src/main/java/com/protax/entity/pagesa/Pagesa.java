package com.protax.entity.pagesa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pagesa")
public class Pagesa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pagese_id;
    private Double vlera;
    private Long fatura_fkey;
    private LocalDateTime gjeneruar;
    private Long kod_pronari;
    private String arketari;
    private String arketariDetails;
}
