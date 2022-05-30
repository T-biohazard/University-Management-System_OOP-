package universitymanagement;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class faculty  implements salary{ //interface

    private String FacultyName, FacultyId, Phone, OfficeHour, Mail;
    int salari;
    JFrame fc;
    
    faculty() throws FileNotFoundException, IOException{
        fc=new JFrame();
        fc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fc.setSize(901, 499);
		fc.setLayout(null);
                fc.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Faculty mangement");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(341, 11, 254, 46);
		fc.add(lblNewLabel);
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Faculty List");
		lblNewLabel_1.setBounds(338, 92, 105, 14);
		fc.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(49, 215, 89, 23);
		fc.add(btnNewButton);
                  btnNewButton.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	  fc.setVisible(false);
	                	addfac ad=new addfac();
	                      
	               }  
	            }); 
                
		
		
		
        JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(706, 69, 136, 20);
		fc.add(textField);
		
		JButton btnNewButton_2_1 = new JButton("<Back");
		btnNewButton_2_1.setBounds(10, 11, 87, 32);
		fc.add(btnNewButton_2_1);
                 btnNewButton_2_1.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	  fc.setVisible(false);
	                	  pannel nw=new pannel();
	                      
	               }  
	            }); 
		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(561, 117, 281, 245);
		fc.add(textPane);
		
		
		
		
                                                      //viewing is done
                 JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 117, 239, 245);
		fc.add(scrollPane);
                 final DefaultListModel<String> l1 = new DefaultListModel<>();  
       
                 FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("facultyView.txt"); //Add faculty read
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
                            if(!line.equals("AAAAA"))
				l1.addElement(line);
			}
			
                        fw.close();
			bf.close();
		}finally {
			
		}
         
           final JList<String> list = new JList<>(l1);//fact list ... generics
		scrollPane.setViewportView(list); 
                JButton btnNewButton_1_2 = new JButton("Show Details");
		btnNewButton_1_2.setBounds(37, 162, 116, 23);
		fc.add(btnNewButton_1_2);
                btnNewButton_1_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {  //work swing button     
	                
                  if (list.getSelectedIndex() != -1) {                       
                      String  selected =list.getSelectedValue(); 
                                     
                       String line2=" ";
                       String line="";
                                int lineno=0;
                                boolean ans=true;
                               FileReader fw=null;
		           BufferedReader bf=null;
		try {
			fw=new FileReader("facultyMAIN.txt");//main to search by id fact read 
			bf= new BufferedReader(fw);
                       
			 String original="Faculty Id   :"+selected;
                     
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
                        
			
		} catch (FileNotFoundException ex) {
                                  
                               } catch (IOException ex) {

                           }
                            textPane.setText(line); 
	                      
                  }
                       }}); 
                       
                JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(49, 280, 89, 23);
		fc.add(btnNewButton_2);
                btnNewButton_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
  
                if (list.getSelectedIndex() != -1) {                       
                     String  selected = list.getSelectedValue(); 
                     
                       
                FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		
		FileReader fw=null;
		BufferedReader bf=null;
                String content="";
		try {
			fw=new FileReader("facultyView.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
				content+=line+"\n";
			}
                        
                        fw.close();
			bf.close();
			
		}   catch (FileNotFoundException ex) {
                        Logger.getLogger(faculty.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(faculty.class.getName()).log(Level.SEVERE, null, ex);
                    }finally {
			
		}
                
                
               
                content=content.replaceAll(selected,"AAAAA");  //replace
                
              //  writing
              
            
		try {   //faculty info write
		    // fle= new File();
			 fwrite =new FileWriter("facultyView.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			pw.println(content);
                        
                        bw.close();
			pw.close();
		}   catch (IOException ex) {
                        Logger.getLogger(faculty.class.getName()).log(Level.SEVERE, null, ex);
                    }finally {
			
		}
                           }
	                      
	               }  
	            }); 
                JButton btnNewButton_1_1 = new JButton("Update List");
		btnNewButton_1_1.setBounds(309, 386, 124, 23);
		fc.add(btnNewButton_1_1);
                btnNewButton_1_1.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                	
                             l1.clear();
                 
                FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("facultyView.txt");
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
                
	                      
	               }  
	            }); 
                
		JButton btnNewButton_3 = new JButton("Search by ID :"); //6 line show
		btnNewButton_3.setBounds(562, 68, 120, 23);
		fc.add(btnNewButton_3);
                 btnNewButton_3.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	
                              String show=textField.getText();
                         
                            
                    String line2=" ";
                             String line="";
                                int lineno=0;
                                boolean ans1=true;
                               FileReader fw=null;
		           BufferedReader bf=null;  
                           boolean confirm=false;
                           
                         try {                                 //adding
			fw=new FileReader("facultyMAIN.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Faculty Id   :"+show;
                        
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
                   JOptionPane.showMessageDialog(fc,"Not Found! , Enter correct CODE");
                          }
                          else
                       textPane.setText(line);  
	                      
	               }  
	            }); 
                 
    }

    faculty(String FacultyName, String FacultyId, String Phone, int salari, String Mail) {
        this.FacultyName = FacultyName;
        this.FacultyId = FacultyId;
        this.Phone = Phone;
        this.salari = salari;
      
        this.Mail = Mail;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String FacultyId) {
        this.FacultyId = FacultyId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getSalary() {
        return salari;
    }

    public void setSalary(int salari) {
        this.salari = salari;
    }

    public String getOfficeHour() {
        return OfficeHour;
    }

    public void setOfficeHour(String OfficeHour) {
        this.OfficeHour = OfficeHour;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }
    @Override                 //run.poly
    public String  Annualincome() {
        int an=salari*12;
        String hb=String.valueOf(an);
         return hb;
    }

    @Override
    public String toString() {
        return "Faculty Id   :" + getFacultyId() +"\nFaculty Name    :" + getFacultyName() +  "\nFaculty Phone   :" + getPhone()
                + "\nFaculty  Salary  :" + getSalary() + "\nFaculty Mail    :" + getMail()+"\nAnnualIncome : "+Annualincome();
    }

}
class addfac{
    JFrame af;
        addfac(){
            af=new JFrame();
       af. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		af.setSize(901,499);
		af.setLayout(null);
                af.setVisible(true);
		
		JLabel lblFacultyDetails = new JLabel("Faculty Details");
		lblFacultyDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFacultyDetails.setBounds(376, 0, 220, 45);
		af.add(lblFacultyDetails);
		
        JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(342, 114, 208, 29);
		af.add(textField);
		
        JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(342, 180, 208, 29);
		af.add(textField_1);
		
        JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 235, 208, 29);
		af.add(textField_2);
		
        JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(342, 295, 208, 29);
		af.add(textField_3);
		
		JLabel lblFacultyName = new JLabel("Faculty Name :");
		lblFacultyName.setBounds(251, 121, 91, 14);
		af.add(lblFacultyName);
		
		JLabel lblFacultyId = new JLabel("Faculty ID :");
		lblFacultyId.setBounds(251, 187, 91, 14);
		af.add(lblFacultyId);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(251, 242, 91, 14);
		af.add(lblPhone);
		
		JLabel lblSalary = new JLabel("Salary  :");
		lblSalary.setBounds(264, 302, 91, 14);
		af.add(lblSalary);
		
		JLabel lblSalary_1 = new JLabel("E-Mail  :");
		lblSalary_1.setBounds(251, 359, 91, 14);
		af.add(lblSalary_1);
		
        JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(342, 352, 208, 29);
		af.add(textField_4);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(410, 412, 89, 23);
		af.add(btnNewButton);
                JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.setBounds(20, 15, 87, 32);
		af.add(btnNewButton_2);
                btnNewButton_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     af.setVisible(false);
                             try{
                                faculty cf=new faculty();  
                             }catch(IOException ee){
                                 
                             }
                            
	                 }
	                      
	               } ); 
                
                btnNewButton.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	
                           String name=textField.getText();
                           String id=textField_1.getText();
                           String phone=textField_2.getText();
                           String slry=textField_3.getText();
                           String mail=textField_4.getText();
                           int sl=Integer.parseInt(slry);
                           
                         salary fac=new faculty(name,id,phone,sl,mail); //ifterface
                         
                           String print=fac.toString();   //*********print ta file e write
                          
                            FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
                          try {
		   
			 fwrite =new FileWriter("facultyMAIN.txt",true);
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

                   fwrite = new FileWriter("facultyView.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
                         pw.println(id);
			
                         bw.close();
			pw.close();
			
		}          catch (IOException ex) {
                               Logger.getLogger(addCourse.class.getName()).log(Level.SEVERE, null, ex);
                           }finally {
			
		}
            
                             af.setVisible(false);
                           try { 
                               faculty cf=new faculty();
                           } catch (IOException ex) {
                               Logger.getLogger(addfac.class.getName()).log(Level.SEVERE, null, ex);
                           }
                           
                           
	                      
	               }  
	            }); 
    }
}
