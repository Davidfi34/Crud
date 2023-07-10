# Java CRUD Project

This Java CRUD project provides a set of APIs for managing user-related operations. It allows you to perform basic Create, Read, Update, and Delete operations on user records in a database.
##Technologies Used

    Java
    Spring Framework
    Spring Boot
    Spring Data JPA
    RESTful API

# Installation

    Clone the repository to your local machine.
    Import the project into your preferred Java IDE.
    Make sure you have Java and Maven installed on your system.
    Resolve the project dependencies by running mvn install or using your IDE's build tools.

# Usage

    Start the application.
    The CRUD APIs are accessible via HTTP requests to the specified endpoints.

## Endpoints
## Get All Users

    Endpoint: GET /user
    Description: Retrieves a list of all users.
    Returns: A JSON array containing user objects.

## Create User

    Endpoint: POST /user
    Description: Creates a new user.
    Request Body: User object in JSON format.
    Returns: The created user object.

## Get User by ID

    Endpoint: GET /user/{id}
    Description: Retrieves a user by their ID.
    Path Variable: id - The ID of the user to retrieve.
    Returns: The user object with the specified ID, if found.

## Update User by ID

    Endpoint: PUT /user/{id}
    Description: Updates a user by their ID.
    Path Variable: id - The ID of the user to update.
    Request Body: User object with updated data in JSON format.
    Returns: The updated user object.

## Delete User by ID

    Endpoint: DELETE /user/{id}
    Description: Deletes a user by their ID.
    Path Variable: id - The ID of the user to delete.
    Returns: A message indicating the success or failure of the deletion.

## Partial Update of User by ID

    Endpoint: PATCH /user/{id}
    Description: Updates a user partially by their ID.
    Path Variable: id - The ID of the user to update.
    Request Body: User object with partial updated data in JSON format.
    Returns: The updated user object.

## Contributors

    David Figuerero

Feel free to contribute to the project by submitting bug reports, feature requests, or pull requests.
## License

This project is licensed under the MIT License.

 
 
