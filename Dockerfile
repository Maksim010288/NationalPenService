FROM openjdk:17

WORKDIR /app

COPY files/* /app

ADD target/NationalPen-0.0.1-SNAPSHOT.jar start.jar

ENTRYPOINT ["java", "-jar", "start.jar"]