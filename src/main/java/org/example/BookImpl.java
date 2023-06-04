package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookImpl implements BookInterface {
    private Connection con;

    public BookImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/userDB";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        String query = "INSERT INTO books (title, pageCount, publication_date) VALUES (?, ?, ?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, book.getTitle());
            pstm.setString(2, book.pageCount());
            pstm.setString(3, book.getPublicationDate());
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Book added successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addBook(java.awt.print.Book book) {

    }
    @Override
    public List<Book> getBooks() {
        String query = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setPageCount(Integer.parseInt(rs.getString("pageCount")));
                book.setPublicationDate(rs.getString("publication_date"));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return books;
    }

    @Override
    public List<Book> sortBooksByTitle() {
        String query = "SELECT * FROM books ORDER BY title";
        List<Book> books = new ArrayList<>();

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setPageCount(Integer.parseInt(rs.getString("pageCount")));
                book.setPublicationDate(rs.getString("publication_date"));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return books;
    }
    @Override
    public List<Book> sortBooksByPublicationDate() {
        String query = "SELECT * FROM books ORDER BY publication_date";
        List<Book> books = new ArrayList<>();

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setPageCount(Integer.parseInt(rs.getString("pageCount")));
                book.setPublicationDate(rs.getString("publication_date"));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return books;
    }
}
