package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class EM extends JFrame implements ActionListener {
    Choice crn;
    JComboBox<String> cbs;
    JTextField tfs1, tfs2, tfs3, tfs4, tfs5, tfm1, tfm2, tfm3, tfm4, tfm5;
    JButton submit, cancel;

    EM() {
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT); // Adjusted to match the frame size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("ENTER MARKS");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrn = new JLabel("SELECT ROLL NO.");
        lblrn.setBounds(50, 70, 150, 20);
        add(lblrn);

        crn = new Choice();
        crn.setBounds(200, 70, 150, 20);
        add(crn);

        // Populate roll numbers from the database
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crn.add(rs.getString("rollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblsem = new JLabel("SELECT SEMESTER");
        lblsem.setBounds(50, 110, 150, 20);
        add(lblsem);

        String[] sem = { "1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        cbs = new JComboBox<>(sem);
        cbs.setBounds(200, 110, 150, 20);
        cbs.setBackground(Color.white);
        add(cbs);

        JLabel lblsub = new JLabel("ENTER SUBJECT");
        lblsub.setBounds(100, 150, 200, 40);
        add(lblsub);

        JLabel lblmarks = new JLabel("ENTER MARKS");
        lblmarks.setBounds(320, 150, 200, 40);
        add(lblmarks);

        tfs1 = new JTextField();
        tfs1.setBounds(50, 200, 200, 20);
        add(tfs1);

        tfs2 = new JTextField();
        tfs2.setBounds(50, 230, 200, 20);
        add(tfs2);

        tfs3 = new JTextField();
        tfs3.setBounds(50, 260, 200, 20);
        add(tfs3);

        tfs4 = new JTextField();
        tfs4.setBounds(50, 290, 200, 20);
        add(tfs4);

        tfs5 = new JTextField();
        tfs5.setBounds(50, 320, 200, 20);
        add(tfs5);

        tfm1 = new JTextField();
        tfm1.setBounds(250, 200, 200, 20);
        add(tfm1);

        tfm2 = new JTextField();
        tfm2.setBounds(250, 230, 200, 20);
        add(tfm2);

        tfm3 = new JTextField();
        tfm3.setBounds(250, 260, 200, 20);
        add(tfm3);

        tfm4 = new JTextField();
        tfm4.setBounds(250, 290, 200, 20);
        add(tfm4);

        tfm5 = new JTextField();
        tfm5.setBounds(250, 320, 200, 20);
        add(tfm5);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String rollNo = crn.getSelectedItem();
                String semester = (String) cbs.getSelectedItem();

                String subject1 = tfs1.getText();
                String subject2 = tfs2.getText();
                String subject3 = tfs3.getText();
                String subject4 = tfs4.getText();
                String subject5 = tfs5.getText();

                String marks1 = tfm1.getText();
                String marks2 = tfm2.getText();
                String marks3 = tfm3.getText();
                String marks4 = tfm4.getText();
                String marks5 = tfm5.getText();

                conn c = new conn();

                // Insert subjects
                String query1 = "INSERT INTO subject (rollno, sem, s1, s2, s3, s4, s5) VALUES ('" + rollNo + "', '" + semester + "', '" + subject1 + "', '" + subject2 + "', '" + subject3 + "', '" + subject4 + "', '" + subject5 + "')";
                
                // Insert marks
                String query2 = "INSERT INTO marks (rollno, sem, m1, m2, m3, m4, m5) VALUES ('" + rollNo + "', '" + semester + "', '" + marks1 + "', '" + marks2 + "', '" + marks3 + "', '" + marks4 + "', '" + marks5 + "')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks entered successfully!");
                setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EM();
    }
}
