# Sử dụng OpenJDK 17 làm base image
FROM openjdk:17-jdk-slim

# Đặt thư mục làm working directory trong container
WORKDIR /app

# Copy mã nguồn dự án vào thư mục gốc trong container
COPY . .

# Cài đặt Maven
RUN apt-get update && apt-get install -y maven

# Build project Maven
RUN mvn clean package -DskipTests

# Sử dụng lại base image OpenJDK 17-jdk-slim
FROM openjdk:17-jdk-slim

# Đặt thư mục làm working directory trong container
WORKDIR /app

# Copy file JAR từ stage trước (stage 0) vào thư mục /app trong stage hiện tại
COPY --from=0 /app/target/api-0.0.1-SNAPSHOT.jar .

# Expose cổng 8084 để ứng dụng Spring Boot chạy trên đó
EXPOSE 8084

# Chạy ứng dụng Spring Boot
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
