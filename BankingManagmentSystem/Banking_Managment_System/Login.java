package Banking_Managment_System;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
             // implement class for action purose of button
public class Login extends JFrame implements ActionListener{
    // all button are local difine so we cant access out in infeface abstract method
     //  we are making it GLOBALY avalbale
     // use to acces out of constructor also
    JButton login,Signup,clear;
    JTextField cardTextField;
    // for not show password on screen we can use
    JPasswordField pinTextField;

    Login(){
          setTitle("Automated Teller Machine");

    setLayout(null);

   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Banking_Managment_System/logo.jpg"));
    Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3  = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    
    // image location
    label.setBounds(70, 10, 100, 100);
    add(label); 

    // j label use to write content on screen
    JLabel text = new JLabel("WelCome To Atm");
    // font 
    text.setFont(new Font("Osward", Font.BOLD,38));
    // where to show
    text.setBounds(200,40,400,40);
      add(text);
     
         // j label use to write content on screen
    JLabel cardno = new JLabel("Card No...");
    // font 
    cardno.setFont(new Font("Raleway", Font.BOLD,28));
    // where to show
    cardno.setBounds(120,150,150,30);
      add(cardno);
   // for need test feild
     cardTextField = new JTextField();
     cardTextField.setBounds(300,150,230,30);
     cardTextField.setFont(new Font("Arial",Font.BOLD,14) );
     add(cardTextField);
        
    JLabel pin = new JLabel("PIN");
    pin.setFont(new Font("Raleway", Font.BOLD,28));
    pin.setBounds(122,220,250,30);
      add(pin);

       pinTextField = new JPasswordField();
      pinTextField.setBounds(300,220,230,30);
      pinTextField.setFont(new Font("Arial",Font.BOLD,14) );
     add(pinTextField);

      //for SingIn Button
       login = new JButton("SIGN IN");
      login.setBounds(300, 270, 100, 30);
      // change backgrond of button
      login.setBackground(Color.BLACK);
      // change Font colour
      login.setForeground(Color.WHITE);
      login.addActionListener(this);
      add(login);
    
       // for clear button
        clear = new JButton("CLEAR");
       clear.setBounds(430, 270, 100, 30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);
       add(clear);
        
       // for Signup button
        Signup = new JButton("SIGN UP");
       Signup.setBounds(300, 320, 230, 30);
       Signup.setBackground(Color.BLACK);
       Signup.setForeground(Color.WHITE);
       Signup.addActionListener(this);
       add(Signup);


       // change colour of pop screen
    getContentPane().setBackground(Color.WHITE);

    setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
       // it is abstract method come from interface ActionListener
     public void actionPerformed(ActionEvent ae){
           if(ae.getSource() == clear){
              cardTextField.setText("");
              pinTextField.setText("");
           }
           else if(ae.getSource() == login){
               Conn conn = new Conn();
               String cardNumber = cardTextField.getText();
               String pinNumber = pinTextField.getText();
               String query  = "select * from login where cardnumber = '"+cardNumber+"' and pin='"+pinNumber+"'";
                try {
                  //ddl comand
                ResultSet rs = conn.s.executeQuery(query);
                 
                if(rs.next()){
                  setVisible(false); // current scrren well disapper
                  // next trasaction field will show
                  new Transaction(pinNumber).setVisible(true);
                }
                else{
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
             
             
              } catch (Exception e) {
                System.out.println(e);
                }
              }
           else if(ae.getSource() == Signup){
          // first should make signup class
                    // if user click on signup will jump to signup page
                    setVisible(false);
                    new SignupOne().setVisible(true);
           }
     }
    public static void main(String[] args) {
        
        new Login();
    }

}