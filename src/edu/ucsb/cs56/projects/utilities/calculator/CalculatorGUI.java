package edu.ucsb.cs56.projects.utilities.calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/** CalculatorGUI class which is a user interface for a calculator. 
 

@author Roeland Singer-Heinze
@version CS56, S13, UCSB

 */


public class CalculatorGUI extends JFrame{

    private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
    private JTextField displayField; // Displays our input and output
    private Calculator calculator = new Calculator(); // This is what will be peforming our actual operations


    /** Constructor for CalculatorGUI class.

     */

    public CalculatorGUI(){

	//Set our attributes for the display field
        displayField = new JTextField("0", 12);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(BIGGER_FONT);
	displayField.setEditable(false);

	JPanel buttonPanel = new JPanel(); //Where our numberic buttons will be including '.' and '+-'
	JPanel operatorPanel = new JPanel(); //Where our operators /, *, -, + will be
	JPanel keyPanel = new JPanel(); //Where our =, del, and c (clear) keys will be and 1/x as well

        //add buttons for 1 through 9
	ActionListener numListener = new NumListener(); //This is for all numeric buttons and '.'

        buttonPanel.setLayout(new GridLayout(4,3,2,2)); //Want little gaps between buttons
	String s = "7894561230."; //These are the buttons that go in buttonPanel \u00B1 is '+-'

        for(int i=0; i<s.length(); i++) {
            String label = s.substring(i,i+1); 
            JButton jb = new JButton(label);
            buttonPanel.add(jb);
	    jb.addActionListener(numListener); //Put a digit in the interface
	    jb.setFont(BIGGER_FONT);
        }

	//Now to add a plus minus key with its own action listener
	ActionListener plusMinusListener = new PlusMinusListener(); //Add negative sign basically

	JButton pm = new JButton("\u00B1");
	buttonPanel.add(pm);
	pm.addActionListener(plusMinusListener); //put a negative sign in interface
	pm.setFont(BIGGER_FONT); 

	//add buttons for operator panel and ActionListener
	ActionListener operatorListener = new OperatorListener();

	operatorPanel.setLayout(new GridLayout(4, 1, 2, 2));
	String[] op = {"/", "*", "-", "+"};
	for (int i=0; i<op.length; i++){
	    JButton jb = new JButton(op[i]);
	    jb.addActionListener(operatorListener);
	    jb.setFont(BIGGER_FONT);
	    operatorPanel.add(jb);
	}


	//add buttons for key panel, which includes 1/x
	keyPanel.setLayout(new GridLayout(4, 1, 2, 2));

	//add button for clear
        ActionListener clearListener = new ClearListener();
        JButton clear = new JButton("C");
        clear.addActionListener(clearListener);
        clear.setFont(BIGGER_FONT);
        keyPanel.add(clear);


	//add button for delete
        ActionListener delListener = new delListener();
        JButton del = new JButton("DEL");
        del.addActionListener(delListener);
        del.setFont(BIGGER_FONT);
        keyPanel.add(del);

	//add button for inverse
	ActionListener inverseListener = new InverseListener();
        JButton inverse = new JButton("1/x");
        inverse.addActionListener(inverseListener);
        inverse.setFont(BIGGER_FONT);
        keyPanel.add(inverse);

	//add button for equals sign
	JButton equalSign = new JButton("=");
	equalSign.addActionListener(operatorListener);
	equalSign.setFont(BIGGER_FONT);
	keyPanel.add(equalSign);


	//Layout the top-level panel
	JPanel content = new JPanel();
	content.setLayout(new BorderLayout(5,5));
	content.add(displayField, BorderLayout.NORTH);
	content.add(buttonPanel, BorderLayout.WEST);
	content.add(operatorPanel,BorderLayout.CENTER);
	content.add(keyPanel,BorderLayout.EAST);

	content.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); 

	//Finish our JFrame
	this.setContentPane(content);
	this.pack();
	this.setTitle("Calculator");
	this.setResizable(false);
	this.setLocationRelativeTo(null);
    }// end of our constructor


    /**Action listener for number keys and .
     */
    class NumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	}
    }

    /**Action listener for plus minus button
     */
    class PlusMinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	}
    }

    /**Action listener for inverse 1/x button
     */
    class InverseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

	}
    }

    /**Action listener for operator buttons +,-,/,*, and =
     */
    class OperatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

	}
    }

    /**Action listener for DEL button
     */

    class delListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**Action listener for clear button
     */

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

	}
    }


    //======Finally our Main Method which fires up the calculator===============
    public static void main (String[] args){

	CalculatorGUI frame = new CalculatorGUI();
	frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	frame.setVisible(true);

    }



}
