CREATE SCHEMA rh;

CREATE TABLE rh.category(
  id bigint NOT NULL PRIMARY KEY,
  name VARCHAR (50)
);


CREATE TABLE rh.role(
  id bigint NOT NULL PRIMARY KEY,
  name VARCHAR(50)
);



CREATE TABLE rh.status(
  id bigint NOT NULL PRIMARY KEY,
  name VARCHAR(50)
);



CREATE TABLE rh.user
(
  id bigint NOT NULL PRIMARY KEY,
  "e-mail" VARCHAR(50),
  login VARCHAR(50),
  password VARCHAR(50),
  "roleId" bigint,
  CONSTRAINT "roleID" FOREIGN KEY ("roleId")
  REFERENCES rh.role (id) MATCH SIMPLE
);



CREATE TABLE rh.order
(
    "id" bigint NOT NULL PRIMARY KEY,
    time timestamp without time zone,
    tablenumber bigint,
    close boolean,
    "userId" bigint,
    CONSTRAINT "userId" FOREIGN KEY ("userId")
    REFERENCES rh.user (id)
);



CREATE TABLE rh.dish
(
  "id" bigint NOT NULL PRIMARY KEY,
  name VARCHAR(50),
  description VARCHAR(1000),
  weight bigint,
  calories bigint,
  preparingtime timestamp without time zone,
  price bigint,
  avalibility boolean,
  picture VARCHAR(1000),
  "category_id" bigint,
  CONSTRAINT "category_id" FOREIGN KEY ("category_id")
  REFERENCES rh.category (id)
);


CREATE TABLE rh.orderdish
(
  quantity bigint,
  "dish_id" bigint,
  "status_id" bigint,
  "order_id" bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "status_id" FOREIGN KEY ("status_id")
  REFERENCES rh.status (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES rh.order (id)
)