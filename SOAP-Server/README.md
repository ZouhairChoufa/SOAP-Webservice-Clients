# SOAP Web Service for a Library (Bibliothèque)

This project is a simple SOAP web service built with Java and JAX-WS that manages a collection of books. It provides endpoints to perform CRUD (Create, Read, Update, Delete) operations on a library's book inventory.

## Features

* **Add a Book**: Add a new book to the collection.
* **Get a Book by ISBN**: Retrieve book details using its unique ISBN.
* **Get All Books**: List all books in the library.
* **Update a Book**: Modify the details of an existing book.
* **Delete a Book**: Remove a book from the collection by its ISBN.
* **Search by Author**: Find all books written by a specific author.

## Technologies Used

* **Java 8**
* **JAX-WS**: Java API for XML Web Services for creating the SOAP service.
* **Maven**: For project dependency management and build automation.

## Prerequisites

Before you begin, ensure you have the following installed:
* Java Development Kit (JDK) 8 or higher.
* Apache Maven.

## How to Run the Server

1.  **Clone the repository:**
    ```bash
    git clone <your-repository-url>
    ```

2.  **Navigate to the project directory:**
    ```bash
    cd SOAP-Server
    ```

3.  **Compile and build the project using Maven:**
    ```bash
    mvn clean install
    ```

4.  **Run the SOAP Server:**
    You can run the `main` method in the `com.example.serveur.SoapServer` class directly from your IDE (like IntelliJ IDEA).

    Once running, you will see the following output in the console, indicating the server is active:
    ```
    Démarrage du serveur SOAP à http://localhost:1510/ws/Bibliotheque
    Service SOAP disponible à : http://localhost:1510/ws/Bibliotheque?wsdl
    Serveur SOAP en cours d'exécution...
    ```

## Web Service Endpoint

* **Endpoint URL**: `http://localhost:1510/ws/Bibliotheque`
* **WSDL URL**: `http://localhost:1510/ws/Bibliotheque?wsdl`

You can use the WSDL URL with a tool like SoapUI or by generating a client in Java, PHP, or another language to interact with the service.