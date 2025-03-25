# Spring Security Application
This is a Spring Boot application showcasing how to configure custom security settings with Spring Security, including custom user authentication and login functionality. The project uses a custom UserDetailsService for user authentication.

Project Structure
SpringSecurityApplication: The main entry point of the Spring Boot application.
SecurityConfig: A configuration class responsible for customizing Spring Security, including authentication, authorization, session management, and login configuration with custom filterchain.
MyUserDetailsService: A custom implementation of UserDetailsService to load user-specific details during authentication.
UserPrincipal: A model that implements UserDetails to represent authenticated user data.
Users: The model class representing a user in the database.
UserRepo: A repository interface extending JpaRepository to handle database operations for the Users entity.

Features
Custom Security Configuration: Spring Security is configured with a custom UserDetailsService and authentication provider.
Login and Registration: Provides custom login and registration endpoints.
Basic Authentication: Basic authentication is enabled for API access (useful for Postman).
Session Management: Configured to use sessions when required (SessionCreationPolicy.IF_REQUIRED).
Password Encoding: Passwords are securely encoded using BCryptPasswordEncoder.
User Details Service: Implements a custom service (MyUserDetailsService) to load users from the database during authentication.

Dependencies
Spring Boot 2.x
Spring Security
Spring Data JPA (for handling users and authentication data)

Security Configuration
The SecurityConfig class defines the security rules:
CSRF Protection: Disabled.
Custom Login Page: /login is set as the custom login page, and a successful login redirects to /.
Session Management: Configured to create a session only if required.
Public URLs: /register, /login, and /logout are publicly accessible.
Basic Authentication: Enabled for non-browser clients (e.g., Postman or APIs).
Password Encoding: Uses BCryptPasswordEncoder for secure password storage.