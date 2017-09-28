/*
This is the MakeHiddenExpression class which converts the inputted expression into a hidden format
*/
package com.company;

class makeHiddenExpresion {
    public static StringBuffer makeHiddenExpression(String expr){        //method with the parameter expr where the phrase is converted into astriks
        StringBuffer hiddenExpr = new StringBuffer(expr);
        for (int i = 0; i < expr.length(); i++)                     // loop to convert each letter to asteriks
            if (expr.charAt(i) == '\'' || expr.charAt(i) == ' ')        // exceptions to the asteriks
                hiddenExpr.setCharAt(i, expr.charAt(i));
            else
                hiddenExpr.setCharAt(i, '*');           // replacing the letter with asetriks
        return hiddenExpr;
    }
}
