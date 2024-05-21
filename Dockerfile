FROM maven:3.8.3-openjdk-17 AS build
# WORKDIR /app
# COPY /pom.xml .
COPY . .
# RUN mvn dependency:go-offline
# COPY /src /app/src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
# WORKDIR /app
COPY --from=build /target/NaviGo-1.0.0-SNAPSHOT.jar NaviGo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "NaviGo.jar"]
