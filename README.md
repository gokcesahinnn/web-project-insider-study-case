# Java Selenium With TestNG Cucumber Test Automation Project

This project is a base project for Java-Selenium-Cucumber Test Automation Projects.

It includes processes such as parallel execution and rerunning failed test cases. Allure Report is used for reporting.
# Tool stack

* **Java/Javascript** - Development Language
* **IntelliJ IDE** - Development IDE
* **Maven** - Package Management
* **Cucumber** - Gherkin Syntax Framework
* **Selenium** - Web APP Test Automation Tool
* **TestNG** - Web App Test Automation Tool and Testing Framework


# Project tree

```
.
|-- src
|   |-- test
|   |   |-- java
|   |   |   |   |-- config
|   |   |   |   |   |-- BaseConfig
|   |   |   |   |-- pages
|   |   |   |   |   |-- BasePage
|   |   |   |   |   |-- CareerPage
|   |   |   |   |   |-- HomePage
|   |   |   |   |   |-- LeverPage
|   |   |   |   |   |-- OpenPositionsPage
|   |   |   |   |   |-- QualityAssurancePage
|   |   |   |   |-- runners
|   |   |   |   |   |-- Runner
|   |   |   |   |-- stepDefinitions
|   |   |   |   |   |-- BaseSteps
|   |   |   |   |   |-- CareerSteps
|   |   |   |   |   |-- HomeSteps
|   |   |   |   |   |-- Hooks
|   |   |   |   |   |-- LeverSteps
|   |   |   |   |   |-- OpenPositionsSteps
|   |   |   |   |   |-- QualityAssuranceSteps
|   |   |   |   |-- utils
|   |   |   |   |   |-- driver
|   |   |   |   |   |   |-- browserManager
|   |   |   |   |   |   |   |-- BrowserManager
|   |   |   |   |   |   |-- driverManager
|   |   |   |   |   |   |   |-- Driver
|   |   |   |   |   |-- ApiUtils
|   |   |   |   |   |-- DataGenerator
|   |   |   |   |   |-- PageHelper
|   |   |   |   |   |-- ResourceFileReader
|   |   |-- resources
|   |   |   |-- features
|   |   |   |   |-- qaJob.feature
|   |   |   |-- validations
|   |   |   |   |-- validations.json
|-- git.ignore
|-- pom.xml
|-- testng.xml
|-- README.md
```

# Generate Cucumber Report

### Maven Run

```
mvn clean test
```

### Maven Run With Runner Name And Parameter

```
mvn clean test -Dtest=Runner -D"cucumber.filter.tags=@smoke" -Dheadless=true -DthreadCount=5
```

### Maven Run With Parameter

```
mvn clean test -D"cucumber.filter.tags=@smoke" -Dheadless=true -DthreadCount=5
```

### Cucumber Tag Run

Example for `@register` tag:
```
mvn clean test -D"cucumber.filter.tags=@register"
```

### Generate Allure Report
```
allure serve allure-results 
```

### Selenium Grid Integration
* Selenium grid is downloaded from => [Selenium Grid Download](https://www.selenium.dev/downloads/)
* Installations are completed
* getRemoteServerUrl in Baseconfig is replaced with your own URL.