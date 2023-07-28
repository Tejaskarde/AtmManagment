package Banking_Managment_System;

//connection jdbc connection
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;

import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {

     
     JTextField pan,aadharNumField;
      
     JButton next;
     JRadioButton syes,sNo,eyes,eNo;
    
     JComboBox religion,Catagory,Occupation,education,Income;
     String formno;

    SignupTwo(String formno){
        this.formno = formno;
      setLayout(null);
   
       setTitle("New Account APPLICATION FORM - Page 2");

    
      JLabel additionalDetail = new JLabel("Page 2: Additional Details");
      additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
      additionalDetail.setBounds(290, 80, 400, 30);
      add(additionalDetail);
    

      JLabel name = new JLabel("Religion:");
      name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100, 140, 100, 30);
      add(name);
        // to create rollabel box pop box   
        String[] valReligion = {"Hindu","Muslim","Sikh","Buddha","other"};   
        religion = new JComboBox(valReligion);
       religion.setBounds(300,140,400,30);
       religion.setBackground(Color.WHITE);
       add(religion);

       
       
      JLabel fname = new JLabel("Catagory:");
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100, 190, 200, 30);
      add(fname);
      String valCatagory[] = {"Genral","OBC","SC","ST","Other"};
       Catagory = new JComboBox(valCatagory);
      Catagory.setBounds(300,190,400,30);
      Catagory.setBackground(Color.WHITE);
      add(Catagory);
      
      JLabel dob = new JLabel("Income:");
      dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100, 240, 200, 30);
      add(dob);
      String incomeCatagory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
       Income = new JComboBox(valCatagory);
      Income.setBounds(300,240,400,30);
      Income.setBackground(Color.WHITE);
      add(Income);
        
      JLabel gender = new JLabel("Educational:");
      gender.setFont(new Font("Raleway",Font.BOLD,20));
      gender.setBounds(100, 290, 200, 30);
      add(gender);

      JLabel email = new JLabel("Qulification:");
      email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100, 315, 200, 30);
      add(email);
      String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
       education = new JComboBox(educationValues);
      education.setBounds(300,315,400,30);
      education.setBackground(Color.WHITE);
      add(education);


      JLabel marital = new JLabel("Occupation:");
      marital.setFont(new Font("Raleway",Font.BOLD,20));
      marital.setBounds(100, 390, 200, 30);
      add(marital);
      String OccupationValues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
       Occupation = new JComboBox(OccupationValues);
      Occupation.setBounds(300,390,400,30);
      Occupation.setBackground(Color.WHITE);
      add(Occupation);
     

      JLabel address = new JLabel("Pan Number:");
      address.setFont(new Font("Raleway",Font.BOLD,20));
      address.setBounds(100, 440, 200, 30);
      add(address);
       pan = new JTextField();
       pan.setFont(new Font("Raleway",Font.BOLD,14));
       pan.setBounds(300,440,400,30);
      add(pan);


      JLabel aadharNum = new JLabel("Aadhar Number:");
      aadharNum.setFont(new Font("Raleway",Font.BOLD,20));
      aadharNum.setBounds(100, 490, 200, 30);
      add(aadharNum);
      aadharNumField = new JTextField();
      aadharNumField.setFont(new Font("Raleway",Font.BOLD,14));
      aadharNumField.setBounds(300,490,400,30);
      add(aadharNumField);


      JLabel Senior = new JLabel("Senior Citizen:");
      Senior.setFont(new Font("Raleway",Font.BOLD,20));
      Senior.setBounds(100, 540, 200, 30);
      add(Senior);
      syes = new JRadioButton("Yes");
      syes.setBounds(300,540,100,30);
      syes.setBackground(Color.WHITE);
      add(syes);
      sNo = new JRadioButton("No");
      sNo.setBounds(450,540,100,30);
      sNo.setBackground(Color.WHITE);
      add(sNo);

      ButtonGroup newYesNogroup = new ButtonGroup();
      newYesNogroup.add(syes);
      newYesNogroup.add(sNo);
    
      

      JLabel pincode = new JLabel("Exisiting Account:");
      pincode.setFont(new Font("Raleway",Font.BOLD,20));
      pincode.setBounds(100, 590, 200, 30);
      add(pincode);
      eyes = new JRadioButton("Yes");
      eyes.setBounds(300,590,100,30);
      eyes.setBackground(Color.WHITE);
      add(eyes);
      eNo = new JRadioButton("No");
      eNo.setBounds(450,590,100,30);
      eNo.setBackground(Color.WHITE);
      add(eNo);

      ButtonGroup newYesNogroup2 = new ButtonGroup();
      newYesNogroup2.add(eyes);
      newYesNogroup2.add(eNo);




      /// End of page next button
       next = new JButton("Next");
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway", Font.BOLD,14));
      next.setBounds(620, 660, 80, 30);
      next.addActionListener(this);
      add(next);

       // main screen size colour
        getContentPane().setBackground(Color.WHITE);
        // main screen size
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
     // convert to long
                           // its return object so typecast to string
      String religion1 = (String)religion.getSelectedItem(); 
     
       String cat1  = (String)Catagory.getSelectedItem();
       String sincome = (String)Income.getSelectedItem();
       String education1 = (String)education.getSelectedItem();
       String Occupation1 = (String)Occupation.getSelectedItem();
       String seniorCitzen = null;  
          
      if(syes.isSelected()){
        seniorCitzen = "yes";
      }
      else if(sNo.isSelected()){
        seniorCitzen = "No";
      }

       String ExistingAcc  = null;
       if(eyes.isSelected()){
        ExistingAcc = "Yes";
       }
       else if(eNo.isSelected()){   
        ExistingAcc = "No";
       }
       

       String pan1 = pan.getText();
       String aadhar1 = aadharNumField.getText();
      
      

        // to hit database to throw exeption should do exeption handling
        try{
               
                Conn c = new Conn();
                 // to insert data should use dml command
                String query1 = "insert into signupTwo values('"+formno+"','"+religion1+"','"+cat1+"','"+sincome+"','"+education1+"','"+Occupation1+"','"+pan1+"','"+aadhar1+"','"+seniorCitzen+"','"+ExistingAcc+"')";
               
                //  to run dml command of sql so use this command
                c.s.executeUpdate(query1); 
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);

            
        }
        catch(Exception ed){
            System.out.println(ed);
        }

    }


    public static void main(String[] args) {
      
        new SignupTwo("");
    }


  
}
