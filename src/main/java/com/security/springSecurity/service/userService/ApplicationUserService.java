package com.security.springSecurity.service.userService;

import com.security.springSecurity.data.models.ApplicationUser;
import org.springframework.stereotype.Service;


public interface ApplicationUserService {
    public void registerUser(ApplicationUser user);
}
