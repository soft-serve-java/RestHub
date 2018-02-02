DROP  SCHEMA IF EXISTS  rh CASCADE;
CREATE SCHEMA rh;
DROP SEQUENCE IF EXISTS  rest_sequance;
CREATE  SEQUENCE rest_sequance;

CREATE TABLE rh.category(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name varchar(50)
);


CREATE TABLE rh.role(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name varchar(50)
);



CREATE TABLE rh.status(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name varchar(50)
);



CREATE TABLE rh.user
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  "email" varchar(50),
  login varchar(50),
  password varchar(50),
  "role_id" bigint,
  CONSTRAINT "role_id" FOREIGN KEY ("role_id")
  REFERENCES rh.role (id) MATCH SIMPLE
);



CREATE TABLE rh.order
(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  time timestamp without time zone,
  tablenumber int,
  close boolean,
  "user_id" bigint,
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES rh.user (id)
);



CREATE TABLE rh.dish
(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name varchar(50),
  description varchar(1000),
  weight int,
  calories int,
  preparingtime varchar(50),
  price int,
  avalibility boolean,
  picture varchar(100),
  "category_id" bigint,
  CONSTRAINT "category_id" FOREIGN KEY ("category_id")
  REFERENCES rh.category (id)
);


CREATE TABLE rh.orderdish
(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  quantity int,
  "dish_id" bigint,
  "status" VARCHAR(40),
  "order_id" bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES rh.order (id)
)


