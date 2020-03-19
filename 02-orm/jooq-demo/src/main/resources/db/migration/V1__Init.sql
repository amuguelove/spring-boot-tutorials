
drop table if exists coffee;

create table coffee (
    id bigint not null auto_increment,
    name varchar(255),
    price double not null,
    create_time datetime,
    update_time datetime,
    primary key (id)
);

insert into coffee (name, price, create_time, update_time) values ('espresso', 20.00, now(), now());
insert into coffee (name, price, create_time, update_time) values ('latte', 25.00, now(), now());
insert into coffee (name, price, create_time, update_time) values ('capuccino', 25.00, now(), now());
insert into coffee (name, price, create_time, update_time) values ('mocha', 30.00, now(), now());
insert into coffee (name, price, create_time, update_time) values ('macchiato', 30.00, now(), now());