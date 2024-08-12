FROM openjdk:22
VOLUME /tmp
ADD target/first_jobappproject.jar first_jobappproject.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/first_jobappproject.jar"]