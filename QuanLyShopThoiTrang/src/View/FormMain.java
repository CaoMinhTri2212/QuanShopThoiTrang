package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FormMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
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
	public FormMain() {
		setTitle("Form Quản Lí");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 771);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 246, 734);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 157, 226, 2);
		panel.add(separator);
		
		JButton btn_formSanPham = new JButton("Sản Phẩm");
		btn_formSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormSanPham menu = new FormSanPham();
		        menu.setVisible(true); 
		        menu.setSize(desktopPane.getSize());
		        menu.setLocation(0, 0);
		        desktopPane.add(menu);
		        try {
		            menu.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
				
			}
		});
		btn_formSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		
		btn_formSanPham.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_formSanPham.setBackground(SystemColor.text);
		btn_formSanPham.setBounds(30, 169, 189, 46);
		panel.add(btn_formSanPham);
		
		JButton btn_KhachHang = new JButton("Khách Hàng");
		btn_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormKhachHang menu = new FormKhachHang();
		        menu.setVisible(true); 
		        menu.setSize(desktopPane.getSize());
		        menu.setLocation(0, 0);
		        desktopPane.add(menu);
		        try {
		            menu.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }

			}
		});
		
		btn_KhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btn_KhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_KhachHang.setBackground(Color.WHITE);
		btn_KhachHang.setBounds(30, 236, 189, 46);
		panel.add(btn_KhachHang);
		
		JButton btn_Thoat = new JButton("Đăng xuất");
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 FormDangNhap formDangNhap = new FormDangNhap();
			        // Hiển thị FormDangNhap
			     formDangNhap.setVisible(true);
			        // Đóng FormMain
			     dispose();
				
			}
		});

		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.setBounds(32, 672, 189, 52);
		panel.add(btn_Thoat);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 657, 226, 11);
		panel.add(separator_1);
		
		JButton btn_HoaDon = new JButton("Hóa đơn");
		btn_HoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormChiTiet_HoaDon menu = new FormChiTiet_HoaDon();
		        menu.setVisible(true); 
		        menu.setSize(desktopPane.getSize());
		        menu.setLocation(0, 0);
		        desktopPane.add(menu);
		        try {
		            menu.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
			}
		});

		btn_HoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btn_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_HoaDon.setBackground(Color.WHITE);
		btn_HoaDon.setBounds(30, 380, 189, 46);
		panel.add(btn_HoaDon);
		
		
		JButton btn_NhanVien = new JButton("Nhân viên");
		btn_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormNhanvien menu = new FormNhanvien();
		        menu.setVisible(true); 
		        menu.setSize(desktopPane.getSize());
		        menu.setLocation(0, 0);
		        desktopPane.add(menu);
		        try {
		            menu.setSelected(true);
		        } catch (java.beans.PropertyVetoException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		
		btn_NhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_NhanVien.setBackground(Color.WHITE);
		btn_NhanVien.setBounds(30, 307, 189, 46);
		panel.add(btn_NhanVien);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FormMain.class.getResource("/Icon/logo.jpg")));
		lblNewLabel.setBounds(30, 20, 170, 118);
		panel.add(lblNewLabel);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(256, 0, 969, 734);
		contentPane.add(desktopPane);
	}
}
