package com.security.springSecurity.service.userService;

import com.security.springSecurity.data.models.ApplicationUser;
import com.security.springSecurity.data.models.Roles;
import com.security.springSecurity.data.repository.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{
    BCryptPasswordEncoder bCryptPasswordEncoder;
    ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void registerUser(ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(List.of(Roles.ROLE_USER));

    }
}
