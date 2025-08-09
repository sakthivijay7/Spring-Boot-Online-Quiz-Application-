FROM openjdk:17-jdk-slim
WORKDIR /app
COPY mvnw pom.xml ./
COPY src ./src
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/*.jar"]
