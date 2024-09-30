FROM openjdk:17-slim
ARG JAR_FILE=target/biblioteca-0.0.1.jar
COPY ${JAR_FILE} app_biblioteca.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_biblioteca.jar"]