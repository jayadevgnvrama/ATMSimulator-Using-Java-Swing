import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginPage extends JFrame implements ActionListener{
    JButton b1, b2, b3;
    JTextField txt1;
    JPasswordField txt2;
    JFrame f = new JFrame();
    LoginPage(){
        
        f.setLayout(null);
        f.setTitle("Automated Teller Machine");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(70,40,50,50);
        f.add(j1);
        
        JLabel text = new JLabel("Welcome To Login Page");
        text.setBounds(150,43,300,50);
        text.setFont(new Font("Times New Roman",Font.BOLD, 24)); 
        f.add(text);
        
        
        
        
        
        JLabel cardno = new JLabel("Card Number: ");
        cardno.setBounds(40,120,130,50);
        cardno.setFont(new Font("Times New Roman",Font.BOLD, 20)); 
        f.add(cardno);
        
        
        txt1 = new JTextField();
        txt1.setBounds(200, 130, 250,30);
        txt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        f.add(txt1);
        
        JLabel pin = new JLabel("Pin Number: ");
        pin.setBounds(40,170,120,50);
        pin.setFont(new Font("Times New Roman",Font.PLAIN, 20)); 
        f.add(pin);
        
        txt2 = new JPasswordField();
        txt2.setBounds(200, 180, 250,30);
        txt2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        f.add(txt2);
        
        
        b1 = new JButton("Login");
        b1.setFont(new Font("Times New Roman", Font.BOLD,18));
        b1.setBounds(60, 250,150,25);
        b1.addActionListener(this);
        f.add(b1);
        
        
        b2 = new JButton("Reset");
        b2.setFont(new Font("Times New Roman", Font.BOLD,18));
        b2.setBounds(280, 250,150,25);
        b2.addActionListener(this);
        f.add(b2);
        
        
        b3 = new JButton("SignUp");
        b3.setFont(new Font("Times New Roman", Font.BOLD,18));
        b3.setBounds(60, 300,370,25);
        b3.addActionListener(this);
        f.add(b3);
        
        f.getContentPane().setBackground(Color.WHITE);
        f.setSize(500,400);
        f.setVisible(true);
        f.setLocation(570,200);
        f.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            txt1.setText("");
            txt2.setText("");
        }
        else if(ae.getSource()==b1){
            DbConnection c = new DbConnection();
            String cno = txt1.getText();
            String pass = txt2.getText();
            String query = "select * from login where cardno='"+cno+"' and pinno = '"+pass+"'";
            
            try{
                if(cno.equals("") || pass.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter details!");
                }else{
                ResultSet rs = c.st.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pass).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin number!");
                }}
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b3){
            f.setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new LoginPage();
    }
}
