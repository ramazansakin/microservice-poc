FROM openjdk:8-jdk-alpine
ADD target/microservice-demo-zuul-server-0.0.1-SNAPSHOT.jar .
CMD /usr/bin/java -Xmx600m -Xms600m -jar microservice-demo-zuul-server-0.0.1-SNAPSHOT.jar
EXPOSE 8765