package com.microservice.orderservice.security;

import com.microservice.orderservice.Entity.Role;
import com.microservice.orderservice.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails {

   private String name;
   private String password;
   private List<GrantedAuthority> authorities;

   public UserDetailsImpl(User user){
       this.name =user.getName();
       this.password=user.getPassword();
    List<Role> roles =   user.getRoles();
       this.authorities = roles.isEmpty()?null : roles.stream().map(role -> role.toString())
               .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
   }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.name;
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
