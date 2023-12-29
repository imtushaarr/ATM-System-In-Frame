package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    BigInteger cardno;
    JLabel [] tn = new JLabel[10];

    MiniStatement(BigInteger cardno){
        this.cardno = cardno;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Your Last 8 Transaction Statement");
        bank.setBounds(90,20,500,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        for (int i = 0; i<10; i++){
            tn[i] = new JLabel();
            tn[i].setBounds(20,150+(i*40),300,20);
            add(tn[i]);
        }



        try {
            conn conn = new conn();
           ResultSet rs =  conn.s.executeQuery("Select * from depositamount where cardno = " + cardno);
           card.setText("Card Number : " + cardno);
           int i=0;
           while (rs.next()){
               if(i==tn.length)
                   break;
              String s1 = rs.getString("type");
              int s2 = rs.getInt("amount");
              tn[i].setText(s1 +"                               "+ s2);
              i++;

           }

        }catch (Exception e){
            System.out.println(e);

        }


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new transection(cardno).setVisible(true);
            }
        });
    }


}
