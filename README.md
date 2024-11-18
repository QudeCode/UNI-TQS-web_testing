# Automated Testing Framework - Chollometro

This project is an **automated testing framework** developed for the *TQS (Test i Qualitat Software)* course at the **Universitat Autònoma de Barcelona (UAB)**. The framework validates functionalities of the **Chollometro** website using **Cucumber** and **Selenium WebDriver**.  

---

## Features Tested

### **1. Common Steps**
Shared steps used across different scenarios, including:
- Navigating to the index page.
- Accepting cookies.
- Logging in and checking session status.

### **2. Edit Profile**
- **Edit Profile**: Completed with minor bugs.
  - Scenarios for changing and canceling updates to the profile description.

### **3. Filter Chollos**
- **Filter Functionality**: Pre-merge stage.
  - Scenarios for filtering views (text, list) and hiding sold-out products.

### **4. Get Coupon**
- **Coupon Stores**: Scenarios for applying and validating coupon-related features.

### **5. Save Chollo**
- **Save Chollo Functionality**: Merged manually (contributions by Eric).

### **6. Search Chollo**
- **Search Functionality**: Validates search results and user interactions with Chollos.

---

## Project Structure

### **1. Features**
- Feature files are located in `src/test/java/features/`. 
- Each `.feature` file defines specific scenarios written in Gherkin.

### **2. Step Definitions**
- **CommonSteps.java**: Shared utilities like login, navigation, and cookie acceptance.
- **LoginSteps.java**: Authentication workflows including login, logout, and forgot password.
- **EditProfile.java**: Steps for testing profile-related functionalities.
- **FilterChollos.java**: Steps for validating filtering options on products.
- **GetCouponSteps.java**: Steps for testing coupon-related functionalities.
- **SaveChollo.java**: Steps for saving Chollos.
- **SearchCholloSteps.java**: Steps for validating search functionality.

### **3. Test Runner**
- Defined in `RunTests.java`:
  - Configures test execution with Cucumber and TestNG integration.
  - Handles WebDriver setup and teardown.

---

## Setup

### **Prerequisites**
- **Java 11 or higher** installed.
- **Maven** for dependency management.
- **Google Chrome** and compatible **ChromeDriver** installed.

### **Dependencies**
Managed through Maven, including:
- **Cucumber**: For Behavior-Driven Development (BDD) testing.
- **Selenium WebDriver**: For browser automation.
- **TestNG**: For test orchestration and reporting.

### **Configuration**
1. Update the `chromedriver.exe` path in `RunTests.java`:
   ```java
   System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
2.	Ensure the Chollometro URL (https://www.chollometro.com) is accessible.

## Running Tests

### Maven Command
Run all tests in the framework:
mvn test

### TestNG
- Open `RunTests.java`.
- Right-click and select **Run as TestNG Test**.

---

## Debugging Tips

- Verify browser compatibility: Ensure the `chromedriver` version matches the installed version of Chrome.
- Use **WebDriverWait** for dynamic elements that load asynchronously.
- Check console logs for stack traces and debug information.

---

## Project Status

- Developed for academic purposes under the *TQS (Test i Qualitat Software)* course at **UAB**.
- **Edit Profile** functionality: Completed but contains minor bugs.
- **Filter Chollos**: Pre-merge stage.
- This project is **not maintained** post-course completion.

---

## Contributors
- **Raúl Quirós, Eric Cruz**
- **University**: Universitat Autònoma de Barcelona (UAB)  
- **Course**: TQS - Test i Qualitat Software  
