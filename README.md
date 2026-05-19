

# 🏨 Hotel Reservation Application

<p align="center">

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge\&logo=openjdk)
![Architecture](https://img.shields.io/badge/Architecture-Layered-blue?style=for-the-badge)
![Design](https://img.shields.io/badge/Design-OOP-green?style=for-the-badge)
![Pattern](https://img.shields.io/badge/Pattern-Singleton-purple?style=for-the-badge)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Stable-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge)

</p>

---

## 📌 Overview

The **Hotel Reservation Application** is a console-based Java project designed using **Object-Oriented Programming principles** and a **Layered Architecture pattern**.

The system simulates a real-world hotel booking workflow, allowing:

* Customers to search and book rooms
* Administrators to manage hotel inventory
* Reservation tracking and customer management

This project demonstrates strong software engineering practices including:

* Separation of concerns
* Clean code structure
* Reusable service logic
* Proper abstraction using interfaces

---

## 🎯 Objectives

* Implement a modular hotel booking system
* Apply OOP concepts in a real-world scenario
* Design a layered architecture system
* Practice Singleton design pattern
* Build scalable and maintainable code

---

# 🏗️ System Architecture

The application follows a **4-Layer Architecture**:

```
UI Layer → API Layer → Service Layer → Model Layer
```

---

## 🔹 1️⃣ Model Layer (Core Business Entities)

Contains domain objects representing the system.

| Class         | Responsibility                          |
| ------------- | --------------------------------------- |
| `Customer`    | Stores customer information             |
| `IRoom`       | Interface for Room abstraction          |
| `Room`        | Standard hotel room                     |
| `FreeRoom`    | Special room with zero cost             |
| `RoomType`    | Enum (SINGLE / DOUBLE)                  |
| `Reservation` | Links customer, room, and booking dates |

### ✔ Concepts Used

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction (Interfaces)

---

## 🔹 2️⃣ Service Layer (Business Logic)

Handles all core operations and data management.

### `CustomerService`

* Add customer
* Get customer by email
* Retrieve all customers

### `ReservationService`

* Add rooms
* Find available rooms
* Create reservations
* Get customer reservations
* Print all reservations

### ✔ Design Pattern

Both services implement the **Singleton Pattern** to ensure:

* Single instance
* Centralized data management
* Better performance

---

## 🔹 3️⃣ API Layer (Facade Layer)

Acts as an intermediary between UI and services.

### `HotelResource`

* Customer operations
* Room search
* Booking logic

### `AdminResource`

* Add rooms
* View customers
* View reservations
* View room inventory

This layer improves:

* Decoupling
* Maintainability
* Code reusability

---

## 🔹 4️⃣ UI Layer (Presentation Layer)

Console-based interaction using:

* `MainMenu`
* `AdminMenu`
* `Driver` (Application Entry Point)

Handles:

* User input
* Navigation
* Display output

---

# ✨ Features

## 👤 Customer Functionalities

* Create account
* Search rooms by check-in/check-out date
* Book room
* View personal reservations

## 🛠️ Admin Functionalities

* Add rooms
* View all rooms
* View all customers
* View all reservations

---

# 💻 Technology Stack

| Technology           | Purpose                      |
| -------------------- | ---------------------------- |
| Java                 | Core programming language    |
| Java Collections     | Data storage                 |
| OOP                  | Software design              |
| Layered Architecture | Clean structure              |
| Singleton Pattern    | Controlled service instances |

---

# 📂 Project Structure

```
Hotel Reservation Application/
│
├── src/
│   ├── Driver.java
│   ├── HotelApplication.java
│   │
│   ├── api/
│   │   ├── AdminResource.java
│   │   └── HotelResource.java
│   │
│   ├── model/
│   │   ├── Customer.java
│   │   ├── IRoom.java
│   │   ├── Room.java
│   │   ├── FreeRoom.java
│   │   ├── RoomType.java
│   │   └── Reservation.java
│   │
│   ├── service/
│   │   ├── CustomerService.java
│   │   └── ReservationService.java
│   │
│   └── ui/
│       ├── MainMenu.java
│       └── AdminMenu.java
│
└── out/
```

---

# ▶️ Installation & Execution

## 🔹 Prerequisites

* Java JDK 8 or higher
* Command Prompt / Terminal
* IDE (VS Code / IntelliJ / Eclipse)

---

## 🔹 Clone Repository

```
git clone https://github.com/your-username/hotel-reservation-application.git
cd hotel-reservation-application
```

---

## 🔹 Compile

```
cd src
javac Driver.java
```

---

## 🔹 Run

```
java Driver
```

---

# 🔍 Sample Workflow

### Customer Flow

1. Create Account
2. Search Rooms
3. Book Room
4. View Reservation

### Admin Flow

1. Login to Admin Menu
2. Add Room
3. View Rooms
4. View Reservations

---

# 🧠 Concepts Demonstrated

*  Object-Oriented Programming
*  Interface-based design
*  Enum usage
*  Collections Framework
*  Singleton Pattern
*  Separation of Concerns
*  Layered Architecture
*  Clean Code Practices

---

# 📈 Scalability & Improvements

Future upgrades can include:

*  Database Integration (MySQL / PostgreSQL)
*  REST API version (Spring Boot)
*  GUI (JavaFX / Swing)
*  Payment Gateway Integration
*  JUnit Testing
*  Logging Framework
*  Input validation improvements

---

# 🧪 Testing

Currently tested manually through console interactions.

Future improvement:

* Add JUnit test cases
* Add integration testing
* Add input validation tests

---

