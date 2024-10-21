package com.example.springall.controller;

import com.example.springall.config.JwtUtil;
import com.example.springall.model.JwtRequest;
import com.example.springall.model.JwtResponse;
import com.example.springall.serviceImp.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private MyUserDetailsService userDetailsService;

  @PostMapping("/authenticate")
  public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
    );

    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails.getUsername());

    return new JwtResponse(jwt);
  }
}
