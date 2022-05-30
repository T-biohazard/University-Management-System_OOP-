package universitymanagement;
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class startmenu{          //login panel
    JFrame f;
	    startmenu(){
	f=new JFrame("LogIn Page");    
	    final JLabel label = new JLabel();            
	    label.setBounds(20,150, 200,50);  
	    final JPasswordField value = new JPasswordField();   
	    value.setBounds(100,75,100,30);   
	    JLabel l1=new JLabel("Username:");    
	       l1.setBounds(20,20, 80,30);    
	       JLabel l2=new JLabel("Password:");    
	       l2.setBounds(20,75, 80,30);    
	       JButton b = new JButton("Login");  
	       b.setBounds(100,120, 80,30);    
	       final JTextField text = new JTextField();  
	       text.setBounds(100,20, 100,30);    
	               f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);  
	               f.setSize( 450, 300);    
	               f.setLayout(null);    
	               f.setVisible(true);     
	               b.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                  String user =text.getText();  
	                 String pass= new String(value.getPassword()); 
	                 System.out.println(pass);
	                 if(user.equals("1") && pass.equals("1")) {
                             
	                	  f.setVisible(false);
	                	  pannel nw=new pannel();
	                	
	                 }
	                      
	               }  
	            });   

	}
	   
}

public class UniversityManagement {

    public static void main(String[] args) {
        startmenu st=new startmenu();
    }

}
