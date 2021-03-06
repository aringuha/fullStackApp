### This CRUD full-stack supplier management system based on Dockerized React-Redux frontend with Spring Boot RESTful API backend and swagger docs

### What you'll need
- React/Redux
- [Java](https://www.java.com) 1.8
- [Spring Boot](http://spring.io/projects/spring-boot) 2.1.2
- [maven](https://maven.apache.org/)
- JPA/Hibernate
- [H2](http://www.h2database.com)
- DevTools
- [Lombok](https://projectlombok.org/)
- [JUnit 4](https://junit.org/junit4/)
- [Swagger](https://swagger.io/) 2
- [Docker ]

## Getting Started

### Database UI
http://localhost:8080/h2/

### Swagger UI
http://localhost:8080/swagger-ui.html

### build with Docker & Run the application

### Backend
- Go to your project folder and run SpringBootApplication.
- Build Image: $ mvn clean install
               $ docker build -t tag-name/image-name .
- See Image: docker images
- Run Container: $ docker run -p 8080:8080 -t tag-name/image-name
- Stop Container: $ docker ps -q //<....>
			 $ docker stop <....>
- Server is running at http://localhost:8080 (Here 8081 is the Docker port and 8080 is the Tomcat port where is Spring Boot Backend is running

### Frontend
- Go to your project folder from your terminal `cd frontend`
- Build Image: $ docker build -t sample:dev .
- See Image: docker images
- Run Container: $ winpty docker run \
    -it \
    --rm \
    -v ${PWD}:/app \
    -v /app/node_modules \
    -p 3001:3000 \
    -e CHOKIDAR_USEPOLLING=true \
    sample:dev
- Stop Container: $ docker ps -q //<....>
			 $ docker stop <....>
- Open your browser (http://localhost:3001)
(port 3000 exposed to other Docker containers on the same network (for inter-container communication) and port 3001 to the host)