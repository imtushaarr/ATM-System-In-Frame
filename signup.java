package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signup extends  JFrame implements ActionListener {


    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pcTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    public
    long random;

    signup() {

        setLayout(null);

        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Arial", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personaldetails = (new JLabel("Page 1: Personal Details"));
        personaldetails.setFont(new Font("Arial", Font.BOLD, 18));
        personaldetails.setBounds(290, 80, 400, 30);
        add(personaldetails);

        JLabel name = (new JLabel("Name :"));
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);


        JLabel fname = (new JLabel("Father's Name :"));
        fname.setFont(new Font("Arial", Font.PLAIN, 18));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);


        JLabel dob = (new JLabel("DOB :"));
        dob.setFont(new Font("Arial", Font.PLAIN, 18));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setBackground(Color.white);
        add(dateChooser);


        JLabel gender = (new JLabel("Gender :"));
        gender.setFont(new Font("Arial", Font.PLAIN, 18));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 120, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = (new JLabel("E-Mail Address :"));
        email.setFont(new Font("Arial", Font.PLAIN, 18));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel ms = (new JLabel("Merital Status :"));
        ms.setFont(new Font("Arial", Font.PLAIN, 18));
        ms.setBounds(100, 390, 200, 30);
        add(ms);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        add(other);

        ButtonGroup meritalgroup = new ButtonGroup();
        meritalgroup.add(married);
        meritalgroup.add(unmarried);
        meritalgroup.add(other);

        JLabel address = (new JLabel("Address :"));
        address.setFont(new Font("Arial", Font.PLAIN, 18));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = (new JLabel("City :"));
        city.setFont(new Font("Arial", Font.PLAIN, 18));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = (new JLabel("State :"));
        state.setFont(new Font("Arial", Font.PLAIN, 18));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pc = (new JLabel("Pin Code :"));
        pc.setFont(new Font("Arial", Font.PLAIN, 18));
        pc.setBounds(100, 590, 200, 30);
        add(pc);

        pcTextField = new JTextField();
        pcTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        pcTextField.setBounds(300, 590, 400, 30);
        add(pcTextField);

        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

//        only letters accepted


        nameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isWhitespace(c) || Character.isLetter(c)){
                    nameTextField.setEditable(true);
                } else
                    nameTextField.setEditable(false);
            }
        });

        nameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isWhitespace(c) || Character.isLetter(c)){
                    nameTextField.setEditable(true);
                } else
                    nameTextField.setEditable(false);
            }
        });

        fnameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isWhitespace(c) || Character.isLetter(c)){
                    fnameTextField.setEditable(true);
                } else
                    fnameTextField.setEditable(false);
            }
        });

        cityTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isWhitespace(c) || Character.isLetter(c)){
                    cityTextField.setEditable(true);
                } else
                    cityTextField.setEditable(false);
            }
        });

        stateTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isWhitespace(c) || Character.isLetter(c)){
                    stateTextField.setEditable(true);
                } else
                    stateTextField.setEditable(false);
            }
        });

        pcTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isDigit(c)){
                    pcTextField.setEditable(true);
                } else
                    pcTextField.setEditable(false);
            }
        });



        getContentPane().setBackground(Color.WHITE);

            setSize(850, 800);
            setLocation(350, 10);
        setResizable(false);
            setVisible(true);

            //for program close
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });



    }


    public void actionPerformed(ActionEvent e) {
        int formno = Integer.parseInt(String.valueOf(random)); //long
        String name = nameTextField.getText(); //setText
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";

        }

        String email = emailTextField.getText();
        if (!email.contains("@") || !email.contains(".com")){
            JOptionPane.showMessageDialog(null,"Mail Id Not Valid!");
            return;
        }
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pc = pcTextField.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
            return;
        }
        if(fname.equals("")){
            JOptionPane.showMessageDialog(null, "Father's name is Required");
            return;
        }
        if(dob.equals("")){
            JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            return;
        }
        if(!male.isSelected() && !female.isSelected()){
            JOptionPane.showMessageDialog(null, "Gender is Required");
            return;
        }
        if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Email is Required");
            return;
        }
        if(!married.isSelected() && !unmarried.isSelected() && !other.isSelected()){
            JOptionPane.showMessageDialog(null, "Maritial status is Required");
            return;
        }
        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Address is Required");
            return;
        }
        if(city.equals("")){
            JOptionPane.showMessageDialog(null, "City is Required");
            return;
        }
        if(state.equals("")){
            JOptionPane.showMessageDialog(null, "State is Required");
            return;
        }
        if(pc.equals("")){
            JOptionPane.showMessageDialog(null, "Pincode is Required");
            return;
        }



       try {
                conn c = new conn();
                String query = "insert into signup values (" + formno + ",'" + name + "','" + fname + "', '" + dob + "', '" + email + "', '" + gender + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pc + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signup2(formno).setVisible(true);

        } catch (Exception a) {
            System.out.println(a);

        }
    }
        public static void main (String[] args){
            new signup();

        }
    }
