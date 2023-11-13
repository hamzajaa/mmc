package com.thefivebytes.mmc.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String Nom;
    @Column(name = "Description")
    private String Description;
    //@Column(name = "sponsorType")
   // private SponsorType sponsorType;
}
