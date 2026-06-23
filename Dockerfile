# ==========================
# Build Stage
# ==========================
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy all project files
COPY . .

# Give execution permission to Maven Wrapper
RUN chmod +x mvnw

# Build application
RUN ./mvnw clean package -DskipTests


# ==========================
# Runtime Stage
# ==========================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy generated jar
COPY --from=builder /app/target/*.jar app.jar

# Render injects PORT environment variable
EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]