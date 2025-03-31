# Blackfy-RestAssured_SkillDemo

## Overview
"Blackfy-RestAssured_SkillDemo" is a project developed to demonstrate strong skills in backend automation using Java, REST API testing, RestAssured, BDD, Cucumber, Gherkin, and CI/CD integration. The project emphasizes efficient testing practices and readable specifications for RESTful APIs.

## Features
- Built using **RestAssured**, **Gherkin**, and **JUnit5** for API test automation and behavior-driven development.
- Integrated with **Maven Wrapper** for simplified dependency and build management.
- CI/CD integration with **GitHub Actions** for automated testing on every change.
- Automatically generates detailed test reports using **Cucumber Reports**.

## Prerequisites
Make sure the following tools and libraries are installed before using the project:
- [Amazon Corretto JDK 17.0.14](https://aws.amazon.com/corretto/)
- [Maven](https://maven.apache.org/install.html) *(optional if using Maven Wrapper)*
- [Git](https://git-scm.com/downloads)
- RestAssured, Cucumber, Cucumber-reporting, and JUnit5 (managed via Maven dependencies)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/DiegoPatcheco/Blackfy-RestAssured_SkillDemo.git
   ```
2. Navigate into the project directory:
   ```sh
   cd Blackfy-RestAssured_SkillDemo
   ```
3. Build the project using Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```

## Running Tests
To run the test suite:
```sh
./mvnw clean test
```

You can also run a predefined suite using the following script:
```sh
./runSuite.sh
```

## Cucumber Report
- The **Cucumber Report** is automatically generated after executing the tests.
- To open the report locally:
  ```sh
  ./openReport.sh
  ```

## CI/CD Integration
- This project is integrated with **GitHub Actions**, automatically running tests on every push or pull request.
- The Cucumber report and test results are uploaded as CI artifacts and are available in the GitHub Actions tab.

## Contributing
Contributions are always welcome! To contribute:
1. Fork the repository.
2. Create a new branch with your feature or fix.
3. Commit and push your changes.
4. Open a pull request.

## Author
Developed by [Diego Patcheco](https://github.com/DiegoPatcheco).
