drop table if exists  clients;
create table clients
(
    user_id     bigint not null,
    date_create datetime(6),
    first_name  varchar(255),
    last_name   varchar(255),
    primary key (user_id)
) engine=InnoDB