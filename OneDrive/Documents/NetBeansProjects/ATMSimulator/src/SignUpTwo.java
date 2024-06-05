
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class SignUpTwo extends JFrame implements ActionListener{
    JTextField txt1, txt2;
    JRadioButton yes,no,yes1,no1;
    JComboBox box1, box2, box3, box4, box5;
    JButton but;
    String formno;
    SignUpTwo(String formno){
        setLayout(null);
        this.formno = formno;
        
        JLabel l2 = new JLabel("Page 2: Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 25));
        l2.setBounds(120,65,400,30);
        add(l2);
        
        JLabel l3 = new JLabel("Religion:");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l3.setBounds(45,135,200,30);
        add(l3);
        String value1[] = {"Hindu", "Muslim", "Christian", "Sikh","Other"};
        box1 = new JComboBox(value1);
        box1.setBounds(220,140,300,26);
        //box1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        box1.setBackground(Color.WHITE);
        add(box1);
        
        
        JLabel l4 = new JLabel("Category:");
        l4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l4.setBounds(45,175,200,30);
        add(l4);
        String value2[]={"General", "OBC","EWS","SC","ST","Other"};
        box2 = new JComboBox(value2);
        box2.setBounds(220,180,300,26);
        //box2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        box2.setBackground(Color.WHITE);
        add(box2);
        
        
        
        
        JLabel l5 = new JLabel("Income:");
        l5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l5.setBounds(45,215,200,28);
        add(l5);
        String value3[]= {"NULL","< 1,50,000","< 2,50,000", "Above 5,00,000"};
        box3 = new JComboBox(value3);
        box3.setBounds(220,220,300,26);
        box3.setBackground(Color.WHITE);
        add(box3);
        
        JLabel l6 = new JLabel("Educational");
        l6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l6.setBounds(45,255,200,30);
        add(l6);
        JLabel l61 = new JLabel("Qualification:");
        l61.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l61.setBounds(43,275,200,30);
        add(l61);
        String value4[]= {"HighSchooling", "Graduate", "Post- Graduate", "Doctrate","Other"};
        box4 = new JComboBox(value4);
        box4.setBounds(220, 275,300,26);
        box4.setBackground(Color.WHITE);
        add(box4);
        
        
        JLabel l7 = new JLabel("Occupation:");
        l7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l7.setBounds(45,315,200,30);
        add(l7);
        String value5[]={"Self-Employeed", "Business","Salaried","Daily wages","Other"};
        box5 = new JComboBox(value5);
        box5.setBounds(220, 321,300,26);
        box5.setBackground(Color.WHITE);
        add(box5);
        
        
        
        JLabel l8 = new JLabel("PAN number:");
        l8.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l8.setBounds(45,355,200,30);
        add(l8);
        txt1 = new JTextField();
        txt1.setBounds(220,361,300,26);
        txt1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt1);
        
        
        
        JLabel l9 = new JLabel("Aadhar Number:");
        l9.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l9.setBounds(45,395,150,30);
        add(l9);
        txt2 = new JTextField();
        txt2.setBounds(220,400,300,26);
        txt2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt2);
        
        
        JLabel l10 = new JLabel("Senior Citizen:");
        l10.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l10.setBounds(45,435,180,30);
        add(l10);
        yes = new JRadioButton("Yes");
        yes.setBounds(220,440,100,26);
        yes.setBackground(Color.WHITE);
        yes.setFont(new Font("Times New Roman",Font.BOLD,15));
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(380,443,100,26);
        no.setBackground(Color.WHITE);
        no.setFont(new Font("Times New Roman",Font.BOLD, 15));
        add(no);
        ButtonGroup b1 = new ButtonGroup();
        b1.add(yes);
        b1.add(no);
        
        
        JLabel l11 = new JLabel("Existing Account:");
        l11.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l11.setBounds(45,475,180,30);
        add(l11);
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(220,480,100,26);
        yes1.setBackground(Color.WHITE);
        yes1.setFont(new Font("Times New Roman",Font.BOLD,15));
        add(yes1);
        no1 = new JRadioButton("No");
        no1.setBounds(380,483,100,26);
        no1.setBackground(Color.WHITE);
        no1.setFont(new Font("Times New Roman",Font.BOLD, 15));
        add(no1);
        ButtonGroup b2 = new ButtonGroup();
        b2.add(yes1);
        b2.add(no1);
        
        
        
        but = new JButton("Next");
        but.setFont(new Font("Times New Roman", Font.BOLD, 18));
        but.setBounds(440, 600,80,25);
        but.addActionListener(this);
        add(but);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("New Account Registration Page - 2");
        setSize(550,700);
        setLocation(520,80);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String) box1.getSelectedItem();
        String category = (String) box2.getSelectedItem();
        String income = (String) box3.getSelectedItem();
        String educationalQualification = (String) box4.getSelectedItem();
        String occupation = (String) box5.getSelectedItem();
        String panno = txt1.getText();
        String aadharno = txt2.getText();
        String seniorcitizen = null;
        if(yes.isSelected()){
            seniorcitizen = "Yes";
        }else if (no.isSelected()){
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(yes1.isSelected()){
            existingaccount = "Yes";
        }else if (no1.isSelected()){
            existingaccount = "No";
        }
        
        try{
            if(panno.equals("")|| aadharno.equals("")|| seniorcitizen.equals("")||existingaccount.equals("")){
                JOptionPane.showMessageDialog(null, "Enter details for all fields is required!");
            }else{
                DbConnection c = new DbConnection();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+educationalQualification+"', '"+occupation+"', '"+panno+"', '"+aadharno+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.st.executeUpdate(query);
                
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    } 
    
    
    public static void main(String[] args){
        new SignUpTwo("");
    }
}
