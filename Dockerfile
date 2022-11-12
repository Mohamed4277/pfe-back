FROM openjdk:11
EXPOSE 8080
ADD target/spring-pfe.jar spring-pfe.jar
ENTRYPOINT ["java","-jar","/spring-pfe.jar"]