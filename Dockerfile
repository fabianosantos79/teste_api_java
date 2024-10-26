FROM maven:3.9.9-eclipse-temurin-17-alpine AS build
COPY . /app/.

WORKDIR /app
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-alpine

COPY --from=build target/teste-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]