DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA public;

CREATE SEQUENCE public_category;
CREATE TABLE public.category(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('public_category'),
  name varchar(50)
);

CREATE SEQUENCE public_role;
CREATE TABLE public.role(
  id bigint NOT NULL PRIMARY KEY DEFAULT  nextval('public_role'),
  name varchar(50)
);

CREATE SEQUENCE public_status;
CREATE TABLE public.status(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('public_status'),
  name varchar(50)
);

CREATE SEQUENCE public_user;
CREATE TABLE public.user(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('public_user'),
  "email" varchar(50),
  login varchar(50),
  password varchar(50),
  "role_id" bigint,
  CONSTRAINT "role_id" FOREIGN KEY ("role_id")
  REFERENCES public.role (id) MATCH SIMPLE
);

CREATE SEQUENCE public_order;
CREATE TABLE public.order(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('public_order'),
  time timestamp without time zone,
  tablenumber int,
  close boolean,
  "user_id" bigint,
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES public.user (id)
);

CREATE SEQUENCE public_dish;
CREATE TABLE public.dish(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('public_dish'),
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
  REFERENCES public.category (id)
);

CREATE SEQUENCE public_orderdish;
CREATE TABLE public.orderdish(
  "id" bigint NOT NULL PRIMARY KEY DEFAULT nextval('public_orderdish'),
  quantity int,
  "dish_id" bigint,
  "status_id" bigint,
  "order_id" bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES public.dish (id),
  CONSTRAINT "status_id" FOREIGN KEY ("status_id")
  REFERENCES public.status (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES public.order (id)
);

