package com.mycompany.MyWebApp;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest //spring jpa use
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//real db
@Rollback(false)//committed to db
public class UserRepositoryTests {

}
