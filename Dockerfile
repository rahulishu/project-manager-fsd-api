FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/project-manager-fsd-api.jar
COPY ${JAR_FILE} project-manager-fsd-api.jar
ENTRYPOINT ["java","-jar","/project-manager-fsd-api.jar"]