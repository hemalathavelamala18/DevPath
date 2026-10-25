

\# DevPath — Programming Learning \& Placement Preparation Portal



DevPath is a Spring Boot web application designed to provide a starting point for programming courses and placement preparation. The project demonstrates an automated DevOps workflow using Git, GitHub, Jenkins, Maven, Docker, and Java.



\## Features



\- Home page with project navigation

\- Courses page

\- Java and Spring Boot application

\- Automated build and test stages

\- Docker image creation

\- Automated deployment through Jenkins

\- HTTP endpoint verification after deployment



\## Technology Stack



| Technology | Purpose |

|---|---|

| Java 21 | Application development |

| Spring Boot | Web application framework |

| Maven | Build and dependency management |

| JUnit | Automated testing |

| Git | Version control |

| GitHub | Source code hosting |

| Jenkins | CI/CD automation |

| Docker | Containerization |



\## CI/CD Pipeline



The Jenkins pipeline performs these stages:



1\. Checkout — prepares the source code from GitHub.

2\. Build — compiles and packages the application.

3\. Test — runs automated tests.

4\. Docker Build — builds the application image.

5\. Deploy — starts the application in a Docker container.

6\. Verify Deployment — checks the Home and Courses endpoints.

7\. Complete — reports pipeline completion.



\## Run Locally



Requirements: Java 21 and Git.



From the project directory, run:



```bash

mvnw.cmd package

mvnw.cmd spring-boot:run

```



Open the application at:



http://localhost:8081



\## Docker Deployment



Build the application first, then build the Docker image:



```bash

mvnw.cmd package

docker build -t devpath-app:latest .

docker run -d --name devpath-container -p 8083:8081 devpath-app:latest

```



Open:



\- Home: http://localhost:8083/

\- Courses: http://localhost:8083/courses



If the container name is already in use, remove the old container before running the command again.



\## Jenkins



The `Jenkinsfile` defines the CI/CD pipeline. Jenkins builds and tests the project, builds the Docker image, deploys the container, and verifies the application endpoints.



\## Project Repository



GitHub: https://github.com/hemalathavelamala18/DevPath



\## Learning Outcomes



\- Version control with Git and GitHub

\- Maven build and test automation

\- Jenkins pipeline configuration

\- Docker image creation and container deployment

\- Automated HTTP endpoint verification



