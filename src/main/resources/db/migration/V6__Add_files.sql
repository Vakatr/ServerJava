
create table files (
                      id int8 not null,
                      name varchar(255),
                      size int8,
                      upload_Date timestamp default current_timestamp,
                      primary key (id)
);

