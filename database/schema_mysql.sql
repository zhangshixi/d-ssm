/* mysql-5.5 databse schema */

-- database
DROP DATABASE IF EXISTS	dssm;
CREATE DATABASE dssm DEFAULT CHARACTER SET utf8;
USE dssm;

/* ------------------------------------------------------------------ */
-- role
DROP TABLE IF EXISTS ssm_role;
CREATE TABLE ssm_role(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT 'role id',
	name VARCHAR(128) NOT NULL COMMENT 'role name',
	code VARCHAR(128) UNIQUE NOT NULL COMMENT 'role code',
	description VARCHAR(255) COMMENT 'role description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'role table';

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
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'admin table';

-- admin role relation
DROP TABLE IF EXISTS ssm_relate_admin_role;
CREATE TABLE ssm_relate_admin_role(
	admin_id SMALLINT UNSIGNED NOT NULL COMMENT 'related admin id',
	role_id SMALLINT UNSIGNED NOT NULL COMMENT 'related role id',
	PRIMARY KEY(role_id, admin_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'admin role relation table';

-- permission
DROP TABLE IF EXISTS ssm_permission;
CREATE TABLE ssm_permission(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT 'permission id',
	name VARCHAR(128) NOT NULL COMMENT 'permission name',
	code VARCHAR(128) UNIQUE NOT NULL COMMENT 'permission code',
	description VARCHAR(255) COMMENT 'permission description',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'permission table';

-- role permission relation
DROP TABLE IF EXISTS ssm_relate_role_permission;
CREATE TABLE ssm_relate_role_permission(
	role_id SMALLINT UNSIGNED NOT NULL COMMENT 'related role id',
	permission_id SMALLINT UNSIGNED NOT NULL COMMENT 'related permission id',
	PRIMARY KEY(role_id, permission_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'role permission relation table';

-- menu
DROP TABLE IF EXISTS ssm_menu;
CREATE TABLE ssm_menu(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '菜单ID',
	parent_id SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父菜单ID',
	name VARCHAR(64) NOT NULL COMMENT '菜单名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '菜单编码',
	link VARCHAR(128) DEFAULT NULL COMMENT '菜单链接',
	sequence SMALLINT NOT NULL DEFAULT 0 COMMENT '排序值',
	display BOOLEAN NOT NULL DEFAULT TRUE COMMENT '是否显示',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '菜单设置表';


/* ------------------------------------------------------------------ */
-- product category
DROP TABLE IF EXISTS ssm_product_category;
CREATE TABLE ssm_product_category(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '分类ID',
	parent_id SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父分类ID',
	name VARCHAR(64) NOT NULL COMMENT '分类名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '分类编码',
	description VARCHAR(255) DEFAULT NULL COMMENT '分类描述',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '分类设置表';

-- product brand
DROP TABLE IF EXISTS ssm_product_brand;
CREATE TABLE ssm_product_brand(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '品牌ID',
	name VARCHAR(64) NOT NULL COMMENT '品牌名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '品牌编码',
	description TEXT DEFAULT NULL COMMENT '品牌描述',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '商品品牌表';

-- product color
DROP TABLE IF EXISTS ssm_product_color;
CREATE TABLE ssm_product_color(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '颜色ID',
	name VARCHAR(64) NOT NULL COMMENT '颜色名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '颜色编码',
	description TEXT DEFAULT NULL COMMENT '颜色描述',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '商品颜色表';

-- product size
DROP TABLE IF EXISTS ssm_product_size;
CREATE TABLE ssm_product_size(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '尺寸ID',
	name VARCHAR(64) NOT NULL COMMENT '尺寸名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '尺寸编码',
	description TEXT DEFAULT NULL COMMENT '尺寸描述',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '商品尺寸表';

-- product provider
DROP TABLE IF EXISTS ssm_product_provider;
CREATE TABLE ssm_product_provider(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '供应商ID',
	name VARCHAR(64) NOT NULL COMMENT '供应商名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '供应商编码',
	description TEXT DEFAULT NULL COMMENT '供应商描述',
	company_name VARCHAR(128) DEFAULT NULL COMMENT '公司名称',
	company_address VARCHAR(255) DEFAULT NULL COMMENT '公司地址',
	contact_name VARCHAR(128) DEFAULT NULL COMMENT '联系人姓名',
	contact_qq VARCHAR(16) DEFAULT NULL COMMENT '联系人QQ',
	contact_tel VARCHAR(16) DEFAULT NULL COMMENT '联系人电话',
	contact_email VARCHAR(128) DEFAULT NULL COMMENT '联系人电邮',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '商品供应商表';



/* ------------------------------------------------------------------ */
-- depot trans type
DROP TABLE IF EXISTS ssm_depot_trans_type;
CREATE TABLE ssm_depot_trans_type(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '事务类型ID',
	name VARCHAR(64) NOT NULL COMMENT '事务类型名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '事务类型编码',
	description VARCHAR(255) COMMENT '事务类型描述',
	type BOOLEAN NOT NULL DEFAULT FALSE COMMENT '出入库类型:0-入库;1-出库;',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '事务类型表';

-- depot
DROP TABLE IF EXISTS ssm_depot;
CREATE TABLE ssm_depot(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '仓库ID',
	name VARCHAR(64) NOT NULL COMMENT '仓库名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '仓库编码',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '仓库表';

-- batch
DROP TABLE IF EXISTS ssm_batch;
CREATE TABLE ssm_batch(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '批次ID',
	name VARCHAR(64) NOT NULL COMMENT '批次名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '批次编码',
	update_aid SMALLINT UNSIGNED NOT NULL COMMENT '最后更新人',
	update_time DATETIME DEFAULT NULL COMMENT '最后更新时间',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '批次表';



/* ------------------------------------------------------------------ */
-- platform
DROP TABLE IF EXISTS ssm_platform;
CREATE TABLE ssm_platform(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '平台ID',
	name VARCHAR(64) NOT NULL COMMENT '平台名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '平台编码',
	enable BOOLEAN NOT NULL DEFAULT FALSE COMMENT '是否支持:0-未支持;1-支持;',
	description TEXT DEFAULT NULL COMMENT '平台描述',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '电商平台表';

-- shop
DROP TABLE IF EXISTS ssm_shop;
CREATE TABLE ssm_shop(
	id SMALLINT UNSIGNED AUTO_INCREMENT COMMENT '网店ID',
	platform_id SMALLINT UNSIGNED NOT NULL COMMENT '平台ID',
	name VARCHAR(64) NOT NULL COMMENT '网店名称',
	code VARCHAR(64) UNIQUE NOT NULL COMMENT '网店编码',
	type VARCHAR(64) DEFAULT NULL COMMENT '网店类型',
	website VARCHAR(255) DEFAULT NULL COMMENT '网店网址',
	description VARCHAR(255) DEFAULT NULL COMMENT '网店描述',
	account VARCHAR(128) NOT NULL COMMENT '登陆账户',
	password VARCHAR(128) NOT NULL COMMENT '登陆密码',
	PRIMARY KEY(id),
	UNIQUE(id, platform_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '网店表';



/* ------------------------------------------------------------------ */
-- user
DROP TABLE IF EXISTS ssm_user;
CREATE TABLE ssm_user(
	id INT AUTO_INCREMENT COMMENT 'user id',
	name VARCHAR(128) UNIQUE NOT NULL COMMENT 'user login name',
	password VARCHAR(128) NOT NULL COMMENT 'user login password',
	email VARCHAR(128) NOT NULL COMMENT 'user email address',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'user table';
ALTER TABLE ssm_user ADD INDEX IDX_NAME(name);

-- user detail
DROP TABLE IF EXISTS ssm_user_detail;
CREATE TABLE ssm_user_detail(
	id INT AUTO_INCREMENT COMMENT 'user detail id',
	user_id INT UNIQUE NOT NULL COMMENT 'related user id',
	real_name VARCHAR(128) COMMENT 'user real name',
	age INT COMMENT 'user age',
	register_time DATETIME NOT NULL COMMENT 'user register time',
	last_login_time DATETIME NOT NULL COMMENT 'user last login time',
	last_login_ip VARCHAR(128) NOT NULL COMMENT 'user last login ip address',
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'user detail information table';

