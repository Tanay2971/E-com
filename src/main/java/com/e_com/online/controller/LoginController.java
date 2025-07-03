package com.e_com.online.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.e_com.online.global.GlobalData;
import com.e_com.online.model.Role;
import com.e_com.online.model.User;
import com.e_com.online.repository.RoleRepository;
import com.e_com.online.repository.UserRepository;

@Controller
public class LoginController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/login") 
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}
	
	@GetMapping("/register") 
	public String registerGet() {	
		return "register";
	}
	

	@PostMapping("/register") 
	public String registerPost(@ModelAttribute("user") User user) {
	    String password = user.getPassword();
	    user.setPassword(password);

	    // Fetch role safely
	    Role defaultRole = roleRepository.findById(1).orElseThrow(() -> 
	         new IllegalArgumentException("Role with ID 1 not found"));

	    List<Role> roles = new ArrayList<>();
	    roles.add(defaultRole);
	    user.setRoles(roles);

	    // Save the user to the repository
	    userRepository.save(user);

	    return "redirect:/";
	}

}
