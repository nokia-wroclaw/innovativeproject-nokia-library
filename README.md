# innovativeproject-nokia-library
## Table of contents
1. Project overview
2. Functionality
3. Technologies
4. Installation guide
5. Contributing

# 1. Project overview
The goal of the project is to create a library web application.

Demo app available at: https://nokia-library-client.herokuapp.com

Demo video no YouTube: https://youtu.be/f9H7dZBYAxw

# 2. Functionality
For all users:
* Borrowing and reserving books,
* prolongation of borrowed books,
* reminder about returning a book,
* requesting new books,
* notification about book availability,
* contact with developers (report a bug, request new feature, etc.),
* user accounts,
* night theme.

For admins only:
* Books management (add, edit, remove),
* semi-automated book details completion,
* returning books,
* list of requested books.

The business logic of main features which are borrowing and reserving books (and everything related to them) are explained on below flowchart:
![Flowchart](./logic_flowchart.jpeg)

5 big rectangles are different states of book: available, awaiting, borrowed, reserved, unavailable. 
For every action taken by user or admin, estimated availability date can be changed by days or month, or it can reset back to default (small rectangles).

# 3. Technologies
* Backend
  * [PostgreSQL](https://www.postgresql.org/)
  * [Java 8](https://www.java.com)
  * [Spring 5](https://spring.io/)
  * [JUnit 5](https://junit.org/junit5/)
  * [Mockito 2](https://site.mockito.org/)
* Frontend
  * [Angular 7](https://angular.io/)
  * [Angular Material 7](https://material.angular.io/)
* Other
  * [Docker](https://www.docker.com/)
  * [Travis CI](https://travis-ci.org/)
  * [Swagger UI](https://swagger.io/)
  * [Heroku](https://www.heroku.com/)
  * [Cloudinary](https://cloudinary.com/) 

# 4. Installation guide
1. Install docker on your local machine.
2. In a project's source folder execute: ``` docker-compose up ```

# 5. Contributing
Students:
* Mikołaj Banaszkiewicz
* Alex Kostiukov [Github](https://github.com/KostiukovAleksey)
* Wojciech Sponton 
* Jacek Zalewski [Github](https://github.com/tubidubidam)

Nokia supervisors:
* Mateusz Płuciennik
* Adam Dyngosz
* Mateusz Wierzbicki