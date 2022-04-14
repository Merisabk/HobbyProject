drop table if exists recipe CASCADE;
create table recipe (
id INTEGER auto_increment, 
recipe_name VARCHAR(255) not null, 
category VARCHAR(255) not null, 
servings INTEGER not null, 
cooking_time INTEGER not null, 
ingredients VARCHAR(255) not null,
PRIMARY KEY (id) 
);