-- drop table if exists mutual_fund;
-- drop table if exists roles;
-- drop table if exists user_roles;
-- drop table if exists user_watchlist;
-- drop table if exists users;
create table mutual_fund (id bigint not null, aum float, cagr float, expense_ratio float, is_active bit, name varchar(255), plan varchar(255), sebi_risk varchar(255), sub_category varchar(255), primary key (id));
create table roles (id bigint not null auto_increment, is_active bit, name varchar(255), primary key (id));
create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id));
create table user_watchlist (user_id bigint not null, mutual_fund_id bigint not null, primary key (user_id, mutual_fund_id));
create table users (id bigint not null auto_increment, email varchar(255), email_confirmed bit, is_active bit, password varchar(255), username varchar(255), primary key (id));
--alter table mutual_fund add constraint UK_90fd1epxilr6wu0efg9iuuf5e unique (name);
alter table roles add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);
alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (id);
alter table user_roles add constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users (id);
alter table user_watchlist add constraint FKnq3t4d0l9olh9yd63cts84khu foreign key (mutual_fund_id) references mutual_fund (id);
alter table user_watchlist add constraint FK1a2sf5ha20f8a3sqgo3n4h3w6 foreign key (user_id) references users (id);
COMMIT;