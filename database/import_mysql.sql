/* database initialization data */
USE dssm;

INSERT INTO ssm_admin(id, login_name, password, real_name, email, mobile, create_aid, create_time, remark) VALUES
(1, 'administrator', '123456', '超级管理员', 'xishizhang@gmail.com', '15121191401', 1, NOW(), 'initialization');

INSERT INTO ssm_role(id, name, code, description) VALUES
(1, '超级管理员', 'administrator', '系统初始化数据'),
(2, '日志管理员', 'log:manager', '系统初始化数据'),
(3, '缓存管理员', 'cache:manager', '系统初始化数据');

INSERT INTO ssm_relate_admin_role(admin_id, role_id) VALUES(1, 1);

INSERT INTO ssm_permission(name, code, description) VALUES
('查看权限', 'permission:show', '系统初始化数据'),
('添加权限', 'permission:new', '系统初始化数据'),
('编辑权限', 'permission:edit', '系统初始化数据'),
('删除权限', 'permission:remove', '系统初始化数据'),
('查看角色', 'role:show', '系统初始化数据'),
('添加角色', 'role:new', '系统初始化数据'),
('编辑角色', 'role:edit', '系统初始化数据'),
('删除角色', 'role:remove', '系统初始化数据'),
('分配权限', 'role:authorize', '系统初始化数据'),
('查看管理员', 'admin:show', '系统初始化数据'),
('添加管理员', 'admin:new', '系统初始化数据'),
('编辑管理员', 'admin:edit', '系统初始化数据'),
('删除管理员', 'admin:remove', '系统初始化数据'),
('分配角色', 'admin:authorize', '系统初始化数据'),
('查看菜单', 'menu:show', '系统初始化数据'),
('添加菜单', 'menu:new', '系统初始化数据'),
('编辑菜单', 'menu:edit', '系统初始化数据'),
('删除菜单', 'menu:remove', '系统初始化数据');

INSERT INTO ssm_menu(id, parent_id, name, code, link, sequence, update_aid, update_time) VALUES
(1, 0, '权限管理', 'authorize', null, 99, 1, NOW()),
(2, 0, '系统管理', 'system', null, 99, 1, NOW()),
(3, 1, '管理员管理', 'admin', 'admin', 9, 1, NOW()),
(4, 1, '角色管理', 'role', 'role', 8, 1, NOW()),
(5, 1, '权限管理', 'permission', 'permission', 7, 1, NOW()),
(6, 1, '菜单管理', 'menu', 'menu', 6, 1, NOW()),
(7, 2, '日志管理', 'log', 'log', 9, 1, NOW()),
(8, 2, '缓存管理', 'cache', 'cache', 8, 1, NOW());