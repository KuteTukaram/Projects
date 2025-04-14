package com.electricitybill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    String acctype;
    String meter_pass;

    // Constructor for main_class with account type and meter number
    main_class(String acctype, String meter_pass) {
        this.meter_pass = meter_pass;
        this.acctype = acctype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Set background image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 830, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLable = new JLabel(imageIcon2);
        add(imageLable);

        // Set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif", Font.PLAIN, 15));

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 14));
        newcustomer.setIcon(loadIcon("icon/newcustomer.png"));
        newcustomer.addActionListener(this);
        menu.add(newcustomer);

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        customerdetails.setIcon(loadIcon("icon/customerDetails.png"));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        depositdetails.setIcon(loadIcon("icon/depositdetails.png"));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced", Font.PLAIN, 14));
        calculatebill.setIcon(loadIcon("icon/calculatorbills.png"));
        calculatebill.addActionListener(this);
        menu.add(calculatebill);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif", Font.PLAIN, 15));

        JMenuItem upinfo = new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced", Font.PLAIN, 14));
        upinfo.setIcon(loadIcon("icon/refresh.png"));
        upinfo.addActionListener(this);
        info.add(upinfo);

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced", Font.PLAIN, 14));
        viewInfo.setIcon(loadIcon("icon/information.png"));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif", Font.PLAIN, 15));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 14));
        paybill.setIcon(loadIcon("icon/pay.png"));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        billdetails.setIcon(loadIcon("icon/detail.png"));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif", Font.PLAIN, 15));

        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced", Font.PLAIN, 14));
        genBill.setIcon(loadIcon("icon/bill.png"));
        genBill.addActionListener(this);
        bill.add(genBill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif", Font.PLAIN, 15));

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 14));
        notepad.setIcon(loadIcon("icon/notepad.png"));
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 14));
        calculator.setIcon(loadIcon("icon/calculator.png"));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif", Font.PLAIN, 15));

        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced", Font.PLAIN, 14));
        eexit.setIcon(loadIcon("icon/exit.png"));
        eexit.addActionListener(this);
        exit.add(eexit);

        // Add menus depending on account type
        if (acctype.equals("Admin")) {
            menuBar.add(menu);
        } else {
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);

        // Set the layout and make it visible
        setLayout(new FlowLayout());
        setVisible(true);
    }

    // Helper method to load icon images
    private ImageIcon loadIcon(String path) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(path));
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        return new ImageIcon(img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        switch (msg) {
            case "New Customer" -> new newCustomer();
            case "Customer Details" -> new customer_details();
            case "Deposit Details" -> new deposit_details();
            case "Calculate Bill" -> new calculate_bill();
            case "View Information" -> new view_information(meter_pass);
            case "Update Information" -> new update_information(meter_pass);
            case "Bill Details" -> new bill_details(meter_pass);
            case "Calculator" -> {
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            case "Notepad" -> {
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            case "Exit" -> {
                setVisible(false);
                new Login();
            }
            case "Pay Bill" -> new pay_bill(meter_pass);
            case "Generate Bill" -> new generate_bill(meter_pass);
        }
    }

    public static void main(String[] args) {
        // Provide values for account type and meter number
        new main_class("User", "123456");  // Example account type and meter number
    }
}
