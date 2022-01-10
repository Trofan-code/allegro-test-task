#Allegro test task

####Spring Boot REST API GitHub Client Using Spring WebFlux
Spring Boot Application performing assigned tasks:
1) Lists the repositories (name and number of stars).
2) Returns the sum of stars in all repositorie.
3) Lists the most popular programming languages (name and size).


##Ide and Tools
___
* I used Intellij IDE to develop this
sample application.
* I created a skeleton of the project 
from [start.spring.io](https://start.spring.io/)
* Specified Gradle as my build system 
and selected web for my dependencies.
######App Dependencies
* Added dependencies **Spring Reactive Web**,
**Spring Boot DevTools**, **Lombok**.

##App Setup
___
* Create a GitHub account if you don't already have one.
* clone this project by running the following command in your command line
git clone `https://github.com/Trofan-code/allegro-test-task`
* Build the project with Gradle and then run the application.
######Run
* To run the project with Gradle `gradle bootRun`


##Testing Rest Client
___
* Run the following request using any HTTP client of 
your choice (Curl, Postman or even a browser).
* For getting a list of listing of repositories 
(name and stars)
`GET http://localhost:8080/allegro/repositories`
* For returning the sum of stars in all repositories,
`GET http://localhost:8080/allegro/repositories/stars-count`
* For getting a list the most popular programming
languages (name and size of bytecode)
  `GET http://localhost:8080/allegro/repositories/popular-languages`


