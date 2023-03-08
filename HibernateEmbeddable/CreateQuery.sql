create table user_information (
       userId integer not null auto_increment,
        username varchar(255),
        primary key (userId)
    );
create table user_Address (
       userId integer not null,
        city varchar(255),
        pincode integer,
        street varchar(255),
        foreign key (userId) 
       references user_information (userId)
    ) ;