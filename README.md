To give you an industry-standard, high-end README in a single copy-paste block, I have used a mix of GitHub-flavored Markdown and HTML alignment tags. This ensures that icons are centered, tables are clean, and code blocks are properly separated.

Copy the entire block below into your README.md file:
Markdown
<p align="center">
  <img src="https://capsule-render.vercel.app/render?type=soft&color=auto&height=200&section=header&text=FinanceFlow%20Pro&fontSize=70" width="100%" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />
  <img src="https://img.shields.io/badge/JavaFX-43BF4D?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Persistence-GSON-blue?style=for-the-badge" />
</p>

---

## 🎯 Project Overview
**FinanceFlow** is a professional-grade desktop application built to simplify personal wealth management. It allows users to track daily expenses, monitor diverse income streams, and calculate loan EMIs through a clean, intuitive interface.

The project follows the **MVC (Model-View-Controller)** design pattern, ensuring that business logic, data models, and UI layouts remain decoupled for high maintainability.

---

## ✨ Core Features

| Feature | Description | Status |
| :--- | :--- | :--- |
| **📊 Analytics Dashboard** | Real-time spending visualization with dynamic JavaFX PieCharts. | `COMPLETED` |
| **💸 Transaction Engine** | Categorized logging for Income and Expenses with GSON serialization. | `COMPLETED` |
| **🏦 EMI Calculator** | Automated logic for Principal, Interest, and Tenure-based loan tracking. | `COMPLETED` |
| **🔍 Smart Filtering** | Search and sort transactions by date, category, or amount. | `COMPLETED` |
| **🗄️ Database Migration** | Transitioning from JSON files to **Hibernate 6 & MySQL**. | `IN PROGRESS` |

---

## 🏗️ System Architecture & Logic

### **📁 Directory Structure**
```text
src/main/java/com/finance/
├── MainApp.java        # Entry point for the JavaFX Application
├── model/              # POJOs: Expense.java, Income.java, Loan.java
├── controller/         # UI logic for Dashboard & Transactions
├── service/            # DataService (JSON I/O) & EMI Logic
└── resources/
    ├── fxml/           # Modern UI Layouts (Main, Dashboard, etc.)
    └── css/            # Professional Styling (Dark/Light mode)

🛠️ Installation & Setup
1. Prerequisites
JDK 21 or higher.

Maven 3.8+ (Ensure mvn is in your environment PATH).

Git (For version control).

2. Setup Steps
Bash
# Clone the project repository
git clone https://github.com/Tanmay2109/Finance_Tracker.git

# Enter project directory
cd Finance_Tracker

# Build and install dependencies
mvn clean install

🚀 Running the Application
Option A: Terminal (Universal)
mvn javafx:run

Option B: IntelliJ IDEA
Open the Maven sidebar (Right side).

Expand Finance_Tracker > Plugins > javafx.

Right-click javafx:run and select Run.

👤 Contact
Tanmay Patil 📧 tanmaypatil2109@gmail.com

Created with ❤️ by Tanmay Patil
