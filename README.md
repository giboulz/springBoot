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


test repo : 
https://spring.io/guides/gs/accessing-data-jpa/


curl http://localhost:8080/customers


http://docs.spring.io/autorepo/docs/spring-boot/current/reference/html/boot-features-profiles.html


gestion des profils
gestion dans application.properties
ou ligne de commande : 
--spring.profiles.active=dev,hsqldb.

profile h2 : bdd à la volée
profile Dev : connexion direct à la BDD
profile Pool : connexion pool de connexion sur serveur via jndi



Ajout profile Maven pour pouvoir générer un JAR ou un WAR : 
mvn package -P war produit un WAR 
mvn package -P jar produit un JAR.
  