ALTER TABLE users
ADD default_workspace_id binary(16);

ALTER TABLE users
ADD CONSTRAINT FK_users_default_workspace_id
FOREIGN KEY (default_workspace_id) REFERENCES workspaces(ID);
