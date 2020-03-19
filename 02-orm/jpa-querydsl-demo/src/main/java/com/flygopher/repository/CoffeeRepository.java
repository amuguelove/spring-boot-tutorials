package com.flygopher.repository;

import com.flygopher.common.BaseJpaRepository;
import com.flygopher.domain.Coffee;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CoffeeRepository extends BaseJpaRepository<Coffee, Long>, QuerydslPredicateExecutor<Coffee> {
    Page<Coffee> findAll(Predicate predicate, Pageable pageable);
}
