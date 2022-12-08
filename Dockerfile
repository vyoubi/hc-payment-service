FROM adoptopenjdk/openjdk11
VOLUME /tmp
ARG JAR_FILE=build/libs/hc-payment-service.jar
ADD ${JAR_FILE} hc-payment-service.jar
EXPOSE 5006
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","hc-payment-service.jar"]
