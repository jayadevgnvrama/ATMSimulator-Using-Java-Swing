import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    JButton back, change;
    JPasswordField txt3, txt5, txtCurrentPin;
    String currentPin;

    PinChange(String currentPin) {
        this.currentPin = currentPin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 900, 900);
        add(l1);

        JLabel txt1 = new JLabel("CHANGE YOUR PIN");
        txt1.setForeground(Color.WHITE);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setBounds(250, 280, 500, 35);
        l1.add(txt1);

        JLabel txtCurrentPinLabel = new JLabel("Current PIN: ");
        txtCurrentPinLabel.setForeground(Color.WHITE);
        txtCurrentPinLabel.setFont(new Font("System", Font.BOLD, 16));
        txtCurrentPinLabel.setBounds(175, 330, 180, 25);
        l1.add(txtCurrentPinLabel);

        txtCurrentPin = new JPasswordField();
        txtCurrentPin.setFont(new Font("Raleway", Font.BOLD, 16));
        txtCurrentPin.setBounds(330, 330, 180, 25);
        l1.add(txtCurrentPin);

        JLabel txt2 = new JLabel("New PIN: ");
        txt2.setForeground(Color.WHITE);
        txt2.setFont(new Font("System", Font.BOLD, 16));
        txt2.setBounds(175, 370, 180, 25);
        l1.add(txt2);

        txt3 = new JPasswordField();
        txt3.setFont(new Font("Raleway", Font.BOLD, 16));
        txt3.setBounds(330, 370, 180, 25);
        l1.add(txt3);

        JLabel txt4 = new JLabel("Re-enter PIN: ");
        txt4.setForeground(Color.WHITE);
        txt4.setFont(new Font("System", Font.BOLD, 16));
        txt4.setBounds(175, 410, 180, 25);
        l1.add(txt4);

        txt5 = new JPasswordField();
        txt5.setFont(new Font("Raleway", Font.BOLD, 16));
        txt5.setBounds(330, 410, 180, 25);
        l1.add(txt5);

        change = new JButton("Change");
        change.setBounds(375, 483, 130, 30);
        change.addActionListener(this);
        l1.add(change);

        back = new JButton("Back");
        back.setBounds(375, 518, 130, 30);
        back.addActionListener(this);
        l1.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(currentPin).setVisible(true);
        } else if (ae.getSource() == change) {
            try {
                String enteredCurrentPin = new String(txtCurrentPin.getPassword());
                String npin = new String(txt3.getPassword());
                String rnpin = new String(txt5.getPassword());

                if (!enteredCurrentPin.equals(currentPin)) {
                    JOptionPane.showMessageDialog(null, "Current PIN is incorrect!");
                    return;
                }
                if (!npin.equals(rnpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match with the re-entered PIN!");
                    return;
                }
                if (npin.equals("") || rnpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the details!");
                    return;
                }

                DbConnection c = new DbConnection();
                String query1 = "update bank set pinno= '" + rnpin + "' where pinno = '" + currentPin + "'";
                String query2 = "update login set pinno= '" + rnpin + "' where pinno = '" + currentPin + "'";
                String query3 = "update signupthree set pinno= '" + rnpin + "' where pinno = '" + currentPin + "'";

                c.st.executeUpdate(query1);
                c.st.executeUpdate(query2);
                c.st.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully!");

                setVisible(false);
                new LoginPage().setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
