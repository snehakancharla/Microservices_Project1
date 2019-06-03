FROM openjdk:11-jdk-stretch

WORKDIR /src/app/musicapp

ADD /target/track-service-0.0.1-SNAPSHOT.jar  /src/app/musicapp/track-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","track-service-0.0.1-SNAPSHOT.jar"]

