FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Varadharajan
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/flightticketbooking-DEVELOP:1.0.0-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "flightticketbooking-DEVELOP:1.0.0-SNAPSHOT.jar"]