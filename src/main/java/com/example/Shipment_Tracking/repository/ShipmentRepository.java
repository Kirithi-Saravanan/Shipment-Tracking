package com.example.Shipment_Tracking.repository;

import com.example.Shipment_Tracking.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    
}
