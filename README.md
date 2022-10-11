
![alt text](https://github.com/fatjon1/protax/blob/master/Screenshot%202022-10-10%20at%2021-43-42%20Login.png)
# Protax

Protax is a webgis application for managing spatial data information like roads, buildings ec and generate invoices for local taxes.
The application is based on php for the backend, smarty template for the frontend and Postgresql database (+ PostGis).

Based on the existing database schema i created a new spring boot rest api.
This rest api exposes same endpoints where a authenticated user (or another app) can get the invoices and create payments.

![alt text](https://github.com/fatjon1/protax/blob/master/Screenshot%202022-10-10%20at%2020-50-00%20Swagger%20UI.png)

http://localhost:8081/swagger-ui.html#/

Spring Boot

Spring Data JPA

Spring Security

JWT Web Token

Swagger UI

Postgresql

This project is under development and instructions comming soon...

![alt text](https://github.com/fatjon1/protax/blob/master/Protax-ER-Diagram.png)




