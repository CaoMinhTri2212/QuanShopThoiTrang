package View;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JInternalFrame;

import Controller.sqlconnect;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FormSanPham extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private sqlconnect con;
	private Connection connection;
	DefaultTableModel defaultTableModel;
	JTable table;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtKC;
	private JTextField txtMau;
	private JTextField txtTL;
	private JTextField txt_NCC;
	private JTextField txtAnhSP;
	private JTextField txtGiaBan;
	private JTextField txtGiaSi;
	private JTextField txtMoTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSanPham frame = new FormSanPham();
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
	public FormSanPham() {
		getContentPane().setBackground(new Color(240, 240, 240));
		con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
		connection = con.getCon();
		setBounds(327, 0, 1008, 734);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sản Phẩm ");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		lblNewLabel.setBounds(78, 17, 211, 64);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 115, 960, 307);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		table = new JTable(defaultTableModel);
		table.setBackground(new Color(255, 255, 255));
		JScrollPane jScrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBounds(0, 0, 960, 307);
		panel.add(jScrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(39, 453, 943, 229);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(32, 36, 95, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(32, 73, 117, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kích cỡ:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(32, 111, 95, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Màu:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(32, 149, 95, 14);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Thể loại:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(32, 190, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Ảnh:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(506, 38, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Giá bán:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1.setBounds(506, 75, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Giá sỉ:");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(506, 113, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2 = new JLabel("Nhà cung cấp:");
		lblNewLabel_1_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_2.setBounds(506, 151, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1 = new JLabel("Mô tả:");
		lblNewLabel_1_2_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_2_1.setBounds(506, 190, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_2_1);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(152, 35, 228, 20);
		panel_1.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(152, 72, 228, 20);
		panel_1.add(txtTenSP);
		
		txtKC = new JTextField();
		txtKC.setColumns(10);
		txtKC.setBounds(152, 110, 228, 20);
		panel_1.add(txtKC);
		
		txtMau = new JTextField();
		txtMau.setColumns(10);
		txtMau.setBounds(152, 148, 228, 20);
		panel_1.add(txtMau);
		
		txtTL = new JTextField();
		txtTL.setColumns(10);
		txtTL.setBounds(152, 189, 228, 20);
		panel_1.add(txtTL);
		
		txt_NCC = new JTextField();
		txt_NCC.setColumns(10);
		txt_NCC.setBounds(627, 148, 228, 20);
		panel_1.add(txt_NCC);
		
		txtAnhSP = new JTextField();
		txtAnhSP.setColumns(10);
		txtAnhSP.setBounds(627, 35, 228, 20);
		panel_1.add(txtAnhSP);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(627, 72, 228, 20);
		panel_1.add(txtGiaBan);
		
		txtGiaSi = new JTextField();
		txtGiaSi.setColumns(10);
		txtGiaSi.setBounds(627, 110, 228, 20);
		panel_1.add(txtGiaSi);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(627, 189, 228, 20);
		panel_1.add(txtMoTa);
		
		JButton btnInsert = new JButton("Thêm Sản Phẩm");
		btnInsert.setBackground(new Color(0, 0, 0));
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBounds(373, 49, 141, 21);
		getContentPane().add(btnInsert);
		
		JButton btn_update = new JButton("Sửa Sản Phẩm");
		btn_update.setForeground(new Color(255, 255, 255));
		btn_update.setBackground(new Color(0, 0, 0));
		btn_update.setBounds(553, 49, 141, 21);
		getContentPane().add(btn_update);
		
		JButton btnXaSnPhm = new JButton("Xóa Sản Phẩm");
		btnXaSnPhm.setForeground(new Color(255, 255, 255));
		btnXaSnPhm.setBackground(new Color(0, 0, 0));
		btnXaSnPhm.setBounds(748, 49, 141, 21);
		getContentPane().add(btnXaSnPhm);

	}
}
