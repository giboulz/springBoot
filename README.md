# springBoot

https://spring.io/guides/gs/spring-boot/

app créé avec archetype de base 
mvn archetype:generate -DgroupId=com.gbz -DartifactId=testSpringBoot -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=true

lancement : 
mvn package && java -jar target/testSpringBoot-1.0-SNAPSHOT.jar

C:\Users\567885>curl http://localhost:8080/
Greetings from Spring Boot!

#ajout de health : 

curl localhost:8080/health

#Ajout jpa

test repo : 
https://spring.io/guides/gs/accessing-data-jpa/

curl http://localhost:8080/customers


http://docs.spring.io/autorepo/docs/spring-boot/current/reference/html/boot-features-profiles.html


#gestion des profils

gestion dans application.properties
ou ligne de commande : 
--spring.profiles.active=dev,hsqldb.

profile h2 : bdd à la volée
profile Dev : connexion direct à la BDD
profile Pool : connexion pool de connexion sur serveur via jndi



#Profil Maven : 

Ajout profile Maven pour pouvoir générer un JAR ou un WAR : 
"mvn package -P war" produit un WAR 
"mvn package -P jar" produit un JAR (default).
  
  
#Configuration TomCat pour ajout de pool de connexion : 
context.xml : 

    <Context>
    .....
	    <ResourceLink name="jdbc/infoAceDB"
                    	global="jdbc/infoAceDataSource"
                        auth="Container"
                        type="javax.sql.DataSource" />
    </Context>

server.xml

      <GlobalNamingResources>
      
      <Resource 
          name="jdbc/infoAceDataSource"
    	  global="jdbc/infoAceDataSource" 
          type="javax.sql.DataSource"
          factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
          auth="Container"
          username="******" 
          password="*******"
          driverClassName="com.sybase.jdbc4.jdbc.SybDriver"
          url="jdbc:sybase:Tds:************/info_ace"
	  	    /> 
    		
      </GlobalNamingResources>
  
 Ajout de deux librairies dans tomcat : jcon4-1.jar & jtds-1.3.1.jar
