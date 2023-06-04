package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserImpl userImpl = new UserImpl();
        BookImpl bookImpl = new BookImpl();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to application");

        boolean isLoggedIn = false;
        User loggedInUser = null;

        do {
            System.out.println("1.Register\n" +
                    "2.Login");

            if (isLoggedIn) {
                System.out.println("3.Add Book\n" +
                        "4.View Books\n" +
                        "5.Sort Books by Title\n" +
                        "6.Sort Books by Publication Date\n" +
                        "7.Logout");
            } else {
                System.out.println("7.Exit");
            }

                System.out.println("Your choice?");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        User user = new User();
                        System.out.println("Choose a username: ");
                        String username = scanner.next();
                        System.out.println("Choose a password: ");
                        String password = scanner.next();
                        user.setUsername(username);
                        user.setPassword(password);
                        userImpl.userRegister(user);
                        break;
                    case 2:
                        User loginUser = new User();
                        System.out.println("Enter your username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.println("Enter your password: ");
                        String loginPassword = scanner.nextLine();
                        loginUser.setUsername(loginUsername);
                        loginUser.setPassword(loginPassword);
                        if (userImpl.userLogin(loginUser)) {
                            isLoggedIn = true;
                            loggedInUser = loginUser;
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Invalid username or password. Please try again.");
                        }
                        break;
                    case 3:
                        if (isLoggedIn) {
                            System.out.println("Add Book");
                            Book book = new Book();

                            System.out.println("Enter book title: ");
                            String title = scanner.nextLine();
                            if (title.isEmpty()) {
                                System.out.println("Title cannot be empty. Please try again.");
                                break;
                            }
                            book.setTitle(title);

                            System.out.println("Enter book page count: ");
                            String pageCountInput = scanner.nextLine();
                            if (pageCountInput.isEmpty()) {
                                System.out.println("Page count cannot be empty. Please try again.");
                                break;
                            }
                            int pageCount;
                            try {
                                pageCount = Integer.parseInt(pageCountInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid page count. Please enter a valid number.");
                                break;
                            }
                            book.setPageCount(pageCount);

                            LocalDate publicationDate = LocalDate.now();
                            book.setPublicationDate(String.valueOf(publicationDate));

                            bookImpl.addBook(book);
                            System.out.println("Book added successfully!");
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;
                    case 4:
                        if (isLoggedIn) {
                            System.out.println("View Books");
                            List<org.example.Book> books = bookImpl.getBooks();
                            for (org.example.Book book : books) {
                                System.out.println(book.getTitle());
                            }
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;
                    case 5:
                        if (isLoggedIn) {
                            System.out.println("Sort Books by Title");
                            List<org.example.Book> sortedBooks = bookImpl.sortBooksByTitle();
                            for (org.example.Book book : sortedBooks) {
                                System.out.println(book.getTitle());

                            }
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;
                    case 6:
                        if (isLoggedIn) {
                            System.out.println("Sort Books by Publication Date");
                            List<org.example.Book> sortedBooks = bookImpl.sortBooksByPublicationDate();
                            for (org.example.Book book : sortedBooks) {
                                System.out.println(book.getTitle());
                            }
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter a valid choice!");
                        System.exit(0);
                }
            }
            while (true) ;
        }

    }


