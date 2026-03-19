# 💰 Personal Finance Tracker

A professional-grade desktop application built with **Java 21** and **JavaFX**. This tool helps users manage their financial health by tracking expenses, income, and loan EMIs with a modern, interactive dashboard.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-blue?style=for-the-badge&logo=java&logoColor=white)

---

## 🚀 Features

-   **Interactive Dashboard:** Real-time visualization of spending patterns using JavaFX PieCharts.
-   **Transaction Management:** Full CRUD (Create, Read, Update, Delete) operations for Expenses and Income.
-   **Loan & EMI Tracker:** Dedicated module to monitor outstanding loans and calculate monthly commitments.
-   **Data Persistence:** Currently uses **GSON** for JSON-based local storage (Migrating to **Hibernate/MySQL** soon).
-   **Modern UI/UX:** Clean, dark-themed interface with CSS styling and responsive layouts.

---

## 🛠️ Tech Stack

-   **Language:** Java 21
-   **Build Tool:** Maven
-   **Framework:** JavaFX (MVC Architecture)
-   **Library:** Google GSON (JSON Parsing)
-   **Styling:** Custom CSS (JavaFX Modena override)

---

## 📂 Project Structure

```text
src/main/
├── java/com/finance/
│   ├── model/          # Data Entities (Expense, Income, Loan)
│   ├── controller/     # UI Logic & Event Handling
│   ├── service/        # Data handling (JSON I/O)
│   └── MainApp.java    # Application Entry Point
└── resources/
    ├── fxml/           # UI Layout files
    └── css/            # Modern UI Styling

---
##⚙️ **Installation & Setup**
Clone the repository

Bash
git clone [https://github.com/Tanmay2109/Finance_Tracker.git](https://github.com/Tanmay2109/Finance_Tracker.git)
cd Finance_Tracker
Build the project
Make sure you have Maven installed, or use the wrapper:

Bash
mvn clean install
Run the application

Bash
mvn javafx:run


---
##👤 **Author**
Tanmay Patil

GitHub: @Tanmay2109

Email: tanmaypatil2109@gmail.com
