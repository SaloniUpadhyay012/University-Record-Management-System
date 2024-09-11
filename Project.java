package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {

    Project() {
        // Set frame properties
        setSize(1540, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Or use a suitable layout manager

        // Load and set the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sss.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT); // Adjusted to match the frame size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1540, 850); // Full size background image
        add(image);

        // Create the menu bar
        JMenuBar mb = new JMenuBar();

        // New Information Menu
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInformation = new JMenuItem("New Faculty Information");
        facultyInformation.setForeground(Color.WHITE);
         facultyInformation.addActionListener(this);
        newInformation.add(facultyInformation);

        JMenuItem studentInformation = new JMenuItem("New Student Information"); // Corrected item name
        studentInformation.setForeground(Color.WHITE);
        studentInformation.addActionListener(this);
        newInformation.add(studentInformation);

        // View Details Menu
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem fDetails = new JMenuItem("View Faculty Details");
        fDetails.setForeground(Color.WHITE);
         fDetails.addActionListener(this);
        details.add(fDetails);

        JMenuItem sDetails = new JMenuItem("View Student Details");
        sDetails.setForeground(Color.WHITE);
         sDetails.addActionListener(this);
        details.add(sDetails);

        // Apply Leave Menu
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem fLeave = new JMenuItem("Faculty Leave");
        fLeave.setForeground(Color.WHITE);
        fLeave.addActionListener(this);
        leave.add(fLeave);

        JMenuItem sLeave = new JMenuItem("Student Leave");
        sLeave.setForeground(Color.WHITE);
        sLeave.addActionListener(this);
        leave.add(sLeave);

        // Leave Details Menu
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED); 
        mb.add(leaveDetails);

        JMenuItem fLeaveDetails = new JMenuItem("Faculty Leave Details");
        fLeaveDetails.setForeground(Color.WHITE);
        fLeaveDetails.addActionListener(this);
        leaveDetails.add(fLeaveDetails);

        JMenuItem sLeaveDetails = new JMenuItem("Student Leave Details");
        sLeaveDetails.setForeground(Color.WHITE);
        sLeaveDetails.addActionListener(this);
        leaveDetails.add(sLeaveDetails);

        // Examination Menu
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem results = new JMenuItem("Results");
        results.setForeground(Color.WHITE);
        results.addActionListener(this);
        exam.add(results);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
enterMarks.setForeground(Color.BLACK);
enterMarks.addActionListener(this); // This ensures action is handled
exam.add(enterMarks);

        // Update Details Menu
        JMenu updateDetails = new JMenu("Update Details");
        updateDetails.setForeground(Color.RED);
        mb.add(updateDetails);

        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.setForeground(Color.WHITE);
        updateFaculty.addActionListener(this);
        updateDetails.add(updateFaculty);

        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.setForeground(Color.WHITE);
        updateStudent.addActionListener(this);
        updateDetails.add(updateStudent);

        

        // Utility Menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setForeground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setForeground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        // Exit Menu
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setForeground(Color.WHITE);
        exitItem.addActionListener(this);
        exit.add(exitItem);

        // Set the menu bar
        setJMenuBar(mb);

        // Make frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")) {
            System.exit(0); // Exit the application
        } else if (msg.equals("Calculator")) {
            try {
                // Open Calculator
                Runtime.getRuntime().exec("calc"); // 'calc' is a command for Windows Calculator
            } catch (Exception e) {
                e.printStackTrace(); // Print the stack trace for debugging
            }
        } else if (msg.equals("Notepad")) {
            try {
                // Open Notepad
                Runtime.getRuntime().exec("notepad"); // 'notepad' is a command for Windows Notepad
            } catch (Exception e) {
                e.printStackTrace(); // Print the stack trace for debugging
            }
            
        }
        else if(msg.equals("New Faculty Information")){
                    new tinfo();
                    }
            else if(msg.equals("New Student Information")){
                    new sinfo();
                    }
        else if(msg.equals("View Faculty Details")){
                    new tdetail();
                    }
        
        else if(msg.equals("Faculty Leave")){
                    new TL();
                    }
        else if(msg.equals("Student Leave")){
                    new SL();
                    }
        else if(msg.equals("Faculty Leave Details")){
                    new TLD();
                    }
        else if(msg.equals("Student Leave Details")){
                    new SLD();
                    }
      else if(msg.equals("Update Faculty Details")){
                    new Updateteacher();
                    } 
         else if(msg.equals("Update Student Details")){
                    new Updatestu();
                    } 
        else if(msg.equals("Enter Marks")){
                    new EM();
                    } 
        else if(msg.equals("Results")){
                    new ED();
                    } 
        
    }

    public static void main(String[] args) {
        new Project();
    }
}
