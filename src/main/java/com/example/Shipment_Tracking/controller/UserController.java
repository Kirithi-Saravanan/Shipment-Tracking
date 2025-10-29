package com.example.Shipment_Tracking.controller;


import com.example.Shipment_Tracking.entity.User;
import com.example.Shipment_Tracking.entity.enums.Role;
import com.example.Shipment_Tracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")


public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "Users/users";
    }

    @GetMapping({"/add", "/new"})
    public String addUserForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roles",Role.values());
        return "Users/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "Users/user-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
