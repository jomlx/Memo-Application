package com.jomlx.database;

import java.sql.*;

public class User {
    private static final String user_username = "root";
    private static final String user_password = "Jomlx1924!";
    private static final String url = "jdbc:mysql://localhost:3306/memo_schema";

    static Connection conn = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public User() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        }
    }

    public static void addUser(String username, String email, String password, Timestamp creationDate) {
        try {
            conn = DriverManager.getConnection(url, user_username, user_password);
            String insertSQL = "INSERT INTO account_user (username, email, password, creationDate) VALUES (?, ?, ?, ?)";  // Ensure the table name is 'users'
            
            pst = conn.prepareStatement(insertSQL);
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setTimestamp(4, creationDate);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record successfully added!");
            } else {
                System.out.println("No record was added.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public static boolean selectUserByUsername(String username) {
        boolean found = false;
        try {
            conn = DriverManager.getConnection(url, user_username, user_password);
            String selectSQL = "SELECT username FROM account_user WHERE username = ?";

            pst = conn.prepareStatement(selectSQL);
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        System.out.println(found);
        return found;
    }

    public static boolean selectUserByEmail(String email) {
        boolean found = false;
        try {
            conn = DriverManager.getConnection(url, user_username, user_password);
            String selectSQL = "SELECT email FROM account_user WHERE email = ?";

            pst = conn.prepareStatement(selectSQL);
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        System.out.println(found);
        return found;
    }

    public static boolean selectUserByUsernameAndEmail(String username, String email) {
        boolean found = false;
        try {
            conn = DriverManager.getConnection(url, user_username, user_password);
            String selectSQL = "SELECT username, email FROM account_user WHERE username = ? OR email = ?";

            pst = conn.prepareStatement(selectSQL);
            pst.setString(1, username);
            pst.setString(2, email);
            rs = pst.executeQuery();

            if (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        System.out.println(found);
        return found;
    }

    public static boolean selectUserByPassword(String password) {
        boolean found = false;
        try {
            conn = DriverManager.getConnection(url, user_username, user_password);
            String selectSQL = "SELECT password FROM account_user WHERE password = ?";

            pst = conn.prepareStatement(selectSQL);
            pst.setString(1, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return found;
    }

    private static void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
