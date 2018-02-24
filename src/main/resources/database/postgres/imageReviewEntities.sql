DROP SEQUENCE IF EXISTS image_sequence CASCADE;
CREATE SEQUENCE image_sequence;
CREATE TABLE rh.image
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('image_sequence'),
  url VARCHAR,
  dish_id bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id)
);


DROP SEQUENCE IF EXISTS review_sequence CASCADE;
CREATE SEQUENCE review_sequence;
CREATE TABLE rh.review
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('review_sequence'),
  comment_text VARCHAR(1000),
  date TIMESTAMP,
  dish_id bigint,
  user_id bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES rh.user (id)
);