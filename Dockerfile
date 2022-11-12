FROM maven:3.8.2-jdk-11
EXPOSE 8080
COPY . .
RUN mvn clean package
ENTRYPOINT ["java","-jar","target/spring-pfe.jar"]