drop table if exists clients;
create table clients
(
    id          int8 not null,
    date_create timestamp,
    first_name  varchar(255),
    last_name   varchar(255),
    primary key (id)
)