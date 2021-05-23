create sequence hibernate_sequence start 1 increment 1;

create table news (
                         id int8 not null,
                         title varchar(255) not null,
                         text text not null,
                         date_of_created timestamp default current_timestamp,
                         date_of_updated timestamp,
                         id_author varchar(255),
                         primary key (id)
);

alter table news
    add constraint news_id_author
        foreign key (id_author) references user_data(id);

create table chatroom (
                               id int8 not null,
                               initiator_id varchar(255) not null,
                               recipient_id varchar(255) not null,
                               primary key (id)
);

alter table chatroom
    add constraint chatroom_initiatorId
        foreign key (initiator_id) references user_data(id);

alter table chatroom
    add constraint chatroom_recipientId
        foreign key (recipient_id) references user_data(id);

create table chatMessage (
                          id int8 not null,
                          chat_id int8 not null,
                          sender_id varchar(255) not null,
                          recipient_id varchar(255) not null,
                          sender_name varchar(255) not null,
                          recipient_name varchar(255) not null,
                          content text,
                          dateMessage timestamp,
                          primary key (id)
);
alter table chatMessage
    add constraint chatMessage_chatroomId
        foreign key (chat_id) references chatroom(id);

alter table chatMessage
    add constraint chatMessage_senderId
        foreign key (sender_id) references user_data(id);

alter table chatMessage
    add constraint chatMessage_recipientId
        foreign key (recipient_id) references user_data(id);

create table requests (
                      id int8 not null,
                      request_text text not null,
                      decision text,
                      created timestamp,
                      meeting_time timestamp,
                      status int8 not null,
                      user_id varchar(255) not null,
                      user_specialist_id varchar(255) not null,
                      primary key (id)
);

alter table requests
    add constraint requests_user_id
        foreign key (user_id) references user_data(id);

alter table requests
    add constraint requests_user_specialist_id
        foreign key (user_specialist_id) references user_data(id);

create table requestsSpecialist (
                          id int8 not null,
                          requestText text not null,
                          decision text,
                          created timestamp,
                          status int8 not null,
                          user_id varchar(255) not null,
                          primary key (id)
);

alter table requestsSpecialist
    add constraint requestsSpecialist_user_id
        foreign key (user_id) references user_data(id);
