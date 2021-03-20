insert into roles(id, name)
VALUES (1, 'USER'),
       (2, 'ADMIN'),
       (3, 'LEGIST');

create extension if not exists pgcrypto;
update user_data set password = crypt(password, gen_salt('bf', 8));

