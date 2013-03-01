cd ../
mvn clean package
cp mjee-ssm-web/target/mjee-ssm-web.war /home/michael/install/tomcat-7.0.27/webapps
cd /home/michael/install/tomcat-7.0.27/webapps

sh ../bin/shutdown.sh
rm -rf mjee-ssm-web/
sh ../bin/startup.sh