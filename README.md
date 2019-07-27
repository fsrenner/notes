# notes
Notes Spring Boot REST Service



# Steps to run the notes application (requires Gradle)
1. Clone the repository
2. Navigate inside the notes directory: `cd notes`
3. Build the executable Spring Boot jar: `gradle build`
4. Navigate to the libs directory: `cd build/libs`
5. Execute the Spring Boot jar: `java -jar note-0.0.1-SNAPSHOT.jar`

# Using the REST Service
1. Open Postman (or preferred REST API endpoint testing tool)
2. Perform a GET request to the following URL: localhost:8080/api/notes
3. Perform a POST request to the same above URL with JSON body:
```json
{
  "body": "Pick up milk:
}
```
4. Perform several other POST request using above JSON format
5. Perform the following GET request: localhost:8080/api/notes/2
6. Perform the following GET request: localhost:8080/api/notes/300 (Should return a not found message)
7. Peform the following GET request: localhost:8080/api/notes?query=milk
8. (Bonus): Also has the ability to update and delete notes
