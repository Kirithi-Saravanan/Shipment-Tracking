package com.example.Shipment_Tracking.controller;

import com.example.Shipment_Tracking.entity.Route;
import com.example.Shipment_Tracking.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public String listRoutes(Model model){
        model.addAttribute("routes",routeService.getAllRoutes());
        return "routes";
    }

    @GetMapping("/add")
    public String addRouteForm(Model model){
        model.addAttribute("route",new Route());
        return "route-form";
    }

    @PostMapping("/save")
    public String saveRoute(@ModelAttribute Route route){
        routeService.saveRoute(route);
        return "redirect:/routes";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoute(@PathVariable Long id){
            routeService.deleteRoute(id);
            return "redirect:/routes";
    }
}