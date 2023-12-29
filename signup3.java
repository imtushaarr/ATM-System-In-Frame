package bankmanegmentsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener{

    JRadioButton acctypesc;

    JLabel accdetails,acctype,cardno,cardnox,cardnoycn,pin,pintt,pint,servicer;
    JRadioButton acctypefdc,acctypec,acctyperdc,atmc,inters,mobileb,ems,checkb,estat,tnc;
    JButton submit, cancel;
    ButtonGroup g1;

    static int formno;

    signup3(int formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("New Account Application - Page 3");

        g1 = new ButtonGroup();

         accdetails = (new JLabel("Page : 3 Account Details"));
        accdetails.setFont(new Font("Arial", Font.BOLD, 18));
        accdetails.setBounds(290,80,500,30);
        add(accdetails);

         acctype = (new JLabel("Account Type :"));
        acctype.setFont(new Font("Arial", Font.PLAIN, 18));
        acctype.setBounds(100,140,300,30);
        add(acctype);

        acctypesc = new JRadioButton("Saving Account");
        acctypesc.setBounds(100,190,200,30);
        add(acctypesc);

         acctypefdc = new JRadioButton(("Fix Deposite Account"));
        acctypefdc.setBounds(300,190,300,30);
        add(acctypefdc);

         acctypec = new JRadioButton("Current Account");
        acctypec.setBounds(100,230,200,30);
        add(acctypec);

         acctyperdc = new JRadioButton("Recurring Deposite Account");
        acctyperdc.setBounds(300,230,300,30);
        add(acctyperdc);

        g1.add(acctypesc);
        g1.add(acctypefdc);
        g1.add(acctypec);
        g1.add(acctyperdc);

         cardno = (new JLabel("Card Number :"));
        cardno.setFont(new Font("Arial", Font.PLAIN, 18));
        cardno.setBounds(100,290,300,30);
        add(cardno);

         cardnox = (new JLabel("XXXX-XXXX-XXXX-1234"));
        cardnox.setFont(new Font("Arial", Font.PLAIN, 18));
        cardnox.setBounds(320,290,500,30);
        add(cardnox);

         cardnoycn = (new JLabel("Your 16 Digit Card Number"));
        cardnoycn.setFont(new Font("Arial", Font.PLAIN, 8));
        cardnoycn.setBounds(100,305,400,30);
        add(cardnoycn);

         pin = (new JLabel("PIN :"));
        pin.setFont(new Font("Arial", Font.PLAIN, 18));
        pin.setBounds(100,350,400,30);
        add(pin);

         pintt = (new JLabel("Your 4 Digit Password"));
        pintt.setFont(new Font("Arial", Font.PLAIN, 8));
        pintt.setBounds(100,365,350,30);
        add(pintt);

         pint = (new JLabel("XX12"));
        pint.setFont(new Font("Arial", Font.PLAIN, 18));
        pint.setBounds(320,350,500,30);
        add(pint);

         servicer = (new JLabel("Service Required :"));
        servicer.setFont(new Font("Arial", Font.PLAIN, 18));
        servicer.setBounds(100,410,400,30);
        add(servicer);

         atmc = new JRadioButton("ATM Card");

        add(atmc);

         inters = new JRadioButton("Internet Service");

        add(inters);

         mobileb = new JRadioButton("Mobile Banking");
        add(mobileb);

         ems = new JRadioButton("eMail and SMS Service");

        add(ems);

         checkb = new JRadioButton("Check Book");

        add(checkb);

         estat = new JRadioButton("eStatement");
        add(estat);


        checkb.setBounds(300,540,300,30);
        inters.setBounds(100,460,300,30);
        atmc.setBounds(300,460,300,30);
        mobileb.setBounds(300,500,300,30);
        ems.setBounds(100,500,300,30);
        estat.setBounds(100,540,300,30);


         tnc = new JRadioButton("I hereby declears that the above entered details are correct to the best knowledge");
        tnc.setBounds(100,590,3000,30);
        add(tnc);

         submit = new JButton("Submit");
        submit.setBounds(320, 630, 80, 30);
        submit.addActionListener(this);
        add(submit);

         cancel = new JButton("Cancel");
        cancel.setBounds(420, 630, 80, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(cancel);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setResizable(false);
        setLocation(350,10);
        setVisible(true);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e){

        if (!tnc.isSelected()){
            JOptionPane.showMessageDialog(null,"Hereby is Required");
            return;

        }

        if (e.getSource() == submit){
            String acctype = null;
            if (acctypesc.isSelected()){
                acctype = "Saving Account";
            } else if (acctypefdc.isSelected()){
                acctype = "Fixed Deposite Account";
            } else if (acctypec.isSelected()){
                acctype = "Current Account";
            } else if (acctyperdc.isSelected()) {
                acctype = "Recurring Deposit Account";
            }

            Random random = new Random();
            long cardnumber = Math.abs((random.nextLong() % 90000000L)) + 5040936000000000L;

            int pinnumber = (int) Math.abs((random.nextLong() % 9000L)+10000L);

            String servicer = "";
            if (atmc.isSelected()){
                servicer = "ATM Card";
            } else if (inters.isSelected()) {
                servicer = "Internet Service";
            } else if (mobileb.isSelected()) {
                servicer = "Mobile Banking";
            } else if (ems.isSelected()) {
                servicer = "eMail & SMS Service";
            } else if (checkb.isSelected()) {
                servicer = "Check Book";
            } else if (estat.isSelected()){
                servicer = "eStatement";}


            try {
                conn c = new conn();
                String query1 = "insert into signup3 values (" + formno + "," + cardnumber + "," + pinnumber + ",'" + acctype + "','" + servicer + "')";
                String query2 = "insert into lonin values (" + formno + "," + cardnumber + "," + pinnumber + ")";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber + "\n Pin : "+ pinnumber );
                dispose();
                new login();


            } catch (Exception q) {
                System.out.println(q);
            }


        } else if (e.getSource()==cancel) {
            System.exit(0);
        }



    }
//
//    public static void main(String[] args) {
//        new bankmanegmentsystem.signup3(134);
//    }
}
