# RSVP

Provide one endpoint `/rsvp` which receives JSON and writes to /database.

# Development

Install:
 * JDK
 * Leiningen

Run tests:

`lein midje` or `lein midje :autotest`

Run web server:

`lein run`

## Deployment

Build uberjar to deploy:

`lein uberjar`

Run uberjar:

`java -jar target/rsvp-0.1.0-SNAPSHOT-standalone.jar`