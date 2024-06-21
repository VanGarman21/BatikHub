# Cloud Computing Path

Creating **RESTful APIs** using NodeJS (Express) and deploying to [Google Cloud Platform](https://cloud.google.com) by using [Google Cloud run](https://cloud.google.com/run) for connection between android application and database. Using Cloud SQL and Prisma for creating the database server, and Cloud Storage for images storage.

# RESTful APIs
In making the RESTful APIs we use NodeJS with the Express Framework for building an API server, and for responses using JSON format.
Explanation for each URL that can be used :

## Base Routes

Base URL
> https://batikhub-api-smdkgsrncq-et.a.run.app

## Batik Route

#### Get All Batik 

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

#### Get Batik by Id

**Endpoint :**

> `GET /batik`

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

#### Get specific batik by batik ID 

**Method :**

> `GET`

**Base URL :**

> `/batiks/id/:id`

**Description :**

> Retrieves information about a specific batik identified by the provided 'id' parameter.

**URL Parameters :**

> `id`   : The Unique identifier of the batik. 

**Response :**

- Status Code : 200 (OK)
- Body		      : Success message and the batik object.
   - message  : Success message.
   - data     : Object containing information about the specific batik. The `createdAt` and `updatedAt` fields are excluded.
     
**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the batik with the specified ID was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the batik. 

<br>

#### Get specific batik by batik ID 

**Method :**

> `GET`

**Base URL :**

> `/batiks/name/:name`

**Description :**

> Retrieves information about a specific batik identified by the provided 'name' parameter.

**URL Parameters :**

> `name`   : The name of the batik. 

**Response :**

- Status Code : 200 (OK)
- Body		      : 
   - message  : Success message.
   - data     : Object containing information about the specific batik. The `createdAt` and `updatedAt` fields are excluded.
     
**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the batik with the specified name was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the batik. 

<br>

#### Get specific batik by batik ID 

**Method :**

> `GET`

**Base URL :**

> `/batiks/name/:name`

**Description :**

> Retrieves information about a specific batik identified by the provided `name` parameter.

**URL Parameters :**

> `name`   : The name of the batik. 

**Response :**

- Status Code : 200 (OK)
- Body		      : 
   - message  : Success message.
   - data     : Object containing information about the specific batik. The `createdAt` and `updatedAt` fields are excluded.
     
**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the batik with the specified name was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the batik. 

<br>

