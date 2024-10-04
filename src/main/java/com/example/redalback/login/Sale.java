package com.example.redalback.login;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geolatte.geom.Geometry;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String nbrclient;
    private BigDecimal dso_jr;
    private String quartier;
    private String imp_mdh;
    @Column(columnDefinition = "geometry")
    @JsonSerialize(using = GeometrySerializer.class)

    private Geometry geom;
}
