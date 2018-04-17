DROP SEQUENCE IF EXISTS tag_sequence CASCADE;
CREATE SEQUENCE tag_sequence;
CREATE TABLE rh.tag
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('tag_sequence'),
  title VARCHAR UNIQUE
);

DROP SEQUENCE IF EXISTS tagdish_sequence CASCADE;
CREATE SEQUENCE tagdish_sequence;
CREATE TABLE rh.tagdish
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('tagdish_sequence'),
  tag_id bigint,
  dish_id bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "tag_id" FOREIGN KEY ("tag_id")
  REFERENCES rh.tag (id)
);