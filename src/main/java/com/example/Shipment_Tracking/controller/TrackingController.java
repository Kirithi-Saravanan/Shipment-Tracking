package com.example.Shipment_Tracking.controller;

import com.example.Shipment_Tracking.entity.TrackingLog;
import com.example.Shipment_Tracking.service.TrackingService;
import com.example.Shipment_Tracking.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tracking")
public class TrackingController {

    @Autowired private TrackingService trackingService;
    @Autowired private ShipmentService shipmentService;

    @GetMapping
    public String listTracking(Model model){
        model.addAttribute("shipments", shipmentService.getAllShipments());
        return "tracking";
    }

    @GetMapping("/{shipmentId}")
    public String viewTracking(@PathVariable Long shipmentId,Model model){
        model.addAttribute("logs",trackingService.getLogsByShipment(shipmentId));
        model.addAttribute("shipmentId",shipmentId);
        model.addAttribute("newLog",new TrackingLog());
        return "tracking";
    }

    @PostMapping("/add")
    public String addTrackingLog(@ModelAttribute TrackingLog log, @RequestParam Long shipmentId){
        log.setShipment(shipmentService.getAllShipments().stream().filter(s -> s.getId().equals(shipmentId))
        .findFirst().orElse(null));
        trackingService.addLog(log);
        return "redirect:/tracking/" + shipmentId;

    }
}
