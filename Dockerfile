FROM amazoncorretto:17-alpine-jdk
COPY *.jar calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]