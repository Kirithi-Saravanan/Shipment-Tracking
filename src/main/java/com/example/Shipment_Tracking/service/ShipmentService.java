package com.example.Shipment_Tracking.service;

import com.example.Shipment_Tracking.entity.*;
import com.example.Shipment_Tracking.entity.enums.ShipmentStatus;
import com.example.Shipment_Tracking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentService {
     @Autowired private ShipmentRepository shipmentRepository;
    @Autowired private UserRepository userRepository;

    public List<Shipment> getAllShipments() { return shipmentRepository.findAll(); }

    public void saveShipment(Shipment shipment) {
        if (shipment.getId() == null) {
            shipment.setStatus(ShipmentStatus.CREATED);
        }
        shipmentRepository.save(shipment);
    }

    public void updateShipmentStatus(Long id, ShipmentStatus status) {
        Shipment s = shipmentRepository.findById(id).orElseThrow();
        s.setStatus(status);
        shipmentRepository.save(s);
    }

    public void assignAgent(Long shipmentId, Long agentId) {
        Shipment s = shipmentRepository.findById(shipmentId).orElseThrow();
        User agent = userRepository.findById(agentId).orElseThrow();
        s.setAssignedAgent(agent);
        shipmentRepository.save(s);
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id).orElseThrow();
    }
}
