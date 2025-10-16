# SOAP Webservice and Clients for a Library

This repository contains a SOAP web service for a library management system, along with several client applications built in different technologies to demonstrate its functionality.

## Repository Structure

This is a multi-project repository. Each folder contains a standalone application with its own specific `README.md` for setup and execution instructions.

* `SOAP-Server/`: The core web service built with **Java and JAX-WS**. This must be running for any of the clients to work.
* `SOAP-Client-Java/`: A simple **Java console client** to test the service.
* `SOAP-Client-JSP/`: A **web application client** built with JavaServer Pages (JSP) and Servlets.
* `SOAP-Client-PHP/`: A **PHP web client** that consumes the SOAP service.

## Getting Started

1.  **Start the Server**: First, navigate into the `SOAP-Server` directory, follow its `README.md` instructions, and run the server.
2.  **Run a Client**: Once the server is running, choose any client folder (`SOAP-Client-Java`, `SOAP-Client-JSP`, `SOAP-Client-PHP`), go inside, and follow the instructions in its specific `README.md` file to run it.