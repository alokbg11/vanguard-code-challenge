# vanguard-code-challenge
Introduction to Design and Implementation:
The Trade Reporting Engine is a Java Spring Boot application that reads XML event files, extracts relevant elements, stores them in a H2 database using JPA, filters events based on criteria provided, and returns the filtered events in JSON format. The application aims to provide a scalable and maintainable solution for processing and reporting trade events.

Instructions to Execute:
Clone the project from the repository mentioned below.
Place the event XML files to your desired folder location and get the path to the folder.
Update ‘events.directory.path’ property in ‘application.properties’ file.
Build and run the Spring Boot application using gradle commands like: gradle build, gradle boot run.
Use the API endpoint (/reports) to trigger event processing and filtering.

Source Code Repository:
https://github.com/alokbg11/vanguard-code-challenge/tree/main

Design Patterns and Class Structure:
The application follows the MVC design pattern, separating concerns into different layers:
Model: JPA entities for storing trade event data.
Repository: JPA repositories for database interactions.
Service: Business logic for event processing, filtering, and reporting.
Controller: API endpoints for triggering event processing and returning filtered events.

Testing Approach:
The application follows Test-Driven Development (TDD) principles, ensuring test coverage for critical components. Unit tests are written using JUnit and Mockito for services and controllers. Integration tests can be added to validate the interaction between components and the database.

Third-Party Libraries:
The application uses Spring Boot for its core framework, Spring Data JPA for database interactions. Mockito and JUnit are used for testing.

OOP Skill and Assumptions:
The codebase demonstrates good Object-Oriented Programming (OOP) practices by encapsulating logic within classes, promoting reusability, and maintaining separation of concerns. Assumptions include having the XML event files available, utilizing the specified XML elements for filtering, and adhering to the given filter criteria.

Trade-Offs:
Scalability: The application design takes scalability into account by using Spring Boot, which can easily be scaled horizontally.
Maintainability: A modular design with clear separation of concerns enhances maintainability. However, specific considerations like versioning, error handling, and database optimizations might require further attention.

Future Enhancements:
To extend or modify the filtering criteria, new conditions can be added to the service layer without affecting existing filters. Additionally, API versioning and more advanced error handling could be implemented for improved user experience.
