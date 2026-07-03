# 🍔 Food Delivery Application

A full-stack Food Delivery Web Application developed using Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript. The application allows users to browse restaurants, order food, manage carts, place orders, and manage their profiles through an interactive and responsive interface.

---

# 📋 Table of Contents

- Requirements
- Installation Process
- Execution Steps
- Features
- Technologies Used
- Project Structure
- Conclusion

---

# 📌 Requirements

Before running the project, make sure the following software is installed on your system.

### Software Requirements

- Java JDK 17 or above
- Apache Tomcat 10.x
- MySQL Server 8.x
- MySQL Workbench (Optional)
- Eclipse IDE (Enterprise Edition) or IntelliJ IDEA
- Git
- Web Browser (Chrome, Edge, Firefox)

### Database Requirements

- MySQL Database
- JDBC Driver (MySQL Connector J)

---

# ⚙️ Installation Process

## Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/food-delivery-application.git
```

## Step 2: Import the Project

- Open Eclipse IDE.
- Select **Import Existing Dynamic Web Project**.
- Choose the cloned project folder.
- Finish the import.

## Step 3: Configure Apache Tomcat

- Download Apache Tomcat 10.x.
- Add the Tomcat server in Eclipse.
- Set Tomcat as the runtime server.

## Step 4: Configure MySQL Database

- Open MySQL Workbench.
- Create a new database.

```sql
CREATE DATABASE food_delivery;
```

- Import the SQL file included in the project.

## Step 5: Update Database Configuration

Open your database connection file and update:

```java
URL = jdbc:mysql://localhost:3306/food_delivery

Username = your_mysql_username

Password = your_mysql_password
```

## Step 6: Add JDBC Driver

Copy the MySQL Connector JAR into

```
WEB-INF/lib
```

or add it through your IDE.

---

# ▶️ Execution Steps

### 1. Start MySQL Server

Make sure the MySQL service is running.

### 2. Start Apache Tomcat

Run the configured Tomcat server.

### 3. Deploy the Project

Right-click the project

```
Run As → Run on Server
```

### 4. Open the Application

Visit

```
http://localhost:8080/food_deliver_application/
```

### 5. Login or Register

- Create a new account.
- Login using your credentials.
- Browse restaurants.
- Add food items to the cart.
- Place orders.
- View order history.
- Manage profile settings.

---

# ✨ Features

## 👤 User Features

- User Registration
- Secure Login & Logout
- Profile Management
- Account Settings
- Password Update

## 🍴 Restaurant Features

- Browse Restaurants
- Restaurant Details
- Restaurant Search

## 🍕 Food Menu

- View Menu Items
- Food Images
- Item Description
- Price Display

## 🛒 Cart Management

- Add to Cart
- Update Quantity
- Remove Items
- Total Price Calculation

## ❤️ Favourite Items

- Add to Favourite
- Remove Favourite
- View Favourite Menu

## 📦 Order Management

- Place Order
- Order Confirmation
- Order History
- View Previous Orders

## 💳 Payment

- Payment Method Selection
- Order Success Page

## 🎨 User Interface

- Responsive Design
- Modern UI
- Swiggy/Zomato Inspired Layout
- Interactive Navigation
- Mobile Friendly Pages

---

# 💻 Technologies Used

### Backend

- Java
- JSP
- Servlets
- JDBC

### Frontend

- HTML5
- CSS3
- JavaScript

### Database

- MySQL

### Server

- Apache Tomcat 10

### IDE

- Eclipse IDE

### Version Control

- Git
- GitHub

---

# 📂 Project Structure

```
FoodDeliveryApplication
│
├── src/
│   ├── Controller
│   ├── DAO
│   ├── DAOImplementation
│   ├── Model
│   └── Utility
│
├── WebContent/
│   ├── css
│   ├── images
│   ├── js
│   ├── WEB-INF
│   └── *.jsp
│
├── database/
│   └── food_delivery.sql
│
└── README.md
```

---

# 🎯 Conclusion

The Food Delivery Application is a complete full-stack web application designed to provide a seamless online food ordering experience. It demonstrates the practical implementation of Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript in building a real-world web application.

The project includes user authentication, restaurant browsing, menu management, shopping cart functionality, order processing, payment workflow, favourites management, and responsive user interface design. It serves as an excellent learning project for understanding MVC architecture, database integration, session management, and dynamic web development using Java technologies.

Future enhancements may include online payment gateway integration, live order tracking, email notifications, admin dashboard, restaurant management, and deployment on cloud platforms.
