-- CREATE DATABASE test;
-- create user for matching to the application.properties for tests
-- CREATE USER my WITH PASSWORD '1234';

-- GRANT ALL ON DATABASE test TO my;
DROP TABLE IF EXISTS rh.orderdish;
DROP TABLE IF EXISTS rh.status;

DROP TABLE IF EXISTS rh.dish;
DROP TABLE IF EXISTS rh.order;

DROP TABLE IF EXISTS rh.user;
DROP TABLE IF EXISTS rh.category;
DROP TABLE IF EXISTS rh.role;

DROP SCHEMA IF EXISTS rh;
CREATE SCHEMA rh;

-- sequences stuff
DROP SEQUENCE IF EXISTS category_sequance;
CREATE SEQUENCE category_sequance;

DROP SEQUENCE IF EXISTS role_sequance;
CREATE SEQUENCE role_sequance;

DROP SEQUENCE IF EXISTS status_sequance;
CREATE SEQUENCE status_sequance;

DROP SEQUENCE IF EXISTS user_sequance;
CREATE SEQUENCE user_sequance;

DROP SEQUENCE IF EXISTS order_sequance;
CREATE SEQUENCE order_sequance;

DROP SEQUENCE IF EXISTS dish_sequance;
CREATE SEQUENCE dish_sequance;

DROP SEQUENCE IF EXISTS orderdish_sequance;
CREATE SEQUENCE orderdish_sequance;
-- end of sequences stuff

CREATE TABLE rh.category(
  id bigint NOT NULL UNIQUE PRIMARY KEY DEFAULT nextval('category_sequance'),
  name varchar(50)
);

CREATE TABLE rh.role(
  id bigint NOT NULL UNIQUE PRIMARY KEY DEFAULT nextval('role_sequance'),
  name varchar(50)
);

CREATE TABLE rh.status(
  id bigint NOT NULL UNIQUE PRIMARY KEY DEFAULT nextval('status_sequance'),
  name varchar(50)
);

CREATE TABLE rh.user
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('user_sequance'),
  email varchar(50) NOT NULL UNIQUE,
  login varchar(50) NOT NULL UNIQUE,
  psword varchar(50) NOT NULL,
  role_id bigint NOT NULL,
  CONSTRAINT "role_id" FOREIGN KEY ("role_id")
  REFERENCES rh.role (id) MATCH SIMPLE
);

CREATE TABLE rh.order
(
  id bigint NOT NULL PRIMARY KEY UNIQUE DEFAULT nextval('order_sequance') NOT NULL,
  time timestamp without time zone NOT NULL,
  table_number int NOT NULL,
  closed boolean NOT NULL,
  user_id bigint NOT NULL,
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES rh.user (id)
);

CREATE TABLE rh.dish
(
  id bigint NOT NULL PRIMARY KEY UNIQUE DEFAULT nextval('dish_sequance'),
  name varchar(50) NOT NULL UNIQUE,
  description varchar(1000) NOT NULL,
  weight int NOT NULL,
  calories int NOT NULL,
  preparingtime varchar(50) NOT NULL,
  price int NOT NULL,
  avalibility boolean NOT NULL,
  picture varchar(100) NOT NULL,
  category_id bigint NOT NULL,
  CONSTRAINT "category_id" FOREIGN KEY ("category_id")
  REFERENCES rh.category (id)
);

CREATE TABLE rh.orderdish
(
  id bigint NOT NULL PRIMARY KEY UNIQUE DEFAULT nextval('orderdish_sequance'),
  quantity int NOT NULL,
  dish_id bigint NOT NULL,
  status_id bigint NOT NULL,
  order_id bigint NOT NULL,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "status_id" FOREIGN KEY ("status_id")
  REFERENCES rh.status (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES rh.order (id)
);