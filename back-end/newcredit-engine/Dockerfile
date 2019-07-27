FROM adoptopenjdk/openjdk8-openj9:alpine-slim

ENV JAVA_OPTS=" -server -Duser.timezone=America/Sao_Paulo -Duser.language=pt -Duser.country=BR -Dfile.encoding=UTF-8"
ADD target/*.jar /build/app.jar
WORKDIR /build/
EXPOSE 8080
CMD java $JAVA_OPTS -jar app.jar