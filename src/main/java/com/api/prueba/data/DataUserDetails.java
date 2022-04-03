package com.api.prueba.data;

import com.api.prueba.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DataUserDetails implements UserDetails {

    private final Optional<User> userOptional;

   public DataUserDetails(Optional<User> userOptional) {
       this.userOptional = userOptional;
  }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return userOptional.orElse(new User()).getHashed_password();
    }

   @Override
   public String getUsername() {
       return userOptional.orElse(new User()).getUsername();
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
