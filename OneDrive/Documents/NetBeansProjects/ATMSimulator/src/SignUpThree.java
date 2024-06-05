import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class SignUpThree extends JFrame implements ActionListener{
    JButton submit,cancel;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    SignUpThree(String formno){
        setLayout(null);
        this.formno = formno;
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 25));
        l1.setBounds(120,45,400,30);
        add(l1);
        
        
        JLabel l2 = new JLabel("Account Type:");
        l2.setBounds(45,115,150,30);
        l2.setFont(new Font("Times New Roman",Font.PLAIN, 22));
        add(l2);
        r1 = new JRadioButton("Savings Account");
        r1.setBounds(45, 155,140,26);
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(210, 155,200,26);
        r2.setBackground(Color.WHITE);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setBounds(45, 195,140,26);
        r3.setBackground(Color.WHITE);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(210, 195,200,26);
        r4.setBackground(Color.WHITE);
        add(r4);
        ButtonGroup but1 = new ButtonGroup();
        but1.add(r1);
        but1.add(r2);
        but1.add(r3);
        but1.add(r4);
        
        
        
        JLabel l3 = new JLabel("Card No:");
        l3.setBounds(45, 235,130,30);
        l3.setFont(new Font("Times New Roman",Font.PLAIN, 22));
        add(l3);
        JLabel l4 = new JLabel("xxxx-xxxx-xxxx-1498");
        l4.setBounds(210, 235,330,30);
        l4.setFont(new Font("Times New Roman",Font.PLAIN, 22));
        add(l4);
        JLabel l5 = new JLabel("Your 16-digit card number");
        l5.setBounds(210, 265,330,30);
        l5.setFont(new Font("Times New Roman",Font.PLAIN, 15));
        add(l5);
        
        
        
        JLabel l6 = new JLabel("PIN No:");
        l6.setBounds(45, 295,130,30);
        l6.setFont(new Font("Times New Roman",Font.PLAIN, 22));
        add(l6);
        JLabel l7 = new JLabel("xxxx");
        l7.setBounds(210, 295,60,30);
        l7.setFont(new Font("Times New Roman",Font.PLAIN, 22));
        add(l7);
        JLabel l8 = new JLabel("Your 4-digit pin number");
        l8.setBounds(210, 320,330,30);
        l8.setFont(new Font("Times New Roman",Font.PLAIN, 15));
        add(l8);
        
        
        
        JLabel l9 = new JLabel("Services Required:");
        l9.setBounds(45, 360,200,30);
        l9.setFont(new Font("Times New Roman",Font.PLAIN, 22));
        add(l9);
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setBounds(45,400,130,26);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(220,400,180,26);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setBounds(45,430,160,26);
        add(c3);
        c4 = new JCheckBox("Email & SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setBounds(220,430,180,26);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setBounds(45,460,160,26);
        add(c5);
        c6 = new JCheckBox("E - statement");
        c6.setBackground(Color.WHITE);
        c6.setBounds(220,460,180,26);
        add(c6);
        c7 = new JCheckBox("I hereby declare that the above provided details are true to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setBounds(25,520,800,26);
        add(c7);
        
        
        submit = new JButton("Submit");
        submit.setBounds(120,580,100,26);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cancel.setBounds(300,580,100,26);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLocation(520,80);
        setTitle("Account set up");
        setVisible(true);
        setSize(550, 700);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String acctype= null;
            if(r1.isSelected()){
                acctype = "Savings Account";
            }else if(r2.isSelected()){
                acctype="Fixed Deposit Account";
            }else if(r3.isSelected()){
                acctype = "Current Account";
            }else if(r4.isSelected()){
                acctype = "Recurring Deposit Account";
            }
            
            Random r = new Random();
            String cardno = ""+Math.abs((r.nextLong()%90000000L)+ 5040936000000000L);
            String pinno = ""+Math.abs((r.nextLong()%9000L)+1000L);
            StringBuilder services = new StringBuilder();
            if (c1.isSelected()) {
                services.append("ATM Card, ");
            }
            if (c2.isSelected()) {
                services.append("Internet Banking, ");
            }
            if (c3.isSelected()) {
                services.append("Mobile Banking, ");
            }
            if (c4.isSelected()) {
                services.append("Email & SMS alerts, ");
            }
            if (c5.isSelected()) {
                services.append("Cheque Book, ");
            }
            if (c6.isSelected()) {
                services.append("E - statement, ");
            }

            // Remove the trailing comma and space
            if (services.length() > 0) {
                services.setLength(services.length() - 2);
            }
            
            try{
                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required!");
                }else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please confirm the declaration!");
                }
                else{
                    DbConnection c = new DbConnection();
                    String query = "insert into signupthree values ('"+formno+"','"+acctype+"','"+cardno+"','"+pinno+"','"+services+"')";
                    
                    String query1 = "insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                    c.st.executeUpdate(query);
                    c.st.executeUpdate(query1);
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardno+"\n Pin Number: "+pinno);
                    
                    
                    setVisible(false);
                    new LoginPage().setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }
    
    
    public static void main(String[] args){
        new SignUpThree("");
    }
}
