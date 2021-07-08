CREATE TABLE users (
  id binary(16) NOT NULL PRIMARY KEY,
  email varchar(255) NOT NULL UNIQUE,
  email_verified bit(1) NOT NULL,
  image_url varchar(255) DEFAULT NULL,
  name varchar(255) NOT NULL,
  password varchar(255) DEFAULT NULL,
  provider varchar(255) DEFAULT NULL,
  provider_id varchar(255) DEFAULT NULL
);
