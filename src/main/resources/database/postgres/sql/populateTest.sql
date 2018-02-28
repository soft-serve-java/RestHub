INSERT INTO rh.role (name)
VALUES
  ('Administrator'), ('Cook'),
  ('Waiter'), ('User');

INSERT INTO rh.category (name)
VALUES
  ('Soups'), ('Meals'),
  ('Drinks'), ('Deserts');

INSERT INTO rh.status (name)
VALUES
  ('Preparing'), ('Cooking'), ('Delivery');

INSERT INTO rh.dish (name, description, weight, calories, preparingtime, price,
                     availability, picture, category_id)
VALUES
  ('White corn guacamole',
   'Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.',
   200, 1000, 40, 3, TRUE, '/images/White%20corn%20guacamole.jpg', 4),

  ('Sweet white corn',
   'Very subtle.',
   200, 1000, 40, 6, TRUE, '/images/White%20corn%20sweet.jpg', 4),

  ('Petite wedge',
   'Diced avocado, sweet white corn, black beans, jicama, bell peppers, fresh cilantro and serrano peppers. Served with housemade blue & white corn tortilla chips.',
   400, 1450, 15, 35, TRUE, '/images/White%20corn%20guacamole.jpg', 4),

  ('Arugula salad',
   'Sun-dried tomatoes, toasted almonds and shaved Parmesan served with housemade lemon vinaigrette.',
   100, 1400, 20, 10, TRUE, '/images/Arugula%20salad.jpg', 2),

  ('Spinach artishoke dip',
   'Served hot with housemade blue & white corn tortilla chips..',
   100, 1300, 12, 93, TRUE, '/images/Spinach%20artishoke%20dip.jpg', 2),

  ('Shaved mushroom & spinach flatbread',
   'Cremini mushrooms, sauteed spinach and California Olive Ranch extra virgin olive oil with Romano and Parmesan.',
   100, 1010, 2, 70, TRUE, '/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 1),

  ('Mushrooms', 'Very tasty',
   100, 400, 28, 80, TRUE, '/images/mushroom%20&%20spinach%20flatbread.jpg', 1),

  ('Cranberry cocktail',
   'Cool drink',
   100, 950, 20, 12, TRUE, '/images/Shaved%20mushroom%20&%20spinach%20flatbread.jpg', 3),

  ('Strawberry cocktail',
   'Fresh and subtle drink',
   100, 900, 25, 10, TRUE, '/images/spinach%20flatbread.jpg', 3);

/*INSERT INTO rh.user (email, login, psword, role_id)
VALUES
  ('feed@ukr.net', 'beefoot', 'asegfa254', 1),
  ('newest@ukr.net', 'misterpister', '147qwerty', 2),
  ('albinos@gmail.com', 'bigbro', '123456a', 3),
  ('header@i.ua', 'campid', '15962be23', 4),
  ('news@ukr.net', 'reporter', 'qwertrty', 4),
  ('intuit@i.ua', 'ititit', 'mkoijnb', 4);

INSERT INTO rh.order (time, table_number, closed, user_id)
VALUES
  ('NOW()', 1, FALSE, '4'),
  ('NOW()', 1, FALSE, '4'),
  ('NOW()', 1, FALSE, '4'),
  ('NOW()', 1, FALSE, '4'),
  ('NOW()', 1, FALSE, '4');*/