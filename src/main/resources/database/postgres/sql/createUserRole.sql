DROP SEQUENCE IF EXISTS userrole_sequence CASCADE;
CREATE SEQUENCE userrole_sequence;
CREATE TABLE rh.userrole
(
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('userrole_sequence'),
  user_id bigint NOT NULL,
  role_id bigint NOT NULL
  /*FOREIGN KEY (user_id) REFERENCES rh."user"(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (role_id) REFERENCES rh."role"(id) ON DELETE CASCADE ON UPDATE CASCADE*/
);

ALTER TABLE rh.userrole ADD CONSTRAINT user_id_const FOREIGN KEY (user_id) REFERENCES rh."user" (id) MATCH FULL;
ALTER TABLE rh.userrole ADD CONSTRAINT role_id_const FOREIGN KEY (role_id) REFERENCES rh."role" (id) MATCH FULL;