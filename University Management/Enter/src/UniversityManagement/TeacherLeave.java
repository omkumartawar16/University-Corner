package UniversityManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


import com.toedter.calendar.JDateChooser;

public class TeacherLeave extends JFrame implements ActionListener{

    Choice cEmpid,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;

    TeacherLeave(){
        setSize(500,550);
        setLocation(550, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        
        // Heading
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);

        // Search by Roll no
        JLabel lblEmpid = new JLabel("Search by Employee Id");
        lblEmpid.setBounds(60, 100, 200, 20);
        lblEmpid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblEmpid);
        
        //Drop Down for Roll No
        cEmpid = new Choice(); 
        cEmpid.setBounds(60, 130, 200, 20);
        add(cEmpid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cEmpid.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Which Date Apply
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        // Date calender
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,23);
        add(dcdate);

        // Leave Duration
        JLabel lbltime = new JLabel("Leave Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);
        
        // Leave Drop down
        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String rollno = cEmpid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave values('"+rollno+"', '"+date+"','"+duration+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);  
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherLeave();
    }
}
