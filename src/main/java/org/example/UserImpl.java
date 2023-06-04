package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements UserInterface {

    private Connection con;

    @Override
    public void userRegister(User user) {
        con = DBConnection.createDBConnection();
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("User created successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(con);
        }
    }
    @Override
    public boolean userLogin(User user) {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("User logged in successfully");
                return true;
            } else {
                System.out.println("Invalid username or password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(con);
        }
        return false;
    }
    @Override
    public void userLogin() {
    }
}


