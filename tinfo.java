package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class tinfo extends JFrame implements ActionListener {
    JTextField tfname, tffname, tfadd, tfpn, tfem, tfx, tfxii, tfan;
    JLabel labeleid;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    Random ran = new Random();
    long ff = Math.abs((ran.nextLong() % 9000L) + 1000L);

    tinfo() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("NEW TEACHER DETAILS");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblrn = new JLabel("EMP ID");
        lblrn.setBounds(50, 200, 150, 30);
        lblrn.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrn);

        labeleid = new JLabel("101" + ff);
        labeleid.setBounds(200, 200, 150, 30);
        labeleid.setFont(new Font("serif", Font.BOLD, 20));
        add(labeleid);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        JLabel lbladd = new JLabel("Address");
        lbladd.setBounds(50, 250, 200, 30);
        lbladd.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladd);

        tfadd = new JTextField();
        tfadd.setBounds(200, 250, 150, 30);
        add(tfadd);

        JLabel lblpn = new JLabel("Phone No.");
        lblpn.setBounds(400, 250, 200, 30);
        lblpn.setFont(new Font("serif", Font.BOLD, 20));
        add(lblpn);

        tfpn = new JTextField();
        tfpn.setBounds(600, 250, 150, 30);
        add(tfpn);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfem = new JTextField();
        tfem.setBounds(200, 300, 150, 30);
        add(tfem);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);

        JLabel lblan = new JLabel("Aadhar No.");
        lblan.setBounds(400, 350, 200, 30);
        lblan.setFont(new Font("serif", Font.BOLD, 20));
        add(lblan);

        tfan = new JTextField();
        tfan.setBounds(600, 350, 150, 30);
        add(tfan);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String course[] = {"B.Tech", "M.Tech", "BCA", "MCA", "MBA", "BBA", "BA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = {"CSE", "MECHANICAL", "CIVIL", "ELECTRICAL", "ELECTRONICS", "CHEMICAL"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        // Gather data from the form fields
        String name = tfname.getText();
        String fatherName = tffname.getText();
        String eid = labeleid.getText();
        String dob = dcdob.getDate() != null ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(dcdob.getDate()) : "";
        String address = tfadd.getText();
        String phone = tfpn.getText();
        String email = tfem.getText();
        String X = tfx.getText();
        String XII = tfxii.getText();
        String aadhar = tfan.getText();
        String course = (String) cbcourse.getSelectedItem();
        String branch = (String) cbbranch.getSelectedItem();

        // Basic validation
        if (name.isEmpty() || fatherName.isEmpty() || eid.isEmpty() || dob.isEmpty() ||
            address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Use Statement instead of PreparedStatement
            conn c = new conn();
            try {
                String query = "INSERT INTO teacher (name, fatherName, eid , dob, address, phone, email, X, XII, aadhar, qualification, department) " +
                               "VALUES ('" + name + "', '" + fatherName + "', '" + eid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + X + "', '" + XII + "', '" + aadhar + "', '" + course + "', '" + branch + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher details inserted successfully!");
                setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Ensure resources are closed
                try {
                    if (c.s != null && !c.s.isClosed()) {
                        c.s.close();
                    }
                    if (c.c != null && !c.c.isClosed()) {
                        c.c.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    } else {
        setVisible(false);
    }
}
public static void main(String[] args)
{
    new tinfo();
}}