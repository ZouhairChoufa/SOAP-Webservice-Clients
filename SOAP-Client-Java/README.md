# Java SOAP Client for Library Service

This is a console-based Java client designed to connect to and consume the Library SOAP Web Service. It demonstrates how to perform all the CRUD (Create, Read, Update, Delete) operations offered by the server.

## Features Demonstrated

* Listing all available books.
* Adding a new book.
* Searching for a book by its ISBN.
* Updating the details of an existing book.
* Deleting a book from the library.

## Technologies Used

* **Java 8**
* **JAX-WS**: Used for generating the client stubs and communicating with the SOAP service.
* **Maven**: Manages dependencies and automates the build process, including the generation of JAX-WS client code from the WSDL.

## Prerequisites

1.  Java Development Kit (JDK) 8 or higher.
2.  Apache Maven.
3.  **Crucially, the `SOAP-Server` project must be running** so that the WSDL is available at `http://localhost:1510/ws/Bibliotheque?wsdl`.

## How to Run the Client

1.  **Start the SOAP Server**: Make sure your `SOAP-Server` application is running first.

2.  **Navigate to this client's directory**:
    ```bash
    cd SOAP-Client-Java 
    ```

3.  **Build the project with Maven**: This command will also automatically generate the necessary JAX-WS client classes from the server's WSDL.
    ```bash
    mvn clean install
    ```

4.  **Run the application**: You can run the `main` method in the `com.example.client.ClientBibliotheque` class directly from your IDE (like IntelliJ IDEA) or via the command line. The output will show the results of each operation performed against the web service.