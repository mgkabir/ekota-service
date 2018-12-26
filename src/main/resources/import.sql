INSERT INTO app_role (id, role_name, description) VALUES (1, 'ROLE_USER', 'Standard User -> Has no Admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ROLE_TENANT_ADMIN', 'Admin User -> Has permission to perform Admin tasks in single Tenant');
INSERT INTO app_role (id, role_name, description) VALUES (3, 'ROLE_SYS_ADMIN', 'Sys Admin User -> Has permission to perform Admin tasks in All tenant');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username,tenant_id) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe',2);
INSERT INTO app_user (id, first_name, last_name, password, username,tenant_id) VALUES (2, 'Tenant1', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 't3.admin',3);
INSERT INTO app_user (id, first_name, last_name, password, username,tenant_id) VALUES (3, 'Tenant2', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 't2.admin',2);
INSERT INTO app_user (id, first_name, last_name, password, username,tenant_id) VALUES (4, 'Sys', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'sys.admin',1);


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
INSERT INTO user_role(user_id, role_id) VALUES(3,2);
INSERT INTO user_role(user_id, role_id) VALUES(4,3);

INSERT INTO tenants(id, name) VALUES(1,'No Tenant');
INSERT INTO tenants(id, name) VALUES(2,'Tenant - 02');
INSERT INTO tenants(id, name) VALUES(3,'Tenant - 03');

INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(1,'+8801976452247', 'Acc Name 01 - Tenant 02', 2);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(2,'+8801776452248', 'Acc Name 02 - Tenant 02', 2);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(3,'+8801876452249', 'Acc Name 03 - Tenant 02', 2);

INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(4,'+8801976552247', 'Acc Name 04 - Tenant 03', 3);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(5,'+8801776652248', 'Acc Name 05 - Tenant 03', 3);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(6,'+8801876752249', 'Acc Name 06 - Tenant 03', 3);