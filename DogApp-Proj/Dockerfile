FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dserver.port=8080","-Dspring-boot.run.profiles=dev","/app.jar"]