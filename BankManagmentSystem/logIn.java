import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

//Buttons  kuch action perform kare uske liye ActionListener interface ko implement krna honga
public class logIn extends JFrame implements ActionListener {

    JButton login, SignUp, Clear;
    JTextField cardTextField;
    JPasswordField pinTexField;

    logIn(){
        
        setTitle("Automated Teller Machine ");
        setLayout(null);
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("ICON/logo.jpg"));  // Image ko lagane ke liye ImageIcon ka use krte hai

         Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // Width, height


         //Converting image to icon
         ImageIcon i3= new ImageIcon(i2);
         
         JLabel label= new JLabel(i3); // Image directly frame me  nhi lagti, isliye image ko Jlabel me put krna padhta hai
 
        //  label.setBounds(70, 10, 100, 100);  //isse position change nhi hua
         //layout se position change honga, hame SetLayout null krna honga , means custom rakhna honga
         label.setBounds(70,10, 100,100);
          

         add(label);  // Jlable ko mai frame me add krri hu,  jb bhi aapko kisi component ko place krna hota hai to aapko add() use krna padhta hai,  add()  ke andar object pass krna hota hai.

         



         // icon ko sizing krne ke liye scale krna padhta hai
        
        setSize(800, 480);
        setVisible(true);

        setLocation(350, 200);


        // muje icon ke samne  Kuch ikhna hai to Jlabel ka use honga
        // Jlabel ka use frame  me image daalne me aur , frame me kuch bhi content likhne me use honga
        JLabel  text = new JLabel("Welcome to ATM");
        // ap jab tk   ap location define nhi karoge tb tk nhi display hota
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40 );
        add(text); // display nhi hua ,, qki hame setBounds krna honga, hame dikhana kaha kaha hai


        JLabel cardno= new JLabel("Card No :");
        cardno.setFont(new Font("Raieway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30 );
        add(cardno);
        //Muje card no,  pin no. ke samne box chahiye jaha user entry kr sake, Wo ham daal sakte hai "textField" ki help se, Textfield class hoti hai
       cardTextField= new JTextField();
        cardTextField.setBounds(300, 150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);




        JLabel pin= new JLabel("Pin  Number:");
        pin.setFont(new Font("Raieway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30 );
        add(pin);

       pinTexField= new JPasswordField();
        pinTexField.setBounds(300, 220,230,30);
        pinTexField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTexField);

        //Button banane ke liye JButton Class hoti hai
         login= new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        //Ham Buttons ke colors ko change kr sakte hai
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


         Clear= new JButton("CLEAR");
        Clear.setBounds(430,300,100,30);
        
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);


         SignUp= new JButton("SIGN UP");
        SignUp.setBounds(300,350,230,30);
        
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);
        add(SignUp);

        
       



        //background change krne ke liye, pure frame ko uthana padhega to  getContentPane() use krna honga
        getContentPane().setBackground(Color.WHITE); // Color class ka use kiya



    }


    public void actionPerformed(ActionEvent ae)
    {

        if (ae.getSource()== Clear) {
            cardTextField.setText("Please Enter your Card Number");
            pinTexField.setText(" ");

        }
        else if(ae.getSource()==login){
           Conn conn= new Conn();
           String cardnumber= cardTextField.getText();
           String pinnumber= pinTexField.getText();
           String query= "select * from login where  cardnumber ='"+cardnumber+"' and pin='"+pinnumber+"' ";
           try{
          ResultSet rs=  conn.S.executeQuery(query);
          if (rs.next()) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
          }
          else{
            JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
          }

           }
           catch(Exception e){
            System.out.println(e);
           }
        }
        else if (ae.getSource()==SignUp) {
            setVisible(false);
            new  signup1().setVisible(true);
        }



    }
        public static void main(String[] args) {
        new logIn();
    }
}
