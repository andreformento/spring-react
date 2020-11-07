run:
	test -f spring-social/src/main/resources/application.yml || (echo "Configure application.yml" && exit 1)
	docker-compose up --build -d

status: run
	watch -n1 "docker ps"

open-node:
	docker run -v $$(pwd)/react-social:/temp-app -w="/temp-app" -it --rm --entrypoint=bash node:14.7.0
