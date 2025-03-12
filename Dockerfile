FROM openjdk:21
EXPOSE 8080
COPY /build/libs/aigineer-0.0.1-SNAPSHOT.jar backend.jar
CMD ["java", "-jar", "./backend.jar"]