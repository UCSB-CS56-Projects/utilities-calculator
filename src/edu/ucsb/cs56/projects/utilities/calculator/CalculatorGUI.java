package edu.ucsb.cs56.projects.utilities.calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.Math;
/** CalculatorGUI class which is a user interface for a calculator. 
 

@author Fengyu Wang
@version CS56, W15, UCSB

 */


public class CalculatorGUI extends JFrame{

    private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
    private JTextField displayField; // Displays our input and output
    private Calculator calculator = new Calculator(); // This is what will be peforming our actual operations

    private boolean startNumber = true; 
    private String previousOperation = "="; //previous operation 
    private boolean decimalPoint = false; //We don't start with a decimal point

    /** Reset is called by clear button action listener and elsewhere.*/
    private void reset() {
        startNumber = true;  
	decimalPoint = false;
        displayField.setText("0");
        previousOperation  = "=";
        calculator.setTotal("0");
    }

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
	JPanel extraPanel = new JPanel(); // where sin, cos, tan, x^2, sqrt, and binary converter

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


	//add buttons for extra panel, which include sin, cos, tan, x^2
	extraPanel.setLayout(new GridLayout(1, 6, 2, 2));

	//add button for sin
	ActionListener sinListener = new SinListener();
	JButton sin = new JButton("SIN");
	sin.addActionListener(sinListener);
	extraPanel.add(sin);
	sin.setFont(BIGGER_FONT);

	//add button for cos
	ActionListener cosListener = new CosListener();
	JButton cos = new JButton("COS");
	cos.addActionListener(cosListener);
	extraPanel.add(cos);
	cos.setFont(BIGGER_FONT);
	
	//add button for tan
	ActionListener tanListener = new TanListener();
	JButton tan = new JButton("TAN");
	tan.addActionListener(tanListener);
	extraPanel.add(tan);
	tan.setFont(BIGGER_FONT);
	
	//add button for x2
	ActionListener x2Listener = new X2Listener();
	JButton x2 = new JButton(" X²");
	x2.addActionListener(x2Listener);
	extraPanel.add(x2);
	x2.setFont(BIGGER_FONT);

	//add button for sqrt
	ActionListener sqrtListener = new SqrtListener();
	JButton sqrt = new JButton("sqrt");
	sqrt.addActionListener(sqrtListener);
	extraPanel.add(sqrt);
	sqrt.setFont(BIGGER_FONT);

	//add button for binary converter
	ActionListener biListener = new BiListener();
	JButton bi = new JButton("BI");
	bi.addActionListener(biListener);
	extraPanel.add(bi);
	bi.setFont(BIGGER_FONT);

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
	content.add(extraPanel,BorderLayout.SOUTH);

