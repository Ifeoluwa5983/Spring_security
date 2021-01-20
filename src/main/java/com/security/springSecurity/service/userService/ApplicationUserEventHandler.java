package com.security.springSecurity.service.userService;

import com.security.springSecurity.data.models.ApplicationUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RepositoryEventHandler
public class ApplicationUserEventHandler {

    @Autowired
    ApplicationUserService applicationUserService;

    @HandleBeforeCreate
    public void handleBeforeCreate(ApplicationUser applicationUser){
        log.info("Application user object -> {}", applicationUser);
        applicationUserService.registerUser(applicationUser);
    }
}
