drop table if exists contacts;
create table contacts
(
    client_id bigint not null,
    email     varchar(255),
    phone     varchar(255),
    primary key (client_id)
) engine=InnoDB