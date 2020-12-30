create table if not exists course_jdc.course(
    id int not null AUTO_INCREMENT,
    name varchar (255) not null,
    content varchar (255) not null,
    image varchar (255) not null,
    start_date date null,
    duration varchar (255) not null,
    fees int null,
    primary key (id)
    );
