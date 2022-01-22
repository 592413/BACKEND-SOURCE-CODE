SFG-BEER-WORKS
SFG Beer Works is set of Spring Application to showcase microservices and Spring Cloud

Theme of services is beer distribution

A. Beer Consumer- Creates demand for beer

B. Pub - Provides Beer to Beer Consumer, Reorders Beer from the Distributor

C. Distributor - Restocks beer to Pubs, Order Beer from Brewery

D. Brews Beer, Supplies beer to Distributor

Technology

A. Beer Consumer- Beer SVC -Kotlin, WebClient

B. Pub - Webflux.fn, Spring Data Mongo, MongoDb

C. Distributor - Webflux, Spring Data Mongo, MongoDb

D. Brews Beer, Supplies beer to Distributor- Spring MVC, Spring Data JPA, Hibernate
