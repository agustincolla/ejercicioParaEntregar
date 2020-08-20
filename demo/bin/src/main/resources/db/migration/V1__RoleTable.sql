CREATE TABLE role (
    roleId UUID NOT NULL PRIMARY KEY,
    roleName VARCHAR(100) NOT NULL,
    validRole int NOT NULL DEFAULT '0'
); 
CREATE TABLE person(
   personId UUID NOT NULL PRIMARY KEY,
   personEmail VARCHAR(100) NOT NULL ,
   personFirstName VARCHAR(100) NOT NULL, 
   personLastName VARCHAR(100) NOT NULL,
   validPerson int NOT NULL DEFAULT '0'
);
CREATE TABLE personRole (
  personRoleId UUID NOT NULL PRIMARY KEY,
  personID UUID NOT NULL,
  roleId UUID NOT NULL ,
  validPersonRole int NOT NULL DEFAULT '0'
);
INSERT INTO role (roleId,roleName,validRole) VALUES (uuid_generate_v4(),'admin',0);
INSERT INTO role (roleId,roleName,validRole) VALUES (uuid_generate_v4(),'gerente',0);
INSERT INTO role (roleId,roleName,validRole) VALUES (uuid_generate_v4(),'técnico',0);
INSERT INTO person (personId,personEmail,personFirstName,personLastName,validPerson) VALUES (uuid_generate_v4(),'agu_coyote@hotmail.com','Agustin','Colla',0);
INSERT INTO personRole (personRoleId,personId,roleId,validPersonRole) VALUES (uuid_generate_v4(),(SELECT personId FROM person WHERE personEmail='agu_coyote@hotmail.com'),(SELECT roleId FROM role WHERE roleName='admin'),0);
INSERT INTO personRole (personRoleId,personId,roleId,validPersonRole) VALUES (uuid_generate_v4(),(SELECT personId FROM person WHERE personEmail='agu_coyote@hotmail.com'),(SELECT roleId FROM role WHERE roleName='gerente'),0);
INSERT INTO personRole (personRoleId,personId,roleId,validPersonRole) VALUES (uuid_generate_v4(),(SELECT personId FROM person WHERE personEmail='agu_coyote@hotmail.com'),(SELECT roleId FROM role WHERE roleName='técnico'),0);