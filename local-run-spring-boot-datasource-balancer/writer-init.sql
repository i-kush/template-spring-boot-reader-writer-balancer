create table if not exists data (
    id   text not null,
    data text not null,
    constraint pk_data_id primary key (id)
);