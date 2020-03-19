
drop table if exists coffee;

create table coffee (
    id bigint not null auto_increment,
    name varchar(255),
    price double not null,
    create_time datetime,
    update_time datetime,
    primary key (id)
);