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


#Gestion des profils spring

gestion dans application.properties
ou ligne de commande : 
--spring.profiles.active=dev,hsqldb.

profile h2 : bdd à la volée (non persistante)
profile Dev : connexion direct à la BDD
profile Pool : connexion pool de connexion sur serveur via jndi

TODO : ajouter la ligne de commande pour activer un profil par défault

#Profil Maven : 

Ajout profile Maven pour pouvoir générer un JAR ou un WAR : 
"mvn package -P war" produit un WAR 
"mvn package -P jar" produit un JAR (default).
  
TODO : curl http://localhost:8080/testSpringBoot/customers
  
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
 
# Ajout de DevTools 

pour le restart automatique. 

#Installation checkstyle : 
checkstyle : jar (a dl)
déploiement des règles en dev : 
http://DEV/checkstylerules/ruleGPM.xml
TODO : Not working Atm. 

#Exemple Typical Controlleur

*Query all customers : 
curl http://localhost:8080/customers

*Query One customer by id
curl http://localhost:8080/customer/1

*Adding new Customer : 
(via postman) requete post http://localhost:8080/customer
avec le flux (json) : 
{
	"lastName":"jean", 
	"firstName":"jean"
}

*Modifiying customer : 
PUT : http://localhost:8080/customer/6

{
	"lastName":"jean Modified", 
	"firstName":"jean Modified"
}

*Delete Customer
