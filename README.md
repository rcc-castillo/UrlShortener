# URL Shortener

This is a solution to the URL shortener project on roadmap.sh: https://roadmap.sh/projects/url-shortening-service

This is a simple URL shortening service built with Java, Spring Boot, and Maven. The service allows users to create, retrieve, update, and delete shortened URLs, as well as track the usage statistics of each shortened URL.

## Features

- **Shorten URLs:** Generate a unique, shortened version of any URL.
- **Retrieve URLs:** Look up the original URL using the shortened code.
- **Update URLs:** Modify the original URL associated with a shortened code.
- **Delete URLs:** Remove shortened URLs from the system.
- **View Stats:** Track how many times a shortened URL has been accessed.

## Project Structure

- **`src/main/java/com/roadmapsh/urlshortener/UrlShortenerApplication.java`**: Entry point to start the Spring Boot application.
- **`src/main/resources/application.properties`**: Contains configuration settings for Spring Boot.
- **`src/main/java/com/roadmapsh/urlshortener/presentation/controller/UrlShortenerController.java`**: Contains all the routes for interacting with the API.
- **`src/main/java/com/roadmapsh/urlshortener/bussiness/service/UrlShortenerService.java`**: Contains the business logic for URL shortening.
- **`src/main/java/com/roadmapsh/urlshortener/persistence/model/Url.java`**: Defines the `Url` model representing the URL entity.
- **`src/main/java/com/roadmapsh/urlshortener/common/dto/UrlStatsDTO.java`**: Defines the data transfer object for URL statistics.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Spring Boot 2.5.4 or higher
- Lombok 1.18.22 or higher
- PostgreSQL 13.4 or higher
- Postman or any other API testing tool

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/url-shortener.git
   cd url-shortener
   ```
   
2. **Build the project:**

   ```bash
    mvn clean install
    ```
   
3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### **POST /api/shorten**

Create a shortened URL.

- **Request:**
    - **Method:** POST
    - **Content-Type:** `application/json`
    - **Body:**
      ```json
      {
        "url": "http://example.com"
      }
      ```

- **Response:**
    - **Status Code:** 201 Created
    - **Body:**
      ```json
      {
        "id": 1,
        "url": "http://example.com",
        "shortCode": "abc123",
        "createdAt": "2024-08-21T12:00:00Z",
        "updatedAt": "2024-08-21T12:00:00Z"
      }
      ```

- **Description:** Generates a unique shortened URL for the provided original URL.

### **GET /api/shorten/{shortCode}**

Retrieve the original URL by its shortened code.

- **Request:**
    - **Method:** GET
    - **URL Parameter:** `shortCode` (the unique shortened code)

- **Response:**
    - **Status Code:** 200 OK
    - **Body:**
      ```json
      {
        "id": 1,
        "url": "http://example.com",
        "shortCode": "abc123",
        "createdAt": "2024-08-21T12:00:00Z",
        "updatedAt": "2024-08-21T12:00:00Z",
        "accessCount": 1
      }
      ```

- **Description:** Retrieves the original URL associated with the given shortened code and increments the access count.

### **PUT /api/shorten/{shortCode}**

Update the original URL associated with a shortened code.

- **Request:**
    - **Method:** PUT
    - **Content-Type:** `application/json`
    - **URL Parameter:** `shortCode` (the unique shortened code)
    - **Body:**
      ```json
      {
        "url": "http://newexample.com"
      }
      ```

- **Response:**
    - **Status Code:** 200 OK
    - **Body:**
      ```json
      {
        "id": 1,
        "url": "http://newexample.com",
        "shortCode": "abc123",
        "createdAt": "2024-08-21T12:00:00Z",
        "updatedAt": "2024-08-21T12:30:00Z"
      }
      ```

- **Description:** Updates the original URL associated with the given shortened code.

### **DELETE /api/shorten/{shortCode}**

Delete a shortened URL.

- **Request:**
    - **Method:** DELETE
    - **URL Parameter:** `shortCode` (the unique shortened code)

- **Response:**
    - **Status Code:** 204 No Content

- **Description:** Deletes the shortened URL associated with the given shortened code.

### **GET /api/shorten/{shortCode}/stats**

Get the usage statistics for a shortened URL.

- **Request:**
    - **Method:** GET
    - **URL Parameter:** `shortCode` (the unique shortened code)

- **Response:**
    - **Status Code:** 200 OK
    - **Body:**
      ```json
      {
        "id": 1,
        "url": "http://example.com",
        "shortCode": "abc123",
        "createdAt": "2024-08-21T12:00:00Z",
        "updatedAt": "2024-08-21T12:00:00Z",
        "accessCount": 1
      }
      ```

## Testing the API

To test the API, you can use Postman or any other API testing tool. Below are the steps to test each endpoint:

### **POST /api/shorten**

1. **Open Postman** and create a new POST request.
2. **Set the URL** to `http://localhost:8080/api/shorten`.
3. **Set the Content-Type** to `application/json`.
4. **Add the request body**:
    ```json
    {
      "url": "http://example.com"
    }
    ```
5. **Send the request** and verify that the response status is `201 Created` and the response body contains the shortened URL.

### **GET /api/shorten/{shortCode}**

1. **Open Postman** and create a new GET request.
2. **Set the URL** to `http://localhost:8080/api/shorten/{shortCode}`, replacing `{shortCode}` with the actual short code.
3. **Send the request** and verify that the response status is `200 OK` and the response body contains the original URL.

### **PUT /api/shorten/{shortCode}**

1. **Open Postman** and create a new PUT request.
2. **Set the URL** to `http://localhost:8080/api/shorten/{shortCode}`, replacing `{shortCode}` with the actual short code.
3. **Set the Content-Type** to `application/json`.
4. **Add the request body**:
    ```json
    {
      "url": "http://newexample.com"
    }
    ```
5. **Send the request** and verify that the response status is `200 OK` and the response body contains the updated URL.

### **DELETE /api/shorten/{shortCode}**

1. **Open Postman** and create a new DELETE request.
2. **Set the URL** to `http://localhost:8080/api/shorten/{shortCode}`, replacing `{shortCode}` with the actual short code.
3. **Send the request** and verify that the response status is `204 No Content`.

### **GET /api/shorten/{shortCode}/stats**

1. **Open Postman** and create a new GET request.
2. **Set the URL** to `http://localhost:8080/api/shorten/{shortCode}/stats`, replacing `{shortCode}` with the actual short code.
3. **Send the request** and verify that the response status is `200 OK` and the response body contains the usage statistics.

- **Description:** Retrieves the usage statistics, including the access count, for the given shortened URL.