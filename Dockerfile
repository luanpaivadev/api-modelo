# Use uma imagem base do OpenJDK para Java 17 ou posterior
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da sua API REST (certifique-se de que o arquivo JAR foi gerado)
COPY target/*.jar app.jar

# Expõe a porta em que sua API REST está sendo executada
EXPOSE 8080

# Comando para iniciar sua aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
