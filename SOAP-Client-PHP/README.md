# PHP Client for Library SOAP Service

This is a simple web-based client built with native PHP to connect to and consume the Library SOAP Web Service. It uses PHP's built-in `SoapClient` class and provides a basic HTML interface to interact with the service.

## Features

* A single-page interface (`index.php`) for all operations.
* Forms to add, update, search, and delete books.
* Functionality to list all books or search by author.
* A custom `BibliothequeClient.php` class to encapsulate the SOAP calls.

## Technologies Used

* **PHP** (7.4 or higher recommended)
* PHP's built-in **SoapClient** extension
* **Composer** for autoloading (though no external packages are used)
* Basic HTML and CSS for the user interface

## Prerequisites

1.  **PHP** installed on your system.
2.  The **PHP SOAP extension** must be enabled in your `php.ini` file. (Look for `extension=soap` and uncomment it).
3.  **Composer** installed globally.
4.  The **SOAP-Server** project must be running so the WSDL is accessible.

## How to Run the Application

1.  **Start the SOAP Server**: Make sure your `SOAP-Server` application is running first.

2.  **Install Dependencies**: Open a terminal in the `SOAP-Client-PHP` directory and run Composer. This will generate the `vendor` directory and autoloader.
    ```bash
    composer install
    ```

3.  **Start the PHP Built-in Web Server**: This is the easiest way to run the client. From the `SOAP-Client-PHP` directory, run:
    ```bash
    php -S localhost:8000
    ```

4.  **Access the Application**: Open your web browser and navigate to:
    ```
    http://localhost:8000
    ```
    You should now see the web interface for managing the library.