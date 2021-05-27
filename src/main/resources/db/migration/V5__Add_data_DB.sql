insert into news (id, title, text, date_of_created, date_of_updated, id_author)
VALUES (1, 'Test title', 'Test text', current_timestamp, current_timestamp,2);
insert into chatroom (id, initiator_id, recipient_id)
VALUES (1, 1, 3);
insert into chatMessage (id, chat_id, sender_id, recipient_id, sender_name, recipient_name, content, dateMessage)
VALUES (1, 1, '1', '3', 'user',
        'legist', 'Test message', current_timestamp);
insert into requests (id, request_text, decision, created, meeting_time, status, user_id, user_specialist_id)
VALUES (1,'Test request', null, current_timestamp, current_timestamp,
        1, '1', '3');

insert into requests_Specialist (id, request_text, decision, created, user_id, file)
VALUES (10000,'Test request User1', null, current_timestamp, '5' , '9ead8295-3125-465d-bfae-bfc7bae0dfcf');
insert into requests_Specialist (id, request_text, decision, created, user_id, file)
VALUES (20000,'Test request User2', null, current_timestamp, '10', '25aa338f-bdd1-4ef9-8cfb-10f8aae95254');

