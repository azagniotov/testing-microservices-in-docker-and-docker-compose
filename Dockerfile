########################################################################################
# Stage 1 : build the app
########################################################################################
FROM gradle:6.7.1-jdk8-openj9 AS BUILD-JAR-STAGE
ENV GRADLE_USER_HOME=/home/gradle
COPY --chown=gradle:gradle src $GRADLE_USER_HOME/src
COPY --chown=gradle:gradle build.gradle gradle.properties $GRADLE_USER_HOME/
WORKDIR $GRADLE_USER_HOME
RUN gradle clean build test

########################################################################################
# Stage 2 : create the Docker final image
########################################################################################
# https://hub.docker.com/r/azul/zulu-openjdk-alpine
FROM azul/zulu-openjdk-alpine:8u282-8.52.0.23-jre-headless@sha256:91fe8ae651d5c778312e946e89f934240c2a80f55b7ca894d76daef8f5281375

MAINTAINER Alexander Zagniotov <azagniotov@gmail.com>

ENV SPRING_APPLICATION_PROPERTIES_PROFILE=testing-in-docker
ENV SERVICE_ACCOUNT_HOST=http://localhost
ENV SERVICE_RESERVATION_HOST=http://localhost
ENV SPRING_USER_HOME=/home/spring

# Users & permissions, docs: https://wiki.alpinelinux.org/wiki/Setting_up_a_new_user
RUN addgroup --system --gid 1000 spring && \
      adduser --system --uid 1000 spring --shell /bin/bash --home "$SPRING_USER_HOME" && \
      chown --recursive spring:spring "$SPRING_USER_HOME"

WORKDIR "$SPRING_USER_HOME"

COPY --from=BUILD-JAR-STAGE /home/gradle/build/libs/*.jar ./application.jar

RUN chown spring:spring application.jar && ls -al

# Set the UID and GID to application.jar for the ENTRYPOINT instructions
USER spring:spring

EXPOSE 8080
ENTRYPOINT java -Dspring.profiles.active=${SPRING_APPLICATION_PROPERTIES_PROFILE} \
                -Dservice.account.host=${ACCOUNT_SERVICE_HOST} \
                -Dservice.reservation.host=${RESERVATION_SERVICE_HOST} \
                -jar application.jar
