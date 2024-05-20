FROM openjdk:17-jdk-slim
COPY ./target/security-0.0.1-SNAPSHOT.jar /app/application.jar
WORKDIR /app
CMD ["java", "-jar", "application.jar"]