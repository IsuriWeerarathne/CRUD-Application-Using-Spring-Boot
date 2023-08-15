package com.mycompany.MyWebApp.user;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired private UserService service;
    @GetMapping("/users")
    public String showList(Model model){
        List<User> listUsers = service.listAll();
        //model.addAttribute("listUsers",listUsers); addAttribute is showing as an error, why
        
        return "users";
    }


}
