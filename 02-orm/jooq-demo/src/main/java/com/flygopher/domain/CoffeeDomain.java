package com.flygopher.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString(callSuper = true)
public class CoffeeDomain {

    private Long id;

    private String name;

    private Double price;

    private Date createTime;

    private Date updateTime;
}
