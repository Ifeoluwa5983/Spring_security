package com.security.springSecurity.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private boolean isActive;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Roles> Roles;


}
