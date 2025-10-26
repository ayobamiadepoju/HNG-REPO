# HNG Backend Stage 0 — Dynamic Profile Endpoint

## Project Overview
This project implements the **Stage 0 task** for the **HNG Backend Track**.  
It provides a RESTful API that returns personal profile information along with a **dynamic cat fact** fetched in real time from the [Cat Facts API](https://catfact.ninja/fact).
---

## API Endpoint

### **GET** `/me`

#### **Response Example**
```json
{
  "status": "success",
  "user": {
    "email": "myemail@example.com",
    "name": "My Full Name",
    "stack": "Java/Spring Boot"
  },
  "timestamp": "2025-10-15T12:34:56.789Z",
  "fact": "Cats sleep 70% of their lives."
}
```

## Technologies Used
* Java 21

* Spring Boot 3.5.6

* Maven build tool

* RestTemplate (for optional HTTP requests)

* Railway (for deployment)

---

## Features
* Has One endpoint (GET)

* Returns user profile information

* Dynamically fetches random cat facts from the Cat Facts API

* Returns current UTC timestamp in ISO 8601 format

* Handles network errors and timeouts gracefully

* Uses environment variables for configuration

* Includes CORS support and JSON response headers

* Hosting and deployment of a production-ready API

---

## Project Structure

```
com.hng.profileapi
├── controller
│   └── ProfileController.java      # Handles /me endpoint
├── service
│   └── UserProfileService.java     # Business logic and Cat Fact integration
├── dto
│   ├── CatFact.java                # DTO for Cat Facts API response
│   ├── ProfileResponse.java        # DTO for response body
│   └── UserDto.java                # DTO for user details
├── Config.java                     # Configures RestTemplate bean
└── ProfileApiApplication.java      # Main Spring Boot entry point
```

---

## Configuration

All configuration values are set in the `src/main/resources/application.properties` file.

### Example:
```properties
# User details
user.name=${USER_NAME:John Doe}
user.email=${USER_EMAIL:JohnDoe@gmail.com}
user.stack=${USER_STACK:Java/SpringBoot}

# External API
catfacts.api.url=https://catfact.ninja/fact

# Server settings
server.port=8080
```
---

## How It Works

1. When `/me` is called, `ProfileController` delegates the request to `UserProfileService`.
2. `UserProfileService`:
    - Reads user details from environment variables.
    - Fetches a random cat fact from the external API using `RestTemplate`.
    - Generates a current UTC timestamp (`Instant.now().toString()`).
    - Returns all data as a formatted JSON object.
3. `Config.java` defines a `RestTemplate` bean with 5-second timeouts for both connection and read operations.
4. If the external API fails, a default fallback message is returned:  
   `"Unable to fetch new fact"`.

---

## Setup Instructions

### **1️⃣ Clone the repository**
```bash
git https://github.com/ayobamiadepoju/profileapi
cd <your-repo-name>
```

### **2️⃣ Configure environment**
Edit the file:
```
src/main/resources/application.properties
```
Add your details as shown above.

### **3️⃣ Build and run**
```bash
mvn clean install
mvn spring-boot:run
```

### **4️⃣ Test endpoint**
Visit:
```
http://localhost:8080/me
````
---

## Deployment

You can deploy this application on any cloud platform **except Vercel or Render**, such as:
- [Railway](https://railway.app)
- [Heroku](https://heroku.com)
- [PXXL App](https://pxxl.app)
- AWS, Azure, or GCP

Make sure port `8080` (or whichever you set) is exposed publicly.

---

## 👤 Author

**Name:** AYOBAMI ADEPOJU  
**Email:** ayobamiadepoju263@gmail.com  
**Stack:** Java / Spring Boot  
**GitHub:** [@ayobamiadepoju](https://github.com/ayobamiadepoju)
---

