insert into tb_course(title) values('TIL - Spring Boot microservices course');
insert into tb_course(title) values('TIL - Microservice with Netflix Eureka Discovery Client');


insert into tb_speaker(worker_id) values(1);
insert into tb_speaker(worker_id) values(2);

insert into tb_speaker_course(speaker_id, course_id) values(1,1);
insert into tb_speaker_course(speaker_id, course_id) values(1,2);
insert into tb_speaker_course(speaker_id, course_id) values(2,2);

