# psira-admin-service-api

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8812/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/psira-admin-service-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)



### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

# Testing API

## List All Posts
    GET http://localhost:8813/api/posts  
  Example Request:
```shell script
GET /api/posts HTTP/1.1
Host: localhost:8813

```

## Get Post by ID
    GET http://localhost:8812/api/posts/1
  Example Request:
  ```shell script
GET /api/posts/1 HTTP/1.1
Host: localhost:8813
    
    ```
## Create Post
    POST http://localhost:8812/api/posts
  Example Request:
 ```shell script
{
  "postName": "Software Engineer",
  "jobDescription": "Develop and maintain software applications.",
  "businessUnit": "IT",
  "managerId": 1,
  "experienceYears": 3,
  "qualification": "BACHELORS",
  "driversLicenseRequired": false,
  "openingDate": "2024-01-01",
  "closingDate": "2024-01-31"
}
```

##  Update an Existing Post
  PUT http://localhost:8812/api/posts/{id}  
  
Example Payload:

 ```shell script
{
  "postName": "Senior Software Engineer",
  "jobDescription": "Lead software development projects.",
  "businessUnit": "IT",
  "managerId": 1,
  "experienceYears": 5,
  "qualification": "MASTERS",
  "driversLicenseRequired": false,
  "openingDate": "2024-01-01",
  "closingDate": "2024-01-31"
}
 ```
## Delete Post
    DELETE http://localhost:8812/api/posts/{id}  
  Example Request:
    ```shell script
DELETE /api/posts/1 HTTP/1.1
Host: localhost:8813
    ``` 
