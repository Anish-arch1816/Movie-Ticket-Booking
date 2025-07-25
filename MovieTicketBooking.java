import java.util.Scanner;

class Booking {
    String userName;
    int row, col;
    Booking next;

    Booking(String userName, int row, int col) {
        this.userName = userName;
        this.row = row;
        this.col = col;
        this.next = null;
    }
}

public class MovieTicketBooking {
    static final int ROWS = 5, COLS = 5;
    static int[][] seats = new int[ROWS][COLS]; // 0 = available, 1 = booked
    static Booking head = null;
    static Scanner in = new Scanner(System.in);

    // Price per seat
    static final int SEAT_PRICE = 100;

    // Movies and Cinema Halls
    static String[] movies = {
        "1. The Shawshank Redemption",
        "2. Inception",
        "3. The Dark Knight",
        "4. Forrest Gump",
        "5. Interstellar"
    };

    static String[] halls = {
        "1. Grand Cinema Hall",
        "2. Regal Theater",
        "3. Galaxy Cineplex",
        "4. Platinum Screens",
        "5. Star Movies"
    };

    // Selected movie and hall indices
    static int selectedMovie = -1;
    static int selectedHall = -1;

    static void showMovies() {
        System.out.println("\nAvailable Movies:");
        for (String movie : movies) {
            System.out.println(movie);
        }
    }

    static void showHalls() {
        System.out.println("\nAvailable Cinema Halls:");
        for (String hall : halls) {
            System.out.println(hall);
        }
    }

    static void selectMovie() {
        showMovies();
        System.out.print("Select a movie (1-5): ");
        int choice = in.nextInt();
        if (choice < 1 || choice > 5) {
            System.out.println("Invalid movie selection.");
            selectedMovie = -1;
        } else {
            selectedMovie = choice - 1;
            System.out.println("Selected movie: " + movies[selectedMovie].substring(3));
        }
    }

    static void selectHall() {
        showHalls();
        System.out.print("Select a cinema hall (1-5): ");
        int choice = in.nextInt();
        if (choice < 1 || choice > 5) {
            System.out.println("Invalid cinema hall selection.");
            selectedHall = -1;
        } else {
            selectedHall = choice - 1;
            System.out.println("Selected cinema hall: " + halls[selectedHall].substring(3));
        }
    }

    static void showSeats() {
        if (!checkSelection()) return;
        System.out.println("\nSeating Arrangement (0 = Available, 1 = Booked)");
        System.out.println("Price per seat: $" + SEAT_PRICE);
        System.out.print("   ");
        for (int c = 0; c < COLS; c++) System.out.print((c + 1) + " ");
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print((char) ('A' + i) + "  ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bookSeat() {
        if (!checkSelection()) return;
        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.print("Enter row (A-E): ");
        char rowChar = in.next().toUpperCase().charAt(0);
        System.out.print("Enter seat number (1-5): ");
        int col = in.nextInt() - 1;
        int row = rowChar - 'A';
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat selection!");
            return;
        }
        if (seats[row][col] == 1) {
            System.out.println("Seat already booked!");
            return;
        }
        seats[row][col] = 1;
        Booking booking = new Booking(name, row, col);
        booking.next = head;
        head = booking;
        System.out.println("Seat successfully booked for " + name + " at " + rowChar + (col + 1) + ".");
    }

    static void cancelBooking() {
        if (!checkSelection()) return;
        System.out.print("Enter your name for cancellation: ");
        String name = in.next();
        System.out.print("Enter row (A-E): ");
        char rowChar = in.next().toUpperCase().charAt(0);
        System.out.print("Enter seat number (1-5): ");
        int col = in.nextInt() - 1;
        int row = rowChar - 'A';
        Booking curr = head, prev = null;
        while (curr != null) {
            if (curr.userName.equals(name) && curr.row == row && curr.col == col) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
                seats[row][col] = 0;
                System.out.println("Booking cancelled for " + name + " at " + rowChar + (col + 1) + ".");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("No booking found with the given details.");
    }

    static void showBookings() {
        if (!checkSelection()) return;
        System.out.println("\nSelected Movie: " + movies[selectedMovie].substring(3));
        System.out.println("Selected Cinema Hall: " + halls[selectedHall].substring(3));

        Booking curr = head;
        System.out.println("\nCurrent Bookings:");
        if (curr == null) {
            System.out.println("(None)");
            System.out.println("Total Earnings: $0");
            return;
        }

        int totalPrice = 0;
        while (curr != null) {
            System.out.println(curr.userName + " - " + (char) ('A' + curr.row) + (curr.col + 1));
            totalPrice += SEAT_PRICE;
            curr = curr.next;
        }
        System.out.println("Total Earnings: $" + totalPrice);
    }

    static boolean checkSelection() {
        if (selectedMovie == -1) {
            System.out.println("Please select a movie first.");
            return false;
        }
        if (selectedHall == -1) {
            System.out.println("Please select a cinema hall first.");
            return false;
        }
        return true;
    }

    static void resetBookings() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = 0;
            }
        }
        while (head != null) {
            Booking temp = head;
            head = head.next;
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Movie Ticket Booking System ===");
            System.out.println("0. Select Movie and Cinema Hall");
            System.out.println("1. Show Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            switch (choice) {
                case 0:
                    selectMovie();
                    selectHall();
                    resetBookings();
                    break;
                case 1:
                    showSeats();
                    break;
                case 2:
                    bookSeat();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    showBookings();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (choice != 5);
        in.close();
    }
}

