# Microservices Repository

## Overview
This repository contains a set of microservices designed to work together for a hotel management platform. The system follows a microservices architecture, with each service independently responsible for a specific function, allowing for scalability and ease of maintenance.

### Microservices in this Repository:
1. **Hotel Service** - Manages hotel data including hotel details, room availability, and amenities.
2. **User Service** - Handles user information such as profiles, registration, and user preferences.
3. **Rating Service** - Stores and retrieves ratings and reviews provided by users for hotels.
4. **Registry Service** - Acts as a service discovery to register and discover available services (using tools like Eureka).

## Technologies Used
- **Java**, **Spring Boot**: For building RESTful microservices.
- **Spring Cloud**: For managing microservice interactions, including configuration and service discovery.
- **Eureka**: Service registry for service discovery.
- **PostgreSQL/MongoDB**: Databases for storing structured and unstructured data.
- **Docker**: For containerizing microservices.
- **Swagger**: For API documentation.
- **Spring Cloud Gateway**: For routing requests and API Gateway.

## Prerequisites
Before you can run the microservices, ensure you have the following installed:
- **Java 17**
- **Maven**: For building the project.
- **Docker**: For containerizing and running the services.
- **PostgreSQL/MongoDB**: For storing data.

## Getting Started

### Cloning the Repository
Clone the repository to your local machine:

```sh
git clone https://github.com/your-username/micro-services.git
cd micro-services

### Contact
For any inquiries or issues, please contact [abusalehmd2@gmail.com].

Feel free to explore and enhance democrud!
