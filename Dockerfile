FROM openjdk:17-jdk-alpine

WORKDIR /quizapp

COPY target/onlineassesment-0.0.1-SNAPSHOT.jar quizapp.jar

EXPOSE 8080

CMD ["java","-jar","quizapp.jar"]

