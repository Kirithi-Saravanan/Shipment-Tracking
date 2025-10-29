package com.example.Shipment_Tracking.service;

import com.example.Shipment_Tracking.entity.Route;
import  com.example.Shipment_Tracking.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteService {
    @Autowired private RouteRepository routeRepository;
    public List<Route> getAllRoutes(){return routeRepository.findAll();}
    public Route getRouteById(Long id){return routeRepository.findById(id).orElseThrow();}
    public void saveRoute(Route route){ routeRepository.save(route);}
    public void deleteRoute(Long id){routeRepository.deleteById(id);}
}
