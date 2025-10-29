package com.example.Shipment_Tracking.service;

import com.example.Shipment_Tracking.entity.User;
import com.example.Shipment_Tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() { return userRepository.findAll(); }
    public void saveUser(User user) { userRepository.save(user); }
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}
