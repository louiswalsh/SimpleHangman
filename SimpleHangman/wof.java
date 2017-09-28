
//This is the WOF class where the guess is compared with the original expression to check if the guess is right or wrong

package com.company;

import javax.swing.*;

public class wof {
    protected boolean found = false;
    protected boolean complete=false;
    public  StringBuffer checkguess(StringBuffer hiddenExpression, char characterGuess, String expr1) {

        for (int i = 0; i < hiddenExpression.length(); i++) {  // loop to check each letter if the guessed letter is present or not
            if (expr1.charAt(i) == characterGuess) {
                hiddenExpression.setCharAt(i, characterGuess); // if present the asterisk is replaced by the letter
                found = true;

            } if (expr1.equals(hiddenExpression.toString())) {   // control statement to check if the guessed expression is the same as the original
                complete = true;
            }

        }
        return hiddenExpression;  // returns the hidden expression
    }
    public boolean expression(String guessed,String expr1){
        if (guessed.equals(expr1)){                 // control statement to check if the guessed expression is the same as the original
            complete=true;
        }else{JOptionPane.showMessageDialog(null,"Wrong Guess!");}      //message box to show wrong guess
        return complete; //returns boolean complete
    }
}
