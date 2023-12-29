package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {

    JLabel text, subtext;
    JTextField amount;
    JButton back,withdraw;
    BigInteger cardno;

    withdrawl(BigInteger cardno){
        this.cardno = cardno;


        setLayout(null);
        setSize(960,1080);ImagePanel panel = new ImagePanel(new ImageIcon("/Users/tushargupta/IdeaProjects/BMS/src/bankmanegmentsystem/assest/atm.jpg").getImage());
        getContentPane().add(panel);
        setResizable(false);
        setLocationRelativeTo(null);

//        add text

        text = new JLabel("Enter the amount you want withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,18));
        text.setBounds(208,340,700,35);
        panel.add(text);

//        add text field

        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.PLAIN, 18));
        amount.setBounds(208,400,300,35);
        amount.setForeground(Color.red);
        amount.setHorizontalAlignment(JTextField.CENTER);
        panel.add(amount);

//       Button

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(395,620,150,35);
        withdraw.setFont(new Font("Arial", Font.PLAIN, 13));
        withdraw.addActionListener(this);
        panel.add(withdraw);





        //                Back Button

        back = new JButton("Back");
        back.setBounds(270,695,150,35);
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.addActionListener(this);
        panel.add(back);


//                Screen Layout


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== withdraw){
            Date date = new Date();
            if (amount.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw!");
            } else{
                int number  = Integer.parseInt(amount.getText());
                try {
                    conn conn = new conn();
                    String query  = "insert into depositamount values(" + cardno + ",\"" + date + "\"," + amount + ",\"withdrawal\")";
                    conn.s.execute(query);
                    JOptionPane.showMessageDialog(null, "₹ " + number + "/- Withdraw Successfully!");
                    setVisible(false);
                    new transection(cardno).setVisible(true);
                }catch (Exception e){
                    System.out.print(e);
                }

            }

        }else if (ae.getSource()== back){
            setVisible(false);
            new transection(cardno).setVisible(true);

        }
    }
}
