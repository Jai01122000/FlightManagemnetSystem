FROM adoptopenjdk:16-jre
COPY target/FlightManagementSystem*.jar /app.jar
CMD java -jar /app.jar