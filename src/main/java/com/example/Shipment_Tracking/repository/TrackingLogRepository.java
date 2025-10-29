package com.example.Shipment_Tracking.repository;
import com.example.Shipment_Tracking.entity.TrackingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface TrackingLogRepository extends JpaRepository<TrackingLog,Long>{
    List<TrackingLog> findByShipmentId(Long shipmentId);
}
