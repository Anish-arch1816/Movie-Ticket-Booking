# Movie Ticket Booking System (Java)

## Project Overview

This is a simple **Movie Ticket Booking System** implemented in Java that allows users to:

- Select a movie from a predefined list.
- Select a cinema hall from a predefined list.
- View the seating arrangement of seats (5 rows x 5 columns).
- Book available seats by specifying the seat row and number.
- Cancel bookings with seat and user information.
- View all current bookings along with the selected movie, cinema hall, and total earnings.
- See the price per seat displayed in the seating arrangement.

The system uses arrays to represent the seating arrangement and a linked list to store booking records dynamically.

---

## Features

- Console-based menu-driven interface for ease of interaction.
- Dynamic handling of bookings using a singly linked list.
- Input validation for movie/hall selection and seat booking.
- Display of seat price and calculation of total earnings.
- Reset seat availability and bookings on movie or cinema hall change.

---

## Technologies and Concepts Used

- **Java** (Core language features)
- **Arrays:** 2D array to represent seats (available/booked)
- **Linked List:** Custom singly linked list for booking records
- **Object-Oriented Programming:** `Booking` class with fields and linked list pointers
- **Input Handling:** Scanner class for reading user input
- **Control Structures:** loops, conditionals, switch-case statements
- **String Manipulation:** For movie & cinema hall names and booking details
- **Constants and Variables:** For keeping seat price and matrix size

---

## How to Use

1. **Clone the repository:**
2. **Compile the code:**
Navigate to the project directory and compile the Java file:
3. **Run the program:**
4. **Interact with the menu:**

- Start by selecting option `0` to pick a movie and a cinema hall.
- Use the other options to book seats, cancel bookings, or view seating and booking details.
- Exit the program by selecting option `5`.

---

## Code Structure

- **Booking.java** (inner class in the main file)
- Represents each booking node in the linked list.

- **MovieTicketBooking.java**
- The main class containing:
 - Arrays for movies and cinema halls.
 - 2D seats array representing seat availability.
 - Linked list head reference.
 - Methods for all operations (select movie/hall, book seat, cancel booking, show seats/bookings).
 - Main loop for user interaction.

---

## Sample Menu
=== Movie Ticket Booking System ===
0. Select Movie and Cinema Hall
1.Show Seats
2.Book Ticket
3.Cancel Booking
4.Show Bookings
5.Exit
 Enter choice:
---

## Sample Output Snapshot
Select a movie (1-5): 2
Selected movie: Inception

Select a cinema hall (1-5): 3
Selected cinema hall: Galaxy Cineplex

Seating Arrangement (0 = Available, 1 = Booked)
Price per seat: $100
1 2 3 4 5
A 0 0 0 0 0
B 0 0 1 0 0
C 0 0 0 0 0
D 0 0 0 0 0
E 0 0 0 0 0

Current Bookings:
John - B3
Total Earnings: $100

---

## Contributions

Contributions, suggestions, and improvements are welcome! Feel free to open issues or submit pull requests.

---

## License

This project is open-source and free to use under the Mozilla Public License 2.0.

---

## Author

[ANISH KUNDU]  
[https://github.com/Anish-arch1816/]






