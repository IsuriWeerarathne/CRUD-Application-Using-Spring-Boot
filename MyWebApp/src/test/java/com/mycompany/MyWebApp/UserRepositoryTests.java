package com.mycompany.MyWebApp;


import com.mycompany.MyWebApp.user.User;
import com.mycompany.MyWebApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest //spring jpa use
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//real db
@Rollback(false)//committed to db
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user=new User();
        /*user.setId(1);*/
        user.setEmail("isuriweerarathna@gmail.com");
        user.setPassword("123234");
        user.setFirstName("Isuri");
        user.setLastName("Weerarathne");

        User savedUser = repo.save(user);//save user details
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User> optionalUser = repo.findById(userId);
        User user=optionalUser.get();
        user.setPassword("123!@#");
        repo.save(user);
        //update user by id
        User updatedUser=repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("pwrd12@");


    }

    @Test
    public void testGet(){//get by id
        Integer userId=2;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId=1;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
