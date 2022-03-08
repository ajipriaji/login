package com.login.login;

import com.login.models.entity.User;
import com.login.models.repo.UserRepo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class UserRepositoryTest {
    
    @Autowired
    private UserRepo repo;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("test2@gmail.com");
        user.setPassword("hello2000");
        user.setFirstName("Aji");
        user.setLastName("Oktawibyan");
    
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testFindUserByEmail() {
        String email = "user@app.com";

        User user = repo.findByEmail(email);

        Assertions.assertThat(user).isNotNull();
    }
}
