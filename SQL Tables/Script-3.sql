create table if not exists ERS_REIMBURSEMENT(
REIMB_ID SERIAL primary key ,
REIMB_AMOUNT DECIMAL not null,
REIMB_SUBMITTED TIMESTAMP not null,
REIMB_RESOLVED TIMESTAMP ,
REIMB_DESCRIPTION VARCHAR(250),
REIMB_AUTHOR INTEGER not null references ERS_USERS(ERS_USERS_ID),
REIMB_RESOLVER INTEGER not null references ERS_USERS(ERS_USERS_ID),
REIMB_STATUS_ID INTEGER not null references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
REIMB_TYPE_ID INTEGER not null references ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)
);


create table if not exists ERS_REIMBURSEMENT_STATUS(
REIMB_STATUS_ID SERIAL primary key ,
REIMB_STATUS VARCHAR(10) not null 
);

create table if not exists ERS_REIMBURSEMENT_TYPE(
REIMB_TYPE_ID SERIAL primary key ,
REIMB_TYPE VARCHAR(10) not null 
);

create table if not exists ERS_USER_ROLES(
ERS_USER_ROLE_ID SERIAL primary key ,
USER_ROLE VARCHAR(10) not null 
);


create table if not exists ERS_USERS(
ERS_USERS_ID SERIAL primary key, 
ERS_USERNAME VARCHAR(50) not null UNIQUE ,
ERS_PASSWORD VARCHAR(50) not null, 
USER_FIRST_NAME VARCHAR(100) not null,
USER_LAST_NAME VARCHAR(100) not null, 
USER_EMAIL VARCHAR(150) not null unique,
USER_ROLE_ID SERIAL references ers_user_roles(ERS_USER_ROLE_ID)
);

 alter table ERS_REIMBURSEMENT
 add REIMB_RECEIPT VARCHAR(400);

drop table ERS_REIMBURSEMENT;

insert into ers_users  (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values
	('pwesthoff0', 'Lte8k1', 'Porty', 'Westhoff', 'pwesthoff0@php.net',1);

insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)  values ('kkitchinham1', 'qWLOdh9Q', 'Keelia', 'Kitchinham', 'kkitchinham1@exblog.jp',2) ;
insert into  ers_user_roles (user_role) values ('worker');
insert into ers_user_roles (user_role) values ('manager');
select * from ers_user_roles;
select* from ers_users;

insert into ers_reimbursement_type(reimb_type) values ('lodging'), ('travel'), ('food'), ('other');
select * from ers_reimbursement;
select * from ers_reimbursement_status;

insert into ers_reimbursement_status(reimb_status) values ('pending'), ('approved'), ('denied');



alter table ers_reimbursement add column  reim_receipt varchar(200);










