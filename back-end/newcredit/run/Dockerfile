FROM adoptopenjdk/8u212-b04-jre-openj9-0.14.2

ADD target/*.jar /build/app.jar
RUN echo "java -jar /build/app.jar" >> /build/entrypoint.sh
RUN chmod 777 /build/entrypoint.sh

CMD ["sh", "-c", "/build/entrypoint.sh"]