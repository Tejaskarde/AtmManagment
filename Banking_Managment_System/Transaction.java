package Banking_Managment_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {
    
     JButton deposite , withdrawl,ministatement,pinchange,fastcash,balanceEnquiry,exit;
      String pinnumber;


    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
         setLayout(null);
 

      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Banking_Managment_System/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
       ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

     JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(210,300,700,35);
          text.setForeground(Color.WHITE);
          text.setFont(new Font("System",Font.BOLD, 16));
         //  add(text);
         // to text add to on image not on screen
         image.add(text);


          deposite = new JButton("Deposite");
         deposite.setBounds(170,415,150,30);
         deposite.addActionListener(this);
         image.add(deposite);

          withdrawl = new JButton("Withdrawl");
         withdrawl.setBounds(355,415,150,30);
         withdrawl.addActionListener(this);
         image.add(withdrawl);

          fastcash = new JButton("Fast Cash");
         fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
         image.add(fastcash);

          ministatement = new JButton("Mini Statement");
         ministatement.setBounds(355,450,150,30);
         ministatement.addActionListener(this);
         image.add(ministatement);

          pinchange = new JButton("Pin Change");
         pinchange.setBounds(170,485,150,30);
         pinchange.addActionListener(this);
         image.add(pinchange);

          balanceEnquiry = new JButton("Balance Enquiry");
         balanceEnquiry.setBounds(355,485,150,30);
         balanceEnquiry.addActionListener(this);
         image.add(balanceEnquiry);
           
          exit = new JButton("Exit");
         exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
         image.add(exit);



        setSize(900, 900);
        setLocation(300, 0);
      
        //to disapper uper border of screen unused screen we use
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }
        else if(e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        else if(e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(e.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(e.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(e.getSource() == ministatement){
          
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
          
        new Transaction("");
    }


  
}
