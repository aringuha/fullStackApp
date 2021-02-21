drop table if exists suppliers;

create table suppliers (
    id         int8 not null,
    address    varchar(255),
    city       varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    telephone  varchar(255),
    primary key (id)
);

insert into suppliers (id, first_name, last_name, city, address, telephone) values (1, 'Ivan', 'Ivanov', 'Kiev', 'Khreschatyk 1', '414-00-01');
insert into suppliers (id, first_name, last_name, city, address, telephone) values (2, 'John', 'Doe', 'New York', 'Wall Street, 2', '777-77-72');
insert into suppliers (id, first_name, last_name, city, address, telephone) values (3, 'Walter', 'White', 'Albuquerque', 'Negra Arroyo Lane, 308', '777-77-73');