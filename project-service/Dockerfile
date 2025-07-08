FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/project-service-1.0.0.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]