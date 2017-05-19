
-- todo: add scritp to create 'hibernate_app' user and database 'javawebapp_sandbox'.
DO
$do$
BEGIN

RAISE NOTICE 'create schema and table';
CREATE SCHEMA IF NOT EXISTS simpleapp_crud_up;
DROP TABLE IF EXISTS simpleapp_crud_up.up_users CASCADE;
CREATE TABLE  simpleapp_crud_up.up_users ( 
	 id BIGSERIAL PRIMARY KEY,
	 username VARCHAR(100),
	 email VARCHAR(100),
	 phone VARCHAR(100),
	 street VARCHAR(255),
	 suite VARCHAR(255),
	 city VARCHAR(255),
	 zipcode VARCHAR(255),
	 created timestamp default current_timestamp,
	 last_update timestamp default current_timestamp
);

GRANT ALL PRIVILEGES ON TABLE simpleapp_crud_up.up_users TO hibernate_app;
$do$


create sequence user_idClass_seq
  start with 13
  increment by 1;
$do$

GRANT USAGE ON SEQUENCE user_idClass_seq TO hibernate_app ;
$do$

RAISE NOTICE 'insert values';
INSERT INTO simpleapp_crud_up.up_users(username,email,phone,street,suite,city,zipcode)
VALUES
('Leanne Graham',		'Sincere@april.biz', 				'1-770-736-8031 x56442'	, 'Kulas Light', 		'Apt. 556',    'Gwenborough'		,'92998-3874' 	),		
('Ervin Howell',		'Shanna@melissa.tv', 				'010-692-6593 x09125'	, 'Victor Plains', 		'Suite 879',   'Wisokyburgh'		,'90566-7771' 	),		
('Clementine Bauch',		'Nathan@yesenia.net', 			'1-463-123-4447'		, 'Douglas Extension', 	'Suite 847',   'McKenziehaven'		,'59590-4157'	),		
('Patricia Lebsack',		'Julianne.OConner@kory.org', 	'493-170-9623 x156'		, 'Hoeger Mall', 		'Apt. 692',    'South Elvis'		,'53919-4257'	),		
('Chelsey Dietrich',		'Lucio_Hettinger@annie.ca', 	'(254)954-1289'			, 'Skiles Walks', 		'Suite 351',   'Roscoeview'			,'33263'		),		
('Mrs. Dennis Schulist',	'Karley_Dach@jasper.info', 		'1-477-935-8478 x6430'	, 'Keebler LLC', 		'Apt. 950',    'South Christy'		,'23505-1337'	),		
('Kurtis Weissnat',		'Telly.Hoeger@billy.biz', 			'210.067.6132'			, 'Norberto Crossing', 	'Suite 280',   'Howemouth'			,'58804-1099'	),		
('Nicholas Runolfsdottir V',	'Sherwood@rosamond.me', 	'586.493.6943 x140'		, 'Rex Trail', 			'Suite 729',   'Aliyaview'			,'76495-3109'	),	
('Glenna Reichert',		'Chaim_McDermott@dana.io', 			'(775)976-6794 x41206'	, 'Ellsworth Summit', 	'Suite 449',   'Bartholomebury'		,'31428-2261'	),		
('Clementina DuBuque',		'Rey.Padberg@karina.biz', 		 '024-648-3804'			,  'Dayna Park',			'Suite 198',   'Lebsackbury'	,'45169'		);

END
$do$






