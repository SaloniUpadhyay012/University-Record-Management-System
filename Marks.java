package javaapplication1;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Marks extends JFrame {
    String rollno;

    Marks(String rollno) {
        this.rollno = rollno;
        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);
        getContentPane().setBackground(Color.orange);

        JLabel heading = new JLabel("FET AGRA COLLEGE, AGRA");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        JLabel Sheading = new JLabel("RESULT OF 2024 EXAMINATION");
        Sheading.setBounds(100, 50, 500, 20);
        Sheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(Sheading);

        JLabel lblrn = new JLabel("ROLL NO. " + rollno);
        lblrn.setBounds(60, 100, 500, 20);
        lblrn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrn);

        JLabel lblsem = new JLabel();
        lblsem.setBounds(60, 130, 500, 20);
        lblsem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsem);

        JLabel s1 = new JLabel();
        s1.setBounds(60, 200, 500, 20);
        s1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(s1);

        JLabel s2 = new JLabel();
        s2.setBounds(60, 230, 500, 20);
        s2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(s2);

        JLabel s3 = new JLabel();
        s3.setBounds(60, 260, 500, 20);
        s3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(s3);

        JLabel s4 = new JLabel();
        s4.setBounds(60, 290, 500, 20);
        s4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(s4);

        JLabel s5 = new JLabel();
        s5.setBounds(60, 320, 500, 20);
        s5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(s5);

        // Labels for marks
        JLabel m1 = new JLabel();
        m1.setBounds(300, 200, 500, 20);
        m1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(m1);

        JLabel m2 = new JLabel();
        m2.setBounds(300, 230, 500, 20);
        m2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(m2);

        JLabel m3 = new JLabel();
        m3.setBounds(300, 260, 500, 20);
        m3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(m3);

        JLabel m4 = new JLabel();
        m4.setBounds(300, 290, 500, 20);
        m4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(m4);

        JLabel m5 = new JLabel();
        m5.setBounds(300, 320, 500, 20);
        m5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(m5);

        try {
            conn c = new conn();
            // Fetching subjects
            ResultSet rs1 = c.s.executeQuery("SELECT * FROM subject WHERE rollno = '" + rollno + "'");
            if (rs1.next()) {
                s1.setText("Subject 1: " + rs1.getString("s1"));
                s2.setText("Subject 2: " + rs1.getString("s2"));
                s3.setText("Subject 3: " + rs1.getString("s3"));
                s4.setText("Subject 4: " + rs1.getString("s4"));
                s5.setText("Subject 5: " + rs1.getString("s5"));
            }

            // Fetching marks
            ResultSet rs2 = c.s.executeQuery("SELECT * FROM marks WHERE rollno = '" + rollno + "'");
            if (rs2.next()) {
                m1.setText("Marks 1: " + rs2.getString("m1"));
                m2.setText("Marks 2: " + rs2.getString("m2"));
                m3.setText("Marks 3: " + rs2.getString("m3"));
                m4.setText("Marks 4: " + rs2.getString("m4"));
                m5.setText("Marks 5: " + rs2.getString("m5"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Marks("12345");  // Example roll number
    }
}
