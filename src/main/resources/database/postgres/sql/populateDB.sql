INSERT INTO rh.role (name) VALUES ('administrator');
INSERT INTO rh.role (name) VALUES ('cook');
INSERT INTO rh.role (name) VALUES ('waiter');
INSERT INTO rh.role (name) VALUES ('user');


INSERT INTO rh.category (name) VALUES ('soups');
INSERT INTO rh.category (name) VALUES ('meals');
INSERT INTO rh.category (name) VALUES ('drinks');
INSERT INTO rh.category (name) VALUES ('deserts');


INSERT INTO rh.status (name) VALUES ('preparing');
INSERT INTO rh.status (name) VALUES ('cooking');
INSERT INTO rh.status (name) VALUES ('delivery');


INSERT INTO rh.user(email, password, name, confirmationtoken, enabled) VALUES ('admin@i.ua', '$2a$10$tkXKWLaylsMChogk6Ros.OXHjp5BDVpNlkuVFyrTJNjxjNtpu/6Gu',
'admin', '123456', TRUE);
INSERT INTO rh.user(email, password, name, confirmationtoken, enabled) VALUES ('cook@i.ua', '$2a$10$OU/O/OYT7iOrwBNCs9ZRFOIS4qQs6Y34.z4kR3ddqql2uXNh2D8.u',
 'cook', '123456', TRUE);
INSERT INTO rh.user(email, password, name, confirmationtoken, enabled) VALUES ('waiter@i.ua', '$2a$10$ReL9IZ/AfhaNqV4NgK1KR.Jn6294C0WbSDOD3M1Xy2IRX0px4ApYq',
'waiter', '123456', TRUE);
INSERT INTO rh.user(email, password, name, confirmationtoken, enabled) VALUES ('user@i.ua', '$2a$10$SpDt2DfR05gV97lmQ881l.FpwpAD6167RsJw8GNqVUynZojhPwQNq',
'user', '123456', TRUE);

INSERT INTO rh.userrole (user_id, role_id) VALUES (1, 1);
INSERT INTO rh.userrole (user_id, role_id) VALUES (2, 2);
INSERT INTO rh.userrole (user_id, role_id) VALUES (3, 3);
INSERT INTO rh.userrole (user_id, role_id) VALUES (4, 4);


INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
, picture, category_id) VALUES ('Spicy buffalo Cauliflower', 'Fresh cauliflower florets buttermilk-battered and fried to a golden brown, then tossed in housemade Sriracha buffalo sauce and topped with a salad of celery, Gorgonzola and cilantro.'
, 300, 1200, 3, 130, true, '/images/Spicy%20buffalo%20Cauliflower.jpg', 1);


INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
, picture, category_id) VALUES ('Mushroom & spinach flatbread', 'Cremini mushrooms, sauteed spinach and California Olive Ranch extra virgin olive oil with Romano and Parmesan.'
  , 100, 1400, 25, 3, true, '/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 1);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
  , picture, category_id) VALUES ('White corn guacamole', 'Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.'
  , 200, 1000, 40, 3, true, '/images/White%20corn%20guacamole.jpg', 3);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
  , picture, category_id) VALUES ('Petite wedge', 'Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.'
  , 400, 1450, 15, 3, true, '/images/White%20corn%20guacamole.jpg', 2);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
  , picture, category_id) VALUES ('Arugula salad',
    'Sun-dried tomatoes, toasted almonds and shaved Parmesan served with housemade lemon vinaigrette.'
  , 100, 1400, 2, 30, true, '/images/Arugula%20salad.jpg', 2);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
  , picture, category_id) VALUES ('Spinach artishoke dip', 'Served hot with housemade blue & white corn tortilla chips..'
  , 100, 1400, 2, 30, true, '/images/Spinach%20artishoke%20dip.jpg', 1);

INSERT INTO rh.dish(name, description, weight, calories, preparingtime, price, availability
  , picture, category_id) VALUES ('Shaved mushroom & spinach flatbread', 'Cremini mushrooms, sauteed spinach and California Olive Ranch extra virgin olive oil with Romano and Parmesan.'
  , 100, 1400, 2, 30, true, '/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 1);