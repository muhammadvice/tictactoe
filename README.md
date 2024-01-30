# Tic Tac Toe Game with Spring Boot and Thymeleaf

This is a simple implementation of the Tic Tac Toe game using Spring Boot for the backend and Thymeleaf for the frontend.

## Features

- Dynamic and customizable board size (minimum 3x3).
- Ability to play Tic Tac Toe with non-symmetric board sizes.
- Reset functionality to start a new game.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed on your local machine.
- Maven build tool installed.
- Any modern web browser installed.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine:
   ```sh
   git clone https://github.com/your_username/tic-tac-toe-spring-boot.git

   cd tic-tac-toe-spring-boot
   
   mvn clean install -DskipTests

   mvn spring-boot:run

Open your web browser and navigate to http://localhost:8080 to play the Tic Tac Toe game.

Usage
Upon visiting the application, you will be greeted with a welcome page where you can input the board size and start the game.
Once the game starts, you can click on the cells to make your move.
The game will continue until one player wins or the game ends in a draw.
You can reset the game at any time to start a new game.