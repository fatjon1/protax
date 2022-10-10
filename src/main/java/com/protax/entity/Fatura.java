package com.protax.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.protax.entity.fshati.FshatiLagjia;
import com.protax.entity.njesia.Njesia;
import com.protax.entity.viti.Viti;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Entity
@Table(name = "fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taks_id")
    private Long kodFature;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kod_pronari", referencedColumnName = "kod_pronari")
    private Banore pronari;
    @JsonIgnore
    @Column(name = "nid")
    private String nid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "viti", referencedColumnName = "kod_viti")
    private Viti viti;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "njesia_fkey", referencedColumnName = "kod_njesie")
    private Njesia njesia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fshati_fkey", referencedColumnName = "kod_lagjie")
    private FshatiLagjia fshati_lagjia;
   /* @Column(name = "adresa")
    @Nullable
    private int adresa_fkey;*/
    @Column(name = "detyrimi")
    private Double detyrimi;
    @Column(name = "likujduar")
    private Double likujduar;
    @Column(name = "diferenca")
    private Double diferenca;
    @Column(name = "gjeneruar")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date gjeneruar;
    @Column(name = "perditesuar")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date perditesuar;
    @Column(name = "active")
    private boolean paguar;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "fature_fkey")
    @JsonManagedReference
    private Collection<Detyrime> detyrime = new ArrayList<>();


}
