#docker build -t task-management-service -f task-management-service.dockerfile .

# Build stage
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build /app/target/challenge05.jar challenge05.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "challenge05.jar"]
