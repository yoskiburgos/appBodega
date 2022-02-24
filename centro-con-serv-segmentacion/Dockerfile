FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/centro-con-serv-segmentacion.jar app.jar

EXPOSE 30004

ENTRYPOINT ["java", "-jar", "/app.jar"]