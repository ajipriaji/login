package com.login.login;

import java.util.List;

import com.login.models.entity.Role;
import com.login.models.repo.RoleRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
    @Autowired
    RoleRepository repo;

    @Test
    public void testCreateRole() {
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role customer = new Role("Customer");

        repo.saveAll(List.of(user, admin, customer));

        List<Role> listRoles = (List<Role>) repo.findAll();
        Assertions.assertThat(listRoles.size()).isEqualTo(3);
    }
}
