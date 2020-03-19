package com.flygopher;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flygopher.domain.User;
import com.flygopher.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

        System.out.println("1===========================");
        userMapper.insert(User.builder().name("liangbo").age(29).build());
        List<User> userList2 = userMapper.selectList(null);
        userList2.forEach(System.out::println);

        System.out.println("2===========================");
        Page<User> userPage = userMapper.selectPage(new Page<User>(1, 3), Wrappers.emptyWrapper());
        System.out.println(userPage);
    }

}
