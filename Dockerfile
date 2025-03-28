FROM openjdk:21
EXPOSE 8080
COPY /build/libs/aigineer-*-SNAPSHOT.jar backend.jar
CMD ["java", "-jar", "/backend.jar"]