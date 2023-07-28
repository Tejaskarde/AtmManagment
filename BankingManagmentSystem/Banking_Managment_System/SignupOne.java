package Banking_Managment_System;
//connection jdbc connection
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import com.toedter.calendar.*;


public class SignupOne extends JFrame implements ActionListener {

     long random;
     JTextField namTextField, fnamTextField, dob , emailTextField, addresTextField , cityTextField ,stateTextField, pincodeTextField;
      
     JButton next;
     JRadioButton male, female, other , married ,unmarried;
     JDateChooser dateChooser ;

    SignupOne(){
      setLayout(null);
     Random ran = new Random();
        //  we % bcoz we do not want that much long number
        // by this number giving negative so using math.abs
       random = Math.abs((ran.nextLong() % 9000L)+1000l);
      //Labels

      JLabel formno = new JLabel("APPLICATION FORM NO. "+ random );
      formno.setFont(new Font("Raleway",Font.BOLD,38));
      formno.setBounds(140, 20, 600, 40);
      add(formno);


      JLabel personalDetail = new JLabel("Page 1: Personal Details");
      personalDetail.setFont(new Font("Raleway",Font.BOLD,22));
      personalDetail.setBounds(290, 80, 400, 30);
      add(personalDetail);
    

      JLabel name = new JLabel("Name:");
      name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100, 140, 100, 30);
      add(name);
       namTextField = new JTextField();
      namTextField.setFont(new Font("Raleway",Font.BOLD,14));
      namTextField.setBounds(300,140,400,30);
      add(namTextField);


      JLabel fname = new JLabel("Father's Name:");
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100, 190, 200, 30);
      add(fname);
       fnamTextField = new JTextField();
      fnamTextField.setFont(new Font("Raleway",Font.BOLD,14));
      fnamTextField.setBounds(300,190,400,30);
      add(fnamTextField);

      
      JLabel dob = new JLabel("Date of Birth:");
      dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100, 240, 200, 30);
      add(dob);
   //  for a use calander we have first add JCalander jar file in liberry
  // then  import import com.toedter.calendar.JDataChooser;
      dateChooser = new JDateChooser();
     dateChooser.setBounds(300,240,400,30);
     //change date text colour
     dateChooser.setForeground(new Color(105, 105, 105));
     add(dateChooser);
     



      JLabel gender = new JLabel("Gender:");
      gender.setFont(new Font("Raleway",Font.BOLD,20));
      gender.setBounds(100, 290, 200, 30);
      add(gender);
      //how to make radio button
       male = new JRadioButton("Male");
      male.setBounds(300, 290, 60, 30);
      male.setBackground(Color.WHITE);
      add(male);
       female = new JRadioButton("Female");
      female.setBounds(450, 290, 120, 30);
      female.setBackground(Color.WHITE);
      add(female);
      // for chooise of only mail or femail at one time for that we use

      ButtonGroup gendeGroup = new ButtonGroup();
      gendeGroup.add(male);
      gendeGroup.add(female);


      JLabel email = new JLabel("Email Address:");
      email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100, 340, 200, 30);
      add(email);
       emailTextField = new JTextField();
      emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
      emailTextField.setBounds(300,340,400,30);
      add(emailTextField);


      JLabel marital = new JLabel("Marita Status:");
      marital.setFont(new Font("Raleway",Font.BOLD,20));
      marital.setBounds(100, 390, 200, 30);
      add(marital);
      
       married = new JRadioButton("Maaried");
      married.setBounds(300, 390, 100, 30);
      married.setBackground(Color.WHITE);
      add(married);
       unmarried = new JRadioButton("Unmarried");
      unmarried.setBounds(450, 390, 100, 30);
      unmarried.setBackground(Color.WHITE);
      add(unmarried);
       other = new JRadioButton("Other");
      other.setBounds(630, 390, 100, 30);
      other.setBackground(Color.WHITE);
      add(other);
      ButtonGroup maritalGroup = new ButtonGroup();
      maritalGroup.add(married);
      maritalGroup.add(unmarried);
      maritalGroup.add(other);
       

      JLabel address = new JLabel("Address:");
      address.setFont(new Font("Raleway",Font.BOLD,20));
      address.setBounds(100, 440, 200, 30);
      add(address);
       addresTextField = new JTextField();
      addresTextField.setFont(new Font("Raleway",Font.BOLD,14));
      addresTextField.setBounds(300,440,400,30);
      add(addresTextField);


      JLabel city = new JLabel("city:");
      city.setFont(new Font("Raleway",Font.BOLD,20));
      city.setBounds(100, 490, 200, 30);
      add(city);
       cityTextField = new JTextField();
      cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
      cityTextField.setBounds(300,490,400,30);
      add(cityTextField);


      JLabel State = new JLabel("State:");
      State.setFont(new Font("Raleway",Font.BOLD,20));
      State.setBounds(100, 540, 200, 30);
      add(State);
       stateTextField = new JTextField();
      stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
      stateTextField.setBounds(300,540,400,30);
      add(stateTextField);
      

      JLabel pincode = new JLabel("Pin Code:");
      pincode.setFont(new Font("Raleway",Font.BOLD,20));
      pincode.setBounds(100, 590, 200, 30);
      add(pincode);
       pincodeTextField = new JTextField();
      pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
      pincodeTextField.setBounds(300,590,400,30);
      add(pincodeTextField);
      
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
      String formno = ""+random; // convert to long
      String name = namTextField.getText(); 
      String fname  = fnamTextField.getText();
      String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
      String gender = null;
      if(male.isSelected()){
             gender = "Male";
      }
      else if(female.isSelected()){
         gender = "Female";
      }

       String email = emailTextField.getText();
       String marital  = null;
       if(married.isSelected()){
        marital = "Married";
       }
       else if(unmarried.isSelected()){   
        marital = "Unmarried";
       }
       else if(other.isSelected()){
        marital = "Other";
       }

       String address = addresTextField.getText();
       String city = cityTextField.getText();
       String state = stateTextField.getText();
       String pin = pincodeTextField.getText();
      

        // to hit database to throw exeption should do exeption handling
        try{
               if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Requied ");
               }
               else{
                Conn c = new Conn();
                 // to insert data should use dml command
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                //  to run dml command of sql so use this command
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);  
            }
        }
        catch(Exception ed){
            System.out.println(ed);
        }

    }


    public static void main(String[] args) {
      
        new SignupOne();
    }


  
}
