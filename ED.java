package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ED extends JFrame implements ActionListener {
    JTextField search;
    JButton submit, cancel;
    JTable table;

    ED() {
        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.ORANGE);

        JLabel heading = new JLabel("CHECK RESULT");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.ITALIC, 18));
        add(search);

        submit = new JButton("Result");
        submit.setBounds(300, 90, 200, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(520, 90, 200, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);

        // MouseListener to capture the selected row's roll number and set it in the text field
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();  // Get the selected row index
                if (selectedRow != -1) {
                    // Assuming the roll number is in the third column (column index 2)
                    String rollNo = table.getModel().getValueAt(selectedRow, 2).toString();
                    search.setText(rollNo);  // Set the roll number in the text field
                }
            }
        });

        // Populate the JTable with data from the database
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // If 'Result' button is clicked, open Marks window
            setVisible(false);
            new Marks(search.getText());  // Assuming Marks class accepts roll number as parameter
        } else if (ae.getSource() == cancel) {
            // If 'Cancel' button is clicked, close the current window
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ED();
    }
}
