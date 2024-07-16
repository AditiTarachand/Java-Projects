import java.awt.*;

import javax.swing.*;


import java.awt.event.*;
   





public class signup2 extends JFrame implements ActionListener 

{
 
    JTextField pan,  aadhar;
    JButton  next;
    JRadioButton syes, sno, eyes, eno;
   JComboBox religion, category, income, qualification,occupation;
   String formno;
   


    signup2(String formno){
        this.formno= formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2 ");
       
     

        JLabel additionDetails= new JLabel("Page 2: Additional  Details " );
        additionDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionDetails.setBounds(290,80,400,30);
        add(additionDetails);

        JLabel rel= new JLabel("Religion:" );
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100,140,100,30);
        add(rel);

        String valReligion[]={"Hindu", "Muslim", "Sikh", "Christian", "Other"};
         religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140,400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

       
        JLabel cat= new JLabel("Category" );
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100,190,200,30);
        add(cat);

        String  valCategory[]={"General", "OBC","SC","ST","Other"};
        category= new JComboBox<>(valCategory);


        
        category.setBounds(300, 190,400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel inco= new JLabel("Income" );
        inco.setFont(new Font("Raleway", Font.BOLD, 20));
        inco.setBounds(100,240,200,30);
        add(inco);
        String  valIncome[]={"Null", "<1,50,000","<2,50,000>","<5,00,000","Upto 10,00,000"};
         income= new JComboBox<>(valIncome);


        
        income.setBounds(300, 240,400, 30);
        category.setBackground(Color.white);
        add(income);

       
        JLabel edu= new JLabel("Educational" );
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100,290,200,30);
        add(edu);
         
        JLabel qual= new JLabel("Qualification:" );
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100,315,200,30);
        add(qual);
        String  valQualification[]={"Non-Graduation", "Graduate","Post-Graduation","Doctrate","Others"};
         qualification= new JComboBox<>(valQualification);

        qualification.setBounds(300, 315,400, 30);
        qualification.setBackground(Color.white);
        add(qualification);

        

        JLabel occu= new JLabel("Occupation: " );
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100,390,200,30);
        add(occu);

        String  valOccupation[]={"Salaried", "Self-Employed","Bussiness","Student","Retired","Others"};
         occupation= new JComboBox<>(valOccupation);      
        occupation.setBounds(300, 390,400, 30);
        occupation.setBackground(Color.white);
        add(occupation);



        
        JLabel pano= new JLabel("PAN No:" );
        pano.setFont(new Font("Raleway", Font.BOLD, 20));
        pano.setBounds(100,440,200,30);
        add(pano);

         pan= new JTextField();
        pan.setFont(new Font("Raleway",  Font.BOLD , 14));
        pan.setBounds(300, 440,400, 30);
        add(pan);
        



        JLabel aadh= new JLabel("Aadhar No:" );
        aadh.setFont(new Font("Raleway", Font.BOLD, 20));
        aadh.setBounds(100,490,200,30);
        add(aadh);

         aadhar= new JTextField();
        aadhar.setFont(new Font("Raleway",  Font.BOLD , 14));
        aadhar.setBounds(300, 490,400, 30);
        add(aadhar);



        JLabel state= new JLabel("Senior Citizen:" );
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

         syes= new JRadioButton("Yes");
         syes.setBounds(300,540,100,30);
         syes.setBackground(Color.WHITE);
         add(syes);
         sno= new JRadioButton("No");
         sno.setBounds(450,540,100, 30);
         sno.setBackground(Color.white);
         add(sno);
         ButtonGroup seniorGroup = new ButtonGroup();
         seniorGroup.add(syes);
         seniorGroup.add(sno);


        JLabel exists= new JLabel("Exisiting Account:" );
        exists.setFont(new Font("Raleway", Font.BOLD, 20));
        exists.setBounds(100,590,200,30);
        add(exists);

         
       eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno= new JRadioButton("No");
        eno.setBounds(450, 590,100, 30);
        eno.setBackground(Color.white);
        add(eno);
        ButtonGroup exisitingGroup = new ButtonGroup();
        exisitingGroup.add(eyes);
        exisitingGroup.add(eno);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        
    }
    public void actionPerformed(ActionEvent ae)
    {

     

        String sreligion= (String)religion.getSelectedItem(); 
        String scategory= (String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String squalification=(String)qualification.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();

        String sseniorcitizen= null;

        
        if (syes.isSelected()) {
            sseniorcitizen= "YES";
            
        }
        else if (sno.isSelected()) {
            sseniorcitizen= "NO";
            
        }

        String exisitingaacount= null;
        if (eyes.isSelected()) {
            exisitingaacount= "YES";
            
        }
        else if (eno.isSelected()) {
            exisitingaacount= "NO";

            
        }
       
        String span= pan.getText();
        String saadhar= aadhar.getText();
       

         try
        {
          
             Conn c= new Conn();
            String query= "insert into signup2 values('" +formno+"', '"+sreligion+"', '"+scategory+"', '"+ sincome+"' ,  '"+squalification+"', '"+soccupation+"',  '"+span+"','"+saadhar+"' , '"+sseniorcitizen+"' , '"+exisitingaacount+"'   )";
                
           c.S.executeUpdate(query);
               
             //Singup3 class Object
        setVisible(false);
        new signup3(formno).setVisible(true
        );
        }      
       


        catch(Exception e){
            System.out.println(e);

        }


    }




    public static void main(String[] args) {
        new signup2("");

        
    }
}

