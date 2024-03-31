FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/api-modelo-0.0.1-SNAPSHOT.jar api-modelo.jar

EXPOSE 8080

CMD ["java", "-jar", "api-modelo.jar"]