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
  approved BOOLEAN,
  dish_id bigint,
  user_id bigint,
  CONSTRAINT "dish_id" FOREIGN KEY ("dish_id")
  REFERENCES rh.dish (id),
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES rh.user (id)
);

ALTER TABLE rh.dish
  DROP COLUMN picture;

INSERT INTO rh.image (url, dish_id) VALUES ('/images/Spicy%20buffalo%20Cauliflower.jpg', 1);
INSERT INTO rh.image (url, dish_id) VALUES ('/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 2);
INSERT INTO rh.image (url, dish_id) VALUES ('/images/White%20corn%20guacamole.jpg', 3);
INSERT INTO rh.image (url, dish_id) VALUES ('/images/White%20corn%20guacamole.jpg', 4);
INSERT INTO rh.image (url, dish_id) VALUES ('/images/Arugula%20salad.jpg', 5);
INSERT INTO rh.image (url, dish_id) VALUES ('/images/Spinach%20artishoke%20dip.jpg', 6);
INSERT INTO rh.image (url, dish_id) VALUES ('/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 7);