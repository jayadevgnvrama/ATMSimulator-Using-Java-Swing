
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Withdrawl extends JFrame implements ActionListener{
    
    JButton back, withdrawl;
    JTextField amount;
    String pass;
    
    Withdrawl(String pass){
        this.pass = pass;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,900,900);
        add(l1);
        
        JLabel txt1 = new JLabel("Enter the amount you want to withdraw: ");
        txt1.setForeground(Color.WHITE);
        txt1.setFont(new Font("System",Font.BOLD, 16));
        txt1.setBounds(170,300,400,30);
        l1.add(txt1);
        
        amount = new JTextField();
        amount.setBounds(170,350,320,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(amount);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(375,485,130,30);
        withdrawl.addActionListener(this);
        l1.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(375,520,130,30);
        back.addActionListener(this);
        l1.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pass).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw!");
            }
            else{
                try{
                DbConnection c = new DbConnection();
                String query1 = "select * from bank where pinno ='"+pass+"'";
                ResultSet rs = c.st.executeQuery(query1);
                int balance = 0;
                while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                        
                    }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                    }
               }
                if(balance < Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance, please deposit!");
                    return;
                }else{
                String query = "insert into bank values('"+pass+"','"+date+"','Withdraw','"+amt+"')";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amt+" withdraw successfully!");
                setVisible(false);
                new Transactions(pass).setVisible(true);
                }}catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    
    
    public static void main(String[] args){
        new Withdrawl("");
    }
}
