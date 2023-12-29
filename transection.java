package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.Date;

public class transection extends JFrame implements ActionListener {

        JLabel text;

        JButton deposit, fastcash,cashwithdrawl,ministat,pinchng,balenqry,exit;
        BigInteger cardno;

        transection(BigInteger cardno) {
                this.cardno = cardno;



                setLayout(null);
                setSize(960,1080);ImagePanel panel = new ImagePanel(new ImageIcon("/Users/tushargupta/IdeaProjects/BMS/src/bankmanegmentsystem/assest/atm.jpg").getImage());
                getContentPane().add(panel);
                setResizable(false);
                setLocationRelativeTo(null);

//                Label

                text = new JLabel("Please Select Your Transection");
                text.setBounds(225,340,700,35);
                text.setForeground(Color.white);
                text.setFont(new Font("Arial", Font.BOLD, 18));
                panel.add(text);

//                Buttons

                deposit = new JButton("Deposite");
                deposit.setBounds(170,500,150,35);
                deposit.setFont(new Font("Arial", Font.PLAIN, 13));
                deposit.addActionListener(this);
                panel.add(deposit);

                fastcash = new JButton("Fast Cash");
                fastcash.setBounds(395,500,150,35);
                fastcash.setFont(new Font("Arial", Font.PLAIN, 13));
                fastcash.addActionListener(this);
                panel.add(fastcash);

                cashwithdrawl = new JButton("Cash withdrawl");
                cashwithdrawl.setBounds(170,560,150,35);
                cashwithdrawl.setFont(new Font("Arial", Font.PLAIN, 13));
                cashwithdrawl.addActionListener(this);
                panel.add(cashwithdrawl);

                ministat = new JButton("Mini Statement");
                ministat.setBounds(395,560,150,35);
                ministat.setFont(new Font("Arial", Font.PLAIN, 13));
                ministat.addActionListener(this);
                panel.add(ministat);

                pinchng = new JButton("Pin Change");
                pinchng.setBounds(170,620,150,35);
                pinchng.setFont(new Font("Arial", Font.PLAIN, 13));
                pinchng.addActionListener(this);
                panel.add(pinchng);

                balenqry = new JButton("Balance Enquiry");
                balenqry.setBounds(395,620,150,35);
                balenqry.setFont(new Font("Arial", Font.PLAIN, 13));
                balenqry.addActionListener(this);
                panel.add(balenqry);

//                Exit Button

                exit = new JButton("Close");
                exit.setBounds(270,695,150,35);
                exit.setFont(new Font("Arial", Font.PLAIN, 13));
                exit.addActionListener(this);
                panel.add(exit);


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

//        public static void main(String[] args){
//            new transection(123);
//
//
//        }


        public void actionPerformed(ActionEvent ae){
                if (ae.getSource()==exit){
                        System.exit(0);
                }else if (ae.getSource()==deposit){
                        setVisible(false);
                        new deposit(cardno).setVisible(true);

                } else if (ae.getSource()== cashwithdrawl) {
                        setVisible(false);
                        new withdrawl(cardno).setVisible(true);
                        
                }else if (ae.getSource()==fastcash){
                        setVisible(false);
                        new fastcash(cardno).setVisible(true);
                } else if (ae.getSource() == balenqry) {

                        conn c = new conn();


                        try{
                                ResultSet rs = c.s.executeQuery("Select * from depositamount where cardno = " + cardno);
                                int balance =0;
                                while(rs.next()){
                                        if(rs.getString("type").equals("deposit")){
                                                balance += Integer.parseInt(rs.getString("amount"));
                                        }else {
                                                balance -=Integer.parseInt(rs.getString("amount"));
                                        }
                                }
                                JOptionPane.showMessageDialog(null,"Your Current Balance is Rs. "+balance+"/-");

                                setVisible(false);
                                new transection(cardno).setVisible(true);

                        }catch (Exception e){
                                System.out.println(e);
                        }

                }
                else if (ae.getSource()== pinchng){
                        setVisible(false);
                        new pinchng().setVisible(true);
                }
                else if (ae.getSource()== ministat){
                        setVisible(false);
                        new MiniStatement(cardno).setVisible(true);
                }
        }

}



class ImagePanel extends JPanel {

        private Image img;

        public ImagePanel(String img) {
                this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
                this.img = img;
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
        }

        public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
        }

}