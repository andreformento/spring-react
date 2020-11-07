run:
	docker-compose up --build -d

status: run
	watch -n1 "docker ps"
