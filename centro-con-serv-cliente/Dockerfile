FROM maven:3-openjdk-11 as build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim
RUN mkdir /project
COPY --from=build /app/target/centro-con-serv-cliente.jar /project
WORKDIR /project

EXPOSE 30001

ENTRYPOINT ["java","-jar","centro-con-serv-cliente.jar"]
