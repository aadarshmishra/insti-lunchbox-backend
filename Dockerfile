FROM openjdk:11
ADD  target/insti-lunchbox-0.0.1-SNAPSHOT.jar insti-lunchbox-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","insti-lunchbox-0.0.1-SNAPSHOT.jar"]