drop table if exists bot_users;
create table bot_users
(
    id          bigint not null,
    date_create datetime(6),
    first_name  varchar(255),
    last_name   varchar(255),
    user_name   varchar(255),
    primary key (id)
) engine=InnoDB