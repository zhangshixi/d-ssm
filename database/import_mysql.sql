/* database initialization data */
USE dssm;

INSERT INTO ssm_role(name, code, description) VALUES('superadmin', 'superadmin', 'initialization');
INSERT INTO ssm_admin(login_name, password, real_name, email, mobile, create_aid, create_time, remark) VALUES('superadmin', '123456', 'superadmin', 'xishizhang@gmail.com', '15121191401', 1, NOW(), 'initialization');