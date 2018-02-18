
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


INSERT INTO rh.user(login, password, name, role_id) VALUES ('adminLogin', '1111', 'alex', 1);
INSERT INTO rh.user(login, password, name, role_id) VALUES ('cookLogin', '1111', 'alex2', 2);
INSERT INTO rh.user(login, password, name, role_id) VALUES ('waiterLogin', '1111', 'alex3', 3);
INSERT INTO rh.user(login, password, name, role_id) VALUES ('userLogin', '1111', 'alex4', 4);