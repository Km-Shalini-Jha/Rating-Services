FROM openjdk:11-jre
EXPOSE 9090
ADD target/RatingServices-0.0.1-SNAPSHOT.jar RatingServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/RatingServices-0.0.1-SNAPSHOT.jar"]