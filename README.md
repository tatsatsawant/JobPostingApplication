# Job Posting Application

## Overview

The Job Posting Application is a Spring Boot project designed to manage and search for job posts. It provides a RESTful API for posting jobs, searching for jobs, and handling user authentication.

## Features

- **Job Posting:** Create and manage job posts with details such as position, description, experience, and required skills.
- **Job Search:** Implement a custom search mechanism that searches for jobs based on skills, description, and position.
- **User Authentication:** Basic user authentication with roles (HR and READER).

## Technologies Used

- Java
- Spring Boot
- Spring Security
- MongoDB
- Lombok

## Project Structure

The project is structured into several packages:

- `model`: Contains entity classes such as `PostModel` and `UserRole`.
- `repository`: Defines Spring Data MongoDB repositories and a custom search repository.
- `exception`: Houses custom exception classes and handlers.
- `security`: Configures Spring Security for user authentication and authorization.
- `controller`: Handles HTTP requests and responses.
- `service`: Implements business logic and interacts with repositories.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/JobPostingApplication.git
