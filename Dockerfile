FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/AnimeLinkAPI-0.0.1.jar AnimeLinkAPI-0.0.1.jar
EXPOSE 8080
CMD [ "java", "-jar", "AnimeLinkAPI-0.0.1.jar"]
