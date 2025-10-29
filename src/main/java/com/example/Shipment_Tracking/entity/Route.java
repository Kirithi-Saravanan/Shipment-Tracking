package com.example.Shipment_Tracking.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Route {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String startPoint;
    private String endPoint;
    private double distance;
}
