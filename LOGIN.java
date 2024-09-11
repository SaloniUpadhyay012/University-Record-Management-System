package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LOGIN extends JFrame implements ActionListener {
    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;

    LOGIN() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        // Username Text Field
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);

        // Password Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 60, 100, 20);
        add(lblpassword);

        // Password Field
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 60, 150, 20);
        add(tfpassword);

        // Login Button
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        // Frame settings
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = String.valueOf(tfpassword.getPassword());
            String query = "SELECT * FROM logi WHERE username='" + username + "' AND password='" + password + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Project(); // Ensure Project class is defined and handles what happens after login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LOGIN();
    }
}
