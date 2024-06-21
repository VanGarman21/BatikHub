# Cloud Computing Path

Creating **RESTful APIs** using NodeJS (Express) and deploying to [Google Cloud Platform](https://cloud.google.com) by using [Google Cloud run](https://cloud.google.com/run) for connection between android application and database. Using Cloud SQL and Prisma ORM for creating the database server, and Cloud Storage to store ML model and all batik images.

# RESTful APIs
In making the RESTful APIs we use NodeJS with the Express Framework for building an API server, and for responses using JSON format.
Explanation for each URL that can be used :

## Base Routes

Base URL
> https://batikhub-api-smdkgsrncq-et.a.run.app

## Batik Route

### Get All Batik 

**Endpoint :**

> `GET /batik`

**Description :**

> Retrieves data for all Batik. 

**Parameters:**
- None

**Headers:**
- None

**Response:**

- **Success:**
    ```json
    {
        "message": "Get all batik success!",
        "data": [
            {
                "id": "string",
                "name": "string",
                "regional_origin": "string",
                "description": "string",
                "image": "string",
                "createdAt": "DateTime"
            }
        ]
    }
    ```

- **Error:**
    ```json
    {
        "message": "Internal Server Error"
    }
    ```
    Status Code: 500 Internal Server Error

### Get Specified Batik by Id

**Endpoint :**

> `GET /batik/id/:id`

**Description :**

> Retrieves data for a specific batik based on the batik ID.

**Parameters:**
- `id` (string) - Batik ID

**Headers:**
- None

**Response:**

- **Success:**
    ```json
    {
        "message": "Get selected batik success!",
        "data": {
            "id": "string",
            "name": "string",
            "regional_origin": "string",
            "description": "string",
            "image": "string",
            "createdAt": "DateTime"
        }
    }
    ```

- **Error:**
    - 404 Not Found:
        ```json
        {
            "message": "Batik not found!"
        }
        ```
    - 500 Internal Server Error:
        ```json
        {
            "message": "Internal Server Error"
        }
        ```

### Get specific batik by batik name 

**Endpoint :**

> `POST /batik/name`

**Description :**

> Retrieves data for a specific batik based on the batik name.

**Parameters:**
- None

**Body:**
- `name` (string) - Batik name

**Headers:**
- None

**Response:**

- **Success:**
    ```json
    {
        "message": "Get batik from name success!",
        "data": [
            {
                "id": "string",
                "name": "string",
                "regional_origin": "string",
                "description": "string",
                "image": "string",
                "createdAt": "DateTime"
            }
        ]
    }
    ```

- **Error:**
    - 404 Not Found:
        ```json
        {
            "message": "Batik not found!"
        }
        ```
    - 500 Internal Server Error:
        ```json
        {
            "message": "Internal Server Error"
        }
        ```

## Predict Route

### Predict Batik 

**Endpoint :**

> `POST /predict`

**Description :**

> Retrieves predicted batik motif based on user's image input.

**Parameters:**
- None

**Body:**
- `image` (File, multipart/form-data) - Batik image

**Headers:**
- None

**Response:**

- **Success:**
    ```json
    {
        "message": "Get batik from name success!",
        "data": {
            "id": "string",
            "label": "string",
            "percentage": "number",
            "date": "string",
            "desc": "string"
        }
    }
    ```

- **Error:**
    - 400 Bad Request:
        ```json
        {
            "message": "Invalid input, file is required!"
        }
        ```
    - 500 Internal Server Error:
        ```json
        {
            "message": "Internal Server Error"
        }
        ```
