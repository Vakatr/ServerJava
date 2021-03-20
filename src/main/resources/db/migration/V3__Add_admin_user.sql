insert into user_data (id, name, first_name, last_name, password, status, email, created, updated, last_visit)
VALUES ('1', 'user', 'User', 'Test', '$2a$08$xiubgeYqFLLIhOYKAVEUM.dL578Ct3L93u8HxGLBKF8vYy9Wfi8n2',
        'ACTIVE', 'user@gmail.com', current_timestamp, current_timestamp, current_timestamp);
insert into user_data (id, name, first_name, last_name, password, status, email, created, updated, last_visit)
VALUES ('2', 'admin', 'Admin', 'Test', '$2a$08$Q/DToiu6drLjkSPw3cBAeeo6vjWiyux/95I24xEaISlgFy6xud/tW',
        'ACTIVE', 'admin@gmail.com', current_timestamp, current_timestamp, current_timestamp);
insert into user_data (id, name, first_name, last_name, password, status, email, created, updated, last_visit)
VALUES ('3', 'legist', 'Legist', 'Test', '$2a$08$DSiTfgYS4gCHm9Kg5.Y7Cu3H2fOBv1pynzDBhcGsJ/BAE2rQW4rZS',
        'ACTIVE', 'legist@gmail.com', current_timestamp, current_timestamp, current_timestamp);


insert into user_roles(user_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3);