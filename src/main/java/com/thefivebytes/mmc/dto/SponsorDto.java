package com.thefivebytes.mmc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SponsorDto {
    private Long id;
    private String Nom;
    private String Description;
}
