package com.flygopher;

import com.flygopher.domain.CoffeeDomain;
import com.flygopher.repository.CoffeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Test
    public void test_find_user() {
        List<CoffeeDomain> coffeeDomainList = coffeeRepository.findAll();
        Assert.assertThat(coffeeDomainList.size(), is(5));

        coffeeDomainList.forEach(System.out::println);
    }
}
