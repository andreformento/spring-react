CREATE TABLE workspaces (
  id binary(16) NOT NULL PRIMARY KEY,
  name varchar(255) NOT NULL,
  owner_id binary(16) NOT NULL,
  KEY fk_workspaces_owner (owner_id),
  CONSTRAINT fk_workspaces_owner FOREIGN KEY (owner_id) REFERENCES users (id)
);
