Set up spring boot project

spring initializer - to start our string boot project easily
install maven - maven is used to build our spring boot project
add maven path to system variables 

in vs code
go to our project folder 
on terminal - mvn clean install

pom.xml - contains information about dependencies


resources - application.properties - can write port number 
default port - 8080
to run file - mvn spring-boot:run


FirstSpringProjectApplication - contains main function - so run this file to start project

in order to trigger a function inside a backend - we need to do UrlMapping.

client make request to backend
backend responds to client 
backend tells the client what kind of request it can accept

how backend tells this: http protocol
maps function to a url
eg. - addTwoNumbers(x, y) -> /add_two_numbers
it is like a (key, value) pair - url is key - function is value
as soon as a key(url) is used it will trigger the respective value(function).

Request - 3 important parts - Type, url, data
Type:
1. GET - default
2. post
3. put
4. Delete
others...

patch - partial update - only want to update one or two fields, not the entire object.

we can identify any request by (type + url)

/add_two_numbers - endpoints - entry point in an application

example - @GetMapping for making get request, @PostMapping for post request, similarly for others
    @GetMapping("/add_two_numbers")  ---- suppose this is a key
                                     ---- this function is value associated with that key
    public int addTwoNumbers(        
        @RequestParam int a, 
        @RequestParam int b) {
        return a + b;
    }

@RestController  //anotation that is going to make a class capable to telling springboot what kind of mappings are present inside the springboot application
if not present before class then the url mapping will not work

|=========|
| Backend |<------------------  Student
|=========|                          1. Add new student                      -> POST   -> (C)reate
    |                                2. Get student info by admission number -> GET    -> (R)ead
    |                                3. Updating student info                -> PUT    -> (U)pdate
    |        |==========|            4. Delete a student                     -> DELETE -> (D)elete
    |------> | database |
             |==========|    


connect our application with database
1. install database on your machine
2. go to application.properties - write key-value pairs
3. spring.datasource.url=jdbc:postgre://localhost:port_number/database_name

jpa = to make use of database configurations



@Entity  // object of this class is directly going to be mapped with a database table

@Table(name = "student")  // can define table name like this. If table name is not given then className is treated as table name by default.

@Id // id is taken as primary key 
@GeneratedValue(strategy = GenerationType.SEQUENCE)  // id is generated automatically by this 
@Column(name="column name in db", nullable= true/false)

@Repository - tag the class name - where we will do all database related work.
create repositary package inside the same folder as entities.
inside this create an interface which will extend JpaRepository - JpaRepository comes from springboot itself 
JpaRepository is generic type so write JpaRepository<Entity_name that you want to query on, PrimaryKeyType>


@Service -- we write the business logic
eg - we want to that no two students have the same reg no. so we need to check this condition every time a new student joins.
this is called business logic

this business logic needs to interact with the database so we need to connect this service with the repository
eg.    private final StudentRepository studentRepository;

when some value can be null it is called as optional value


request -
type, url, data(query param/ request param, path parameter, header, body)

query param - passed in the url - url?param1=value1, param2=value2,
body - if we want to send an object as parameter- can be sent as json object - @RequestBody before parameter
path parameter - url/parameter - taken directly from url

if we want to pass only one parameter - like primary key then use path parameter otherwise use query parameter

