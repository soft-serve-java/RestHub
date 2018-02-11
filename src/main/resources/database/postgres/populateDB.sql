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


INSERT INTO rh.user(email, login, password, role_id) VALUES ('feed@ukr.net', 'beefoot', 'asegfa254', 1);
INSERT INTO rh.user(email, login, password, role_id) VALUES ('newest@ukr.net', 'misterpister', '147qwerty', 2);
INSERT INTO rh.user(email, login, password, role_id) VALUES ('albinos@gmail.com', 'bigbro', '123456a', 3);
INSERT INTO rh.user(email, login, password, role_id) VALUES ('header@i.ua', 'campid', '15962be23', 4);
INSERT INTO rh.user(email, login, password, role_id) VALUES ('news@ukr.net', 'reporter', 'qwertrty', 4);
INSERT INTO rh.user(email, login, password, role_id) VALUES ('intuit@i.ua', 'ititit', 'mkoijnb', 4);

