FROM parrotstream/centos-openjdk:8

WORKDIR /opt
COPY target/docker-java-performance-1.0-SNAPSHOT-jar-with-dependencies.jar perf.jar

RUN echo -e "#!/bin/bash \n java \$JVM_ADDITIONAL_ARGS -jar perf.jar" > ./entrypoint.sh
RUN chmod +x ./entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

