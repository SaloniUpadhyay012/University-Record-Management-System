package javaapplication1;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TL extends JFrame implements ActionListener {

    Choice crn, ct;
    JDateChooser dcdob;
    JButton submit, cancel;

    TL() {

        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        JLabel heading = new JLabel("APPLY LEAVE(TEACHER)");
        heading.setBounds(40, 50, 300, 30);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrn = new JLabel("SEARCH BY EMP ID");
        lblrn.setBounds(60, 100, 250, 20);
        lblrn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblrn.setForeground(Color.WHITE);
        add(lblrn);

        crn = new Choice();
        crn.setBounds(60, 130, 200, 20);
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

        JLabel lbld = new JLabel("DATE");
        lbld.setBounds(60, 180, 250, 20);
        lbld.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbld.setForeground(Color.WHITE);
        add(lbld);

        dcdob = new JDateChooser();
        dcdob.setBounds(60, 210, 200, 25);
        add(dcdob);

        JLabel lblt = new JLabel("Time Duration");
        lblt.setBounds(60, 260, 200, 20);
        lblt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblt.setForeground(Color.WHITE);
        add(lblt);

        ct = new Choice();
        ct.setBounds(60, 290, 200, 20);
        ct.add("FULL DAY");
        ct.add("HALF DAY");
        add(ct);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String eid = crn.getSelectedItem();
            String date = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String duration = ct.getSelectedItem();

            String query = "insert into teacherleave values('" + eid + "','" + date + "','" + duration + "');";
            try {
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Applied successfully!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TL();
    }
}
