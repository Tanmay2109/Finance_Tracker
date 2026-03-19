# 💹 FinanceFlow: Desktop Wealth Manager
> **A high-performance JavaFX application for modern financial tracking.**

---

## 📖 Table of Contents
* [Overview](#-overview)
* [Core Features](#-core-features)
* [System Architecture](#-system-architecture)
* [Prerequisites](#-prerequisites)
* [Installation & Setup](#-installation--setup)
* [Running the Application](#-running-the-application)
* [Roadmap](#-roadmap)
* [Contact](#-contact)

---

## 🎯 Overview
**FinanceFlow** is a comprehensive personal finance tool designed to manage daily expenses, income streams, and long-term liabilities (Loans/EMIs). It leverages a clean **Model-View-Controller (MVC)** architecture to ensure data integrity and a responsive user experience.

---

## ✨ Core Features

| Feature | Description | Status |
| :--- | :--- | :--- |
| **Interactive Dashboard** | Real-time visual breakdown of spending using **JavaFX PieCharts**. | ✅ Done |
| **Transaction Engine** | Categorized logging for Income and Expenses with GSON serialization. | ✅ Done |
| **Loan & EMI Tracker** | Automated EMI calculation based on principal, interest, and tenure. | ✅ Done |
| **Search & Filter** | Integrated functionality to filter transaction history by date/category. | ✅ Done |
| **Database Sync** | Migration from JSON to **Hibernate 6 / MySQL** persistence. | 🛠️ In Progress |

---

## 🏗️ System Architecture
The application is built using a **Layered Design Pattern** to ensure high maintainability:

* **UI Layer:** FXML files styled with custom CSS for a modern "Dark Mode" aesthetic.
* **Logic Layer:** Java Controllers handling event-driven user actions and data binding.
* **Service Layer:** Business logic for financial math and data validation.
* **Persistence Layer:** Repository pattern utilizing **GSON** for flat-file JSON storage.

## 📁 Directory Structure

```text
src/main/
├── java/com/finance/
│   ├── model/          # Data Entities (Expense, Income, Loan)
│   ├── controller/     # UI Logic & Event Handling
│   ├── service/        # Data handling & Business Logic
│   └── MainApp.java    # Application Entry Point
└── resources/
    ├── fxml/           # SceneBuilder Layout files
    └── css/            # Professional UI Styling
🛠️ Prerequisites
Java Development Kit (JDK) 21 or higher.

Apache Maven 3.8+ (Environment Variable mvn should be configured).

Git installed for version control.

IntelliJ IDEA (Recommended IDE).

⚙️ Installation & Setup
Clone the Repository
Open your terminal/command prompt and run:

Bash
git clone https://github.com/Tanmay2109/Finance_Tracker.git
cd Finance_Tracker
Maven Build
Compile the project and download dependencies:

Bash
mvn clean install
Setup in IntelliJ IDEA

Open IntelliJ and go to File > Open.

Select the Finance_Tracker folder.

If prompted, click "Load Maven Project".

Ensure Project SDK is set to Java 21 (File > Project Structure > Project).

🚀 Running the Application
Via Command Line:

Bash
mvn javafx:run
Via IntelliJ IDEA:

Open the Maven tool window (Right-hand sidebar).

Navigate to finance-tracker > Plugins > javafx.

Double-click javafx:run.
