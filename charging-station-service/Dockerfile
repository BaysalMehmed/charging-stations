FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jre
EXPOSE 8080

COPY --from=builder /home/gradle/src/build/libs/charging-station-service-1.0-SNAPSHOT.jar /
CMD java -Duser.timezone=GMT -jar /charging-station-service-1.0-SNAPSHOT.jar