package com.security.springSecurity.data.repository;

import com.security.springSecurity.data.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "users")
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

    ApplicationUser findByUsername(String username);

    @RestResource(exported = false)
    @Override
    List<ApplicationUser> findAll();
}
