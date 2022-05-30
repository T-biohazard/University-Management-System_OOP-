package universitymanagement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import static java.lang.System.in;
import java.util.logging.*;
import javax.swing.*;



public class course {
    private String CourseName;
    private String coursecode;
    private double courseCredit;
    private double courseCost;
    private String department;
    

    JFrame crse;
public    course() throws FileNotFoundException, IOException{
                crse=new JFrame();
		JLabel lblNewLabel = new JLabel("Course management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(375, -5, 246, 48);
		 crse.add(lblNewLabel);
                 JTextPane textPane = new JTextPane();
		textPane.setBounds(564, 107, 285, 263);
		 crse.add(textPane);
		
		JButton btnNewButton = new JButton("Add");
		 btnNewButton.setBounds(56, 224, 89, 23);
		 crse.add(btnNewButton);
                  btnNewButton.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                   crse.setVisible(false);
                           addCourse s=new addCourse();                            //done
                           
	                 }
	                      
	               } ); 
                  
                                                                   //scroll pan viweing code
                  JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(229, 107, 285, 263);
		 crse.add(scrollPane);
                 
                 final DefaultListModel<String> l1 = new DefaultListModel<>();  
       
                 FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("courseVIEW.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
                            if(!line.equals("AAAAA"))
				l1.addElement(line);
                            
                            
			}
			
		}finally {
			fw.close();
			    bf.close();
		}
         
           final JList<String> list = new JList<>(l1);
		scrollPane.setViewportView(list);
                                               //scroll pan viweing code
		                                                         //show details code
		JButton btnNewButton_1 = new JButton("Show Details");
		btnNewButton_1.setBounds(41, 173, 116, 23);
		 crse.add(btnNewButton_1);
               btnNewButton_1 .addActionListener(new ActionListener() {           // done
	               public void actionPerformed(ActionEvent e) {       
	                     
                                    if (list.getSelectedIndex() != -1) {                       
                      String  selected =list.getSelectedValue(); 
                                     
                       String line2=" ";
                       String line="";
                                int lineno=0;
                                boolean ans=true;
                               FileReader fw=null;
		           BufferedReader bf=null;
		try {
			fw=new FileReader("COURSEMAIN.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Code of Coure : "+selected;
                     
			while((line2=bf.readLine())!=null) {
                            if(line2.equals(original)){
                                ans=false;
                               lineno++;
                            }
                            if(ans==false && lineno<=6){
                                 line=line+"\n"+line2;  // && !line.equals("END")
                                  lineno++;
                            }
				
			}
                        fw.close();
			bf.close();
			
		}              catch (FileNotFoundException ex) {
                                  
                               }        catch (IOException ex) {
                                            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
                                        }finally {
			
		} 
                          
                       
                           textPane.setText(line);        
     
                           }
                             
                           
                           
                           
	                 }
	                      
	               } );                                              //show details code
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(56, 272, 89, 23);
		 crse.add(btnNewButton_2);
                  btnNewButton_1 .addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     
                           
                           
                                     if (list.getSelectedIndex() != -1) {                       
                     String  selected = list.getSelectedValue(); 
                       //file writing
                       
                FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		
		FileReader fw=null;
		BufferedReader bf=null;
                String content="";
		try {
			fw=new FileReader("courseVIEW.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
				content+=line+"\n";
			}
                        
                        fw.close();
			bf.close();
			
		} catch (IOException ex) {
                                           
                  }finally {
			
		}
                
                
               
                content=content.replaceAll(selected,"AAAAA");
                
              //  writing
              
            
		try {
		    // fle= new File();
			 fwrite =new FileWriter("courseVIEW.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			pw.println(content);
                        
                        bw.close();
			pw.close();
		}catch (IOException ex) {
                    
                                         }
                       
                              }
                           
                           
	                 
	                      
                       } } ); 
		
		
		
             JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(713, 70, 136, 20);
		 crse.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Course List");
		lblNewLabel_1.setBounds(332, 88, 105, 14);
		 crse.add(lblNewLabel_1);
		
		JButton btnNewButton_2_1 = new JButton("<Back");
		btnNewButton_2_1.setBounds(10, 7, 87, 32);
		 crse.add(btnNewButton_2_1);
                 btnNewButton_2_1.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                       crse.setVisible(false);
                               pannel pnl=new pannel();
	                 }
	                      
	               } ); 
	        
		
		JButton btnNewButton_1_1 = new JButton("Update List");
		btnNewButton_1_1.setBounds(308, 387, 124, 23);
		 crse.add(btnNewButton_1_1);
                 btnNewButton_1_1 .addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     
                                    l1.clear();
                 
                FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("courseVIEW.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
                            if(!line.equals("AAAAA"))
				l1.addElement(line);
			}
                           fw.close();
			   bf.close();
			
		}          catch (FileNotFoundException ex) {
                               Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
                           } catch (IOException ex) {
                               Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
                           }finally {
			  
		}
         
           final JList<String> list = new JList<>(l1);
                     
                       }} ); 
		
		JButton btnNewButton_3 = new JButton("Search by code :");
		btnNewButton_3.setBounds(567, 69, 136, 23);
		 crse.add(btnNewButton_3);
                  btnNewButton_3 .addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     
                            String show=textField.getText();
                                  String line2=" ";
                             String line="";
                                int lineno=0;
                                boolean ans1=true;
                               FileReader fw=null;
		           BufferedReader bf=null;  
                           boolean confirm=false;
                           
                         try {
			fw=new FileReader("COURSEMAIN.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Code of Coure : "+show;
                        
			while((line2=bf.readLine())!=null) {
                            if(line2.equals(original)){
                                ans1=false;
                                confirm=true;
                               lineno++;
                            }
                            if(ans1==false && lineno<=6){
                                 line=line+"\n"+line2;  // && !line.equals("END")
                                  lineno++;
                            }
				
			}
                        fw.close();
			bf.close();
			
		} catch (FileNotFoundException ex) {
                                  
                               } catch (IOException ex) {
                               Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
                           }finally {
			
		}         
                           
                          if(confirm==false){
                   JOptionPane.showMessageDialog(crse,"Not Found! , Enter correct CODE");
                          }
                          else
                       textPane.setText(line);           
                        
						
						
	                      
                       } } ); 
		
		
                
                crse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crse.setSize(901,499);
		crse.setLayout(null);
                crse.setVisible(true);
        
        
    }

   
    
    course(String CourseName,String coursecode,double courseCost,double courseCredit,String department) {
        this.CourseName = CourseName;
        this.coursecode=coursecode;
        this.courseCost=courseCost;
        this.courseCredit=courseCredit;
        this.department=department;
    }
     course(String coursecode) {       
        this.coursecode=coursecode;
    }

    public String getCourseName() {
        return CourseName;
    }
     public String getcoursecode() {
        return coursecode;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
     public void setcoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    @Override
    public String toString() {
        return "Code of Coure : "+coursecode+"\n"+"Name of course : " + getCourseName()+"\n"+"Department :"+department+"\n"+"Course Credit: "+courseCredit+
                    "\n"+"Course Cost : "+courseCost+"\n"+"Total Semester Cost :"+courseCost*courseCredit;

    }

}
class addCourse{
    JFrame adc;
    addCourse(){
        adc=new JFrame();
        adc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adc.setSize(901,499);
                
		
		adc.setLayout(null);
                adc.setVisible(true);
		
		JLabel lblCourseDetails = new JLabel("Course Details");
		lblCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourseDetails.setBounds(392, 0, 220, 45);
		adc.add(lblCourseDetails);
		
		JLabel lblCourseName = new JLabel("Course Name :");
		lblCourseName.setBounds(251, 96, 91, 14);
		adc.add(lblCourseName);
		
        JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(352, 89, 208, 29);
		adc.add(textField);
		
        JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(352, 148, 208, 29);
		adc.add(textField_1);
		
        JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(352, 204, 208, 29);
		adc.add(textField_2);
		
        JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(352, 267, 208, 29);
		adc.add(textField_3);
		
        JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(352, 330, 208, 29);
		adc.add(textField_4);
		
		JLabel lblCourseCode = new JLabel("Course Code :");
		lblCourseCode.setBounds(251, 155, 91, 14);
		adc.add(lblCourseCode);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setBounds(251, 211, 91, 14);
		adc.add(lblDepartment);
		
		JLabel lblCredit = new JLabel("Credit :");
		lblCredit.setBounds(251, 274, 91, 14);
		adc.add(lblCredit);
		
		JLabel lblCourseCost = new JLabel("Course Cost :");
		lblCourseCost.setBounds(251, 337, 91, 14);
		adc.add(lblCourseCost);
                
                
                
                
                
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(417, 397, 89, 23);
		adc.add(btnNewButton);
                btnNewButton.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     
                           String name=textField.getText();
                           String code=textField_1.getText();
                           String ept=textField_2.getText();
                           String crdt=textField_3.getText();
                           String cost=textField_4.getText();
                           double cst=Double.parseDouble(cost);
                           double cr=Double.parseDouble(crdt);
                           
                       course c=new course(name,code,cst,cr,ept);
                       String print=c.toString();
                           
                FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		                                 
                        
		try {
		   
			 fwrite =new FileWriter("COURSEMAIN.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
                         pw.println(print);
                         
                         bw.close();
			pw.close();
			
		}          catch (IOException ex) {
                               Logger.getLogger(addCourse.class.getName()).log(Level.SEVERE, null, ex);
                           }finally {
			
		}
              
                
                
                  try {

                         fwrite =new FileWriter("courseVIEW.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
                         pw.println(code);
			
                         bw.close();
			pw.close();
			
		}          catch (IOException ex) {
                               Logger.getLogger(addCourse.class.getName()).log(Level.SEVERE, null, ex);
                           }finally {
			
		}
            
                             adc.setVisible(false);
                             try{
                                  course cf=new course();
                             }catch(IOException eee){
                                 
                             }
                            
                       
                           
	                 }
	                      
	               } ); 
                
                
                
                
                
                JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.setBounds(10, 15, 87, 32);
		adc.add(btnNewButton_2);
                btnNewButton_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     adc.setVisible(false);
                             try{
                                course cf=new course();  
                             }catch(IOException ee){
                                 
                             }
                            
                           
	                 }
	                      
	               } ); 
    }
}
