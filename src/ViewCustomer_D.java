import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewCustomer_D extends JFrame {

    private JPanel PView;
    private JButton backbtn;


    public static void main(String[] args) {
        ViewCustomer_D frame = new ViewCustomer_D();
        frame.setVisible(true);
    }


    public ViewCustomer_D() {


        initComponents();

    }



    private void initComponents() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("ramen.png"));
        setTitle("Ramen_Here");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1600, 800);
        PView = new JPanel();
        PView.setBackground(Color.GRAY);
        setContentPane(PView);
        PView.setLayout(null);

        JLabel backgroundlabel = new JLabel("");
        backgroundlabel.setIcon(new ImageIcon("view.jpg"));
        backgroundlabel.setBounds(0, 0, 1370, 749);


        backbtn = new JButton("Back");
        backbtn.setIcon(new ImageIcon("bckR.jpg"));
        backbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Recep_Dashboard_D a=new Recep_Dashboard_D();
                a.setVisible(true);

            }
        });
        backbtn.setForeground(new Color(220, 20, 60));
        backbtn.setBackground(new Color(255, 235, 205));
        backbtn.setBounds(0, 0, 139, 33);
        PView.add(backbtn);

        JLabel customerlbl = new JLabel("Customer Data");
        customerlbl.setForeground(Color.WHITE);
        customerlbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        customerlbl.setBounds(10, 203, 210, 40);
        PView.add(customerlbl);

        String n="",e="",f="",t="",b="";
        try {
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","databaseproject","databaseproject");
            PreparedStatement pst=con.prepareStatement("select * from Customer");
            ResultSet res=pst.executeQuery();
            DefaultTableModel model;
            model= new DefaultTableModel();

            JTable jTabel1= new JTable(model);


//                model.addColumn("Order ID");
            model.addColumn("Customer ID");
            model.addColumn("Name ");
            model.addColumn("Contact_NO");
            model.addColumn("CNIC");
            model.addColumn("Delivery Man ID");
            model.addRow(new Object[]{"Customer ID","Name ","Contact_NO","CNIC","Delivery Man ID"});
            model.addRow(new Object[]{"-","- ","- ","-","-"});

            while(res.next())
            {
                n=res.getString(1);
                e=res.getString(2);
                f=res.getString(3);
                t=res.getString(4);
                b=res.getString(5);
                model.addRow(new Object[]{n,e,f,t,b});
            }
            PView.setLayout(null);
            jTabel1.setBounds(10, 262, 680, 263);
            jTabel1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
//                PView.setSize(1200,800);
            PView.add(jTabel1);
//                PView.setVisible(true);
        }

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error");   }


        PView.add(backgroundlabel);
        setLocationRelativeTo(null);



    }
}


