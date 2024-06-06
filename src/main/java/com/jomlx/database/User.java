package com.jomlx.database;

import java.sql.*;

public class User {
    private static String url= "jdbc:ucanaccess://C://Users//pc//Documents//MemoDatabase.accdb";
    
    public User() {
        
    }
    
    public static void addUser(String username, String email, String password, Timestamp creationDate) {
        try {
            Connection conn = DriverManager.getConnection(url);
            String insertSQL = "INSERT INTO UserTable (username, email, password, creationDate) VALUES (?,?,?,?)";
            
            PreparedStatement pst = conn.prepareStatement(insertSQL);
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setTimestamp(4, creationDate);
            
            int rowsAffected = pst.executeUpdate();
            System.out.println("Record successfully added!");
        } catch (SQLException e) {
            
        }
    }
    
    public static boolean selectUserByUsername(String username) {
        boolean found = false;
        try {
            Connection conn = DriverManager.getConnection(url);
            String selectSQL = "SELECT username FROM UserTable";
            
            PreparedStatement pst = conn.prepareStatement(selectSQL);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String dbUsername = rs.getString("username");
                
               // Compare
               if (username.equals(dbUsername)) {
                       found = true;
                       break;                  
               }                   
            }
        } catch (SQLException e) {  }
        System.out.println(found);
        return found;
    }
    
    public static boolean selectUserByEmail(String email) {
        boolean found = false;
        try {
            Connection conn = DriverManager.getConnection(url);
            String selectSQL = "SELECT email FROM UserTable";
            
            PreparedStatement pst = conn.prepareStatement(selectSQL);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String dbEmail = rs.getString("email");
                
               // Compare
               if (email.equals(dbEmail)) {
                       found = true;
                       break;                  
               }                   
            }
        } catch (SQLException e) {  }
        System.out.println(found);
        return found;
    }
    
    public static boolean selectUserByUsernameAndEmail(String username, String email) {
        boolean found = false;
        try {
            Connection conn = DriverManager.getConnection(url);
            String selectSQL = "SELECT username, email FROM UserTable";
            
            PreparedStatement pst = conn.prepareStatement(selectSQL);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String dbUsername = rs.getString("username");
                String dbEmail = rs.getString("email");
                
               // Compare
               if (username.equals(dbUsername) || username.equals(dbEmail)) {
                       found = true;
                       break;                  
               }                   
            }
        } catch (SQLException e) {  }
        System.out.println(found);
        return found; 
    }
    
    public static boolean selectUserByPassword(String password) {
        boolean found = false;
        try {
            Connection conn = DriverManager.getConnection(url);
            String selectSQL = "SELECT password FROM UserTable";
            
            PreparedStatement pst = conn.prepareStatement(selectSQL);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String dbPassword = rs.getString("password");
               
                // Compare
                if (password.equals(dbPassword)) {
                   found = true;
                   break;
                }                   
            }
        } catch (SQLException e) {  }
        return found;
    }
}
