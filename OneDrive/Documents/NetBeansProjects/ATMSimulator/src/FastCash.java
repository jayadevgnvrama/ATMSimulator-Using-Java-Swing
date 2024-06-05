
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;


public class FastCash extends JFrame implements ActionListener{
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pass;
    
    FastCash(String pass){
        this.pass = pass;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,900,900);
        add(l1);
        
        JLabel l2 = new JLabel("Select withdrawl amount");
        l2.setBounds(225,300,700,35);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l1.add(l2);
        
        deposit = new JButton("100");
        deposit.setBounds(170,418,130,30);
        deposit.addActionListener(this);
        l1.add(deposit);
        
        
        withdrawl = new JButton("500");
        withdrawl.setBounds(375,418,130,30);
        withdrawl.addActionListener(this);
        l1.add(withdrawl);
        
        
        fastcash = new JButton("1000");
        fastcash.setBounds(170,453,130,30);
        fastcash.addActionListener(this);
        l1.add(fastcash);
        
        
        
        ministatement = new JButton("2000");
        ministatement.setBounds(375,453,130,30);
        ministatement.addActionListener(this);
        l1.add(ministatement);
        
        
        
        pinchange = new JButton("5000");
        pinchange.setBounds(170,488,130,30);
        pinchange.addActionListener(this);
        l1.add(pinchange);
        
        
        
        balanceenquiry = new JButton("10000");
        balanceenquiry.setBounds(375,488,130,30);
        balanceenquiry.addActionListener(this);
        l1.add(balanceenquiry);
        
        
        exit = new JButton("Back");
        exit.setBounds(375,523,130,30);
        exit.addActionListener(this);
        l1.add(exit);
        
        
        setTitle("Automated Teller Machine");
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pass).setVisible(true);
        }else{
            
            try{
                String amount = ((JButton)ae.getSource()).getText();
                DbConnection c = new DbConnection();
                ResultSet rs = c.st.executeQuery("select * from bank where pinno = '"+pass+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }
                
                Date date =  new Date();
                String query = "insert into bank values ('"+pass+"','"+date+"','Withdrawl','"+amount+"')";
                c.st.executeUpdate(query);
                
                
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited succesfully!");
                
                
                setVisible(false);
                new Transactions(pass).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    
    public static void main(String[] args){
        new FastCash("");
    }
}
