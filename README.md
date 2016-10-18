# springBoot

https://spring.io/guides/gs/spring-boot/

app créé avec archetype de base 
mvn archetype:generate -DgroupId=com.gbz -DartifactId=testSpringBoot -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=true

lancement : 
mvn package && java -jar target/testSpringBoot-1.0-SNAPSHOT.jar

C:\Users\567885>curl http://localhost:8080/
Greetings from Spring Boot!

ajout de health : 
curl localhost:8080/health