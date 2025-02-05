### Environment settings

1. Update the `application.properties` (in resources)
2. Make sure that the username and password match yours
3. `jdbc:mysql://localhost:3306/demo` <<<< demo is the name of your database
4. Replace with the name of your database, or add a schema `demo` in MySQL Workbench

---

### Creating the model

1. Create a class `Student`.
2. Give it the following attributes:
    - `id` (Long)
    - `name` (String)
    - `email` (String)
    - `age` (int)
3. Annotate it with `@Entity`, `@Id`, and `@GeneratedValue`.

---

### Creating the repository

1. Create an interface `StudentRepository`.
2. Make it extend `CrudRepository<Student, Long>`.
3. Add the following custom abstract method to the repository interface:
   ```java
   Optional<Student> findByName(String name);
   ```

---

### Creating the service

1. Create a `StudentService`.
2. Look at the `CourseService` for how to implement the service.
3. Add methods for:
    - Getting all students
    - Getting a student by ID
    - Adding a student
    - Finding a student by name using our findByName method

---

### Creating the controller

1. Create a `StudentController`.
2. Look at the `CourseController` for how to implement the controller.
3. Add endpoints for:
    - Getting all students (`GET /students`)
    - Getting a student by ID (`GET /students/{id}`)
    - Adding a student (`POST /students`)
    - Finding a student by name (`GET /students/name/{name}`)

---

### Testing the application

1. Test it in Postman (or whatever tool you prefer) and verify that all the endpoints work using MySQL Workbench.