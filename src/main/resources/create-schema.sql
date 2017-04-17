/*CREATE TABLE POST (
  ID      INT          NOT NULL AUTO_INCREMENT,
  CONTENT VARCHAR(250) NULL,
  PRIMARY KEY (id)
);*/
create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(250) not null,
      enabled boolean not null
  );

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);
/*
table POST
*/
CREATE TABLE post (
idPost int NOT NULL AUTO_INCREMENT,
CONTENT varchar_ignorecase(140) NOT NULL,
username varchar_ignorecase(50) NOT NULL,
PRIMARY KEY (idPost),
CONSTRAINT fkPost_user FOREIGN KEY (username) REFERENCES users(username)
);


CREATE TABLE comment (
idComment int NOT NULL AUTO_INCREMENT,
username varchar_ignorecase(50) NOT NULL,
idPost int NOT NULL,
content varchar(15000) NOT NULL,
PRIMARY KEY (idComment),
CONSTRAINT fkco_user FOREIGN KEY (username) REFERENCES users (username),
CONSTRAINT fkco_post FOREIGN KEY (idPost) REFERENCES POST (idPost)
);

CREATE TABLE tbLike
(
  idLike int NOT NULL AUTO_INCREMENT,
  username varchar_ignorecase(50) not null,
  idPost int NOT NULL,
  CONSTRAINT fklike_user FOREIGN KEY (username) REFERENCES users (username),
  CONSTRAINT fklike_post FOREIGN KEY (idPost) REFERENCES POST (idPost),
  PRIMARY KEY (idLike)
);