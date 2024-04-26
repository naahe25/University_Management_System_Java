import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import java.util.*;

public class AddStudent extends JFrame {

    JTextField tfname, tffname, tfdob, tfaddress, tfphone, tfemail, tfsscgpa, tfhscgpa;
    JLabel lablelrollno, lbladdress, lblphone, lblemail, lblsscgpa, lblhscgpa;

    Random ran = new Random();// For Generating random Number
    long first4 = Math.abs(ran.nextLong() % 9000L) + 1000L; // Generates a number between 1000 and 9999

    AddStudent() {
        setSize(900, 700);
        setLocation(500, 250);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(290, 10, 480, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblrollno = new JLabel("Roll Number:");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblrollno);

        lablelrollno = new JLabel("222-134-" + first4);
        lablelrollno.setBounds(210, 200, 200, 30);
        lablelrollno.setFont(new Font("Arial", Font.BOLD, 20));
        add(lablelrollno);

        JLabel lbldob = new JLabel("Date Of Birth:");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbldob);

        tfdob = new JTextField();
        tfdob.setBounds(600, 200, 150, 30);
        add(tfdob);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(400, 250, 200, 30);
        lbladdress.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(600, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(50, 250, 200, 30);
        lblphone.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("E-mail ID:");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblsscgpa = new JLabel("SSC GPA:");
        lblsscgpa.setBounds(400, 300, 200, 30);
        lblsscgpa.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblsscgpa);

        tfsscgpa = new JTextField();
        tfsscgpa.setBounds(600, 300, 150, 30);
        add(tfsscgpa);

        JLabel lblhscgpa = new JLabel("HSC GPA:");
        lblhscgpa.setBounds(400, 350, 200, 30);
        lblhscgpa.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblhscgpa);

        tfhscgpa = new JTextField();
        tfhscgpa.setBounds(600, 350, 150, 30);
        add(tfhscgpa);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
