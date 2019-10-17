/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agecalculator;

/**
 *
 * @author galib
 */

//A simple java program to calculate age

import java.time.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AgeCalculator{
	static JTextField t1;
	static JTextField t2;
	static JTextField t3;

	public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);

        JLabel l1 = new JLabel("Enter Birth Date:");
        pane.add(l1);
        Insets insets = pane.getInsets();
        Dimension size = l1.getPreferredSize();
        l1.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);

        t1 = new JTextField();
        pane.add(t1);
        insets = pane.getInsets();
        size = t1.getPreferredSize();
        t1.setBounds(155 + insets.left, 5 + insets.top, 100, size.height);

        JLabel l2 = new JLabel("Enter Birth Month:");
        pane.add(l2);
        insets = pane.getInsets();
        size = l2.getPreferredSize();
        l2.setBounds(25 + insets.left, 35 + insets.top, size.width, size.height);

        t2 = new JTextField();
        pane.add(t2);
        insets = pane.getInsets();
        size = t2.getPreferredSize();
        t2.setBounds(155 + insets.left, 35 + insets.top, 100, size.height);

        JLabel l3 = new JLabel("Enter Birth Year:");
        pane.add(l3);
        insets = pane.getInsets();
        size = l3.getPreferredSize();
        l3.setBounds(25 + insets.left, 65 + insets.top, size.width, size.height);

        t3 = new JTextField();
        pane.add(t3);
        insets = pane.getInsets();
        size = t3.getPreferredSize();
        t3.setBounds(155 + insets.left, 65 + insets.top, 100, size.height);


        JButton b1 = new JButton("Calculate");
        b1.addActionListener((ActionEvent e) -> {
            calculateAge();
        });
        pane.add(b1);
        insets = pane.getInsets();
        size = b1.getPreferredSize();
        b1.setBounds(100 + insets.left, 125 + insets.top, size.width, size.height);

    }

 	/// Main Calculation Body
	public static void calculateAge(){
		int date = Integer.parseInt(t1.getText());
		int month = Integer.parseInt(t2.getText());
		int year = Integer.parseInt(t3.getText());


		try{
			LocalDate birthdate= LocalDate.of(year, month, date);
                        LocalDate currentdate = LocalDate.now();
                        try{
                                int ageYears = Period.between(birthdate, currentdate).getYears();
                                int ageMonths = Period.between(birthdate, currentdate).getMonths();
                                int ageDays = Period.between(birthdate, currentdate).getDays();

                                if(ageYears<0 || ageMonths<0 || ageDays<0)
                                throw new java.time.DateTimeException("You are not born yet...");

                                 else{
                                    JOptionPane.showMessageDialog(null,"Your Age is: "+ ageYears + " years "+ageMonths + " months and "+ ageDays + " days ");
                                }
                        }
                        catch(java.time.DateTimeException e){
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning!!!", 2);
                            //System.exit(0);
                        }
		}
		catch(java.time.DateTimeException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Warning!!!", 2);
			//System.exit(0);
		}
	}


    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        Insets insets = frame.getInsets();
        //frame.setSize(300 + insets.left + insets.right,
                      //200 + insets.top + insets.bottom);
        frame.setBounds(525,300,300,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}
