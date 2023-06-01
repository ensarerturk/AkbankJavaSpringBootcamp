# Online Shopping Service

This project provides the backend service of an online shopping site. The service manages users, products and reviews. Users can be registered as individuals or institutions. Only one e-mail and one phone number can be assigned to each user. More than one registration cannot be made with the same user name, phone number or e-mail.

Each component contains classes that perform related operations. Thus, the business logic is separated from the controller classes and a more modular structure is provided.

## Features

The project provides the following services:

### Product Controller

- POST /products: Registers a new product.
- GET /products: Lists all products.
- GET /products/{id}: Returns the product according to the given product ID.
- DELETE /products/{id}: Deletes the product according to the given product ID.
- PUT /products/{id}/price: Updates the product price according to the given product ID.

### Customer Controller

- GET /users: Lists all users.
- GET /users/{id}: Gets the user based on the given user ID.
- GET /users/username/{username}: Gets the user based on the given username.
- POST /users: Registers a new user.
- DELETE /users: Deletes the user according to the given username and phone information. In case of conflict, it gives an error message.
- PUT /users/{id}: Updates user information according to given user ID.

### Comment Controller

- GET /comments/user/{userId}: Returns the comments made by the user according to the given user ID. If there is no comment, it gives an error message.
- GET /comments/product/{productId}: Returns all comments made to that product according to the given product ID. If there is no comment, it gives an error message.
- POST /comments: Records a new comment.
- DELETE /comments/{id}: Deletes the comment based on the given comment ID.

### Error Management

The project includes an error handling mechanism to properly manage error states. Errors are returned with the appropriate HTTP error codes and descriptions.
