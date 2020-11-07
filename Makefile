setup:
	echo "GOOGLE_CLIENT_ID=$(GOOGLE_CLIENT_ID)" > .env
	echo "GOOGLE_CLIENT_SECRET=$(GOOGLE_CLIENT_SECRET)" >> .env
	echo "FACEBOOK_CLIENT_ID=$(FACEBOOK_CLIENT_ID)" >> .env
	echo "FACEBOOK_CLIENT_SECRET=$(FACEBOOK_CLIENT_SECRET)" >> .env

run:
	@test -f .env || (echo "execute 'make setup GOOGLE_CLIENT_ID=abc GOOGLE_CLIENT_SECRET=def FACEBOOK_CLIENT_ID=a FACEBOOK_CLIENT_SECRET=b'" && exit 1)
	docker-compose up --build -d

status: run
	watch -n1 "docker ps"

open-node:
	docker run -it --rm \
			   -v node_modules:/temp-app/node_modules \
			   -v $$(pwd)/react-social/package.json:/temp-app/package.json \
	           -v $$(pwd)/react-social/package-lock.json:/temp-app/package-lock.json \
	           -v $$(pwd)/react-social/yarn.lock:/temp-app/yarn.lock \
	           -v $$(pwd)/react-social/src:/temp-app/src \
	           -v $$(pwd)/react-social/public:/temp-app/public \
	           -w="/temp-app" \
			   --entrypoint=bash \
			   node:14.7.0
