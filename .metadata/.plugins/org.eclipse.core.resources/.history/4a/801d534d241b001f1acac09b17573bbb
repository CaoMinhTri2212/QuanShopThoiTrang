package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.sqlconnect;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

public class FormNhanvien extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private sqlconnect con;
	private Connection connection;
	DefaultTableModel defaultTableModel;
	JTable table;
	private JTextField edtma;
	private JTextField edtten;
	private JTextField edtdate;
	private JTextField edtsdt;
	private JTextField edtdiachi;
	private JTextField edtmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNhanvien frame = new FormNhanvien();
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
	public FormNhanvien() {
		con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
		connection = con.getCon();
		setBounds(327, 0, 1008, 734);
		
		getContentPane().setBackground(new Color(240, 240, 240));
		getContentPane().setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("Quản Lý Nhân Viên");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setFont(new Font("Dialog", Font.BOLD, 36));
		lblQunLNhn.setBackground(Color.RED);
		lblQunLNhn.setBounds(239, 27, 343, 64);
		getContentPane().add(lblQunLNhn);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 101, 576, 509);
		getContentPane().add(panel);
		panel.setLayout(null);
		table = new JTable(defaultTableModel);
		table.setBackground(new Color(255, 255, 255));
		panel.setLayout(new BorderLayout());
		JScrollPane jScrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(jScrollPane,BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(637, 101, 332, 539);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 44, 140, 13);
		panel_1.add(lblNewLabel);
		
		edtma = new JTextField();
		edtma.setColumns(10);
		edtma.setBounds(155, 43, 167, 19);
		panel_1.add(edtma);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setBounds(24, 82, 140, 13);
		panel_1.add(lblTnNhnVin);
		
		edtten = new JTextField();
		edtten.setColumns(10);
		edtten.setBounds(155, 81, 167, 19);
		panel_1.add(edtten);
		
		edtdate = new JTextField();
		edtdate.setColumns(10);
		edtdate.setBounds(155, 120, 167, 19);
		panel_1.add(edtdate);
		
		JRadioButton rdNam = new JRadioButton("Nam");
		buttonGroup.add(rdNam);
		rdNam.setBounds(189, 164, 62, 21);
		panel_1.add(rdNam);
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		buttonGroup.add(rdNu);
		rdNu.setBounds(253, 164, 51, 21);
		panel_1.add(rdNu);
		
		edtsdt = new JTextField();
		edtsdt.setColumns(10);
		edtsdt.setBounds(155, 203, 167, 19);
		panel_1.add(edtsdt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(24, 123, 140, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới tính:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(24, 168, 140, 19);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(24, 206, 140, 19);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(24, 245, 140, 21);
		panel_1.add(lblNewLabel_1_4);
		
		JButton btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.setBounds(36, 386, 140, 21);
		panel_1.add(btnThemNV);
		
		JButton btnXoaNV = new JButton("Xóa nhân viên");
		btnXoaNV.setBounds(201, 386, 121, 21);
		panel_1.add(btnXoaNV);
		
		JButton btnSuaNV = new JButton("Sửa nhân viên");
		btnSuaNV.setBounds(117, 444, 132, 21);
		panel_1.add(btnSuaNV);
		
		edtdiachi = new JTextField();
		edtdiachi.setColumns(10);
		edtdiachi.setBounds(155, 248, 167, 19);
		panel_1.add(edtdiachi);
		
		edtmail = new JTextField();
		edtmail.setColumns(10);
		edtmail.setBounds(155, 288, 167, 19);
		panel_1.add(edtmail);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email: ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(24, 285, 140, 21);
		panel_1.add(lblNewLabel_1_4_1);
		
		
		

	}
	public ArrayList<NguyenLieu>getListNguyenlieu()
	{
		ArrayList<NguyenLieu>list=new ArrayList<NguyenLieu>();
		String sqlString="select *from nguyenlieu";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				NguyenLieu nguyenLieu=new NguyenLieu();
				nguyenLieu.setMaNguyenLieu(resultSet.getString("manguyenlieu"));
				nguyenLieu.setTenNguyenLieu(resultSet.getString("tennguyenlieu"));
				nguyenLieu.setDonViTinh(resultSet.getString("donvitinh"));
				list.add(nguyenLieu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
