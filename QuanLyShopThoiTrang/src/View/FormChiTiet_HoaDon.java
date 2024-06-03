package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.sqlconnect;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormChiTiet_HoaDon extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField edtSoLuong;
	private JTextField edtDonGia;
	DefaultTableModel defaultTableModel;
	JTable table;
	private sqlconnect con;
    private Connection connection;
    JComboBox cbxMaHD,cbxMaSP;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormChiTiet_HoaDon frame = new FormChiTiet_HoaDon();
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
	public FormChiTiet_HoaDon() {
		
		 con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
	      connection = con.getCon();
		setBounds(327, 0, 1008, 734);
		getContentPane().setLayout(null);
		
		JLabel lblQunLNhn = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setFont(new Font("Dialog", Font.BOLD, 36));
		lblQunLNhn.setBackground(Color.RED);
		lblQunLNhn.setBounds(185, 24, 343, 64);
		getContentPane().add(lblQunLNhn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(624, 84, 332, 539);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Mã Hóa Đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 44, 140, 13);
		panel_1.add(lblNewLabel);
		
		JLabel lblTnNhnVin = new JLabel("Mã Sản Phẩm");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhnVin.setBounds(24, 82, 140, 13);
		panel_1.add(lblTnNhnVin);
		
		edtSoLuong = new JTextField();
		edtSoLuong.setColumns(10);
		edtSoLuong.setBounds(155, 120, 167, 19);
		panel_1.add(edtSoLuong);
		
		edtDonGia = new JTextField();
		edtDonGia.setColumns(10);
		edtDonGia.setBounds(155, 149, 167, 19);
		panel_1.add(edtDonGia);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(24, 123, 140, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Đơn giá");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(24, 152, 140, 19);
		panel_1.add(lblNewLabel_1_3);
		
		JButton btnThemNV = new JButton("Thêm");
		btnThemNV.setBackground(new Color(0, 0, 255));
		btnThemNV.setForeground(new Color(255, 255, 255));
		btnThemNV.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int maHD = Integer.parseInt(cbxMaHD.getSelectedItem().toString());
		            int maSP = Integer.parseInt(cbxMaSP.getSelectedItem().toString());
		            int soLuong = Integer.parseInt(edtSoLuong.getText());
		            float giaBan = Float.parseFloat(edtDonGia.getText());
		            float tongTien = soLuong * giaBan;

		            CallableStatement callableStatement = connection.prepareCall("{call Pr_ThemChiTietHoaDon(?, ?, ?, ?, ?)}");
		            callableStatement.setInt(1, maHD);
		            callableStatement.setInt(2, maSP);
		            callableStatement.setInt(3, soLuong);
		            callableStatement.setFloat(4, giaBan);
		            callableStatement.setFloat(5, tongTien);
		            callableStatement.execute();

		            showChiTietHoaDon();
		            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn thành công!");
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết hóa đơn: " + ex.getMessage());
		        }
		    }
		});

		
		btnThemNV.setBounds(81, 236, 140, 21);
		panel_1.add(btnThemNV);
		
		JButton btnXoaNV = new JButton("Xóa");
		btnXoaNV.setForeground(new Color(255, 255, 255));
		btnXoaNV.setBackground(new Color(0, 0, 255));
		btnXoaNV.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow == -1) {
		                JOptionPane.showMessageDialog(null, "Vui lòng chọn chi tiết hóa đơn cần xóa!");
		                return;
		            }

		            int maHD = (int) table.getValueAt(selectedRow, 0);
		            int maSP = (int) table.getValueAt(selectedRow, 1);

		            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CHITIET_HOADON WHERE maHD = ? AND maSP = ?");
		            preparedStatement.setInt(1, maHD);
		            preparedStatement.setInt(2, maSP);
		            preparedStatement.executeUpdate();

		            showChiTietHoaDon();
		            JOptionPane.showMessageDialog(null, "Xóa chi tiết hóa đơn thành công!");
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Lỗi khi xóa chi tiết hóa đơn: " + ex.getMessage());
		        }
		    }
		});

		btnXoaNV.setBounds(81, 267, 140, 21);
		panel_1.add(btnXoaNV);
		
		cbxMaHD = new JComboBox();
		cbxMaHD.setBounds(155, 42, 167, 21);
		panel_1.add(cbxMaHD);
		
		cbxMaSP = new JComboBox();
		cbxMaSP.setBounds(155, 80, 167, 21);
		panel_1.add(cbxMaSP);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 114, 559, 434);
		getContentPane().add(panel);
		table = new JTable(defaultTableModel);
		table.setBackground(new Color(255, 255, 255));
		panel.setLayout(new BorderLayout());
		JScrollPane jScrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(jScrollPane,BorderLayout.CENTER);
		
		defaultTableModel=(DefaultTableModel)table.getModel();
		defaultTableModel.setColumnIdentifiers(new Object[] {
				"mã HD","mã SP","Số lượng","Giá","Tổng tiền"
		});
		showChiTietHoaDon();
		showcbxMaHD();
		showcbxSP();

	}
	public void showChiTietHoaDon() {
	    try {
	        String sql = "SELECT * FROM CHITIET_HOADON";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        while (resultSet.next()) {
	            int maHD = resultSet.getInt("maHD");
	            int maSP = resultSet.getInt("maSP");
	            int soLuong = resultSet.getInt("soLuong");
	            float giaBan = resultSet.getFloat("giaBan");
	            float tongTien = resultSet.getFloat("tongtien");

	            model.addRow(new Object[]{maHD, maSP, soLuong, giaBan, tongTien});
	        }

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị chi tiết hóa đơn: " + e.getMessage());
	    }
	}

	public void showcbxMaHD()
	{
		try {
			String sqlString="Select maHD from HOADON";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cbxMaHD.addItem(resultSet.getString("maHD"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void showcbxSP()
	{
		try {
			String sqlString="Select maSP from SANPHAM";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cbxMaSP.addItem(resultSet.getString("maSP"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
