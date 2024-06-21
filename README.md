# batikhub
# Cloud Computing Path

Creating **RESTful APIs** using NodeJS (Express) and deploying to [Google Cloud Platform](https://cloud.google.com) by using [Google Cloud run](https://cloud.google.com/run) for connection between android application and database. Using Cloud SQL and Sequelize for creating the database server, and Cloud Storage for images storage.

# RESTful APIs
In making the RESTful APIs we use NodeJS with the Express Framework for building an API server, and for responses using JSON format.
Explanation for each URL that can be used :

## Base Routes

Base URL
> https://batikhub-api-smdkgsrncq-et.a.run.app

## Plant Route

### Plant Endpoints

#### Get All Plants 

**Method :**

> `GET`

**Base URL :**

> `/plants`

**Description :**

> Retrieves data for all plants. 

**Response :**

- Status Code : 200 (OK)
- Body		      : Success message and an array of plant objects.

**Error Response :**

- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an internal server error.

<br>

#### Get Plant by ID

**Method :**

> `GET`

**Base URL :**

> `/plants/id/:id`

**Description :**

> Retrieves data for a specific plant based on the plant ID.

**URL Parameters :**

> `id`   : The ID of the plant. 

**Response :**

- Status Code : 200 (OK)
- Body		      : Success message and the plant object.

**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the plant with the specified ID was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an internal server error. 

<br>

#### Get Plant by name 

**Method :**

> `GET`

**Base URL :**

> `/plants/name/:name`  

**Description :**

> Retrieves data for a specific plant based on the plant name.

**URL Parameters :**

> `name`   : The name of the plant. 

**Response :**

- Status Code : 200 (OK)
- Body		      : Success message and the plant object.

**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the plant with the specified name was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an internal server error. 

<br>

## Disease Route

### Disease Endpoints

#### Get All Diseases  

**Method :**

> `GET`

**Base URL :**

> `/diseases`

**Description :**

> Retrieves information for all diseases. 

**Response :**

- Status Code : 200 (OK)
- Body		      :
  - message : Success message
  - data    : Array of disease objects containing information about each disease. The `createdAt` and `updatedAt` fields are excluded.

**Error Response :**

- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the diseases. 

<br>

#### Get specific disease by disease ID 

**Method :**

> `GET`

**Base URL :**

> `/diseases/id/:id`

**Description :**

> Retrieves information about a specific disease identified by the provided 'id' parameter.

**URL Parameters :**

> `id`   : The Unique identifier of the disease. 

**Response :**

- Status Code : 200 (OK)
- Body		      : Success message and the plant object.
   - message  : Success message.
   - data     : Object containing information about the specific disease. The `createdAt` and `updatedAt` fields are excluded.
     
**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the plant with the specified ID was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the disease. 

<br>

#### Get specific disease by disease ID 

**Method :**

> `GET`

**Base URL :**

> `/diseases/name/:name`

**Description :**

> Retrieves information about a specific disease identified by the provided 'name' parameter.

**URL Parameters :**

> `name`   : The name of the disease. 

**Response :**

- Status Code : 200 (OK)
- Body		      : 
   - message  : Success message.
   - data     : Object containing information about the specific disease. The `createdAt` and `updatedAt` fields are excluded.
     
**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the disease with the specified name was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the disease. 

<br>

#### Get specific disease by disease ID 

**Method :**

> `GET`

**Base URL :**

> `/diseases/name/:name`

**Description :**

> Retrieves information about a specific disease identified by the provided `name` parameter.

**URL Parameters :**

> `name`   : The name of the disease. 

**Response :**

- Status Code : 200 (OK)
- Body		      : 
   - message  : Success message.
   - data     : Object containing information about the specific disease. The `createdAt` and `updatedAt` fields are excluded.
     
**Error Response :**

- Status Code : 404 (Not Found)
- Body        : Error message if the disease with the specified name was not found.
- Status Code : 500 (Internal Server Error)
- Body        : Error message if there was an error retrieving the disease. 

<br>

