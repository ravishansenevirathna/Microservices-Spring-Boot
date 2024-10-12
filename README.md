
# 🚀 Spring Boot Microservices Project

Welcome to my Spring Boot Microservices project! This project demonstrates the complete implementation of a microservices architecture using **Spring Boot** and **Spring Cloud**. Dive in to explore how microservices solve the challenges of monolithic architecture and learn how they communicate, scale, and provide resilience.

---

## 🏗️ **Microservices Introduction**
- Monolith Architecture and its Challenges
- Microservices: The Solution to Monolith Problems
- Benefits and Best Practices of Microservices Architecture
- Understanding **Spring Cloud** and Its Key Modules
- Building Microservices Architecture with **Spring Boot** and **Spring Cloud**

---

## 🛠️ **Section 2 - Building Microservices**
- Choosing Compatible Versions of **Spring Boot** and **Spring Cloud**
- Building **EmployeeService** and **DepartmentService**
- **DepartmentService**: MySQL Database Configuration
- Building REST APIs for **DepartmentService**
- **EmployeeService**: MySQL Database Configuration
- Building REST APIs for **EmployeeService**

---

## 🔗 **Section 3 - Microservice Communication**
- Overview of Microservice Communication Methods
- Communication Using **RestTemplate**
- Communication Using **WebClient**
- Communication Using **Spring Cloud OpenFeign**

1. RestTemplate:
   Traditional way to make HTTP requests.
   Blocking and simple, but deprecated in Spring 5+.

2. WebClient:
   Modern, flexible, supports both blocking and non-blocking calls.
   Ideal for reactive systems and efficient communication.
   WebClient supports both synchronous and asynchronous communications

3. Spring OpenFeign:
   Declarative REST client for easy service-to-service calls.
   Integrates with service discovery and load balancing.

# Asynchronous Communication
- Message Brokers: Services use message brokers like RabbitMQ, Apache Kafka, or ActiveMQ for event-driven, asynchronous communication.
- Spring Cloud Stream: Provides integration with messaging platforms to handle communication using event streams.
---

## 🗺️ **Section 4 - Service Registry and Discovery with Eureka**
- Understanding **Service Registry**
- Setting up **Eureka Server** in IntelliJ IDEA
- Registering **DepartmentService** and **EmployeeService** as Eureka Clients
- Running Multiple Instances of **DepartmentService**
- Load Balancing with **Eureka**, **OpenFeign**, and **Spring Cloud LoadBalancer**

---

## 🌐 **Section 5 - API Gateway with Spring Cloud Gateway**
- Understanding **API Gateway**
- Setting up **API Gateway** as a Eureka Client
- Configuring Gateway Routes and Testing via Postman
- Dynamic Route Creation with **Spring Cloud Gateway**

---

## 🛡️ **Section 6 - Centralized Configuration using Spring Cloud Config Server**
- Why Use a **Spring Cloud Config Server**?
- Setting up **Spring Cloud Config Server** Project in IntelliJ IDEA
- Registering Config Server as a Eureka Client
- Configuring Git-Based Configuration Storage
- Using Config Server in **Department-Service** and **Employee-Service**
- Refresh Configuration without Service Restart

---

## 🔄 **Section 7 - Auto Refresh Config Changes with Spring Cloud Bus (RabbitMQ)**
- Problem with Static Configuration
- How **Spring Cloud Bus** Solves This Issue
- Auto-Refreshing Config Changes with **Spring Cloud Bus**

---

## 🔍 **Section 8 - Distributed Tracing with Spring Cloud Sleuth & Zipkin**
- Solving the Distributed Tracing Problem
- Implementing Distributed Tracing with **Spring Cloud Sleuth**
- Tracing Requests with **Zipkin**

---

## 🛠️ **Section 9 - Circuit Breaker with Resilience4j**
- Understanding the **Circuit Breaker Pattern**
- Implementing Circuit Breaker and Retry Pattern with **Resilience4j**

---

## ➕ **Section 10 - Adding New Microservices to the Existing Project**
- How to Integrate New Microservices into the Architecture
- Reconfiguring the System for the New Services

---

Good Luck! 💻🚀
