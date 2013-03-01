cd ..

call mvn clean package

cd D:\workspace\mjee-ssm\mjee-ssm-web\target

xcopy /Y mjee-ssm-web.war "D:\Program Files\tomcat-7.0.27\webapps"

cd D:\Program Files\tomcat-7.0.27\bin

call startup.bat

cd D:\workspace\mjee-ssm\deploy