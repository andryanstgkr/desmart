package com.andryanstgkr.desmart.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Entity
@Table(name = "users")
@Access(value = AccessType.FIELD)
public class User extends BaseEntity{

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

}