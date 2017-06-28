FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
ADD target/mainapp-0.0.1-SNAPSHOT.jar target/mainapp.jar
RUN sh -c 'touch target/mainapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/mainapp.jar"]