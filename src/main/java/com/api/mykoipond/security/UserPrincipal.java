package com.api.mykoipond.security;


import com.api.mykoipond.domain.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {
    private UserEntity user;

    public UserPrincipal(UserEntity user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permission (name)
        this.user.getPermissions().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p.getName());
            authorities.add(authority);
        });

        // Extract list of roles (ROLE_NAME)
        this.user.getRoles().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r.getName());
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getPassword();
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
        return this.user.isActive();
    }
}
