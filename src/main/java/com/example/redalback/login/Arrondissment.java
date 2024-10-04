package com.example.redalback.login;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import org.geolatte.geom.Geometry;

import java.math.BigDecimal;

@Entity
@Data
public class Arrondissment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nbrclient;

    private BigDecimal dso_jr;
    private String imp_mdh;
    @Column(columnDefinition = "geometry")
    @JsonSerialize(using = GeometrySerializer.class)
    private Geometry geom;

}
