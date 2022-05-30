package universitymanagement;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class pannel {
	JFrame pnl;	
	public pannel() {
		pnl=new JFrame("MainPanel");				
		JLabel lblNewLabel = new JLabel("East West University");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(328, 11, 325, 33);
		pnl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("University authority access only!");
		lblNewLabel_1.setBounds(353, 437, 197, 14);
		pnl.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Courses");
	
		btnNewButton.setBounds(162, 161, 89, 23);
		pnl.add(btnNewButton);
                btnNewButton.addActionListener((ActionEvent e) -> {
                    pnl.setVisible(false);
                    try {
                        course crse=new course();
                    } catch (IOException ex) {
                       
                    }
                }); 
                
             //    pnl.setVisible(false);
                             
	        
		
		JButton btnNewButton_1 = new JButton("Faculty");
		
		btnNewButton_1.setBounds(619, 161, 89, 23);
		pnl.add(btnNewButton_1);
                 btnNewButton_1.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	  pnl.setVisible(false);
                           try {      
                               faculty nw=new faculty();
                           } catch (IOException ex) {
                              
                           }
	               }  
	            }); 
		
		JButton btnNewButton_2 = new JButton("Student Management");
		btnNewButton_2.setBounds(368, 161, 158, 23);
		pnl.add(btnNewButton_2);
                btnNewButton_2.addActionListener((ActionEvent e) -> {
                    pnl.setVisible(false);
                    try {
                        student std=new student();
                    } catch (IOException ex) {
                       
                    }
                }); 
		
		
		JButton btnNewButton_4 = new JButton("Payment");
		btnNewButton_4.setBounds(292, 228, 118, 23);
		pnl.add(btnNewButton_4);
                btnNewButton_4.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                       pnl.setVisible(false);
                             payment pt=new payment();
	                 }
	                      
	               } );
               
		
		JButton btnNewButton_1_1 = new JButton("Notice Board");
		btnNewButton_1_1.setBounds(472, 228, 118, 23);
		pnl.add(btnNewButton_1_1);
                 btnNewButton_1_1.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                       pnl.setVisible(false);
                               notice stt=new notice();
	                 }
	                      
	               } );
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to main panel!");
		lblNewLabel_2.setBounds(379, 55, 197, 14);
		pnl.add(lblNewLabel_2);
                
                JButton btnNewButton_5 = new JButton("Sign out!");
		btnNewButton_5.setBounds(389, 403, 89, 23);
		pnl.add(btnNewButton_5);
                   btnNewButton_5.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                       pnl.setVisible(false);
                               startmenu stt=new startmenu();
	                 }
	                      
	               } ); 
	        
		
		pnl.setSize(901,499); //frame
		pnl.setLayout(null);  //frame
		pnl.setVisible(true);  //frame
		pnl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
	}

}
