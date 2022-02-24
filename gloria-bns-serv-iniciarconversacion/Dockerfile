FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/gloria-bns-serv-iniciarconversacion.jar app.jar

EXPOSE 31002

ENTRYPOINT ["java", "-jar", "/app.jar"]