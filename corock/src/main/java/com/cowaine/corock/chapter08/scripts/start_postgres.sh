# https://hub.docker.com/_/postgres
docker pull postgres

docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=123$ \
-v $HOME/DockerData/vroong-postgres:/var/lib/postgres \
--name vroong postgres:latest

docker ps

docker exec -it vroong-postgres bash

docker start vroong-postgres
docker stop vroong-postgres
