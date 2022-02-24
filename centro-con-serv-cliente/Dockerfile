FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/centro-con-serv-cliente.jar app.jar

EXPOSE 30001

ENTRYPOINT ["java", "-jar", "/app.jar"]