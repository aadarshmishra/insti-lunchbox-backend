package com.iiitb.instilunchbox;

import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = UserRepository.class)
@EnableJpaRepositories(basePackages = {"com.iiitb.*"})
@EntityScan("com.iiitb.instilunchbox.Model")
public class UserServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmail_thenReturnUser() {
        User testUser = new User("test@gmail.com", "123", "test");
        testEntityManager.persistAndFlush(testUser);
        User found = userRepository.findUserByEmail(testUser.getEmail()).get();
        Assertions.assertEquals(testUser.getEmail(),found.getEmail());
    }

    @Test
    public void whenSaveUser_thenCheckDBIdValid() {
        User testUser = new User("test@gmail.com", "123", "test");
        Assertions.assertNull(testUser.getId());
        userRepository.save(testUser);
        Assertions.assertNotNull(testUser.getId());
    }
}
