package UniversityManagement;

import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener{

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaddhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit,cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent(){
        setSize(900,700);
        setLocation(350,50);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        //Name 
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        //Name TextField
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        //Father Name
        JLabel lblfname = new JLabel("Father's Name :");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        // Father Name Textfield
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        //Roll No
        JLabel lblrollno = new JLabel("Roll Number :");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        //Auto Generate Roll No
        labelrollno = new JLabel("1533"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        //DOB
        JLabel lbldob = new JLabel("Date of Birth :");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        // DoB calender
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        //Address
        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        // Address Textfield
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        //Phone No
        JLabel lblphone = new JLabel("Phone No :");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        // Phone Textfield
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        //Email
        JLabel lblemail = new JLabel("Email :");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        // Email Textfield
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        //X Percent
        JLabel lblx = new JLabel("Class X (%) :");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        // X Percent Textfield
        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);

        //Xii Percent
        JLabel lblxii = new JLabel("Class XII (%) :");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        // Xii Percent Textfield
        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);

        //Addhar No
        JLabel lbladdhar = new JLabel("Aadhar Number :");
        lbladdhar.setBounds(400,350,200,30);
        lbladdhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdhar);

        //Addhar No Textfield
        tfaddhar = new JTextField();
        tfaddhar.setBounds(600, 350, 150, 30);
        add(tfaddhar);

        //Course 
        JLabel lblcourse = new JLabel("Course :");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        //Drop Down for course
        String course[] = {" ","B.Tech","BE","BCA","BCom","BBA","MSc","MBA","MCom","BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        //Branch Name 
        JLabel lblbranch = new JLabel("Branch :");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        //Drop Down for Branch Name
        String branch[] = {" ","CSE","IT","Chemical","Mechanical","Architecture","Civil","Electronics","Textile"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaddhar.getText();
            String course = (String)cbcourse.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();

            try {
                String query = "insert into student values('"+name+"', '"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Inserted Succesfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}