### project-manager-fsd-api

mvn clean build


#Dockerfile jar

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} project-manager-fsd-api.jar
ENTRYPOINT ["java","-jar","/project-manager-fsd-api.jar"]

# Build local docker image
$ docker build --build-args=target/*.jar -t project-manager-fsd-api.jar:latest .


#Dockerfile jar
$ docker build -t project-manager-fsd-api .


# Run docker image
$ docker run --name project-manager-fsd-api -it -p 8080:8080 rahulishu/project-manager-fsd-api:latest

# Retag local image for docker hub
docker tag project-manager-fsd-api:latest rahulishu/project-manager-fsd-api:latest

# Push to docker hub repository
docker push rahulishu/project-manager-fsd-api:latest

# Using MySql command line client or Use Create.sql file to create tables
login to command prompt
> create database prgmgrfsd;
> use prgmgrfsd;
then create tables 
