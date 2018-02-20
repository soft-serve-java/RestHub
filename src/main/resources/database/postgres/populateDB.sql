
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


INSERT INTO rh.user(email, password, name, role_id) VALUES ('admin@i.ua', '1111', 'admin', 1);
INSERT INTO rh.user(email, password, name, role_id) VALUES ('cook@i.ua', '1111', 'cook', 2);
INSERT INTO rh.user(email, password, name, role_id) VALUES ('waiter@i.ua', '1111', 'waiter', 3);
INSERT INTO rh.user(email, password, name, role_id) VALUES ('user@i.ua', '1111', 'user', 4);