import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame{
    String pass;
    MiniStatement(String pass){
        this.pass = pass;
        setLayout(null);
        
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,250);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,30);
        bank.setFont(new Font("System",Font.BOLD,16));
        add(bank);
        
        JLabel bala = new JLabel();
        bala.setBounds(20,400,300,30);
        add(bala);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,30);
        card.setFont(new Font("System",Font.BOLD,14));
        add(card);
        
        try{
            
            DbConnection c = new DbConnection();
            ResultSet rs = c.st.executeQuery("Select * from login where pinno = '"+pass+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            DbConnection co = new DbConnection();
            int bal = 0;
            ResultSet rss = co.st.executeQuery("Select * from bank where pinno = '"+pass+"'");
            while(rss.next()){
                mini.setText(mini.getText()+"<html>"+rss.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rss.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rss.getString("amount")+"<br><br><html>");
                if(rss.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rss.getString("amount"));
                        
                }else{
                    bal -= Integer.parseInt(rss.getString("amount"));
                }
            }
            bala.setText("Your current balance is: Rs "+bal);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(400,600);
        setTitle("Mini Statement");
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
