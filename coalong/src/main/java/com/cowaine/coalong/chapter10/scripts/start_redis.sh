# 레디스 최신 버전 이미지를 로컬 호스트에 내려받는다.
docker pull redis

docker images

# 컨테이너를 실행하며 이름은 ‘spring-tour-redis’이다. 레디스 컨테이너의 6379번 포트와 로컬 호스트의 6379번 포트를 연결한다.
docker run --name spring-tour-redis -p 6379:6379 redis

# spring-tour-redis 를 실행
docker start spring-tour-redis

# 사용중인 컨테이너에 명령어 실행
docker exec -it spring-tour-redis /bin/bash

# 도커 내부에서 레디스 커맨드 모드로 접속하는 redis-cli 명령어를 사용하여 127.0.0.1 호스트에 접속한다.
# root@9477dfbfc9e7:/data# redis-cli -h 127.0.0.1

# GET, SET 명령어 사용
# 127.0.0.1:6379> SET hotel:billing-code:1 "123456789"
#OK
# 127.0.0.1:6379>  GET hotel:billing-code:1
#"123456789"
# 127.0.0.1:6379> KEYS *
#1) "hotel:billing-code:1"

# 더 많은 Redis 명령어 확인 https://redis.io/commands/
