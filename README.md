Java CLI Ticket Handling System
Overview

This project implements a Ticket Handling System using a Java Command-Line Interface (CLI). The system demonstrates the producer-consumer pattern with multithreading and synchronization. It is designed for educational purposes to showcase core Java concepts like thread management, locks, synchronized blocks, and real-time monitoring.
Features

    System Configuration: Set parameters for the ticket system, such as:
        Total tickets (totalTickets)
        Ticket release rate (ticketReleaseRate)
        Customer retrieval rate (customerRetrievalRate)
        Maximum ticket capacity (maxTicketCapacity)
    Input Validation: Ensures all user inputs are valid; re-prompts for invalid entries.
    Start and Stop Commands: Start and stop the ticket handling process via CLI commands.
    Real-Time Monitoring: Displays the current status of tickets (added/removed) and logs transactions in real time.
    Producer-Consumer Pattern: Implements the producer-consumer model using Java multithreading and synchronization techniques.
    Execution and Logging: Logs all ticket transactions and configuration settings for later review.

Getting Started
Prerequisites

    Java Development Kit (JDK) 8 or later
    A text editor or IDE to run the program (e.g., IntelliJ IDEA, Eclipse, or VS Code)
    Terminal or command prompt access

Installation

    Clone this repository:

git clone <repository-url>

Navigate to the project directory:

cd <project-directory>

Compile the Java files:

    javac Main.java

Running the Program

Run the program using the following command:

java Main

How to Use

    Configure System Parameters:
        When prompted, provide the following settings:
            totalTickets: Total number of tickets to be handled.
            ticketReleaseRate: Rate at which tickets are added to the system.
            customerRetrievalRate: Rate at which customers retrieve tickets.
            maxTicketCapacity: Maximum number of tickets the system can hold at a time.
        The program validates each input and re-prompts for invalid entries.

    Control Commands:
        start: Begins the ticket handling process.
        stop: Stops the process gracefully.

    Real-Time Monitoring:
        The program displays real-time ticket status in the CLI and logs each transaction.

Implementation Details

    Producer-Consumer Pattern:
        The producer thread releases tickets at the specified ticketReleaseRate.
        The consumer thread retrieves tickets at the specified customerRetrievalRate.
        Synchronization is achieved using synchronized blocks and Java Lock mechanisms to manage concurrent access to shared resources.

    Logging:
        Configuration settings and ticket transactions are logged in real time to the CLI for transparency and debugging.
