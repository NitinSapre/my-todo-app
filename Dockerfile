# Use a smaller base image for final production image
FROM eclipse-temurin:17-jdk-jammy as build

# Set working directory
WORKDIR /app

# Copy the jar file into the container
ARG JAR_FILE=build/libs/my-todo-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Use a minimal runtime image to reduce size (Optional multi-stage build)
FROM eclipse-temurin:17-jre-jammy as runtime

# Set working directory
WORKDIR /app

# Copy only the built jar from the builder stage
COPY --from=build /app/app.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
