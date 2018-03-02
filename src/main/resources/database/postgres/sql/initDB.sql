DROP SCHEMA IF EXISTS rh CASCADE;
CREATE SCHEMA rh;

DROP SEQUENCE IF EXISTS category_sequance CASCADE;
CREATE SEQUENCE category_sequance;
CREATE TABLE rh.category(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('category_sequance'),
  name varchar(50)
);

DROP SEQUENCE IF EXISTS role_sequance CASCADE;
CREATE SEQUENCE role_sequance;
CREATE TABLE rh.role(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('role_sequance'),
  name varchar(50)
);

DROP SEQUENCE IF EXISTS status_sequance CASCADE;
CREATE SEQUENCE status_sequance;
CREATE TABLE rh.status(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('status_sequance'),
  name varchar(50)
);

DROP SEQUENCE IF EXISTS user_sequance CASCADE;
CREATE SEQUENCE user_sequance;
CREATE TABLE rh.user
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('user_sequance'),
  email varchar(50),
  password varchar(100),
  name varchar(50),
  enabled boolean,
  confirmationtoken varchar(100),
  role_id bigint,
  CONSTRAINT role_id FOREIGN KEY (role_id)
  REFERENCES rh.role (id)
);

DROP SEQUENCE IF EXISTS order_sequense CASCADE;
CREATE SEQUENCE order_sequense;
CREATE TABLE rh.order
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('order_sequense'),
  time timestamp without time zone,
  tablenumber int,
  close boolean,
  user_id bigint,
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES rh.user (id)
);

DROP SEQUENCE IF EXISTS dish_sequense CASCADE;
CREATE SEQUENCE dish_sequense;
CREATE TABLE rh.dish
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('dish_sequense'),
  name varchar(50),
  description varchar(1000),
  weight int,
  calories int,
  preparingtime varchar(50),
  price int,
  avalibility boolean,
  picture varchar(100),
  category_id bigint,
  CONSTRAINT "category_id" FOREIGN KEY ("category_id")
  REFERENCES rh.category (id)
);

DROP SEQUENCE IF EXISTS orderdish_sequense CASCADE;
CREATE SEQUENCE orderdish_sequense;
CREATE TABLE rh.orderdish
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('orderdish_sequense'),
  quantity int,
  dish_id bigint,
  status_id bigint,
  order_id bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "status_id" FOREIGN KEY ("status_id")
  REFERENCES rh.status (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES rh.order (id)
);