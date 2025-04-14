package com.electricitybill;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class bill_details extends JFrame {
    String meter;
    JTextField meterField;  // JTextField for meter number input
    JTable table;  // JTable to display bill details

    // Constructor to initialize frame
    bill_details(String meter_pass) {
        setSize(700, 650);
        setLocation(400, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Label for Meter Number input
        JLabel meterLabel = new JLabel("Enter Meter Number:");
        meterLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        meterLabel.setBounds(20, 20, 150, 30);
        add(meterLabel);

        // Meter number text field for user input
        meterField = new JTextField();
        meterField.setBounds(180, 20, 150, 30);
        add(meterField);

        // Search button to fetch the bill details
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 14));
        searchButton.setBounds(350, 20, 100, 30);
        add(searchButton);

        // Table to display bill details
        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 60, 700, 550);
        add(sp);

        // Action listener for the Search button
        searchButton.addActionListener(e -> {
            String meterInput = meterField.getText().trim(); // Get input from JTextField
            if (!meterInput.isEmpty()) {
                fetchBillDetails(meterInput); // Fetch data from DB
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a meter number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    // Method to fetch bill details from database based on entered meter number
    private void fetchBillDetails(String meter) {
        try {
            // Assuming 'database' is a class that handles your DB connection
            database c = new database();
            String query_bill = "SELECT * FROM bill WHERE meter_no = '" + meter + "'";
            ResultSet resultSet = c.statement.executeQuery(query_bill);

            // Display results in the table
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to run the bill_details frame
    public static void main(String[] args) {
        new bill_details(); // Create and show the frame
    }
}
