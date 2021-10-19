package com.example.freemoneynoscam.services;
import java.sql.*;

public class Database {

    public Database() {
    }

    private Connection connection = null;
    public boolean setConnection() {
        final String url = "jdbc:mysql://localhost:3306/easymoneysniper?serverTimezone=UTC";
        boolean res = false;
        try {
            connection = DriverManager.getConnection(url, "root", "im;1337%HUMAN");
            res = true;
        } catch (SQLException ioerr) {
            System.out.println(ioerr);
        }
        return res;
    }

    public int saveEmail(String email) {
        String insstr = "INSERT INTO email(email) values (?)";
        String input = email;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insstr);
            preparedStatement.setString(1, input.replace("[","").replace("]",""));
            preparedStatement.executeUpdate();
        } catch (SQLException err) {
            System.out.println("bad happened:" + err.getMessage());
            return 400;
        }
        System.out.println("good happened");
        return 200;
    }
}