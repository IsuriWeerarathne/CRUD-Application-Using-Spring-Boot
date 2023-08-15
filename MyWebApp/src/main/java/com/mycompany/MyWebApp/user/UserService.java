package com.mycompany.MyWebApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //service class
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
}