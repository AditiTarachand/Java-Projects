import java.awt.Color;
import java.awt.Image;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class balanceEnqiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    balanceEnqiry(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("ICON/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
       image.setBounds(0,0,900, 900);
       add(image);
       back= new JButton("Back");
       back.setBounds(355, 520, 150, 30 );
       back.addActionListener(this);
       image.add(back);

        Conn c=  new Conn();
        int balance= 0;
           try{
             ResultSet rs= c.S.executeQuery("select * from bank where pin = '"+pinnumber+"'");
             
             while (rs.next()) 
             {
                 if (rs.getString("type").equals("Deposit")) 
                 {
                    balance +=  Integer.parseInt(rs.getString("amount"));
                     
                 }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                
             }
            }
             catch(Exception e){
                System.out.println(e);
             }
         


             JLabel text= new JLabel("Your Current Account balance is Rs "+ balance );
             text.setForeground(Color.WHITE);
             text.setBounds(170, 300, 400, 30);
             image.add(text);

      
        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
     setVisible(false);
     new Transactions(pinnumber).setVisible(true);

    }
    public static void main(String[] args) {
        new balanceEnqiry("");
    }
    
}
