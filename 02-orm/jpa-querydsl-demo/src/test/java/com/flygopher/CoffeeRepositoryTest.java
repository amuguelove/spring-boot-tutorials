package com.flygopher;

import com.flygopher.domain.Coffee;
import com.flygopher.domain.QCoffee;
import com.flygopher.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Test
    public void saveTest() throws Exception {
        Coffee coffee = new Coffee();
        coffee.setName("test-querydsl");
        coffee.setPrice(Money.parse("CNY 50.00"));
        Coffee result = coffeeRepository.save(coffee);
        log.info(result.toString());
        Assert.assertNotNull(coffee.getId());


        Page<Coffee> coffeePage = coffeeRepository.findAll(PageRequest.of(0, 3));
        System.out.println(coffeePage);
        coffeePage.getContent().forEach(System.out::println);
        Assert.assertThat(coffeePage.getContent().size(), is(3));
    }
}
