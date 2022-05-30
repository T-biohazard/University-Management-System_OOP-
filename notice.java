package universitymanagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.util.Date;    
import javax.swing.JOptionPane;

public class notice {
    JFrame ntc;
   notice(){
       ntc=new JFrame();
       ntc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ntc.setSize(901,499);
		
		ntc.setLayout(null);
                ntc.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Notice Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(349, 0, 269, 39);
		ntc.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(110, 75, 703, 329);
		ntc.add(textPane);
                 JTextField textField = new JTextField();
		textField.setBounds(324, 44, 257, 20);
		ntc.add(textField);
		textField.setColumns(10);
                 JLabel time = new JLabel("TIME :");
		time.setBounds(798, 16, 49, 14);
		ntc.add(time);
		
		JLabel date_show = new JLabel("");
		date_show.setBounds(695, 47, 182, 14);
		ntc.add(date_show);
                Date dt=new Date();
                String dat=String.valueOf(dt);
                date_show.setText(dat);
		
		JButton btnNewButton = new JButton("Publish Notice");
		btnNewButton.setBounds(342, 415, 220, 23);
		ntc.add(btnNewButton);
                 btnNewButton.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	Date date=new Date(); 
                           String text=textField.getText();
                           String thenotice=textPane.getText();
                           
                           FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		
		try {
		    // fle= new File();
			 fwrite =new FileWriter("notice.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			
			pw.println(text);
                        pw.println("Date : "+dat);
                        pw.println(thenotice);
                        
                        bw.close();
			pw.close();
                        
                        
		}          catch (IOException ex) {
                               Logger.getLogger(notice.class.getName()).log(Level.SEVERE, null, ex);
                           }finally {
			
		}
                           
	         JOptionPane.showMessageDialog(ntc,"The Notice has been published!");        
	               }  
	            }); 
		
       
		
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(249, 47, 49, 14);
		ntc.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.setBounds(10, 12, 87, 32);
		ntc.add(btnNewButton_2);
                 btnNewButton_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       

	                	  ntc.setVisible(false);
	                	  pannel nw=new pannel();
	                      
	               }  
	            });
                 
                
                
   }
}
