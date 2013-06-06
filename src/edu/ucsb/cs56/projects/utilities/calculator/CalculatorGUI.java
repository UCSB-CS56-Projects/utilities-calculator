package edu.ucsb.cs56.projects.utilities.calculator;
import java.awt.*;
import javax.swing.*;

/** CalculatorGUI class which is a user interface for a calculator. This is only the main method, which brings up the window for the calculator. 

@author Roeland Singer-Heinze
@version CS56, S13, UCSB

 */


public class CalculatorGUI extends JFrame{



    public static void main (String[] args){

	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);






	frame.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	frame.setSize(300, 500);
	frame.setVisible(true);

    }



}
