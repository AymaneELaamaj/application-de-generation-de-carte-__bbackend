package com.example.redalback.login;

import lombok.Data;

@Data
public class ArrondissementResponse {
    private Long id;
    private String name;
    private String geom; // GeoJSON en tant que chaîne

    // Constructeurs, getters et setters
}

