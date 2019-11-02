#FROM java:8

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8088
ADD target/students-mysql.jar students-mysql.jar
ADD students.csv students.csv

#ENTRYPOINT ["java","-jar","students-mysql.jar"]
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /students-mysql.jar" ]
