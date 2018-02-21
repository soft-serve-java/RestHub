CREATE SCHEMA IF NOT EXISTS rh;
CREATE SEQUENCE IF NOT EXISTS rest_sequance;

CREATE TABLE rh.category (
  id   BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name VARCHAR(50)
);


CREATE TABLE rh.role (
  id   BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name VARCHAR(50)
);


CREATE TABLE rh.status (
  id   BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  name VARCHAR(50)
);


CREATE TABLE rh.user
(
  id       BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  email    VARCHAR(50),
  login    VARCHAR(50),
  password VARCHAR(50),
  role_id  BIGINT,
  CONSTRAINT "role_id" FOREIGN KEY ("role_id")
  REFERENCES rh.role (id) MATCH SIMPLE
);


CREATE TABLE rh.order
(
  id           BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  time         TIMESTAMP WITHOUT TIME ZONE,
  table_number INT,
  close        BOOLEAN,
  user_id      BIGINT,
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
  preparingtime INT,
  price         INT,
  availability  BOOLEAN,
  picture       VARCHAR(100),
  category_id   BIGINT,
  FOREIGN KEY ("category_id")
  REFERENCES rh.category (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE rh.orderdish
(
  id        BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('rest_sequance'),
  quantity  INT,
  dish_id   BIGINT,
  status_id BIGINT,
  order_id  BIGINT,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "status_id" FOREIGN KEY ("status_id")
  REFERENCES rh.status (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES rh.order (id)
);