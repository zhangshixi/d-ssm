/* mysql-5.5 databse schema */

-- database
DROP DATABASE IF EXISTS	mjee;
CREATE DATABASE mjee DEFAULT CHARACTER SET utf8;
USE mjee;


/* ------------------------------------------------------------------ */
-- user
CREATE TABLE mj_user(
	id INT AUTO_INCREMENT COMMENT 'user id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'user login name',
	password VARCHAR(128) NOT NULL COMMENT 'user login password',
	email VARCHAR(128) NOT NULL COMMENT 'user email address',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_user COMMENT 'user table';
ALTER TABLE mj_user ADD INDEX IDX_NAME(name);

-- user detail
CREATE TABLE mj_user_detail(
	id INT AUTO_INCREMENT COMMENT 'user detail id',
	user_id INT UNIQUE NOT NULL COMMENT 'related user id',
	real_name VARCHAR(128) COMMENT 'user real name',
	age INT COMMENT 'user age',
	register_time DATETIME NOT NULL COMMENT 'user register time',
	last_login_time DATETIME NOT NULL COMMENT 'user last login time',
	last_login_ip VARCHAR(128) NOT NULL COMMENT 'user last login ip address',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_user_detail COMMENT 'user detail information table';


-- article category
CREATE TABLE mj_article_category(
	id INT AUTO_INCREMENT COMMENT 'article category id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'article catrgory name',
	description VARCHAR(255) COMMENT 'article category description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_article_category COMMENT 'article category table';

-- article
CREATE TABLE mj_article(
	id INT AUTO_INCREMENT COMMENT 'article id',
	category_id INT NOT NULL COMMENT 'article category id',
	admin_id INT NOT NULL COMMENT 'article published admin id',
	headline VARCHAR(128) NOT NULL COMMENT 'article headline',
	summary VARCHAR(255) COMMENT 'article summary',
	content TEXT NOT NULL COMMENT 'article content',
	visit_number INT NOT NULL DEFAULT 0 COMMENT 'article visit number',
	comment_number INT NOT NULL DEFAULT 0 COMMENT 'article comment number',
	publish_time DATETIME NOT NULL COMMENT 'article publish time',
	update_time DATETIME COMMENT 'article update time',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_article COMMENT 'article table';

-- article comment
CREATE TABLE mj_article_comment(
	id INT AUTO_INCREMENT COMMENT 'article comment id',
	article_id INT NOT NULL COMMENT 'related article id',
	user_id INT NOT NULL COMMENT 'comment user id',
	headline VARCHAR(128) NOT NULL COMMENT 'article comment headline',
	content TEXT NOT NULL COMMENT 'article comment content',
	comment_time DATETIME NOT NULL COMMENT 'user comment time',
	deleted BOOLEAN NOT NULL DEFAULT FALSE COMMENT 'has deleted',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_article COMMENT 'article table';


/* ------------------------------------------------------------------ */
-- role
CREATE TABLE mj_role(
	id INT AUTO_INCREMENT COMMENT 'role id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'admin role name',
	description VARCHAR(255) COMMENT 'role description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_role COMMENT 'role table';

-- admin
CREATE TABLE mj_admin(
	id INT AUTO_INCREMENT COMMENT 'admin id',
	role_id INT COMMENT 'role id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'admin login name',
	password VARCHAR(128) NOT NULL COMMENT 'admin login password',
	email VARCHAR(128) NOT NULL COMMENT 'admin email address',
	create_time DATETIME NOT NULL COMMENT 'admin create time',
	last_login_ip VARCHAR(128) NOT NULL COMMENT 'admin last login ip address',
	last_login_time DATETIME NOT NULL COMMENT 'admin last login time',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_admin COMMENT 'admin table';
ALTER TABLE mj_admin ADD INDEX IDX_NAME(name);

-- admin role relation
CREATE TABLE mj_relation_admin_role(
	id INT AUTO_INCREMENT COMMENT 'admin role relation id',
	admin_id INT NOT NULL COMMENT 'admin id',
	role_id INT NOT NULL COMMENT 'role id',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_relation_admin_role COMMENT 'admin role relation table';

-- permission
CREATE TABLE mj_permission(
	id INT AUTO_INCREMENT COMMENT 'permission id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'permission name',
	url VARCHAR(128) UNIQUE NOT NULL COMMENT 'permission url',
	description VARCHAR(255) COMMENT 'permission description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_permission COMMENT 'permission table';

-- role permission relation
CREATE TABLE mj_relation_role_permission(
	id INT AUTO_INCREMENT COMMENT 'role permission relation id',
	role_id INT NOT NULL COMMENT 'role id',
	permission_id INT NOT NULL COMMENT 'permission id',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE mj_relation_role_permission COMMENT 'role permission relation table';

