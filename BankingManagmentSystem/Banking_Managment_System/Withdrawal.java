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
import javax.swing.JTextField;

public class Withdrawal extends JFrame implements ActionListener {

    private JTextField amount;
    private JButton withdrawal, back;
    private String pinNumber;

    public Withdrawal(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon atmImageIcon = new ImageIcon(ClassLoader.getSystemResource("Banking_Managment_System/atm.jpg"));
        Image atmImage = atmImageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon scaledAtmImageIcon = new ImageIcon(atmImage);
        JLabel image = new JLabel(scaledAtmImageIcon);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(355, 485, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
          
                String number = amount.getText();
                Date date = new Date();
                if (e.getSource() == withdrawal) {
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid withdrawal amount.");
                } else {
                    Conn c = new Conn();
                  
                   
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposite")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    c.s.executeUpdate("insert into bank values('" + pinNumber + "','"+date+"','Withdrawal', '" + number + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Debited successfully");

                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                    
                }
            } else if (e.getSource() == back) {
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}










