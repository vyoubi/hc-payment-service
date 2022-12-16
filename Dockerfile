FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/hc-payment-service.jar
ADD ${JAR_FILE} hc-payment-service.jar
EXPOSE 5006
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","hc-payment-service.jar"]
