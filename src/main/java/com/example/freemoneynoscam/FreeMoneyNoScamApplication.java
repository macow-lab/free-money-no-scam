package com.example.freemoneynoscam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class FreeMoneyNoScamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeMoneyNoScamApplication.class, args);
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easymoneysniper","root","password");
            PreparedStatement psts = conn.prepareStatement("SELECT * from employees");
            ResultSet resultSet = psts.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
            }

        }catch(SQLException e){
            System.out.println("Cannot connect to database");
            e.printStackTrace();
        }
    }

}
