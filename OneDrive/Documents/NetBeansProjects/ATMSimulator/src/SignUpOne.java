import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    JRadioButton male, female, married, unmarried, other;
    JButton but;
    JDateChooser dateChooser;
    SignUpOne(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L) + 1000L);
                
                
        JLabel l1 = new JLabel("Application Form No: "+random);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 32));
        l1.setBounds(85,25,400,30);
        add(l1);
        
        
        JLabel l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 25));
        l2.setBounds(120,65,400,30);
        add(l2);
        
        JLabel l3 = new JLabel("Full Name:");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l3.setBounds(45,135,200,30);
        add(l3);
        txt1 = new JTextField();
        txt1.setBounds(220,140,300,26);
        txt1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt1);
        
        
        JLabel l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l4.setBounds(45,175,200,30);
        add(l4);
        txt2 = new JTextField();
        txt2.setBounds(220,180,300,26);
        txt2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt2);
        
        
        
        JLabel l5 = new JLabel("Date Of Birth:");
        l5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l5.setBounds(45,215,200,28);
        add(l5);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(220,220,300,26);
        dateChooser.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        add(dateChooser);
        
        JLabel l6 = new JLabel("Gender:");
        l6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l6.setBounds(45,255,200,30);
        add(l6);
        
        male = new JRadioButton("Male");
        male.setBounds(220, 260,100,30);
        male.setFont(new Font("Times New Roman", Font.BOLD, 17));
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(350, 260,150,30);
        female.setFont(new Font("Times New Roman", Font.BOLD, 17));
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel l7 = new JLabel("E-Mail:");
        l7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l7.setBounds(45,295,200,30);
        add(l7);
        txt3 = new JTextField();
        txt3.setBounds(220,300,300,26);
        txt3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt3);
        
        JLabel l8 = new JLabel("Marital Status:");
        l8.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l8.setBounds(45,335,200,30);
        add(l8);
        married = new JRadioButton("Married");
        married.setBounds(220, 335,100,30);
        married.setFont(new Font("Times New Roman", Font.BOLD, 17));
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(320, 335,120,30);
        unmarried.setFont(new Font("Times New Roman", Font.BOLD, 17));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(440, 335,150,30);
        other.setFont(new Font("Times New Roman", Font.BOLD, 17));
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(unmarried);
        bg1.add(other);
        
        
        
        JLabel l9 = new JLabel("Address:");
        l9.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l9.setBounds(45,375,150,30);
        add(l9);
        txt4 = new JTextField();
        txt4.setBounds(220,380,300,26);
        txt4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt4);
        
        
        JLabel l10 = new JLabel("City:");
        l10.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l10.setBounds(45,415,100,30);
        add(l10);
        txt5 = new JTextField();
        txt5.setBounds(220,420,300,26);
        txt5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt5);
        
        
        JLabel l11 = new JLabel("State:");
        l11.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l11.setBounds(45,455,100,30);
        add(l11);
        txt6 = new JTextField();
        txt6.setBounds(220,460,300,26);
        txt6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt6);
        
        
        
        JLabel l12 = new JLabel("Pincode:");
        l12.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l12.setBounds(45,495,100,30);
        add(l12);
        txt7 = new JTextField();
        txt7.setBounds(220,500,300,26);
        txt7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt7);
        
        
        JLabel l13 = new JLabel("Mobile No:");
        l13.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        l13.setBounds(45,535,130,30);
        add(l13);
        txt8 = new JTextField();
        txt8.setBounds(220,540,300,26);
        txt8.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        add(txt8);
        
        
        but = new JButton("Next");
        but.setFont(new Font("Times New Roman", Font.BOLD, 18));
        but.setBounds(440, 600,80,25);
        but.addActionListener(this);
        add(but);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("New Account Registration Page - 1");
        setSize(550,700);
        setLocation(520,80);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = txt1.getText();
        String fname = txt2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        String email = txt3.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if (unmarried.isSelected()){
            marital = "UnMarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        String address = txt4.getText();
        String city = txt5.getText();
        String state = txt6.getText();
        String pincode = txt7.getText();
        String mobileno = txt8.getText();
        
        try{
            if(name.equals("")|| fname.equals("")|| dob.equals("")||gender.equals("")||email.equals("")|| marital.equals("")||address.equals("")||city.equals("")||state.equals("")||pincode.equals("")||mobileno.equals("")){
                JOptionPane.showMessageDialog(null, "Enter details for all fields is required!");
            }else{
                DbConnection c = new DbConnection();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"', '"+mobileno+"')";
                c.st.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    } 
    
    
    public static void main(String[] args){
        new SignUpOne();
    }
}
