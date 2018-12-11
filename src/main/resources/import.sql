INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User -> Has no Admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User -> Has permission to perform Admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

INSERT INTO tenants(id, name) VALUES(1,'Tenant - 01');
INSERT INTO tenants(id, name) VALUES(2,'Tenant - 02');

INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(1,'+8801976452247', 'Acc Name 01 - Tenant 01', 1);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(2,'+8801776452248', 'Acc Name 02 - Tenant 01', 1);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(3,'+8801876452249', 'Acc Name 03 - Tenant 01', 1);

INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(4,'+8801976552247', 'Acc Name 04 - Tenant 02', 2);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(5,'+8801776652248', 'Acc Name 05 - Tenant 02', 2);
INSERT INTO accounts(id, mobile_number, name, tenant_id) VALUES(6,'+8801876752249', 'Acc Name 06 - Tenant 02', 2);