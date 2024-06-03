package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.sqlconnect;
import Model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField editSDT;
	private JComboBox cbChucVu;
	private JRadioButton rdNam,rdNu;
	ArrayList<NhanVien>listNhanVien;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtname;
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
		btnThemNV.setBackground(new Color(0, 0, 0));
		btnThemNV.setForeground(new Color(255, 255, 255));
		btnThemNV.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int maNV = Integer.parseInt(edtma.getText());
		        String tenNV = edtten.getText();
		        String ngaySinh = edtdate.getText(); 
		        String gioiTinh = rdNam.isSelected() ? "Nam" : "Nữ";
		        String diaChi = edtdiachi.getText();
		        String email = edtmail.getText();
		        String sdt = edtsdt.getText();
		        
		        // Call the stored procedure to add a new employee
		        try {
		            CallableStatement callableStatement = connection.prepareCall("{call Pr_ThemNhanVien(?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)}");
		            callableStatement.setInt(1, maNV);
		            callableStatement.setString(2, tenNV);
		            callableStatement.setString(3, gioiTinh);
		            callableStatement.setString(4, ngaySinh);
		            callableStatement.setString(5, diaChi);
		            callableStatement.setString(6, sdt);
		            callableStatement.setString(7, email);
		            callableStatement.execute();
		            
		            JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
		            
		            // Refresh the table to display the new employee
		            showTableNhanVien();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân viên: " + ex.getMessage());
		        }
		    }
		});


		btnThemNV.setBounds(36, 386, 140, 21);
		panel_1.add(btnThemNV);
		
		JButton btnXoaNV = new JButton("Xóa nhân viên");
		btnXoaNV.setForeground(new Color(255, 255, 255));
		btnXoaNV.setBackground(new Color(0, 0, 0));
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNhanVien();
			}
		});
		btnXoaNV.setBounds(201, 386, 121, 21);
		panel_1.add(btnXoaNV);
		
		JButton btnSuaNV = new JButton("Sửa nhân viên");
		btnSuaNV.setForeground(new Color(255, 255, 255));
		btnSuaNV.setBackground(new Color(0, 0, 0));
		btnSuaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNhanVien();
			}
		});
		btnSuaNV.setBounds(119, 444, 132, 21);
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
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(636, 48, 167, 19);
		getContentPane().add(txtname);
		
		JButton btntimkiemnhanvien = new JButton("Tìm Kiếm Nhân Viên");
		btntimkiemnhanvien.setForeground(new Color(255, 255, 255));
		btntimkiemnhanvien.setBackground(new Color(0, 0, 0));
		btntimkiemnhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String tenNVString = txtname.getText().toString().trim();
			        if (!tenNVString.isEmpty()) {
			            defaultTableModel.setRowCount(0);
			            String callProcedure = "{CALL timNhanVien(?, ?)}";
			            CallableStatement callableStatement;
			            try {
			                callableStatement = connection.prepareCall(callProcedure);
			                callableStatement.setString(1, tenNVString);
			                callableStatement.registerOutParameter(2, java.sql.Types.REF_CURSOR);
			                callableStatement.execute();
			                
			                ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
			                while (resultSet.next()) {
			                	String maNV = resultSet.getString("maNV");
			    	            String tenNV = resultSet.getString("tenNV");
			    	            String gioiTinh = resultSet.getString("gioiTinh");
			    	            Date date = resultSet.getDate("ngaySinh");
			    	            String diaChi = resultSet.getString("diachi");
			    	            String email = resultSet.getString("email");
			    	            
			    	            String sdt = resultSet.getString("sdt");
			                    defaultTableModel.addRow(new Object[]{maNV, tenNV, gioiTinh,date,diaChi,email,sdt});
			                }
			                
			                resultSet.close();
			                callableStatement.close();
			            } catch (SQLException e1) {
			                JOptionPane.showMessageDialog(btntimkiemnhanvien, "Không tìm thấy nhân viên yêu cầu!");
			                e1.printStackTrace();
			            }
			        } else {
			            JOptionPane.showMessageDialog(btntimkiemnhanvien, "Vui lòng nhập tên nhân viên để tìm kiếm!");
			        }
			}
		});
		btntimkiemnhanvien.setBounds(837, 47, 132, 21);
		getContentPane().add(btntimkiemnhanvien);
		
		listNhanVien=getListNhanVien();
		defaultTableModel=(DefaultTableModel)table.getModel();
		defaultTableModel.setColumnIdentifiers(new Object[] {
				"Mã NV","Tên NV","Ngày Sinh","Giới Tính","Địa chỉ","Email","SDT"
		});
		showTableNhanVien();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		       
		        if (!event.getValueIsAdjusting()) {
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
		                // Lấy thông tin của nhân viên từ dòng được chọn
		                String maNV = (String) table.getValueAt(selectedRow, 0);
		                String tenNV = (String) table.getValueAt(selectedRow, 1);
		                Date ngaySinh = (Date) table.getValueAt(selectedRow, 2);
		                String gioiTinh = (String) table.getValueAt(selectedRow, 3);
		                String diaChi = (String) table.getValueAt(selectedRow, 4);
		                String email = (String) table.getValueAt(selectedRow, 5);
		                String sdt = (String) table.getValueAt(selectedRow, 6);
		                
		                // Hiển thị thông tin lên các JTextField tương ứng
		                edtma.setText(maNV);
		                edtten.setText(tenNV);
		                edtdate.setText(ngaySinh.toString()); // Chuyển định dạng Date sang String
		                if (gioiTinh.equals("Nam")) {
		                    rdNam.setSelected(true);
		                } else {
		                    rdNu.setSelected(true);
		                }
		                edtdiachi.setText(diaChi);
		                edtmail.setText(email);
		                edtsdt.setText(sdt);
		            }
		        }
		    }
		});
		

	}
	
	public void showTableNhanVien() {
	    defaultTableModel.setRowCount(0);
	    CallableStatement callableStatement = null;
	    ResultSet resultSet = null;

	    try {
	        String sql = "{call hien_thi_nhanvien(?)}";
	        callableStatement = connection.prepareCall(sql);
	        callableStatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

	        callableStatement.execute();

	        resultSet = (ResultSet) callableStatement.getObject(1);

	        while (resultSet.next()) {
	        	String maNV = resultSet.getString("maNV");
	            String tenNV = resultSet.getString("tenNV");
	            String gioiTinh = resultSet.getString("gioiTinh");
	            Date date = resultSet.getDate("ngaySinh");
	            String diaChi = resultSet.getString("diachi");
	            String email = resultSet.getString("email");
	            
	            String sdt = resultSet.getString("sdt");
	           
	            defaultTableModel.addRow(new Object[] {maNV,tenNV, date,gioiTinh,diaChi,email,sdt});
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị nhân viên: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (callableStatement != null) callableStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public ArrayList<NhanVien>getListNhanVien()
	{
		ArrayList<NhanVien>listNV=new ArrayList<NhanVien>();
		String sqlString="Select *from NhanVien";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				NhanVien nVien=new NhanVien();
				nVien.setMaNhanVien(resultSet.getString("maNV"));
				nVien.setTenNhanVien(resultSet.getString("tenNV"));
				nVien.setNgaySinh(resultSet.getDate("ngaySinh"));
				nVien.setGioiTinh(resultSet.getString("gioiTinh"));
				nVien.setSoDienThoai(resultSet.getString("sdt"));
				nVien.setDiachi(resultSet.getString("diachi"));
				nVien.setMail(resultSet.getString("email"));
				listNV.add(nVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listNV;
	}
	// Phương thức xóa nhân viên
	private void xoaNhanVien() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        String maNV = (String) table.getValueAt(selectedRow, 0);

	        // Thực hiện xóa nhân viên từ cơ sở dữ liệu
	        try {
	            String sql = "DELETE FROM NhanVien WHERE maNV = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, maNV);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công");
	                showTableNhanVien(); // Làm mới bảng sau khi xóa
	            } else {
	                JOptionPane.showMessageDialog(null, "Xóa nhân viên không thành công");
	            }
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Lỗi khi xóa nhân viên: " + ex.getMessage());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để xóa.");
	    }
	}

	// Phương thức cập nhật thông tin nhân viên
	private void suaNhanVien() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        String maNV = (String) table.getValueAt(selectedRow, 0);
	        String tenNV = edtten.getText();
	        String ngaySinh = edtdate.getText();
	        String diaChi = edtdiachi.getText();
	        String email = edtmail.getText();
	        String sdt = edtsdt.getText();

	       
	        try {
	            String sql = "UPDATE NhanVien SET tenNV = ?, ngaySinh = TO_DATE(?, 'YYYY-MM-DD'), diachi = ?, email = ?, sdt = ? WHERE maNV = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, tenNV);
	            preparedStatement.setString(2, ngaySinh);
	           
	            preparedStatement.setString(3, diaChi);
	            preparedStatement.setString(4, email);
	            preparedStatement.setString(5, sdt);
	            preparedStatement.setString(6, maNV);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhân viên thành công");
	                showTableNhanVien(); // Làm mới bảng sau khi cập nhật
	            } else {
	                JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhân viên không thành công");
	            }
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật thông tin nhân viên: " + ex.getMessage());
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên để cập nhật.");
	    }
	}
}
