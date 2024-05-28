package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.sqlconnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormDangNhap extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField edttentk;
    private JTextField edtmk;
    private sqlconnect con;
    private Connection connection;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormDangNhap frame = new FormDangNhap();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FormDangNhap() {
        con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
        connection = con.getCon();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setBounds(175, 29, 335, 66);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tên tài khoản:");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(122, 128, 117, 30);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu: ");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(122, 180, 117, 30);
        contentPane.add(lblNewLabel_1_1);

        edttentk = new JTextField();
        edttentk.setBounds(281, 132, 271, 27);
        contentPane.add(edttentk);
        edttentk.setColumns(10);

        edtmk = new JTextField();
        edtmk.setColumns(10);
        edtmk.setBounds(281, 184, 271, 27);
        contentPane.add(edtmk);

        JButton btndangnhap = new JButton("Đăng Nhập");
        btndangnhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        btndangnhap.setForeground(new Color(0, 0, 255));
        btndangnhap.setFont(new Font("Tahoma", Font.ITALIC, 12));
        btndangnhap.setBounds(165, 265, 117, 37);
        contentPane.add(btndangnhap);

        JButton btnthoat = new JButton("Thoát");
        btnthoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnthoat.setForeground(new Color(0, 0, 255));
        btnthoat.setBackground(new Color(255, 255, 255));
        btnthoat.setFont(new Font("Tahoma", Font.ITALIC, 12));
        btnthoat.setBounds(359, 265, 117, 37);
        contentPane.add(btnthoat);
    }

    public void login() {
        String userNameString = edttentk.getText().trim();
        String passwordString = edtmk.getText().trim();
        if (userNameString.equals("nhanvien01") && passwordString.equals("123")) {
            	
            		 JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                     new FormMain().setVisible(true);
                     this.setVisible(false);
            	
               
            } else {
                JOptionPane.showMessageDialog(this, "Tên tài khoản hoặc mật khẩu không đúng!");
            }
    } 
}
