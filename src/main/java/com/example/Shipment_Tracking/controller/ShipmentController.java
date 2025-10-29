package com.example.Shipment_Tracking.controller;

import com.example.Shipment_Tracking.entity.Shipment;
import com.example.Shipment_Tracking.entity.User;
import com.example.Shipment_Tracking.entity.enums.ShipmentStatus;
import com.example.Shipment_Tracking.service.ShipmentService;
import com.example.Shipment_Tracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final UserService userService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService, UserService userService) {
        this.shipmentService = shipmentService;
        this.userService = userService;
    }

    @GetMapping
    public String listShipments(Model model) {
        model.addAttribute("shipments", shipmentService.getAllShipments());
        return "Shipment/shipments";
    }

    @GetMapping({"/new", "/add"})
    public String addShipmentForm(Model model) {
        model.addAttribute("shipment", new Shipment());
        model.addAttribute("customers", userService.getCustomers());
        model.addAttribute("agents", userService.getAgents());
        model.addAttribute("statuses", ShipmentStatus.values());
        return "Shipment/shipment-form";
    }

    @PostMapping("/save")
    public String saveShipment(@ModelAttribute("shipment") Shipment shipment) {
        shipmentService.saveShipment(shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/edit/{id}")
    public String editShipmentForm(@PathVariable Long id, Model model) {
        Shipment shipment = shipmentService.getShipmentById(id);
        model.addAttribute("shipment", shipment);
        model.addAttribute("customers", userService.getCustomers());
        model.addAttribute("agents", userService.getAgents());
        model.addAttribute("statuses", ShipmentStatus.values());
        return "Shipment/shipment-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }
}
