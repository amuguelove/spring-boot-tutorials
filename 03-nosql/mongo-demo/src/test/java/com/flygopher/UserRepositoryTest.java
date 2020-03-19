package com.flygopher;

import com.flygopher.user.UserRepository;
import com.flygopher.user.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_add_user() {
        User user = new User();
        user.setName("test");
        user.setAge(30);

        User result = userRepository.save(user);
        System.out.println(result);

        Assert.assertNotNull(user.getId());

        userRepository.findAll().forEach(System.out::println);
    }

}
