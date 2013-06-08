package edu.ucsb.cs56.projects.utilities.calculator;
import java.awt.*;
import javax.swing.*;

/** Calculator class is the implementation of a simple calculator which peforms addition, subtraction, division, and multiplication, inverse, and any other calculator operations.

@author Roeland Singer-Heinze
@version CS56, S13, UCSB

*/

public class Calculator{

    private double total; // Only need this number

    /** Constructor
     */

    public Calculator(){
	total = 0;
    }

    /**
totalString converts our double total into a string
     */

    public String getTotalString(){
	return "" + total;
    }



    /** setTotal sets total to number given a string */

    public void setTotal(String n){
	total = Double.parseDouble(n);
    }

    /** add just adds number to total given a string */

    public void add(String n){
	total += Double.parseDouble(n);
    }

    /** subtract just subtracts number from total given a string */

    public void subtract(String n){
	total -= Double.parseDouble(n);
    }

    /** multiply just multiplies total by a number given a string */

    public void multiply(String n){
	total *= Double.parseDouble(n);
    }

    /** divide just divides total by a number given a string */

    public void divide(String n){
	total /= Double.parseDouble(n);
    }

}
