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
  id       BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  email    VARCHAR(50),
  login    VARCHAR(50),
  password varchar(50),
  role_id  BIGINT,
  CONSTRAINT "role_id" FOREIGN KEY ("role_id")
  REFERENCES rh.role (id) MATCH SIMPLE
);



CREATE TABLE rh.order
(
  id          BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  time        TIMESTAMP WITHOUT TIME ZONE,
  tablenumber int,
  close       BOOLEAN,
  user_id     BIGINT,
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES rh.user (id)
);



CREATE TABLE rh.dish
(
  id            BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name          VARCHAR(50),
  description   VARCHAR(1000),
  weight        INT,
  calories      INT,
  preparingtime varchar(50),
  price         INT,
  avalibility   BOOLEAN,
  picture       VARCHAR(100),
  category_id   BIGINT,
  CONSTRAINT "category_id" FOREIGN KEY ("category_id")
  REFERENCES rh.category (id)
);


CREATE TABLE rh.orderdish
(
  id       BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  quantity int,
  dish_id  BIGINT,
  status   VARCHAR(40),
  order_id BIGINT,
  CONSTRAINT dish_id FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT order_id FOREIGN KEY ("order_id")
  REFERENCES rh.order (id)
)


