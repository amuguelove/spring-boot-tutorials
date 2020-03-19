package com.flygopher;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flygopher.domain.User;
import com.flygopher.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyBatisPlusDemoApplication implements ApplicationRunner {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
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
