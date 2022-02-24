FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/centro-con-serv-sucursal.jar app.jar

EXPOSE 30003

ENTRYPOINT ["java", "-jar", "/app.jar"]