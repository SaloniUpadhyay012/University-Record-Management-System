package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Updateteacher extends JFrame implements ActionListener {
    JTextField tfcourse, tfadd, tfpn, tfem, tfbranch;
    JLabel labelrn, lblname, lblfname, lbldoc, lblx, lblxii, lblan;
    Choice crn;
    JButton submit, cancel;

    Updateteacher() {
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);

        JLabel heading = new JLabel("UPDATE TEACHER DETAILS");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblrn = new JLabel("SELECT EMP ID");
        lblrn.setBounds(50, 100, 200, 20);
        lblrn.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrn);

        crn = new Choice();
        crn.setBounds(250, 100, 200, 20);
        add(crn);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                crn.add(rs.getString("eid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Label and text fields for student details
        JLabel lablname = new JLabel("Name");
        lablname.setBounds(50, 150, 100, 30);
        lablname.setFont(new Font("serif", Font.BOLD, 20));
        add(lablname);

        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);

        JLabel lablfname = new JLabel("Father's Name");
        lablfname.setBounds(400, 150, 200, 30);
        lablfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lablfname);

        lblfname = new JLabel();
        lblfname.setBounds(600, 150, 150, 30);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblfname);

        JLabel lablrn = new JLabel("EMP ID");
        lablrn.setBounds(50, 200, 150, 30);
        lablrn.setFont(new Font("serif", Font.BOLD, 20));
        add(lablrn);

        labelrn = new JLabel();
        labelrn.setBounds(200, 200, 150, 30);
        labelrn.setFont(new Font("serif", Font.PLAIN, 18));
        add(labelrn);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        lbldoc = new JLabel();
        lbldoc.setBounds(600, 200, 150, 30);
        lbldoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldoc);

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

        JLabel lablx = new JLabel("Class X (%)");
        lablx.setBounds(400, 300, 200, 30);
        lablx.setFont(new Font("serif", Font.BOLD, 20));
        add(lablx);

        lblx = new JLabel();
        lblx.setBounds(600, 300, 150, 30);
        lblx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblx);

        JLabel lablxii = new JLabel("Class XII (%)");
        lablxii.setBounds(50, 350, 200, 30);
        lablxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lablxii);

        lblxii = new JLabel();
        lblxii.setBounds(200, 350, 150, 30);
        lblxii.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblxii);

        JLabel lablan = new JLabel("Aadhar No.");
        lablan.setBounds(400, 350, 200, 30);
        lablan.setFont(new Font("serif", Font.BOLD, 20));
        add(lablan);

        lblan = new JLabel();
        lblan.setBounds(600, 350, 150, 30);
        lblan.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblan);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);

        // Event listener for Choice selection change
        crn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from teacher where eid='" + crn.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblfname.setText(rs.getString("fathername"));
                        labelrn.setText(rs.getString("eid"));
                        lbldoc.setText(rs.getString("dob"));
                        tfadd.setText(rs.getString("address"));
                        tfpn.setText(rs.getString("phone"));
                        tfem.setText(rs.getString("email"));
                        lblx.setText(rs.getString("X"));
                        lblxii.setText(rs.getString("XII"));
                        lblan.setText(rs.getString("aadhar"));
                        tfcourse.setText(rs.getString("qualification"));
                        tfbranch.setText(rs.getString("department"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Buttons for submit and cancel
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
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
            String name = lblname.getText();
            String fatherName = lblfname.getText();
            String rollNo = labelrn.getText();
            String dob = lbldoc.getText(); // Retrieve Date of Birth
            String address = tfadd.getText();
            String phone = tfpn.getText();
            String email = tfem.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            // Basic validation
            if (name.isEmpty() || fatherName.isEmpty() || rollNo.isEmpty() || dob.isEmpty() ||
                address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Database update query
                conn c = new conn();
                try {
                    String query = "UPDATE teacher SET name = '" + name + "', fathername = '" + fatherName + "', dob = '" + dob + "', "
                            + "address = '" + address + "', phone = '" + phone + "', email = '" + email + "', qualification = '" + course + "', department = '" + branch + "' "
                            + "WHERE eid = '" + rollNo + "'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Teacher details updated successfully!");
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
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Updateteacher();
    }
}
