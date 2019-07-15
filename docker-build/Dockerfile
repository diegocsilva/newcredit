FROM mhart/alpine-node

RUN mkdir /opt/build
WORKDIR /tmp
RUN apk update
RUN apk add --no-cache curl npm bash openjdk8
RUN wget https://www-eu.apache.org/dist/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.tar.gz
RUN tar -xzvf apache-maven-3.6.1-bin.tar.gz -C /opt
ENV M2_HOME=/opt/apache-maven-3.6.1
ENV PATH=$PATH:$M2_HOME/bin
RUN npm install -g @angular/cli
RUN rm -rf /tmp
RUN rm -rf /usr/lib/jvm/java-1.8-openjdk/*src.zip \
         /usr/lib/jvm/java-1.8-openjdk/lib/missioncontrol \
         /usr/lib/jvm/java-1.8-openjdk/lib/visualvm \
         /usr/lib/jvm/java-1.8-openjdk/lib/*javafx* \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/plugin.jar \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/ext/jfxrt.jar \
         /usr/lib/jvm/java-1.8-openjdk/jre/bin/javaws \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/javaws.jar \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/desktop \
         /usr/lib/jvm/java-1.8-openjdk/jre/plugin \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/deploy* \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/*javafx* \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/*jfx* \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libdecora_sse.so \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libprism_*.so \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libfxplugins.so \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libglass.so \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libgstreamer-lite.so \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libjavafx*.so \
         /usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/libjfx*.so 
WORKDIR /opt/build