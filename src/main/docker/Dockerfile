FROM frolvlad/alpine-oraclejdk8:slim

EXPOSE 8080

VOLUME /tmp
ADD mainapp-0.0.1-SNAPSHOT.jar mainapp.jar
RUN sh -c 'touch /mainapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mainapp.jar"]