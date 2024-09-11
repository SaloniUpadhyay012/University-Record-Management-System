package javaapplication1;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        // Load the image and set its size to the screen dimensions
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fi.png"));
        Image i2 = i1.getImage().getScaledInstance(1080, 810, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Initialize the thread
        t = new Thread(this);
        t.start();

        setUndecorated(true); // Removes the window decoration (title bar, etc.)
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            int screenWidth = 1080;
            int screenHeight = 810;
            int widthIncrement = screenWidth / 300;
            int heightIncrement = screenHeight / 300;

            // Start with a small size in the center
            int initialWidth = 100;
            int initialHeight = 100;
            int xPos = (screenWidth - initialWidth) / 2;
            int yPos = (screenHeight - initialHeight) / 2;
            setLocation(xPos, yPos);
            setSize(initialWidth, initialHeight);

            for (int i = 0; i < 300; i++) {
                xPos = (screenWidth - initialWidth) / 2;
                yPos = (screenHeight - initialHeight) / 2;
                initialWidth += widthIncrement;
                initialHeight += heightIncrement;

                setLocation((screenWidth - initialWidth) / 2, (screenHeight - initialHeight) / 2);
                setSize(initialWidth, initialHeight);

                Thread.sleep(10);
            }

            // Ensuring it covers the entire screen
            setLocation(0, 0);
            setSize(screenWidth, screenHeight);

            // Wait for 7 seconds
            Thread.sleep(7000);

            // Close the splash screen
            dispose();

            // Launch the Login frame
            new LOGIN().setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
