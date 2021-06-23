FROM java:8-jre
COPY ./target/BookMarkService-0.0.1-SNAPSHOT.jar /usr/src/BookMarkService-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src
CMD ["java","-jar","BookMarkService-0.0.1-SNAPSHOT.jar"]