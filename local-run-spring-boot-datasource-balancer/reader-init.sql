create table if not exists data (
    id   text not null,
    data text not null,
    constraint pk_data_id primary key (id)
);

insert into data (id, data)
values ('1', 'reader-data-id-1'),
       ('2', 'reader-data-id-2');