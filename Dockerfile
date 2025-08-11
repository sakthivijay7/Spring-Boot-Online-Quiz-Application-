FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar quiz.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quiz.jar"]
