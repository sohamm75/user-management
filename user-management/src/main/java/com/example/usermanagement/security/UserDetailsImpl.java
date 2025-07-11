package com.example.usermanagement.security; // Recommended package for UserDetailsImpl

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections; 


public class UserDetailsImpl implements UserDetails {
    private String username;
    private String password;
    
    public UserDetailsImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return Collections.emptyList();
    }

    
    @Override
    public String getPassword() {
        return password;
    }

   
    @Override
    public String getUsername() {
        return username;
    }

   
    @Override
    public boolean isAccountNonExpired() {
        return true; 
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

  
    @Override
    public boolean isCredentialsNonExpired() {
        return true; 
    }

  
    @Override
    public boolean isEnabled() {
        return true; 
    }

   
}
