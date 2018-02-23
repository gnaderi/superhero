# Superhero Task

This application about write a RESTFUL webservice that can be accessed via http/https.
* Use Java for coding
* Use any framework and build managers you like (please provide a short statement why you chose a particular framework)
* Include some testing (unit, integration, end-to-end)
* ................

## Main building blocks
 * I have used Java as requested 
 * I have used maven because its the best and I am good at it :D
 * I have used spring for IOC, Spring JPA and Spring Boot 
 * Implemented JSON Web Token go to https://jwt.io/ to decode your generated token.
 * I used H2 Database Engine - it is good for rapid prototyping and development, but not suitable for production at least in most cases. 
 * Implemented fully functional security module.
 * Implemented https assess port 8443
 * Docker file and  maven config implemented but had a issue with heath check accessing it, so I'll fix it later. 
 * Implemented swagger to design, build, document, and consume RESTful Web services. Get superhero swagger file on runtime:`https://localhost:8443/v2/api-docs`

**Note:** I'll give my reason why I used those tools in more details on my interview ;).

## DB Schema/ ERD Diagram
https://github.com/gnaderi/superhero/wiki

## Api Documentation
 1.0 
[ Base URL: `localhost:8443/` ]
Api Documentation

### Superhero Service REST API Interface

* POST
`/superhero/create`
Create a superhero and store it in application.

* GET
`/superhero/get`
Pull a list of all superheroes stored in application.

* GET
`/superhero/get/{heroId}`
Find a superhero stored in application by superhero Id.

* GET
`/superhero/search/{heroName}`
Find a superhero stored in application by Name.


**Note:** to get a full documentation and details for request and response please:
* got to http://editor.swagger.io/
* Copy/Paste content of `resource/swagger-def.json` file into the swagger editor
 to see the _**magic**_**!**






## **Important!**
**I have deployed the application to https://boiling-refuge-19519.herokuapp.com/superhero 
you will need to replace `https://localhost:8443/superhero` or `http://localhost:8090/superhero` with that to test the online one!**



## To run the application
Use one of the several ways of running a Spring Boot application. Below are just three options:

1. Build using maven goal: `mvn clean package` and execute the resulting artifact as follows `java -jar superhero-0.0.1-SNAPSHOT.jar` or
2. On Unix/Linux based systems: run `mvn clean package` then run the resulting jar as any other executable `./superhero-0.0.1-SNAPSHOT.jar`
3. Build and start as a Docker container. Instructions at: [README](src/main/docker/README.md)





# To test the application

 ### First you will need the following basic pieces of information:

 * client: heroClientId
 * secret: XY2371kmzoNzl
 * Non-admin username and password: ganderi and jwtpass
 * Admin user: admin and jwtpass
 * Example of resource accessible to all authenticated users:  http://localhost:8090/superhero/get  or https://localhost:8443/superhero/get/{heroId}/
 * Example of resource accessible to only an admin user:  http://localhost:8090/superhero/create/   or https://localhost:8443/superhero/create 

 1. Generate an access token

   Use the following generic command to generate an access token:
   
   `$ curl -i -u client:secret https://${SERVER_IP}:8443/oauth/token -d grant_type=password -d username=user -d password=pwd`

   For this specific application, to generate an access token for the non-admin user john.doe, run:
   
   `$ curl -k -i -u  heroClientId:XY2371kmzoNzl https://localhost:8443/oauth/token -d grant_type=password -d username=admin -d password=jwtpass`
   
   You'll receive a response similar to below
   
    `{
     "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic2FtcGxlSnd0UmVzb3VyY2VJZCJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MTk0Mjk4NjksImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6ImEyZjhkNTJjLTkwOTctNDNjZS1iMzQxLWMzZTEwZGJkNzFhYiIsImNsaWVudF9pZCI6Imhlcm9DbGllbnRJZCJ9.Z8xdG8nhsFLAyIgQ3OKL62ZebpE1ht079EcbPE4T5zA",
     "token_type": "bearer",
     "expires_in": 43199,
     "scope": "read write",
     "jti": "a2f8d52c-9097-43ce-b341-c3e10dbd71ab"
     }`

 2. Use the token to access resources through your RESTful API

    * Access content available to all authenticated users

        Use the generated token  as the value of the Bearer in the Authorization header as follows or use postman with that token:
        `curl -k -X GET \
           https://localhost:8443/superhero/get/1 \
           -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic2FtcGxlSnd0UmVzb3VyY2VJZCJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MTk0Mjk4NjksImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6ImEyZjhkNTJjLTkwOTctNDNjZS1iMzQxLWMzZTEwZGJkNzFhYiIsImNsaWVudF9pZCI6Imhlcm9DbGllbnRJZCJ9.Z8xdG8nhsFLAyIgQ3OKL62ZebpE1ht079EcbPE4T5zA' \
           -H 'Cache-Control: no-cache' \
           -H 'Postman-Token: c6eb4461-5f5c-402b-b673-9006db29be7b';`

        The response will be for superhero id=1(` https://localhost:8443/superhero/get/1`):
        
        `{
             "superhero": {
                 "id": 1,
                 "name": "Superman",
                 "pseudonym": "Clark Kent",
                 "firstAppearance": "1938-05-31",
                 "publisher": {
                     "id": 1,
                     "name": "DC",
                     "desc": "DC Comics"
                 }
             },
             "skills": [
                 {
                     "id": 1,
                     "name": "Fly",
                     "desc": "Fly"
                 },
                 {
                     "id": 2,
                     "name": "Heat vision",
                     "desc": "Heat vision"
                 },
                 {
                     "id": 6,
                     "name": "Speed",
                     "desc": "Superhuman Speed"
                 },
                 {
                     "id": 7,
                     "name": "Strength",
                     "desc": "Superhuman Strength"
                 }
             ],
             "allies": [
                 {
                     "id": 4,
                     "name": "Thor",
                     "pseudonym": "Thor Odinson",
                     "firstAppearance": "1962-07-31",
                     "publisher": {
                         "id": 2,
                         "name": "Marvel",
                         "desc": "Marvel Comics"
                     }
                 }
             ]
         }`

    * Access content available only to an admin user

       As with the previous example first generate an access token for the admin user with the credentials provided above then run
       
           `curl -k -X POST \
              https://localhost:8443/superhero/create \
              -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic2FtcGxlSnd0UmVzb3VyY2VJZCJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1MTk0Mjk4NjksImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6ImEyZjhkNTJjLTkwOTctNDNjZS1iMzQxLWMzZTEwZGJkNzFhYiIsImNsaWVudF9pZCI6Imhlcm9DbGllbnRJZCJ9.Z8xdG8nhsFLAyIgQ3OKL62ZebpE1ht079EcbPE4T5zA' \
              -H 'Cache-Control: no-cache' \
              -H 'Content-Type: application/json' \
              -H 'Postman-Token: 3f67844b-2537-4d8d-805a-dfc77c58dbc1' \
              -d '{
              "name": "Ghodrat",
                "pseudonym": "The Developer",
                "firstAppearance": "1984-01-01",
                "publisher":1,
                "skills": [1,2,6,7],
                 "allies": [2,4]
            }'`
            
       The result will be:`Superhero created with ID#6`
           
       * You will be able to search or retrieve created record by `https://localhost:8443/superhero/get/{id}`  or `https://localhost:8443/superhero/search/{name}`