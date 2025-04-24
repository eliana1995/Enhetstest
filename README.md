# KomponentIntegrationTestExempel

Det här är ett projekt jag använder för att demonstrera hur man bygger ett REST API i Spring Boot med stöd för tre olika typer av tester:
 Enhetstest  Komponenttest  Integrationstest


Tester jag använder i projektet
1. Enhetstester (Unit Tests)
Jag använder enhetstester för att testa logiken i mina tjänsteklasser, t.ex. UserService. I dessa tester mockar jag UserRepository så att testerna är helt oberoende av databasen.

2. Komponenttester (Component Tests)
Dessa tester kör jag för att testa tjänstlager + databas tillsammans. Här ser jag till att datan sparas och hämtas som förväntat.

3. Integrationstester (Integration Tests)
Mina integrationstester kör hela applikationen (inklusive API, service och databas) med en riktig HTTP-server och en riktig databas. Här använder jag TestRestTemplate för att simulera HTTP-anrop och säkerställa att hela systemet fungerar korrekt tillsammans.

Verktyg och ramverk jag använder
Spring Boot 3.4.4

MySQL

JPA/Hibernate

JUnit 5

Mockito
 Min application.properties
properties
Copy
Edit
spring.application.name=KomponentIntegrationTestExempel

spring.datasource.url=jdbc:mysql://localhost:3306/user_db
spring.datasource.username=root
spring.datasource.password=1122334455
spring.jpa.hibernate.ddl-auto=create-drop

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

Enhetstest: Testar funktionaliteten i enskilda tjänstklasser utan att involvera databasen. Jag använder Mockito för att mocka beroenden.

Komponenttest: Testar samverkan mellan tjänster och databasen för att säkerställa att data kan sparas och hämtas korrekt.

Integrationstest: Testar hela applikationens flöde från REST API till databas för att säkerställa att alla delar fungerar tillsammans i en verklig miljö.

