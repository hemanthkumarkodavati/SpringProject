package com.example.springall.serviceImp;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Here you can fetch the user from the database
    return new User("Hemanth", "$2a$10$qcr7.r8TA8igM4cvyBAJjOtL1t/e1uNtGvfn7cutBtPnkP3MniFya", new ArrayList<>());
  }
}