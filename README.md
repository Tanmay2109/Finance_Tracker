💹 FinanceFlow: Desktop Wealth Manager
A high-performance JavaFX application for modern financial tracking.

📖 Table of Contents
Overview

Core Features

System Architecture

Installation & Setup

Project Roadmap

Contact

🎯 Overview
FinanceFlow is a comprehensive personal finance tool designed to manage daily expenses, income streams, and long-term liabilities (Loans/EMIs). It leverages a clean Model-View-Controller (MVC) architecture to ensure data integrity and a responsive user experience.

✨ Core Features
<details>
<summary><b>📈 Interactive Dashboard</b> (Click to expand)</summary>
<ul>
<li>Real-time visual breakdown of spending using <b>JavaFX PieCharts</b>.</li>
<li>Dynamic calculation of <b>Net Balance</b> and <b>Savings Ratio</b>.</li>
</ul>
</details>

<details>
<summary><b>💸 Transaction Engine</b> (Click to expand)</summary>
<ul>
<li>Categorized logging for Income and Expenses.</li>
<li>Custom <b>LocalDateAdapter</b> for seamless JSON serialization.</li>
<li>Integrated search and filter functionality for transaction history.</li>
</ul>
</details>

<details>
<summary><b>🏦 Loan & EMI Tracker</b> (Click to expand)</summary>
<ul>
<li>Automated EMI calculation based on principal, interest, and tenure.</li>
<li>Visual progress tracking for debt repayment.</li>
</ul>
</details>

🏗️ System Architecture
The application is built using a Layered Design Pattern:

UI Layer: FXML files styled with modern CSS (Dark/Light mode support).

Logic Layer: Java Controllers handling event-driven user actions.

Persistence Layer: A Repository pattern currently using GSON for flat-file JSON storage (Transitioning to Hibernate/MySQL in Phase 2).

Plaintext
src/main/
├── java/com/finance/
│   ├── model/          # Data Entities & POJOs
│   ├── controller/     # JavaFX UI Logic
│   └── service/        # Business logic & JSON I/O
└── resources/
    ├── fxml/           # SceneBuilder Layouts
    └── css/            # Modern UI Styling
⚙️ Installation & Setup
Prerequisites
JDK 21 or higher.

Maven 3.8+ installed (or use the included Wrapper).

Execution
PowerShell
# 1. Clone the repository
git clone https://github.com/Tanmay2109/Finance_Tracker.git

# 2. Build the project
mvn clean install

# 3. Run the application
mvn javafx:run
🛤️ Roadmap
[x] Phase 1: Core UI & JSON Persistence.

[ ] Phase 2: Database Integration via Hibernate 6.

[ ] Phase 3: PDF Export for Monthly Financial Statements.

[ ] Phase 4: Cloud Sync & User Authentication.

👤 Contact
Tanmay Patil 📧 tanmaypatil2109@gmail.com

🔗 GitHub Profile
