setup:
	echo "GOOGLE_CLIENT_ID=$(GOOGLE_CLIENT_ID)" > .env
	echo "GOOGLE_CLIENT_SECRET=$(GOOGLE_CLIENT_SECRET)" >> .env
	echo "FACEBOOK_CLIENT_ID=$(FACEBOOK_CLIENT_ID)" >> .env
	echo "FACEBOOK_CLIENT_SECRET=$(FACEBOOK_CLIENT_SECRET)" >> .env

run:
	@test -f .env || (echo "execute 'make setup GOOGLE_CLIENT_ID=abc GOOGLE_CLIENT_SECRET=def FACEBOOK_CLIENT_ID=a FACEBOOK_CLIENT_SECRET=b'" && exit 1)
	COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up --build -d

rm:
	docker-compose rm -s -f -v

recreate: rm run

status: run
	watch -n1 "docker ps"

open-node:
	docker run -v $$(pwd)/react-social:/temp-app -w="/temp-app" -it --rm --entrypoint=bash node:14.7.0
