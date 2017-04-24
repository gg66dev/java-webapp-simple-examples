
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
	 email VARCHAR(100)
);

RAISE NOTICE 'insert values';
INSERT INTO simpleapp_crud_up.up_users(username,email)
VALUES
('Leanne Graham',		'Sincere@april.biz'),		
('Ervin Howell',		'Shanna@melissa.tv'),		
('Clementine Bauch',		'Nathan@yesenia.net'),		
('Patricia Lebsack',		'Julianne.OConner@kory.org'),		
('Chelsey Dietrich',		'Lucio_Hettinger@annie.ca'),		
('Mrs. Dennis Schulist',	'Karley_Dach@jasper.info'),		
('Kurtis Weissnat',		'Telly.Hoeger@billy.biz'),		
('Nicholas Runolfsdottir V',	'Sherwood@rosamond.me'),	
('Glenna Reichert',		'Chaim_McDermott@dana.io'),		
('Clementina DuBuque',		'Rey.Padberg@karina.biz') ;

END
$do$






