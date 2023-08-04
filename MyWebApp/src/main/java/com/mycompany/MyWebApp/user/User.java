package com.mycompany.MyWebApp.user;

import jakarta.persistence.*;

//jpa annotations
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate the id automatically in the database as an ID
    private Integer id;

    @Column(nullable = false, unique = true, length = 50) // email should be not null and unique
    private String email;

    @Column(length = 15) // define the maximum length
    private String password;

    private String firstName;
    private String lastName;
}
