package com.security.springSecurity.service;

import com.security.springSecurity.data.models.ApplicationUser;
import com.security.springSecurity.data.models.Roles;
import com.security.springSecurity.data.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(s);
        if (applicationUser == null){
            throw  new UsernameNotFoundException("");
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), getAuthorities(applicationUser.getRoles()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Roles> roles){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Roles role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(String.valueOf(role)));
        }
        return grantedAuthorities;
    }


    public Collection<? extends GrantedAuthority> getAuthorities(List<Roles> authorities) {
        return getGrantedAuthorities(authorities);
    }
}