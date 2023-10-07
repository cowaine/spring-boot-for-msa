# development 프로파일 설정
# java -jar ./application.jar -Dspring.profiles.active=development
export spring_profiles_active = dev

java -jar ./application.jar

# production 프로파일 설정
java -jar ./application.jar -Dspring.profiles.active=production

# production 과 email 프로파일 설정
java -jar ./application.jar -Dspring.profiles.active=production, email
