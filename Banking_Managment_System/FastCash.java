package Banking_Managment_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
    
     JButton w200 , w500,w1000,w2000,w5000,w10000,exit;
      String pinnumber;


      FastCash(String pinnumber){
        this.pinnumber = pinnumber;
         setLayout(null);
 

      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Banking_Managment_System/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
       ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

     JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
         text.setBounds(210,300,700,35);
          text.setForeground(Color.WHITE);
          text.setFont(new Font("System",Font.BOLD, 16));
         //  add(text);
         // to text add to on image not on screen
         image.add(text);


          w200 = new JButton("Rs 200");
          w200.setBounds(170,415,150,30);
          w200.addActionListener(this);
         image.add(w200);

          w500 = new JButton("Rs 500");
          w500.setBounds(355,415,150,30);
          w500.addActionListener(this);
         image.add(w500);

          w1000 = new JButton("Rs 1000");
          w1000.setBounds(170,450,150,30);
          w1000.addActionListener(this);
         image.add(w1000);

          w2000 = new JButton("Rs 2000");
          w2000.setBounds(355,450,150,30);
          w2000.addActionListener(this);
         image.add(w2000);

          w5000 = new JButton("Rs 5000");
          w5000.setBounds(355,450,150,30);
          w5000.addActionListener(this);
         image.add(w5000);

          w10000 = new JButton("Rs 10000");
          w10000.setBounds(355,485,150,30);
         w10000.addActionListener(this);
         image.add(w10000);
           
          exit = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else {
             String amount =((JButton) e.getSource()).getText().substring(3);
             Conn c = new Conn();
             try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
               int balance = 0;
               while(rs.next()){
                if(rs.getString("type").equals("Deposite")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
               }
            if(e.getSource() != exit  && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficent Balance");
              return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs "+ amount + "Debited Sussessfully");
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
             } catch (Exception ex) {
                System.out.println(ex);
             } 
        }
    }

    public static void main(String[] args) {
          
        new FastCash("");
    }


  
}
