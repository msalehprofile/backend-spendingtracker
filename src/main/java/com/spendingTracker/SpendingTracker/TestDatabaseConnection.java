package com.spendingTracker.SpendingTracker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://rds-spending-tracker-db.cdmiewgukza1.us-east-1.rds.amazonaws.com:3306/spending_tracker";
        String username = "admin";
        String password = "RDSPassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES;");

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            System.out.println("Connection Successful!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed!");
        }
    }
}
