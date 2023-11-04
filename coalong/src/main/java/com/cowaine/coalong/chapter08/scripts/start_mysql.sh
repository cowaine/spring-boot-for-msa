# 도커 허브에서 도커이미지(mysql) 다운로드
# docker pull mysql

# -d: d는 daemon 의 줄임말 (백그라운드로 실행)
# -p: port 의 줄임말 (127.0.0.1:3306 으로 접속하면 mysql 도커 컨테이너 접속)
# -e: environment 환경변수 설정
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=12345 \
-v $HOME/DockerData/spring-tour-mysql:/var/lib/mysql \
--name spring-tour-mysql mysql:latest \
--character-set-server=utf8mb4 \
--collation-server=utf8mb4_unicode_ci

# process status
docker ps

# 실행한 도커 컨테이너에 접속하는 명령어다.  bash 셸을 사용하여 접속한다.
docker exec -it spring-tour-mysql bash

# mysql -u root -p
# mysql> CREATE DATABASE tour;
# mysql> use tour

docker start spring-tour-mysql
docker stop spring-tour-mysql