/* database initialization data */
USE dssm;

INSERT INTO ssm_role(id, name, code, description) VALUES(1, '超级管理员', 'administrator', '系统初始化数据');
INSERT INTO ssm_admin(id, login_name, password, real_name, email, mobile, create_aid, create_time, remark) VALUES(1, 'administrator', '123456', '超级管理员', 'xishizhang@gmail.com', '15121191401', 1, NOW(), 'initialization');
INSERT INTO ssm_ralate_admin_role(admin_id, role_id) VALUES(1, 1);
INSERT INTO ssm_permission(NAME, CODE, description) VALUES(1, '添加权限', 'permission:new', '系统初始化数据');