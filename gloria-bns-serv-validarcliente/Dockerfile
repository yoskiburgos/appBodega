FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/gloria-bns-serv-validarcliente.jar app.jar

EXPOSE 31001

ENTRYPOINT ["java", "-jar", "/app.jar"]