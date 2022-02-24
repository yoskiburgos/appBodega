FROM openjdk:18-ea-11-jdk-alpine3.15

COPY target/centro-con-serv-enrolamiento.jar app.jar

EXPOSE 30006

ENTRYPOINT ["java", "-jar", "/app.jar"]