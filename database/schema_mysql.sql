/* mysql-5.5 databse schema */

-- database
DROP DATABASE IF EXISTS	dssm;
CREATE DATABASE dssm DEFAULT CHARACTER SET utf8;
USE dssm;


/* ------------------------------------------------------------------ */
-- user
CREATE TABLE ssm_user(
	id INT AUTO_INCREMENT COMMENT 'user id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'user login name',
	password VARCHAR(128) NOT NULL COMMENT 'user login password',
	email VARCHAR(128) NOT NULL COMMENT 'user email address',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_user COMMENT 'user table';
ALTER TABLE ssm_user ADD INDEX IDX_NAME(name);

-- user detail
CREATE TABLE ssm_user_detail(
	id INT AUTO_INCREMENT COMMENT 'user detail id',
	user_id INT UNIQUE NOT NULL COMMENT 'related user id',
	real_name VARCHAR(128) COMMENT 'user real name',
	age INT COMMENT 'user age',
	register_time DATETIME NOT NULL COMMENT 'user register time',
	last_login_time DATETIME NOT NULL COMMENT 'user last login time',
	last_login_ip VARCHAR(128) NOT NULL COMMENT 'user last login ip address',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_user_detail COMMENT 'user detail information table';


-- article category
CREATE TABLE ssm_article_category(
	id INT AUTO_INCREMENT COMMENT 'article category id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'article catrgory name',
	description VARCHAR(255) COMMENT 'article category description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_article_category COMMENT 'article category table';

-- article
CREATE TABLE ssm_article(
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
ALTER TABLE ssm_article COMMENT 'article table';

-- article comment
CREATE TABLE ssm_article_comment(
	id INT AUTO_INCREMENT COMMENT 'article comment id',
	article_id INT NOT NULL COMMENT 'related article id',
	user_id INT NOT NULL COMMENT 'comment user id',
	headline VARCHAR(128) NOT NULL COMMENT 'article comment headline',
	content TEXT NOT NULL COMMENT 'article comment content',
	comment_time DATETIME NOT NULL COMMENT 'user comment time',
	deleted BOOLEAN NOT NULL DEFAULT FALSE COMMENT 'has deleted',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_article COMMENT 'article table';


/* ------------------------------------------------------------------ */
-- role
DROP TABLE IF EXISTS ssm_role;
CREATE TABLE ssm_role(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT 'role id',
	name VARCHAR(128) NOT NULL COMMENT 'role name',
	code VARCHAR(128) UNIQUE NOT NULL COMMENT 'role code',
	description VARCHAR(255) COMMENT 'role description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_role COMMENT 'role table';

-- admin
DROP TABLE IF EXISTS ssm_admin;
CREATE TABLE ssm_admin(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT 'admin id',
	login_name VARCHAR(128) UNIQUE NOT NULL COMMENT 'admin login name',
	password VARCHAR(128) NOT NULL COMMENT 'admin login password',
	real_name VARCHAR(128) NOT NULL COMMENT 'admin real name',
	email VARCHAR(128) NOT NULL COMMENT 'admin email address',
	mobile VARCHAR(16) NOT NULL COMMENT 'admin mobile',
	locked BOOLEAN NOT NULL DEFAULT FALSE COMMENT 'locked or not',
	create_aid SMALLINT UNSIGNED NOT NULL COMMENT 'create admin id',
	create_time DATETIME DEFAULT NULL COMMENT 'admin create time',
	last_login_ip VARCHAR(128) DEFAULT NULL COMMENT 'admin last login ip address',
	last_login_time DATETIME DEFAULT NULL COMMENT 'admin last login time',
	remark VARCHAR(255) DEFAULT NULL COMMENT 'admin remark info',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_admin COMMENT 'admin table';

-- admin role relation
DROP TABLE IF EXISTS ssm_relate_admin_role;
CREATE TABLE ssm_relate_admin_role(
	role_id SMALLINT UNSIGNED NOT NULL COMMENT 'related role id',
	admin_id SMALLINT UNSIGNED NOT NULL COMMENT 'related admin id',
	PRIMARY KEY(role_id, admin_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_relate_admin_role COMMENT 'admin role relation table';

-- permission
DROP TABLE IF EXISTS ssm_permission;
CREATE TABLE ssm_permission(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT 'permission id',
	name VARCHAR(128) NOT NULL COMMENT 'permission name',
	code VARCHAR(128) UNIQUE NOT NULL COMMENT 'permission code',
	description VARCHAR(255) COMMENT 'permission description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_permission COMMENT 'permission table';

-- role permission relation
DROP TABLE IF EXISTS ssm_relate_role_permission;
CREATE TABLE ssm_relate_role_permission(
	role_id SMALLINT UNSIGNED NOT NULL COMMENT 'related role id',
	permission_id SMALLINT UNSIGNED NOT NULL COMMENT 'related permission id',
	PRIMARY KEY(role_id, permission_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ssm_relate_role_permission COMMENT 'role permission relation table';

