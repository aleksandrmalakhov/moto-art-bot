drop table if exists orders;
create table orders
(
    id         bigint not null auto_increment,
    cost       bigint not null,
    date       date,
    time_start time,
    time_stop  time,
    bike_id    bigint not null,
    client_id  bigint not null,
    primary key (id)
) engine=InnoDB
