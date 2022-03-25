package com.doctorapp.controllers;

import com.doctorapp.model.AppUser;
import com.doctorapp.service.UserServiceImpl;
import com.doctorapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenUtil tokenUtil;
    @Autowired
    AuthenticationManager authenticationManager;
    // this method will be called first
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody AppUser request){
        authenticate(request.getUsername(), request.getPassword());
        UserDetails details = userService.loadUserByUsername(request.getUsername());
        String token = tokenUtil.generateToken(details);
        return ResponseEntity.ok(token);
    }
    private void authenticate(String username, String password){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(BadCredentialsException e){
            System.out.println("Invalid credentials");
        }catch(DisabledException e){
            System.out.println("disabled");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AppUser request){
        String password = passwordEncoder.encode(request.getPassword());
        AppUser user = new AppUser(request.getUserId(), request.getUsername(), password);
        userService.addUser(user);
        return ResponseEntity.ok("Added");
    }
    @GetMapping("/show")
    public ResponseEntity<String> show(){

        return ResponseEntity.ok("welcome");
    }

}
