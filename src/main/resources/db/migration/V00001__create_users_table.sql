drop table if exists bot_users;
create table bot_users
(
    id          int8 not null,
    date_create timestamp,
    first_name  varchar(255),
    last_name   varchar(255),
    user_name   varchar(255),
    primary key (id)
)