package com.protax.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.protax.entity.fshati.FshatiLagjia;
import com.protax.entity.njesia.Njesia;
import com.protax.entity.taksat.Taksat;
import com.protax.entity.viti.Viti;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Data
@Table(name = "detyrime")
public class Detyrime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "detyrim_id")
    private Long detyrim_id;
    @Column(name = "pronar_fkey")
    @JsonIgnore
    private Long pronar_fkey;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "njesia_fkey", referencedColumnName = "kod_njesie")
    private Njesia njesia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fshati_fkey", referencedColumnName = "kod_lagjie")
    private FshatiLagjia fshati_lagjia;
    @Column(name = "siperfaqe", nullable = true)
    private Double siperfaqe;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taksat_fkey", referencedColumnName = "taksat_id")
    private Taksat taksa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "viti_fkey", referencedColumnName = "kod_viti")
    private Viti viti;
    @Column(name = "vlera_tax")
    private Double vlera_tax;
    @Column(name = "detyrimi")
    private Double detyrimi;
    @Column(name = "prona_id")
    @JsonIgnore
    private Integer prona_id;
    @ManyToOne
    @JoinColumn(name = "fature_fkey", referencedColumnName = "taks_id")
    @JsonBackReference
    private Fatura fature_fkey;
    @Column(name = "muaj")
    private Integer muaj;
    @Column(name = "viti_ndertimit")
    @JsonIgnore
    private Integer viti_ndertimit;
    @Column(name = "prona_nr")
    @JsonIgnore
    private Integer prona_nr;
    @Column(name = "perditesuar")
    private Date perditesuar;
    @Column(name = "perditesuar_nga")
    @JsonIgnore
    private Long perditesuar_nga;
    @Column(name = "adresa_prones")
    private String adresa_prones;
    @Column(name = "gjeneruar")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date gjeneruar;





}
