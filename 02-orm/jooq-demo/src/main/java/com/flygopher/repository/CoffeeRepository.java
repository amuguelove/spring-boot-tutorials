package com.flygopher.repository;

import com.flygopher.domain.CoffeeDomain;
import com.flygopher.jooq.tables.Coffee;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoffeeRepository {

    private final DSLContext dslContext;

    @Autowired
    public CoffeeRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<CoffeeDomain> findAll() {
        return dslContext.select().from(Coffee.COFFEE).fetch().into(CoffeeDomain.class);
    }
}
