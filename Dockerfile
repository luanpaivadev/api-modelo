FROM openjdk:17-jdk-slim

WORKDIR /app

COPY home/runner/work/api-modelo/api-modelo/target/api-modelo-0.0.1-SNAPSHOT.jar /app/api-modelo.jar

EXPOSE 8080

CMD ["java", "-jar", "api-modelo.jar"]