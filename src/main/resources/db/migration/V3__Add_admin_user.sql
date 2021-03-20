insert into user_data (id, name, first_name, last_name, password, status, email, created, updated, last_visit)
VALUES ('1', 'user', 'User', 'Test', '1',
        'ACTIVE', 'user@gmail.com', current_timestamp, current_timestamp, current_timestamp);
insert into user_data (id, name, first_name, last_name, password, status, email, created, updated, last_visit)
VALUES ('2', 'admin', 'Admin', 'Test', '2',
        'ACTIVE', 'admin@gmail.com', current_timestamp, current_timestamp, current_timestamp);
insert into user_data (id, name, first_name, last_name, password, status, email, created, updated, last_visit)
VALUES ('3', 'legist', 'Legist', 'Test', '3',
        'ACTIVE', 'legist@gmail.com', current_timestamp, current_timestamp, current_timestamp);


insert into user_roles(user_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3);