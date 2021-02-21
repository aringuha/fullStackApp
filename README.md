{\rtf1\ansi\ansicpg1252\deff0\nouicompat{\fonttbl{\f0\fnil\fcharset0 Times New Roman;}}
{\colortbl ;\red232\green242\blue254;\red0\green0\blue255;}
{\*\generator Riched20 10.0.18362}\viewkind4\uc1 
\pard\highlight1\f0\fs24\lang1033 ### \highlight0 This CRUD full-stack supplier management system based on Dockerized \highlight1 React-Redux frontend with Spring Boot RESTful API backend and swagger docs\highlight0\par
\par
### What you'll need\par
- React/Redux\par
- [Java]({{\field{\*\fldinst{HYPERLINK https://www.java.com }}{\fldrslt{https://www.java.com\ul0\cf0}}}}\f0\fs24 ) 1.8\par
- [Spring Boot]({{\field{\*\fldinst{HYPERLINK http://spring.io/projects/spring-boot }}{\fldrslt{http://spring.io/projects/spring-boot\ul0\cf0}}}}\f0\fs24 ) 2.1.2\par
- [maven]({{\field{\*\fldinst{HYPERLINK https://maven.apache.org/ }}{\fldrslt{https://maven.apache.org/\ul0\cf0}}}}\f0\fs24 )\par
- JPA/Hibernate\par
- [H2]({{\field{\*\fldinst{HYPERLINK http://www.h2database.com }}{\fldrslt{http://www.h2database.com\ul0\cf0}}}}\f0\fs24 )\par
- DevTools\par
- [Lombok]({{\field{\*\fldinst{HYPERLINK https://projectlombok.org/ }}{\fldrslt{https://projectlombok.org/\ul0\cf0}}}}\f0\fs24 )\par
- [JUnit 4]({{\field{\*\fldinst{HYPERLINK https://junit.org/junit4/ }}{\fldrslt{https://junit.org/junit4/\ul0\cf0}}}}\f0\fs24 )\par
- [Swagger]({{\field{\*\fldinst{HYPERLINK https://swagger.io/ }}{\fldrslt{https://swagger.io/\ul0\cf0}}}}\f0\fs24 ) 2\par
- [Docker ]\par
\par
## Getting Started\par
\par
### Database UI\par
{{\field{\*\fldinst{HYPERLINK http://localhost:8080/h2/ }}{\fldrslt{http://localhost:8080/h2/\ul0\cf0}}}}\f0\fs24\par
\par
### Swagger UI\par
{{\field{\*\fldinst{HYPERLINK http://localhost:8080/swagger-ui.html }}{\fldrslt{http://localhost:8080/swagger-ui.html\ul0\cf0}}}}\f0\fs24\par
\par
\highlight1 ### build with Docker & Run the application\highlight0\par
\par
### Backend\par
- Go to your project folder and run SpringBootApplication.\par
- Build Image: $ mvn clean install\par
               $ docker build -t tag-name/image-name .\par
- See Image: docker images\par
- Run Container: $ docker run -p 8080:8080 -t tag-name/image-name\par
- Stop Container: $ docker ps -q //<....>\par
\tab\tab\tab  $ docker stop <....>\par
- Server is running at {{\field{\*\fldinst{HYPERLINK http://localhost:8080 }}{\fldrslt{http://localhost:8080\ul0\cf0}}}}\f0\fs24  (\highlight1 Here 8081 is the Docker port and 8080 is the Tomcat port where is Spring Boot Backend is running\highlight0\par
\par
### Frontend\par
- Go to your project folder from your terminal `cd frontend`\par
- Build Image: $ docker build -t sample:dev .\par
- See Image: docker images\par
- Run Container: $ winpty docker run \\\par
    -it \\\par
    --rm \\\par
    -v $\{PWD\}:/app \\\par
    -v /app/node_modules \\\par
    -p 3001:3000 \\\par
    -e CHOKIDAR_USEPOLLING=true \\\par
    sample:dev\par
- Stop Container: $ docker ps -q //<....>\par
\tab\tab\tab  $ docker stop <....>\par
- Open your browser ({{\field{\*\fldinst{HYPERLINK http://localhost:3001 }}{\fldrslt{http://localhost:3001\ul0\cf0}}}}\f0\fs24 )\par
(port 3000 exposed to other Docker containers on the same network (for inter-container communication) and port 3001 to the host)\par
\par
\par
\par
\par
\par
\par
}
 # fullStackApp
