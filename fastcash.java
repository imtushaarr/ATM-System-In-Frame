package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {

    JLabel text;

    JButton rs100, rs500,rs1000,rs2000,rs5000,rs10000,back;
    BigInteger cardno;

    fastcash(BigInteger cardno) {
        this.cardno = cardno;



        setLayout(null);
        setSize(960,1080);
        ImagePanel panel = new ImagePanel(new ImageIcon("/Users/tushargupta/IdeaProjects/BMS/src/bankmanegmentsystem/assest/atm.jpg").getImage());
        getContentPane().add(panel);
        setResizable(false);
        setLocationRelativeTo(null);

//                Label

        text = new JLabel("Please Select Your Withdrawal");
        text.setBounds(225,340,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(text);

//                Buttons

        rs100 = new JButton("Rs. 100");
        rs100.setBounds(170,500,150,35);
        rs100.setFont(new Font("Arial", Font.PLAIN, 13));
        rs100.addActionListener(this);
        panel.add(rs100);

        rs500 = new JButton("Rs. 500");
        rs500.setBounds(395,500,150,35);
        rs500.setFont(new Font("Arial", Font.PLAIN, 13));
        rs500.addActionListener(this);
        panel.add(rs500);

        rs1000 = new JButton("Rs. 1000");
        rs1000.setBounds(170,560,150,35);
        rs1000.setFont(new Font("Arial", Font.PLAIN, 13));
        rs1000.addActionListener(this);
        panel.add(rs1000);

        rs2000 = new JButton("Rs. 2000");
        rs2000.setBounds(395,560,150,35);
        rs2000.setFont(new Font("Arial", Font.PLAIN, 13));
        rs2000.addActionListener(this);
        panel.add(rs2000);

        rs5000 = new JButton("Rs. 5000");
        rs5000.setBounds(170,620,150,35);
        rs5000.setFont(new Font("Arial", Font.PLAIN, 13));
        rs5000.addActionListener(this);
        panel.add(rs5000);

        rs10000 = new JButton("Rs. 10000");
        rs10000.setBounds(395,620,150,35);
        rs10000.setFont(new Font("Arial", Font.PLAIN, 13));
        rs10000.addActionListener(this);
        panel.add(rs10000);

//                Exit Button

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
        if (ae.getSource()==back){
            setVisible(false);
            new transection(cardno).setVisible(true);
        }else {
           String amount = ((JButton)ae.getSource()).getText().substring(4);
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

               if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                   return;
               }

               Date date = new Date();
               String query  = "insert into depositamount values(" + cardno + ",\"" + date.toString() + "\"," + amount + ",'withdrawal')";
               c.s.execute(query);
               JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully!");

               setVisible(false);
               new transection(cardno).setVisible(true);

           }catch (Exception e){
               System.out.println(e);
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
}