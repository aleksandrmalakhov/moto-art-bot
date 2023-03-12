drop table if exists bikes;
create table bikes
(
    id            bigint not null auto_increment,
    cost_per_hour integer,
    model    varchar(50),
    name     varchar(50),
    primary key (id)
) engine=InnoDB
