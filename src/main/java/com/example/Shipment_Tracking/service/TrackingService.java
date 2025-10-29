package com.example.Shipment_Tracking.service;

import com.example.Shipment_Tracking.entity.TrackingLog;
import com.example.Shipment_Tracking.repository.TrackingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingService {
    @Autowired private TrackingLogRepository trackingLogRepository;

    public List<TrackingLog> getLogsByShipment(Long shipmentId){
        return trackingLogRepository.findByShipmentId(shipmentId);
    }

    public void addLog(TrackingLog log){
        log.setTimestamp(LocalDateTime.now());
        trackingLogRepository.save(log);
    }
}
