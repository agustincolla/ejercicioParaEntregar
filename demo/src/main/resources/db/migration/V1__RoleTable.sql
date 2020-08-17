CREATE TABLE role (
    roleId UUID NOT NULL PRIMARY KEY,
    roleName VARCHAR(100) NOT NULL
); 
CREATE TABLE person(
   personId UUID NOT NULL PRIMARY KEY,
   personEmail VARCHAR(100) NOT NULL ,
   personFirstName VARCHAR(100) NOT NULL, 
   personLastName VARCHAR(100) NOT NULL
);
CREATE TABLE personRole (
  personRoleId UUID NOT NULL PRIMARY KEY,
  personID UUID NOT NULL,
  roleId UUID NOT NULL 
);
INSERT INTO role (roleId,roleName) VALUES (uuid_generate_v4(),'admin');
INSERT INTO role (roleId,roleName) VALUES (uuid_generate_v4(),'gerente');
INSERT INTO role (roleId,roleName) VALUES (uuid_generate_v4(),'técnico');
INSERT INTO person (personId,personEmail,personFirstName,personLastName) VALUES (uuid_generate_v4(),'agu_coyote@hotmail.com','Agustin','Colla');
INSERT INTO personRole (personRoleId,personId,roleId) VALUES (uuid_generate_v4(),(SELECT personId FROM person WHERE personEmail='agu_coyote@hotmail.com'),(SELECT roleId FROM role WHERE roleName='admin'));
INSERT INTO personRole (personRoleId,personId,roleId) VALUES (uuid_generate_v4(),(SELECT personId FROM person WHERE personEmail='agu_coyote@hotmail.com'),(SELECT roleId FROM role WHERE roleName='gerente'));
INSERT INTO personRole (personRoleId,personId,roleId) VALUES (uuid_generate_v4(),(SELECT personId FROM person WHERE personEmail='agu_coyote@hotmail.com'),(SELECT roleId FROM role WHERE roleName='técnico'));