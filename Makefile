JAR := target/docker-java-performance-1.0-SNAPSHOT-jar-with-dependencies.jar
NCPUS := 24

build:
	mvn install
	docker build -t docker-perf .

clean:
	mvn clean

rebuild: clean build

test:
	java -jar $(JAR)
	java -XX:ActiveProcessorCount=$(NCPUS) -jar $(JAR)

docker-test:
	docker run docker-perf
	docker run -e JVM_ADDITIONAL_ARGS=-XX:ActiveProcessorCount=$(NCPUS) docker-perf
