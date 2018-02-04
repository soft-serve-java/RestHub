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


INSERT INTO "user"("email", login, password, "role_id") VALUES ('feed@ukr.net', 'beefoot', 'asegfa254', 1);
INSERT INTO "user"("email", login, password, "role_id") VALUES ('newest@ukr.net', 'misterpister', '147qwerty', 2);
INSERT INTO "user"("email", login, password, "role_id") VALUES ('albinos@gmail.com', 'bigbro', '123456a', 3);
INSERT INTO "user"("email", login, password, "role_id") VALUES ('header@i.ua', 'campid', '15962be23', 4);
INSERT INTO "user"("email", login, password, "role_id") VALUES ('news@ukr.net', 'reporter', 'qwertrty', 4);
INSERT INTO "user"("email", login, password, "role_id") VALUES ('intuit@i.ua', 'ititit', 'mkoijnb', 4);


INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '1');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '1');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '2');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '3');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '4');


INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '4');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '4');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '4');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '4');
INSERT INTO "order"("time", tablenumber, close, "user_id") VALUES ('NOW()', 1, FALSE, '4');