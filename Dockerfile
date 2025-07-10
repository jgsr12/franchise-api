FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 4400

ENTRYPOINT ["java", "-jar", "target/franchise-0.0.1-SNAPSHOT.jar"]
