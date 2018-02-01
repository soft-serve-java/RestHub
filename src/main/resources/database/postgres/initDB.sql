CREATE SCHEMA rh;

CREATE TABLE rh.category(
    id bigint NOT NULL PRIMARY KEY,
    name character(50)
);


CREATE TABLE rh.role(
    id bigint NOT NULL PRIMARY KEY,
    name character(50)
);



CREATE TABLE rh.status(
    id bigint NOT NULL PRIMARY KEY,
    name character(50)
);



CREATE TABLE rh.user
(
    id bigint NOT NULL PRIMARY KEY,
    "e-mail" character(50),
    login character(50),
    password character(50),
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
    name character(50),
    description character(1000),
    weight bigint,
    calories bigint,
    preparingtime timestamp without time zone,
    price bigint,
    avalibility boolean,
    picture path,
    "categoryId" bigint,
    CONSTRAINT "categoryId" FOREIGN KEY ("categoryId")
    REFERENCES rh.category (id)
);


CREATE TABLE rh.orderdish
(
    quantity bigint,
    "dishId" bigint,
    "statusId" bigint,
    "orderId" bigint,
    CONSTRAINT "dishId" FOREIGN KEY ("dishId")
    REFERENCES rh.dish (id),
    CONSTRAINT "statusId" FOREIGN KEY ("statusId")
    REFERENCES rh.status (id),
    CONSTRAINT "orderId" FOREIGN KEY ("orderId")
    REFERENCES rh.order (id)
)