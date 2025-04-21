# Elixir Crafter

Greetings, Young Wizard!

Elixir Crafter is a Java application that touches the Wizard World API to fetch and manage magical elixirs and their ingredients — all through a mystical command-line interface (CLI).

## Main Dependencies
- Java 17
- Maven
- Junit 5


## Architecture
```text
src/
├── main/java/elixircrafter/
│   ├── cli         - CLI for user interaction
│   ├── config      - Configuration for Wizard World API
│   ├── constants   - Shared application constants
│   ├── exception   - Custom exception classes
│   ├── service     - Elixir filtering logic
│   └── utils       - Helpers for parsing and prompts
└── test/java/elixircrafter/
    ├── service    
    └── utils         
```



## Basic Work flow
Upon startup, the application fetches all elixir data from the Wizard World API. Working with the elixir data fully loaded into memory was chosen intentionally to avoid unnecessary API requests each time the user inputs new ingredients — improving performance and user experience.
The typical workflow is as follows:
- The user is prompted to input the ingredients they have at their disposal.
- The input is processed (trimmed and converted to lowercase) to ensure consistency.
- An algorithm matches the provided ingredients against the ingredients required by each elixir.
- If any elixirs can be crafted with the given ingredients, they are displayed to the user.
- After each search, the user is asked whether they wish to attempt crafting another elixir or quit the application.

## Best Practices 💡

Even though Elixir Crafter is a pretty simple application, it was built with some design patterns in mind, such as:
- Swagger provided was used to generate the API contract and its models automatically.
- Dependency Injection to promote easier testing and flexibility. 
- Separation of concerns, each class has a single responsibility, leading to high cohesion and low coupling.
- Custom exceptions to handle specific error scenarios clearly.
- Logging for observability and debugging.
- Reusable constants to avoid duplication and improve maintainability.
- Unit testing to ensure functionality, with different test types: mocks, parametrized, etc.

## Run the project
```bash
    mvn clean install
    mvn exec:java -Dexec.mainClass=com.wizard.elixircrafter.App
```






    
   
