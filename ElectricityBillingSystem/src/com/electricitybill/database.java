package com.electricitybill;

import java.sql.*;

public class database {
    Connection connection;
    Statement statement;

    database() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bill_system", "postgres", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
