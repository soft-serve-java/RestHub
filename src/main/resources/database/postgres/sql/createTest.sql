DROP SCHEMA IF EXISTS rh CASCADE;

CREATE SCHEMA rh;

DROP SEQUENCE IF EXISTS category_sequence;
CREATE SEQUENCE category_sequence;

DROP SEQUENCE IF EXISTS role_sequence;
CREATE SEQUENCE role_sequence;

DROP SEQUENCE IF EXISTS status_sequence;
CREATE SEQUENCE status_sequence;

DROP SEQUENCE IF EXISTS user_sequence;
CREATE SEQUENCE user_sequence;

DROP SEQUENCE IF EXISTS order_sequence;
CREATE SEQUENCE order_sequence;

DROP SEQUENCE IF EXISTS dish_sequence;
CREATE SEQUENCE dish_sequence;

DROP SEQUENCE IF EXISTS orderdish_sequence;
CREATE SEQUENCE orderdish_sequence;

CREATE TABLE rh.category (
  id   BIGINT      NOT NULL UNIQUE PRIMARY KEY DEFAULT nextval('category_sequence'),
  name VARCHAR(50) NOT NULL
);

CREATE TABLE rh.role (
  id   BIGINT      NOT NULL UNIQUE PRIMARY KEY DEFAULT nextval('role_sequence'),
  name VARCHAR(50) NOT NULL
);

CREATE TABLE rh.status (
  id   BIGINT      NOT NULL UNIQUE PRIMARY KEY DEFAULT nextval('status_sequence'),
  name VARCHAR(50) NOT NULL
);

CREATE TABLE rh.user
(
  id      BIGINT      NOT NULL PRIMARY KEY DEFAULT nextval('user_sequence'),
  email   VARCHAR(50) NOT NULL UNIQUE,
  login   VARCHAR(50) NOT NULL UNIQUE,
  psword  VARCHAR(50) NOT NULL,
  role_id BIGINT      NOT NULL,
  FOREIGN KEY ("role_id")
  REFERENCES rh.role (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE rh.order
(
  id           BIGINT                      NOT NULL PRIMARY KEY UNIQUE DEFAULT nextval('order_sequence') NOT NULL,
  time         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  table_number INT                         NOT NULL,
  closed       BOOLEAN                     NOT NULL,
  user_id      BIGINT                      NOT NULL,
  FOREIGN KEY ("user_id")
  REFERENCES rh.user (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE rh.dish
(
  id            BIGINT                                                NOT NULL PRIMARY KEY UNIQUE DEFAULT nextval(
      'dish_sequence'),
  name          VARCHAR(50)                                           NOT NULL UNIQUE,
  description   VARCHAR(1000)                                         NOT NULL,
  weight        INT CHECK (CAST(weight AS INT) > 0)                   NOT NULL,
  calories      INT
    CHECK (CAST(calories AS INT) > 0)                                 NOT NULL,
  preparingtime INT
    CHECK (CAST(preparingtime AS INT) > 0)                            NOT NULL,
  price         INT
    CHECK (CAST(price AS INT) > 0)                                    NOT NULL,
  availability  BOOLEAN                                               NOT NULL,
  picture       VARCHAR(100)                                          NOT NULL,
  category_id   BIGINT                                                NOT NULL,
  FOREIGN KEY ("category_id")
  REFERENCES rh.category (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE rh.orderdish
(
  id        BIGINT NOT NULL PRIMARY KEY UNIQUE DEFAULT nextval('orderdish_sequence'),
  quantity  INT    NOT NULL  CHECK (CAST(quantity AS INT) > 0)              ,
  dish_id   BIGINT NOT NULL,
  status_id BIGINT NOT NULL,
  order_id  BIGINT NOT NULL,
  FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY ("status_id")
  REFERENCES rh.status (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY ("order_id")
  REFERENCES rh.order (id) ON DELETE CASCADE ON UPDATE CASCADE
);