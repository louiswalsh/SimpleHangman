/*
Frame class where the frame is modified and filled
*/
package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class  Frame extends JFrame{ // frame is the subclass of Jframe

    // declaring public variables which are used in the program in different classes
    private StringBuffer hiddenExpression;
    private int turns = 8,turn1=0,turn2=0;
    private static int p1w = 0;
    private static int p2w = 0;
    private String player2Name,player1Name, expr1;
    private JTextField guessedexpr,wincount1,wincount2;
    private JLabel e1, p1, p2,name,name2,winner2,winner1,expr,numguess;
    private JButton play;

    public Frame() {        // constructor frame class, modifying the frame
        name = new JLabel("Player Name: ");
        name2 = new JLabel("Player2 Name: ");
        // creating new JLabels
        expr = new JLabel("Expression:");

        numguess = new JLabel("Number of Guesses:");
        wincount1 = new JTextField(Integer.toString(p1w));
        wincount2 = new JTextField(Integer.toString(p2w));          // defining new textfields and jlabels
        guessedexpr = new JTextField(Integer.toString(turns));
        play = new JButton("Play Game");

        wincount1.setEditable(false);
        wincount1.setBorder(BorderFactory.createLineBorder(Color.BLACK));       // formatting text field with a border, background and setting its editor to false
        wincount1.setBackground(Color.white);

        wincount2.setEditable(false);
        wincount2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        wincount2.setBackground(Color.white);

        guessedexpr.setEditable(false);
        guessedexpr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        guessedexpr.setBackground(Color.white);

        player1Name = JOptionPane.showInputDialog(this, "Player1, enter your name:");   // JOption pane input dialogue that pop ups a new window that can be used to input in the frame
        p1 = new JLabel(" " + player1Name + " ");
        p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        player2Name = JOptionPane.showInputDialog(this, "Player2, enter your name:");
        p2 = new JLabel(" " + player2Name + " ");
        p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        winner1 = new JLabel(player1Name+" wins: ");
        winner2 = new JLabel(player2Name+ " wins: ");

        e1=new JLabel("     ");
        e1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setLayout(new GridBagLayout());                             //Layout of the frame which is the grid bag layout
        GridBagConstraints layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(5, 5, 5, 5);  // giving 5 pixel space around each label,text box and  button
        layoutConst.gridx = 0;        // position of the x column
        layoutConst.gridy = 0;      // position of the y column
        add(name, layoutConst);     // adding the label to the frame with the layout which is gridlayout but object name is LayoutConst

        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(p1, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(name2, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(p2, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 0;
        add(winner1, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 1;
        add(winner2, layoutConst);

        layoutConst.gridx = 4;
        layoutConst.gridy = 0;
        add(wincount1, layoutConst);

        layoutConst.gridx = 4;
        layoutConst.gridy = 1;
        add(wincount2, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        add(expr, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        add(e1, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 4;
        add(numguess, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        add(guessedexpr, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 6;
        add(play, layoutConst);


        play.addActionListener(new ActionListener() { // performs the task in it when the button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,player1Name+"'s turn to challenge "+player2Name); // pop up message box
                turns=round(); // calling method and storing its return type in the variable turns
                // updating the respective fields with different variables as required
                e1.setText(" " + expr1 + " ");
                p1.setText(" "+player2Name+" ");       // Swapping players after the 1st turn is over
                p2.setText(" "+player1Name+" ");
                turn1=turns;
                JOptionPane.showMessageDialog(null,"Players Swapped"); // pop up message box
                JOptionPane.showMessageDialog(null,player2Name+"'s turn to challenge "+player1Name);
                turns=round();
                turn2=turns;
                JFrame frame = new JFrame(); // new frame used just as an object for the pop up box
                // control statements to check who is the winner of round 1
                if(turn1>turn2) {
                    JOptionPane.showMessageDialog(frame,winner2.getText()+" Wins :)");
                    p2w++;
                    wincount2.setText(Integer.toString(p2w)); //converting integer to string and updating the field
                }
                else if(turn1==turn2){
                    JOptionPane.showMessageDialog(frame," It is a Tie, well played!)");

                }
                else if(turn2>turn1){
                    JOptionPane.showMessageDialog(frame,winner1.getText()+" Wins :)");
                    p1w++;
                    wincount1.setText(Integer.toString(p1w));
                }

                int again = JOptionPane.showConfirmDialog (frame, "Do you want to play again","Warning",JOptionPane.YES_NO_OPTION); // confirm pop up box asking if user wants to play again or not
                // control statement to decide what happens when yes is clicked
                if (again==JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null,"New Round");
                    play.doClick(); // clicks the button even though its not physically clicked by the user to start a new game
                }
                else // if no is clicked declares overall winner
                {
                    if(p1w>p2w){
                        JOptionPane.showMessageDialog(frame,p1.getText()+" Wins overall!");
                    }
                    else if(p1w==p2w){
                        JOptionPane.showMessageDialog(frame," Its a tie overall!");
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,p2.getText()+" Wins overall!");

                    }
                    JOptionPane.showMessageDialog(frame," Thanks for playing, have a nice day!");
                    System.exit(0); // frame is closed and games is exited
                }

            }
        });
    }

    public int round() {        // method that runs when the button play game is clicked and is called by the action listner
        turns=26;
        guessedexpr.setText(Integer.toString(turns));
        JFrame frame = new JFrame();
        wof check = new wof(); // constructor to access variables in another class
        expr1 = JOptionPane.showInputDialog(this, p1.getText() + ", Enter the expression to be guessed ");
        hiddenExpression = makeHiddenExpresion.makeHiddenExpression(expr1);
        e1.setText(" " + hiddenExpression + " ");
        e1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        while ((turns >= 1) && (!check.complete)) { // while loop to complete 1 round of the game
            String guessedchar = JOptionPane.showInputDialog(frame, p2.getText() + ", enter letter to be guessed:");
            char charex = guessedchar.charAt(0);
            hiddenExpression = check.checkguess(hiddenExpression, charex, expr1); // calling method to check if the guessed letter or phrase is correct and storing return in the variable
            // control statements to determine if the guessed letter or phrase is correct
            if (!check.found) {
                turns--;
                guessedexpr.setText(Integer.toString(turns));
                JOptionPane.showMessageDialog(frame,"Wrong Guess!");


            } else if ((check.found) &&(!check.complete)) {
                e1.setText(" " + hiddenExpression + " ");
                JOptionPane.showMessageDialog(frame,"Correct Guess!");
                String guessed = JOptionPane.showInputDialog(frame, p2.getText() + ", enter phrase to be guessed:");
                check.expression(guessed, expr1);
                turns--;
                guessedexpr.setText(Integer.toString(turns));

            } else if ((check.found) && (check.complete)) {
                guessedexpr.setText(Integer.toString(turns));
                e1.setText(" " + expr1 + " ");
                JOptionPane.showMessageDialog(frame,"Congrats you have guessed the phrase!");
                break;
            }
        }
        if(turns==0){
            JOptionPane.showMessageDialog(frame,"Turn over, you have not guessed the phrase!");
            JOptionPane.showMessageDialog(frame,"The phrase is "+expr1);
        }
        p1.setText(" "+player1Name+" ");
        p2.setText(" "+player2Name+" ");
        return turns;
    }

}






