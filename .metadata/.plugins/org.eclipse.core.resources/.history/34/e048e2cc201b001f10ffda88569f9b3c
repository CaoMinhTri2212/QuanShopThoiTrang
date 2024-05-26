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

public class FormSanPham extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private sqlconnect con;
	private Connection connection;
	DefaultTableModel defaultTableModel;
	JTable table;

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
		panel_1.setBounds(39, 453, 943, 215);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
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
