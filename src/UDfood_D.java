import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UDfood_D extends JFrame {

    private JPanel PUD;
    private JButton backbtn;
    private JTextField Uidfld;
    private JTextField emailfld;
    private JTextField Didfld;


    public static void main(String[] args) {
        UDfood_D frame = new UDfood_D();
        frame.setVisible(true);
    }


    public UDfood_D() {


        initComponents();

    }



    private void initComponents() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\oop\\ramen.png"));
        setTitle("Ramen_Here");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1600, 800);
        PUD = new JPanel();
        PUD.setBackground(Color.GRAY);
        setContentPane(PUD);
        PUD.setLayout(null);

        JLabel backgroundlabel = new JLabel("");
        backgroundlabel.setIcon(new ImageIcon("F:\\DB I\\DB_project\\del.jpg"));
        backgroundlabel.setBounds(0, 0, 1370, 749);


        backbtn = new JButton("Back");
        backbtn.setIcon(new ImageIcon("F:\\DB I\\DB_project\\bckR.jpg"));
        backbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Admin_Dashboard_D a=new Admin_Dashboard_D();
                a.setVisible(true);

            }
        });
        backbtn.setForeground(new Color(220, 20, 60));
        backbtn.setBackground(new Color(255, 235, 205));
        backbtn.setBounds(0, 0, 139, 33);
        PUD.add(backbtn);

        JLabel updatelbl = new JLabel("Update Data");
        updatelbl.setForeground(Color.WHITE);
        updatelbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        updatelbl.setBounds(240, 191, 210, 40);
        PUD.add(updatelbl);

        JLabel dellbl = new JLabel("Delete Data");
        dellbl.setForeground(Color.WHITE);
        dellbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        dellbl.setBounds(1020, 192, 210, 40);
        PUD.add(dellbl);

        Uidfld = new JTextField();
        Uidfld.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Uidfld.setBounds(240, 267, 154, 30);
        PUD.add(Uidfld);
        Uidfld.setColumns(10);

        emailfld = new JTextField();
        emailfld.setFont(new Font("Tahoma", Font.PLAIN, 16));
        emailfld.setColumns(10);
        emailfld.setBounds(240, 318, 154, 30);
        PUD.add(emailfld);

        JLabel Uidlbl = new JLabel("ID:");
        Uidlbl.setForeground(Color.WHITE);
        Uidlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Uidlbl.setBounds(53, 270, 74, 22);
        PUD.add(Uidlbl);

        JLabel Uemaillbl = new JLabel("Updated Name :");
        Uemaillbl.setForeground(Color.WHITE);
        Uemaillbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Uemaillbl.setBounds(53, 322, 146, 22);
        PUD.add(Uemaillbl);

        JLabel Didlbl = new JLabel("ID:");
        Didlbl.setForeground(Color.WHITE);
        Didlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Didlbl.setBounds(935, 258, 74, 22);
        PUD.add(Didlbl);

        Didfld = new JTextField();
        Didfld.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Didfld.setColumns(10);
        Didfld.setBounds(1020, 254, 154, 30);
        PUD.add(Didfld);

        JButton updatebtn = new JButton("Update");
        updatebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));

        updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (UpdateAll.updatefood(Integer.parseInt(Uidfld.getText()),emailfld.getText())){
                        JOptionPane.showMessageDialog(null,"Updated");
                        Didfld.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Not Found");
                        Didfld.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        updatebtn.setBounds(240, 376, 110, 30);
        PUD.add(updatebtn);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (DeleteAll.deletefood(Integer.parseInt(Didfld.getText()))){
                        JOptionPane.showMessageDialog(null,"Deleted");
                        Didfld.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Not Found");
                        Didfld.setText("");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        btnDelete.setBounds(1020, 307, 110, 30);
        PUD.add(btnDelete);

        JLabel foodlbl = new JLabel("Food Data");
        foodlbl.setForeground(Color.WHITE);
        foodlbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        foodlbl.setBounds(599, 145, 180, 40);
        PUD.add(foodlbl);
        PUD.add(backgroundlabel);
        setLocationRelativeTo(null);



    }
}


