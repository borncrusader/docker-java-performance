build:
	mvn install
	docker build -t docker-perf .

clean:
	mvn clean
