
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pass;
    
    Transactions(String pass){
        this.pass = pass;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,900,900);
        add(l1);
        
        JLabel l2 = new JLabel("Please select your transaction");
        l2.setBounds(225,300,700,35);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l1.add(l2);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,418,130,30);
        deposit.addActionListener(this);
        l1.add(deposit);
        
        
        withdrawl = new JButton("Cash Withdrawal");
        withdrawl.setBounds(375,418,130,30);
        withdrawl.addActionListener(this);
        l1.add(withdrawl);
        
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,453,130,30);
        fastcash.addActionListener(this);
        l1.add(fastcash);
        
        
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(375,453,130,30);
        ministatement.addActionListener(this);
        l1.add(ministatement);
        
        
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,488,130,30);
        pinchange.addActionListener(this);
        l1.add(pinchange);
        
        
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(375,488,130,30);
        balanceenquiry.addActionListener(this);
        l1.add(balanceenquiry);
        
        
        exit = new JButton("Exit");
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
        if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pass).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pass).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pass).setVisible(true); 
        }else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pass).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pass).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pass).setVisible(true);
        }else if(ae.getSource()==exit){
            System.exit(0);
        }
    }
    
    
    
    public static void main(String[] args){
        new Transactions("");
    }
}
