FROM openjdk:8-jre-alpine3.9
 
# copy the packaged jar file into our docker image
COPY target/QueryCalculator-0.0.5-SNAPSHOT.jar /QueryCalculator.jar
 
# set the startup command to execute the jar
CMD ["java", "-jar", "/QueryCalculator.jar"]
