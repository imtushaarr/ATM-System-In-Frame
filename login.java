package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class login extends JFrame implements ActionListener {
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    login(){
        setTitle("BANK MANAGEMENT SYSTEM");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanegmentsystem/assest/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10, 100,100);
        add(label);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Raleway", Font.PLAIN, 18));
        cardno.setBounds(120,150,400,40);
        add(cardno);

        cardTextField = new JTextField("");
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font ("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.PLAIN, 18));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new  JPasswordField("");
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font ("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300, 100, 30);
        /*bankmanegmentsystem.login.setBackground(Color.BLACK);
        bankmanegmentsystem.login.setForeground(Color.WHITE);*/
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300, 100, 30);
        /*clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);*/
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350, 230, 30);
        /*bankmanegmentsystem.signup.setBackground(Color.BLACK);
        bankmanegmentsystem.signup.setForeground(Color.WHITE);*/
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.white);

        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
        cardTextField.setText("");
        pinTextField.setText("");
        } else if  (ae.getSource() == login){

            if (Objects.equals(cardTextField.getText(), "") && Objects.equals(pinTextField.getText(), "")){
                JOptionPane.showMessageDialog(null,"Card No. is Required");
                return;
            }
            if (Objects.equals(pinTextField.getText(), "")){
                JOptionPane.showMessageDialog(null,"PIN No. is Required");
                return;
            }
            if (cardTextField.getText()=="" ){
                JOptionPane.showMessageDialog(null,"Card No. is Required");
                return;
            }

            try{
                conn c = new conn();
                BigInteger cardno = BigInteger.valueOf(Long.parseLong(cardTextField.getText()));
                int pin = Integer.parseInt(pinTextField.getText());
                String query1 = "select pin from lonin where cardno = '" + cardno + "'";
//                c.s.executeQuery(query1);
                try(Statement p = c.c.createStatement()){
                    try(ResultSet rs = p.executeQuery(query1)){
                        while (rs.next()){
                            if(rs.getInt(1)==pin){
                                dispose();
                                new transection(cardno).setVisible(true);
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Wrong Credentials!");
                    }
                }

            }catch (Exception e){
                System.out.println(e);
            }

        } else if  (ae.getSource() == signup){
            /*For fatch to bankmanegmentsystem.signup*/
            setVisible(false);
            new signup().setVisible(true);

        }

    }
    public static void main(String args[]){

        new login();
    }
}
