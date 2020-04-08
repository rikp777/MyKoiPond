package com.api.mykoipond.security;

import com.api.mykoipond.dao.RoleRepository;
import com.api.mykoipond.dao.UserRepository;
import com.api.mykoipond.domain.RoleEntity;
import com.api.mykoipond.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleResult;
import java.util.*;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(UserEntity userEntity){
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleEntity = roleRepository.findByName("ADMIN");
        userEntity.setRoles(Arrays.asList(roleEntity));
        userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity != null) {
            List<GrantedAuthority> authorities = getUserAuthority(userEntity.getRoles());
            return buildUserForAuthentication(userEntity, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(List<RoleEntity> userRoles){
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
