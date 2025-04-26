---

# 🎬 MovieTorch Backend

Welcome to **MovieTorch**, a Spring Boot backend project designed for movie discovery, powered by **TMDB API** and built with **Reactive Programming** using **Spring WebFlux**.

---

## 📌 Project Overview

MovieTorch backend is a reactive web service that provides movie-related data like:
- Popular movies
- Top-rated movies
- Upcoming releases
- Movie details
- Cast and crew information
- Reviews
- Videos and trailers
- Recommendations
- Similar movies
- Images

It acts as a **bridge** between the client (frontend/mobile app) and **TMDB (The Movie Database)** API, giving a fast, secure, and structured API response.

---

## 🚀 Tech Stack Used

| Technology | Purpose |
|:-----------|:--------|
| 🧩 **Java 17** | Language |
| 🚀 **Spring Boot 3.2.3** | Main Framework |
| 🔄 **Spring WebFlux** | Reactive, Non-Blocking API Calls |
| 🌐 **WebClient** | Calling External TMDB API |
| 🛠 **Maven** | Build Tool |
| 🎯 **Lombok** | Reducing Boilerplate Code |
| 🛡️ **JUnit 5** | Testing Setup |

---

## 📂 Project Structure

```
movieTorch-backend/
 ├── config/          # WebClient, CORS, Content Negotiation Configurations
 ├── controller/      # API Endpoints (REST Controllers)
 ├── model/           # Data Transfer Objects (DTOs)
 ├── service/         # Service Layer - Handles TMDB API communication
 ├── resources/       # Application properties
 └── test/            # Unit Tests
```

---

## ⚙️ Features Implemented

- **Get Popular Movies**  
- **Search Movies by Query**  
- **Get Top Rated Movies**  
- **Fetch Upcoming & Now Playing Movies**  
- **Fetch Movie Details by ID**  
- **Fetch Recommendations & Similar Movies**  
- **Get Cast, Crew, Reviews, Videos, and Images**  
- **Error Handling** with clear HTTP responses  
- **Automatic Retry** for network failures (3 retries with backoff)  

---

## 🔗 Important API Endpoints

| Method | Endpoint | Description |
|:------|:---------|:------------|
| GET | `/api/movies/popular` | Fetch popular movies |
| GET | `/api/movies/top_rated` | Fetch top-rated movies |
| GET | `/api/movies/upcoming` | Fetch upcoming movies |
| GET | `/api/movies/now_playing` | Fetch now playing movies |
| GET | `/api/movies/search?query={movieName}` | Search movies by name |
| GET | `/api/movies/{id}` | Get movie details |
| GET | `/api/movies/{id}/recommendations` | Get movie recommendations |
| GET | `/api/movies/{id}/similar` | Get similar movies |
| GET | `/api/movies/{id}/credits` | Get cast and crew info |
| GET | `/api/movies/{id}/reviews` | Get movie reviews |
| GET | `/api/movies/{id}/videos` | Get movie videos/trailers |
| GET | `/api/movies/{id}/images` | Get movie images |

---

## 🛠 Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/movieTorch-backend.git
cd movieTorch-backend
```

### 2. Add TMDB API Key
Open `src/main/resources/application.properties` and update:

```properties
tmdb.api.key=YOUR_TMDB_API_KEY
```

> 🔥 You can get your free TMDB API key from [TMDB website](https://www.themoviedb.org/).

### 3. Build and Run
```bash
./mvnw spring-boot:run
```
App will start at:  
```
http://localhost:8080/
```

---

## 🧠 Key Concepts & Learnings

- **Reactive Programming** with Spring WebFlux (`Mono`)
- **Non-blocking I/O** using WebClient
- **CORS Configuration** for allowing frontend clients
- **Resilient Systems** with Retry Strategies
- **Exception Handling** and returning proper HTTP responses
- **Modular Code Structure** separating concerns (Controller, Service, Models)

---

## 📝 Future Improvements

- 🌟 JWT Authentication and Authorization
- 🌟 Swagger/OpenAPI Documentation
- 🌟 Caching frequently accessed movies
- 🌟 Pagination Support for large results
- 🌟 Dockerize the backend for deployment

---

## 👨‍💻 Author

Made with ❤️ by **shubham**  
[LinkedIn Profile](https://www.linkedin.com/in/singh-shubhamkumar-krishnadev-b581952a9/) | [GitHub](https://github.com/your-github](https://github.com/SinghShubhamkumarkrishnadev))



# 🎉 Thank you for visiting MovieTorch!

---
