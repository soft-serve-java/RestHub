INSERT INTO rh.category (name) VALUES ('breakfast');

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
            , category_id) VALUES ('Carrot salad', 'Carrot with sunflower seeds and olive oil'
            , 300, 1000, 5, 10, true, 5);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
            , category_id) VALUES ('Cocoa', 'Hot cocoa with marshmallows'
            , 400, 1100, 7, 12, true, 5);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
            , category_id) VALUES ('Buckwheat with mushrooms', 'buckwheat cooked with mushrooms and carrots'
            , 350, 1200, 10, 7, true, 5);

INSERT INTO rh.image (url, dish_id) VALUES ('/assets/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 8);
INSERT INTO rh.image (url, dish_id) VALUES ('/assets/images/Arugula%20salad.jpg', 9);
INSERT INTO rh.image (url, dish_id) VALUES ('/assets/images/Spicy%20buffalo%20Cauliflower.jpg', 10);

INSERT INTO rh.tag (title) VALUES ('breakfast');

INSERT INTO rh.tagdish (tag_id, dish_id) VALUES (1, 8);
INSERT INTO rh.tagdish (tag_id, dish_id) VALUES (1, 9);
INSERT INTO rh.tagdish (tag_id, dish_id) VALUES (1, 10);