CREATE TABLE tb_addreses(
id_addres			INTEGER,
CEP 				VARCHAR(9),
street				VARCHAR(40),
neighborhood		VARCHAR(40),
city				VARCHAR(40),
uf				VARCHAR(40),
country				VARCHAR(30),
CONSTRAINT pk_tb_addreses_id PRIMARY KEY(id_addres)
);

CREATE TABLE tb_categories(
id_category			INTEGER,
description			VARCHAR(20),
CONSTRAINT pk_tb_categories_id PRIMARY KEY(id_category)
);

CREATE TABLE tb_users(
id_user				INTEGER,
email				VARCHAR(90),
passw				VARCHAR(90),
CONSTRAINT pk_tb_users_id PRIMARY KEY(id_user)
);

CREATE TABLE tb_contacts(
id_contact			INTEGER,
id_user				INTEGER,
id_category			INTEGER,
id_addres			INTEGER,
ful_name			VARCHAR(130),
phone				VARCHAR(11),
email				VARCHAR(80),
note				VARCHAR(100),
CONSTRAINT pk_tb_contacts_id PRIMARY KEY(id_contact),
CONSTRAINT fk_tb_contacts_id_user FOREIGN KEY(id_user)
	REFERENCES tb_users(id_user),
CONSTRAINT fk_tb_contacts_id_category FOREIGN KEY(id_category)
	REFERENCES tb_categories(id_category),
CONSTRAINT fk_tb_contacts_id_addres FOREIGN KEY(id_addres)
	REFERENCES tb_addreses(id_addres)
);