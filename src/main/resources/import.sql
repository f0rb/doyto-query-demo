SET DATABASE SQL SYNTAX MYS TRUE;

drop table t_role if exists;
create table t_role
(
    id        bigint generated by default as identity (start with 1) primary key,
    role_name VARCHAR(100) not null,
    role_code VARCHAR(100) not null,
    valid     boolean DEFAULT TRUE
);

INSERT INTO t_role (role_name, role_code) VALUES ('admin', 'ADMIN');
INSERT INTO t_role (role_name, role_code) VALUES ('vip', 'VIP');
INSERT INTO t_role (role_name, role_code) VALUES ('vip2', 'VIP2');
INSERT INTO t_role (role_name, role_code) VALUES ('vip3', 'VIP3');
INSERT INTO t_role (role_name, role_code) VALUES ('guest', 'GUEST');
