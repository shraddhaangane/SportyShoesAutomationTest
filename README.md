# SportyShoes Automation Test Suite

A Selenium + TestNG automation framework for validating the Sporty Shoes web application.  
This project uses Java, Maven, and the Page Object Model (POM) to create a scalable and maintainable UI test suite.

---

## 🚀 Project Overview

This repository contains automated UI tests for the Sporty Shoes application.  
The suite covers:

- Admin login
- Product category management
- User management
- Purchase reporting
- Navigation and UI validation

The framework follows the Page Object Model to keep test logic clean and reusable.

---

## 🧱 Tech Stack

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **HTML TestNG Reports**

---

## 📁 Project Structure

```
SportyShoesAutomationTest/
│
├── src/
│   └── com/sportyshoes/
│       ├── pages/          # Page Object classes
│       ├── tests/          # Test classes
│       └── utils/          # Utility classes (if any)
│
├── testNG.xml              # Test suite configuration
├── pom.xml                 # Maven dependencies
└── test-output/            # TestNG HTML reports (generated after execution)
```

---

## ⚙️ Setup Instructions

### 1. Prerequisites
Install the following:

- Java 8+
- Maven 3.x
- Chrome browser
- ChromeDriver (matching your Chrome version)

### 2. Clone the Repository
```bash
git clone https://github.com/shraddhaangane/SportyShoesAutomationTest.git
cd SportyShoesAutomationTest
```

### 3. Install Dependencies
```bash
mvn clean install
```

---

## ▶️ Running the Tests

### Run the full suite:
```bash
mvn test
```

Or run via TestNG:
```bash
testng testNG.xml
```

---

## 📊 Test Reports

After execution, open:

```
test-output/index.html
```

This includes:

- Passed/Failed test summary
- Execution logs
- Failure stack traces

---

## 🧩 Extending the Framework

To add new tests:

1. Create a new Page Object under `src/com/sportyshoes/pages/`
2. Add a test class under `src/com/sportyshoes/tests/`
3. Update `testNG.xml` to include the new test

The POM structure ensures clean separation of concerns.

---

## 🤝 Contribution

Contributions are welcome.  
Fork the repo, create a branch, and submit a pull request.

---

## 📬 Contact

For questions or suggestions, open an issue in the repository.

