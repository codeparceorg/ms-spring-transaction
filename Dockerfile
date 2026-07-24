# -------- Run stage --------
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY ./target/*.jar app.jar

EXPOSE 80

LABEL org.opencontainers.image.source https://github.com/codeparceorg/ms-spring-transaction

ENTRYPOINT ["java","-jar","app.jar"]