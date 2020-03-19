package com.flygopher.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document
@ToString
public class User implements Serializable {

    @Id
    private String id;

    private String name;

    private Integer age;
}