	content.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); 

	//Finish our JFrame
	this.setContentPane(content);
	this.pack();
	this.setTitle("Calculator");
	this.setResizable(false);
	this.setLocationRelativeTo(null);
    }// end of our constructor
		

		/**Action listener for sin */
	 	class SinListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
						String s = displayField.getText();
						double x = Math.sin(Double.parseDouble(s));
						displayField.setText("" + x);
				}
		}
		
		/**Action listener for cos*/
		class CosListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
						String s = displayField.getText();
						double x = Math.cos(Double.parseDouble(s));
						displayField.setText("" + x);
				}
		}

		/**Action listner for tan*/
		class TanListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
						String s = displayField.getText();
						double x = Math.tan(Double.parseDouble(s));
						displayField.setText("" + x);
				}
		}


		/**Action listener for x^2 */
		class X2Listener implements ActionListener{
				public void actionPerformed(ActionEvent e){
						String s = displayField.getText();
						double x = Double.parseDouble(s)*Double.parseDouble(s);
						displayField.setText("" + x);
				}
		}
	
		/**Action listener for sqrt*/
		class SqrtListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
						String s = displayField.getText();
						double x = Math.sqrt(Double.parseDouble(s));
						displayField.setText("" + x);
				}
		}


    
    	        /**Action listener for binary converter*/
		class BiListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
						String s = displayField.getText();
						int x = Integer.parseInt(s);
						if (x == 0) {
						    String binary = "0";
						    displayField.setText(binary);
						}
						else{
						String binary = "";
						while (x > 0) {
						    int rem = x % 2;
						    binary = rem + binary;
						    x = x / 2;
						}
						displayField.setText(binary);
						}
						
				}
		}

    /**Action listener for number keys and .
     */
    class NumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    String digit = e.getActionCommand(); //get our text from button

	    if (digit.equals(".") && !decimalPoint)
		return; 
	    
	    else if ( startNumber ){ //Is this the first number?
		//this is the first digit, so clear our field and set
		displayField.setText(digit);
		startNumber = false; //Now it's not our start number
		if (digit.equals("."))
				displayField.setText(displayField.getText() + ".");
		    decimalPoint = true; //To prevent two decimal points in input
		   
	    }

	    else {
		//Add our new digit to the end
		displayField.setText(displayField.getText() + digit);
                if (digit.equals("."))
                    decimalPoint = true; //To prevent two decimal points in input

        

	    }
	}
    }

    /**Action listener for plus minus button
     */
    class PlusMinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    String s = displayField.getText();

	    if ( s.equals("0"))
		return;

	    else if ( s.substring(0, 1).equals("-") )
		s = s.substring(1, s.length());
	    else 
		s = "-" + s;


	    displayField.setText(s);

	}
    }

    /**Action listener for inverse 1/x button
     */
    class InverseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


	    String s = displayField.getText();
	    double x = 1 / Double.parseDouble(s);
	    displayField.setText("" + x);



	}
    }

    /**Action listener for operator buttons +,-,/,*, and =
     */
    class OperatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    // The calculator is always in one of two states. We are expecting a number, or an operator.

            if (startNumber && ! previousOperation.equals("=")) { // Error message if we got an operator without a number unless it is equals
                //Expected a number, but got an operator.
                reset();
                displayField.setText("ERROR - No operator");
            } else {
                //Then we expect an operator.
		startNumber = true;  // Next thing we enter has to be a number
		decimalPoint = false; // Reset because it's a new number that must be entered next

                try {
                    // Get value from display field, convert, do prev op
                    // If this is the first op, _previousOp will be =.
                    String displayText = displayField.getText();
                    
                    if (previousOperation.equals("=")) {
                        calculator.setTotal(displayText);
                    } else if (previousOperation.equals("+")) {
                        calculator.add(displayText);
                    } else if (previousOperation.equals("-")) {
                        calculator.subtract(displayText);
                    } else if (previousOperation.equals("*")) {
                        calculator.multiply(displayText);
                    } else if (previousOperation.equals("/")) {
                        calculator.divide(displayText);
                    }
                    
                    displayField.setText("" + calculator.getTotalString());
                    
                } catch (NumberFormatException ex) {
                    reset();
                    displayField.setText("Error");
                }
                
                //Now we set previousOperation for the next operator.
                previousOperation = e.getActionCommand();
            }

	}
    }

    /**Action listener for DEL button
     */

    class delListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

	    if (startNumber)
		return; //do nothing

	    else {
		String s = displayField.getText();
		if (s.length() == 1){
		    reset(); // just reset it
		    return;
		}

		if ( s.substring(s.length() - 1, s.length()).equals("."))
		    decimalPoint = false;

		displayField.setText(s.substring(0, s.length() - 1)); // delete the last thing entered
		

	    }
				      
	}
    }

    /**Action listener for clear button
     */

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

	    reset();
	}
    }


    //======Finally our Main Method which fires up the calculator===============
    public static void main (String[] args){

	CalculatorGUI frame = new CalculatorGUI();
	frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	frame.setVisible(true);

    }

    

}
