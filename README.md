# Book Store

# How to run project

Maven build automation tool is used in the project. 
Run the maven command below to run the application.

>* $ mvn spring-boot:run

After deploying the website, website will be published at localhost 8080 port, connect it using the url

>* localhost:8080/

To run tests, use the command

>* mvn test


## Implementation Details

### Modules

**Java Spring MVC framework** is used to build web application. It uses model-view-controller design pattern which helps us to develop loosely coupled web application.

**Java Spring Boot framework** is used to simplify the development process. Spring boot manages the configuration process so that we can develop application faster. Boot starter package provides all necessary dependency packages for the development process.

**Java Spring JPA API** is used for repositoriy management. Spring JPA uses Hibernate as JPA provider. It help us to interact with the database without writing database dependent queries. It provides built-in functions to save, update and delete object in the database.

**H2 database** is used as a embedded database. It is used as in-memory database so that data will be deleted after deployment process ends. H2 database helps use to test application faster by simplifying the process so that we dont have to create a heavy weight database management system like mysql.  

**Spring Boot Test Module** is used to test the services. Test module includes JUnit, AssertJ and Hamcrest etc. modules to test the application. Book, Author and Publisher services are tested with their repositories to verify that those functions works as expected.

**Thymeleaf** is used for view module. Thymeleaf is server-side java template engine for creating view module. It is used alongside with html and css to create web pages. Bootstrap css library is used to create more user friendly appearance.

**Maven** project management tool is used to simplfy build process. Maven helps us to get dependencies needed for application development.

### Implementation

3 main entites Book, Author, Publisher is created to represent the respective data.

Author and Publisher have name, email and address properties.

Book has name, subtitle, isbn, series name, and author and publisher properties. Author and Publisher properties have ManyToOne relationship so that an Author or a Publisher can have many Book object connected to them.

Since Book is connected to a certain Author and Publisher, When Author or Publisher is deleted, All books that connected to them are also deleted.
User has to define an author and a publisher before defining a book that connected to them.

Database tables are automatically created when application is deployed and some pre-defined values are inserted to the tables for test purpose.

Search can be done for the name of book or author. Search is case in-sensitive.


