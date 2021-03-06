Coverage: 84.2%

# HobbyProject : Recipe App

This is a CRUD application built using the following tools. 
* Jira
* SQL Server
* Java - SpringBoot
* Frontend - HTML, CSS & JavaScript
* Integration Tests: MockMVC
* Version Control: Git

## Overview 

### Planning
#### Jira
* I used Jira for my project management. I created four Epics (Documentation, Backend, Frontend and Testing) which included user stories and tasks to represent the work I was doing.
* I used MosCow prioritisation techinque to determine what needs to be done first. 
* I used story points estimation to estimate the work invovled for each user story. I also added the acceptance creteria to define the expected outcome. 
![](Documentation/example-of-a-user-story.png) 

* I used Jira board to keep track of the work I was doing, the work that had been completed and work that needed to be done. 
![](Documentation/jira-sprint-board.png)

#### Initial design
* I used the interface design tool (figma) to come up with an inital design. However, I was not able to stick to this design so I had to simplify my design to get the project working. I would like to keep working on the front-end to make it more user friendly.
![](Documentation/design.png)

#### Git/Github
* I used the feature branch model. I branched out from main to dev and from dev to many feature branches. I used separate branch for each feature I worked on. On the feature branch, I made all the changes and pushed my commits and updated feature branch on Github. I linked my git with my jira board to make smart commits.
![](Documentation/feature-branch-model.png)



* I used pull requests to merge the feature branch into dev.
![](Documentation/pull-request-1.png)

### Database
* Database that I used: mysql 
![](Documentation/Hobbyproject-ERD.png)

### Backend 
* Backend was created using Java Spring Boot Framework. 
![](Documentation/backend.png)

### Integration Testing
* I used MockMVC to test the application. 
![](Documentation/test.png)

Test Coverage 
![](Documentation/test-coverage.png)

### Frontend 
* Build from HTML, CSS and JavaScipt
* Implemented Bootstrap framework 
* Javascript used for API integration using axios
![](Documentation/front-end.png)

## Starting the Application 

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
- Clone this repositary 
```
git@github.com:Merisabk/HobbyProject.git
```
- Run "mvn clean package" in the root directory to build the app.
- To run the app, open terminal and copy paste the code below. 

```
$ java -jar HobbyProject-0.0.1-SNAPSHOT.jar
```

- In order to interact with this application through a browser navigate to http://localhost:8080/ while the application is running.

## Stopping the Application 
* In order to stop the application from the git bash terminal that is running the server press CTRL + C






