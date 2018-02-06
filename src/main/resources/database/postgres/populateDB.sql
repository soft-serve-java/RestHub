INSERT INTO role (name) VALUES ('administrator');
INSERT INTO role (name) VALUES ('cook');
INSERT INTO role (name) VALUES ('waiter');
INSERT INTO role (name) VALUES ('user');


INSERT INTO category (name) VALUES ('soups');
INSERT INTO category (name) VALUES ('meals');
INSERT INTO category (name) VALUES ('drinks');
INSERT INTO category (name) VALUES ('deserts');


INSERT INTO status (name) VALUES ('preparing');
INSERT INTO status (name) VALUES ('cooking');
INSERT INTO status (name) VALUES ('delivery');


INSERT INTO rh."user"(id, "email", login, password, "role_id") VALUES (1, 'feed@ukr.net', 'beefoot', 'asegfa254', 1);
INSERT INTO rh."user"(id, "email", login, password, "role_id") VALUES (2, 'newest@ukr.net', 'misterpister', '147qwerty', 2);
INSERT INTO rh."user"(id, "email", login, password, "role_id") VALUES (3, 'albinos@gmail.com', 'bigbro', '123456a', 3);
INSERT INTO rh."user"(id, "email", login, password, "role_id") VALUES (4, 'header@i.ua', 'campid', '15962be23', 4);
INSERT INTO rh."user"(id, "email", login, password, "role_id") VALUES (5, 'news@ukr.net', 'reporter', 'qwertrty', 4);
INSERT INTO rh."user"(id, "email", login, password, "role_id") VALUES (6, 'intuit@i.ua', 'ititit', 'mkoijnb', 4);


INSERT INTO rh."order"(id, "time", tablenumber, close, "user_id") VALUES (1, 'NOW()', 1, FALSE, '4');
INSERT INTO rh."order"(id, "time", tablenumber, close, "user_id") VALUES (2, 'NOW()', 1, FALSE, '4');
INSERT INTO rh."order"(id, "time", tablenumber, close, "user_id") VALUES (3, 'NOW()', 1, FALSE, '4');
INSERT INTO rh."order"(id, "time", tablenumber, close, "user_id") VALUES (4, 'NOW()', 1, FALSE, '4');
INSERT INTO rh."order"(id, "time", tablenumber, close, "user_id") VALUES (5, 'NOW()', 1, FALSE, '4');

