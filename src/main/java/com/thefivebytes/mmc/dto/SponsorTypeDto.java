package com.thefivebytes.mmc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SponsorTypeDto {
    private Long id;
    private String Nom_du_type;
    private String Description;
}
