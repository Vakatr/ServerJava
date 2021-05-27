
create table files (
                      id int8 not null,
                      name varchar(255),
                      size int8,
                      key varchar(255),
                      upload_Date timestamp default current_timestamp,
                      primary key (id)
);

insert into files (id,name,key)
VALUES (1000,'Test1','9ead8295-3125-465d-bfae-bfc7bae0dfcf');
insert into files (id,name,key)
VALUES (2000,'Test2','25aa338f-bdd1-4ef9-8cfb-10f8aae95254');
