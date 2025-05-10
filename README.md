# Template Spring Boot DB balancer application

A Spring Boot WEB and JPA application template with reader and writer data sources for balancing of read/write SQL queries

## Info

- use `docker-compose` file under the `local-run-spring-boot-datasource-balancer` to launch reader and writer DB instances
- DB will be initialized with the demo table
- DB reader table will contain demo data
- There are two endpoints to hit (CURLs will could be found below)
- Java 21 is required to run the demo application
- build with `./gradlew build`

## Run

1. Launch `local-run-spring-boot-datasource-balancer/docker-compose.yml` with the DBs
2. Run Spring Boot application in the IDE or terminal via `./gradlew bootRun`
3. Hit get/post endpoint on the base URL `localhost:8080`
4. Verify DB content - write query was routed to the writer DB and read query was routed to the reader DB

## Important notes

- `@Primary` data source still should be defined in order to successfully initialise entity manager and related JPA beans
- Aspect order should be higher than the transactional related ones, including the router itself
- Hikari connection pool properties should be defined on the data source properties level, not under standard `hikari` because
  autoconfiguration is not used for the data source