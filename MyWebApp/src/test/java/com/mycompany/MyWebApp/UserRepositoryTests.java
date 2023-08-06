package com.mycompany.MyWebApp;

import com.mycompany.MyWebApp.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest //spring jpa use
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//real db
@Rollback(false)//committed to db
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){

    }
}
