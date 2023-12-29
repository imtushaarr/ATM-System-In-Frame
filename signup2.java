package bankmanegmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class signup2 extends  JFrame implements ActionListener {

    JTextField pan, ac;
    JButton next;
    JRadioButton seniory, seniorn, ecy, ecn;
    JComboBox religion, category, income, edu, occu;
    static int formno;

    ButtonGroup g1,g2;

    signup2(int formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("New Account Application - Page 2");

        g1 = new ButtonGroup();
        g2 = new ButtonGroup();


        JLabel addidetails = (new JLabel("Page 2: Additional Details"));
        addidetails.setFont(new Font("Arial", Font.BOLD, 18));
        addidetails.setBounds(290, 80, 400, 30);
        add(addidetails);

        JLabel Religion = (new JLabel("Religion :"));
        Religion.setFont(new Font("Arial", Font.PLAIN, 18));
        Religion.setBounds(100, 140, 100, 30);
        add(Religion);

        String valReligion[] = {"Select Here","HINDU", "MUSLIM", "SIKH", "OTHER"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        add(religion);

        JLabel Category = (new JLabel("Category :"));
        Category.setFont(new Font("Arial", Font.PLAIN, 18));
        Category.setBounds(100, 190, 200, 30);
        add(Category);

        String valcategory[] = {"Select Here","GENERAL", "OBC", "ST", "SC", "OTHER"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        add(category);


        JLabel Income = (new JLabel("Income :"));
        Income.setFont(new Font("Arial", Font.PLAIN, 18));
        Income.setBounds(100, 240, 200, 30);
        add(Income);

        String valIncome[] = {"Select Here", "< 1,00,000", "< 5,00,00", "UPTO < 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel Qualification = (new JLabel("Qualification :"));
        Qualification.setFont(new Font("Arial", Font.PLAIN, 18));
        Qualification.setBounds(100, 290, 200, 30);
        add(Qualification);

        String valEdu[] = {"Select Here","NON-GRADUATE", "GRADUATE", "POST GRADUATE", "DOCTRATE", "OTHERS"};
        edu = new JComboBox(valEdu);
        edu.setBounds(300, 290, 400, 30);
        add(edu);

        JLabel Occupation = (new JLabel("Occupation :"));
        Occupation.setFont(new Font("Arial", Font.PLAIN, 18));
        Occupation.setBounds(100, 340, 200, 30);
        add(Occupation);

        String valOccu[] = {"Select Here","SALARIED", "SELF EMPLOYEE", "BUSINESSMEN", "STUDENT", "RETIRED", "OTHERS"};
        occu = new JComboBox(valOccu);
        occu.setBounds(300, 340, 400, 30);
        add(occu);

        JLabel Pan = (new JLabel("PAN Number :"));
        Pan.setFont(new Font("Arial", Font.PLAIN, 18));
        Pan.setBounds(100, 390, 200, 30);
        add(Pan);

        pan = new JTextField();
        pan.setFont(new Font("Arial", Font.PLAIN, 14));
        pan.setBounds(300, 390, 400, 30);
        add(pan);

        JLabel Adhar = (new JLabel("Aadhar Number :"));
        Adhar.setFont(new Font("Arial", Font.PLAIN, 18));
        Adhar.setBounds(100, 440, 200, 30);
        add(Adhar);

        ac = new JTextField();
        ac.setFont(new Font("Arial", Font.PLAIN, 14));
        ac.setBounds(300, 440, 400, 30);
        add(ac);

        JLabel senior = (new JLabel("Senior Citizen :"));
        senior.setFont(new Font("Arial", Font.PLAIN, 18));
        senior.setBounds(100, 490, 200, 30);
        add(senior);

        seniory = new JRadioButton("Yes");

        add(seniory);

        seniorn = new JRadioButton("No");
        seniory.setBounds(450, 490, 400, 30);
        seniorn.setBounds(300, 490, 400, 30);
        add(seniorn);

        g1.add(seniory);
        g1.add(seniorn);

        JLabel ec = (new JLabel("Exisiting Account :"));
        ec.setFont(new Font("Arial", Font.PLAIN, 18));
        ec.setBounds(100, 540, 200, 30);
        add(ec);

        ecy = new JRadioButton("Yes");

        add(ecy);

        ecn = new JRadioButton("No");
        ecy.setBounds(450, 540, 400, 30);
        ecn.setBounds(300, 540, 400, 30);
        add(ecn);

        g2.add(ecy);
        g2.add(ecn);

        next = new JButton("Next");
        next.setBounds(620, 590, 80, 30);
        next.addActionListener(this);
        add(next);


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
        String sreligion = (String) religion.getSelectedItem(); //setText
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String sedu = (String) edu.getSelectedItem();
        String soccu = (String) occu.getSelectedItem();
        if(sreligion.equals("Select Here")){
            JOptionPane.showMessageDialog(null,"Religion Select Required!");
            return;
        }

        if(scategory.equals("Select Here")){
            JOptionPane.showMessageDialog(null,"Category Select Required!");
            return;
        }

        if(sincome.equals("Select Here")){
            JOptionPane.showMessageDialog(null,"Income Select Required!");
            return;
        }

        if(sedu.equals("Select Here")){
            JOptionPane.showMessageDialog(null,"Qualification Select Required!");
            return;
        }

        if(soccu.equals("Select Here")){
            JOptionPane.showMessageDialog(null,"Occupation Select Required!");
            return;
        }

        String span = pan.getText();
        String sac = ac.getText();

        if(Objects.equals(span, "")){
            JOptionPane.showMessageDialog(null,"Pan Card Select Required!");
            return;
        }

        if(Objects.equals(sac, "")){
            JOptionPane.showMessageDialog(null,"Aadhar Card Select Required!");
            return;
        }

        if(!seniory.isSelected() && !seniorn.isSelected()){
                JOptionPane.showMessageDialog(null, "Senior option Required");
                return;
        }

        if(!ecy.isSelected() && !ecn.isSelected()){
            JOptionPane.showMessageDialog(null, "Existing account option Required");
            return;
        }

        String senior = null;
        if (seniory.isSelected()) {
            senior = "Yes";
        } else if (seniorn.isSelected()) {
            senior = "No";

        }

        String ec = null;
        if (ecy.isSelected()) {
            ec = "Yes";
        } else if (ecn.isSelected()) {
            ec = "No";
        }



        try {
            conn c = new conn();
            String query = "insert into signup2 values (" + formno + ",'" + sreligion + "','" + scategory + "', '" + sincome + "', '" + sedu + "', '" + soccu + "', '" + span + "', '" + sac + "', '" + senior + "', '" + ec + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signup3(formno).setVisible(true);

        } catch (Exception q) {
            System.out.println(q);
        }
    }

//    public static void main(String[] args) {
//        new bankmanegmentsystem.signup2(134);
//    }
}

