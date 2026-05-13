FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/java-rest-api-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-cp", "app.jar", "com.project.Main"]