package com.company;
import javax.swing.*;// importing java swing for frame
import java.awt.*;   // importing java awt for frame and to modify the frame
import java.io.IOException;  // handles Io exceptions


public class Main {

    public static void main(String[] args) throws IOException { // throws exception to handle any input output error


        Frame mainFrame= new Frame(); // constructing a new frame

        mainFrame.setTitle("Wheel OF Fortune"); // sets the title of the frame

        Container color=mainFrame.getContentPane(); // settin
        // g background colour using a container
        color.setBackground(Color.white);


        // Terminate program when window closes
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // command to exit frame

        // Resize window to fit components
        mainFrame.setSize(600,400);     //setting size of the frame


        // Display window
        mainFrame.setVisible(true); // making the frame visible


    }
}
