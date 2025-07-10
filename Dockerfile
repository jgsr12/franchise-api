FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/franchise-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4400

ENTRYPOINT ["java", "-jar", "app.jar"]
