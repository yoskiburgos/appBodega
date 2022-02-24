FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/centro-con-serv-beneficio.jar app.jar

EXPOSE 30005

ENTRYPOINT ["java", "-jar", "/app.jar"]