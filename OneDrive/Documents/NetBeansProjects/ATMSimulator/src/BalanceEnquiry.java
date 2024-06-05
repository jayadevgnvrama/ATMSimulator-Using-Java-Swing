import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pass;
    BalanceEnquiry(String pass){
        this.pass = pass;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,900,900);
        add(l1);
        
        
        back = new JButton("Back");
        back.setBounds(375,520,130,30);
        back.addActionListener(this);
        l1.add(back);
        
        
        DbConnection c = new DbConnection();
        int balance = 0;
        try{
            ResultSet rs = c.st.executeQuery("Select * from bank where pinno = '"+pass+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                        
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your current Account Balance is");
        text.setBounds(180,310,500,30);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setForeground(Color.white);
        l1.add(text);
        
        JLabel stext = new JLabel("Rs "+balance);
        stext.setBounds(290,350,500,30);
        stext.setFont(new Font("System",Font.BOLD,18));
        stext.setForeground(Color.white);
        l1.add(stext);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Transactions(pass).setVisible(true);
       
    }
    
    
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
