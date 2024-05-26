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
		panel.setBackground(SystemColor.info);
		panel.setBounds(0, 0, 246, 734);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 157, 226, 2);
		panel.add(separator);
		
		JButton btn__Form_menuMoAn = new JButton("Món Ăn");
		btn__Form_menuMoAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn__Form_menuMoAn.setHorizontalAlignment(SwingConstants.LEFT);
		
		btn__Form_menuMoAn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn__Form_menuMoAn.setBackground(SystemColor.text);
		btn__Form_menuMoAn.setBounds(30, 180, 189, 46);
		panel.add(btn__Form_menuMoAn);
		
		JButton btn__Form_menuNhapHang = new JButton("Nhập hàng");
		btn__Form_menuNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btn__Form_menuNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		btn__Form_menuNhapHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn__Form_menuNhapHang.setBackground(Color.WHITE);
		btn__Form_menuNhapHang.setBounds(30, 259, 189, 46);
		panel.add(btn__Form_menuNhapHang);
		
		JButton btn__Form_menuKhoHang = new JButton("Kho hàng");
		btn__Form_menuKhoHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		btn__Form_menuKhoHang.setHorizontalAlignment(SwingConstants.LEFT);
		btn__Form_menuKhoHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn__Form_menuKhoHang.setBackground(Color.WHITE);
		btn__Form_menuKhoHang.setBounds(30, 341, 189, 46);
		panel.add(btn__Form_menuKhoHang);
		
		JButton btn_Thoat = new JButton("Đăng xuất");
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.setBounds(32, 672, 189, 52);
		panel.add(btn_Thoat);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 657, 226, 11);
		panel.add(separator_1);
		
		JButton btn__Form_menuHoaDon = new JButton("Hóa đơn");

		btn__Form_menuHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btn__Form_menuHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn__Form_menuHoaDon.setBackground(Color.WHITE);
		btn__Form_menuHoaDon.setBounds(30, 417, 189, 46);
		panel.add(btn__Form_menuHoaDon);
		
		JButton btn__Form_menuDatBan = new JButton("Bàn");
		
		btn__Form_menuDatBan.setHorizontalAlignment(SwingConstants.LEFT);
		btn__Form_menuDatBan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn__Form_menuDatBan.setBackground(Color.WHITE);
		btn__Form_menuDatBan.setBounds(30, 493, 189, 46);
		panel.add(btn__Form_menuDatBan);
		
		
		JButton btn_Form_NhanVien = new JButton("Nhân viên");
		btn_Form_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btn_Form_NhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Form_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Form_NhanVien.setBackground(Color.WHITE);
		btn_Form_NhanVien.setBounds(30, 570, 189, 46);
		panel.add(btn_Form_NhanVien);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(256, 0, 969, 734);
		contentPane.add(desktopPane);
	}
}
