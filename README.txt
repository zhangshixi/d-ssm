一、项目构架说明

mjee-ssm (父项目定义)
	
	database (数据库脚本目录)
		-- import_mysql.sql (Mysql初始化导入数据)
		-- schema_mysql.sql (Mysql数据库结构定义)
		
	document (文档目录)
	
	mjee-ssm-app (项目应用子程序)
		
	mjee-ssm-util (项目工具子程序)
	
	mjee-ssm-web (项目Web子程序)
	
	pom.xml (项目Maven定义)

二、项目依赖关系

	mjee-ssm-web
		\|/
	mjee-ssm-app
		\|/
	mjee-ssm-util

