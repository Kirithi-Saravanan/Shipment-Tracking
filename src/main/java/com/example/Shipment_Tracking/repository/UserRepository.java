package com.example.Shipment_Tracking.repository;

import com.example.Shipment_Tracking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long> {
    
}
