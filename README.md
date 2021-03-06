# Allegro test task

#### Spring Boot REST API GitHub Client Using Spring WebFlux

Spring Boot Application performing assigned tasks:

1) Lists the repositories (name and number of stars).
2) Returns the sum of stars in all repositories.
3) Lists the most popular programming languages (name and size).

## Ide and Tools

___

* I used Intellij IDE for development this application.
* I created a skeleton of the project from template [start.spring.io](https://start.spring.io/)
* Specified Gradle as my build system and selected web for my dependencies.

###### App Dependencies

* Added dependencies **Spring Reactive Web**,
  **Spring Boot DevTools**, **Lombok**.

## App Setup

___


* Clone this project by running the following command in your command line git
  clone `https://github.com/Trofan-code/allegro-test-task`
* Build the project with Gradle and then run the application.

###### Run

* To run the project with Gradle `gradle bootRun`

## Testing Rest Client

___

* Run the following request using any HTTP client of your choice (Curl, Postman or even a browser).
* For getting a list of listing of repositories
  (name and stars)
  `GET http://localhost:8080/allegro/repositories`
* For returning the sum of stars in all repositories,
  `GET http://localhost:8080/allegro/repositories/stars-count`
* For getting a list of the most popular programming languages (name and size of bytecode)
  `GET http://localhost:8080/allegro/repositories/popular-languages`



___
**My suggestion:**
* Add unit tests.
* Add authorization for GitHub users.
* Add cookie for repositories.


**Notes for the solution**

For this assignment, I chose Spring WebClient and not RestTemplate
because after reading and analyzing many articles, I came to the conclusion that, 
for this task  it was a better choice, even without the necessity of working with
asynchronous HTTP requests.
Especially considering the possibility of a further extension of the application.
Also, in the official documentation [Spring Framework](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) it is written : 
NOTE: As of 5.0 this class is in maintenance mode, with only minor requests for 
changes and bugs to be accepted going forward. Please, consider using the
org.springframework.web.reactive.client.WebClient which has a more modern API and
supports sync, async, and streaming scenarios.


