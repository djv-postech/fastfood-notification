FROM amazoncorretto:17-alpine-jdk
ADD target/fastfood-notification-0.0.1.jar fastfood-notification.jar
ENTRYPOINT ["java", "-jar", "fastfood-notification.jar"]
EXPOSE 8084