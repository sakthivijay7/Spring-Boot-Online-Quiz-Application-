FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /quizapp
COPY --from=build /app/target/*.jar quizapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quizapp.jar"]
