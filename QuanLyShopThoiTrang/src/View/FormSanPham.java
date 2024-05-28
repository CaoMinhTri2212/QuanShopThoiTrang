package View;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import Controller.sqlconnect;
import Model.NhanVien;
import Model.SanPham;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormSanPham extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private sqlconnect con;
	private Connection connection;
	DefaultTableModel defaultTableModel;
	JTable table;
	ArrayList<SanPham>listSanPham;
	private JTextField edtmasp;
	private JTextField edttnsp;
	private JTextField edtgiaban;
	private JTextField edtgiasi;
	private JTextField edtgianhap;
	private JTextField edtmota;
	private JTextField edtgiatang;
	private JTextField edtsoluong;
	private JTextField txtTimKiem;
	JButton btnTimKiem;
	JLabel lbhinhanh;

	JComboBox cbxkichco,cbxmau,cbxtheloai,cbxnhacungcap;
	private String selectedImagePath = "/path/to/images/default.png";

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
		getContentPane().setBackground(new Color(255, 255, 255));
		con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
		connection = con.getCon();
		
		setBounds(327, 0, 1008, 734);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sản Phẩm ");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		lblNewLabel.setBounds(44, 60, 211, 64);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(44, 192, 913, 224);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		table = new JTable(defaultTableModel);
		table.setBackground(new Color(255, 255, 255));
		JScrollPane jScrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBounds(0, 0, 916, 224);
		panel.add(jScrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(39, 450, 943, 264);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(32, 36, 117, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(32, 61, 117, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kích cỡ:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(32, 85, 95, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Màu:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(32, 113, 95, 14);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Thể loại:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(32, 137, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Giá bán:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1.setBounds(548, 85, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("Giá sỉ:");
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(548, 113, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2 = new JLabel("Nhà cung cấp:");
		lblNewLabel_1_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_2.setBounds(548, 61, 117, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1 = new JLabel("Giá nhập:");
		lblNewLabel_1_2_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_2_1.setBounds(548, 137, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_2_1);
		
		edtmasp = new JTextField();
		edtmasp.setBounds(152, 36, 305, 20);
		panel_1.add(edtmasp);
		edtmasp.setColumns(10);
		
		edttnsp = new JTextField();
		edttnsp.setColumns(10);
		edttnsp.setBounds(152, 60, 305, 20);
		panel_1.add(edttnsp);
		
		edtgiaban = new JTextField();
		edtgiaban.setColumns(10);
		edtgiaban.setBounds(653, 85, 228, 20);
		panel_1.add(edtgiaban);
		
		edtgiasi = new JTextField();
		edtgiasi.setColumns(10);
		edtgiasi.setBounds(653, 113, 228, 20);
		panel_1.add(edtgiasi);
		
		edtgianhap = new JTextField();
		edtgianhap.setColumns(10);
		edtgianhap.setBounds(653, 137, 228, 20);
		panel_1.add(edtgianhap);
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("Số lượng");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_2.setBounds(32, 169, 95, 20);
		panel_1.add(lblNewLabel_1_2_1_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1_1 = new JLabel("Mô tả:");
		lblNewLabel_1_2_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_2_1_1.setBounds(32, 199, 95, 14);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_2_1_1);
		
		edtmota = new JTextField();
		edtmota.setColumns(10);
		edtmota.setBounds(152, 199, 730, 20);
		panel_1.add(edtmota);
		
		cbxkichco = new JComboBox();
		cbxkichco.setBounds(152, 85, 305, 21);
		panel_1.add(cbxkichco);
		
		cbxmau = new JComboBox();
		cbxmau.setBounds(152, 112, 305, 21);
		panel_1.add(cbxmau);
		
		cbxtheloai = new JComboBox();
		cbxtheloai.setBounds(152, 136, 305, 21);
		panel_1.add(cbxtheloai);
		
		cbxnhacungcap = new JComboBox();
		cbxnhacungcap.setBounds(653, 60, 228, 21);
		panel_1.add(cbxnhacungcap);
		
		JLabel lblNewLabel_1_2_1_1_1_1_2_1_2 = new JLabel("Giá tăng");
		lblNewLabel_1_2_1_1_1_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1_2_1_2.setBounds(548, 161, 95, 26);
		panel_1.add(lblNewLabel_1_2_1_1_1_1_2_1_2);
		
		edtgiatang = new JTextField();
		edtgiatang.setColumns(10);
		edtgiatang.setBounds(653, 165, 228, 20);
		panel_1.add(edtgiatang);
		
		edtsoluong = new JTextField();
		edtsoluong.setColumns(10);
		edtsoluong.setBounds(152, 165, 305, 20);
		panel_1.add(edtsoluong);
		
		JButton btnInsert = new JButton("Thêm Sản Phẩm");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSP();
			}
		});
		btnInsert.setBackground(new Color(0, 0, 0));
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBounds(441, 60, 141, 21);
		getContentPane().add(btnInsert);
		
		JButton btn_update = new JButton("Sửa Sản Phẩm");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSP();
			}
		});
		btn_update.setForeground(new Color(255, 255, 255));
		btn_update.setBackground(new Color(0, 0, 0));
		btn_update.setBounds(277, 60, 141, 21);
		getContentPane().add(btn_update);
		
		JButton btnXaSnPhm = new JButton("Xóa Sản Phẩm");
		btnXaSnPhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSP();
				
			}
		});
		btnXaSnPhm.setForeground(new Color(255, 255, 255));
		btnXaSnPhm.setBackground(new Color(0, 0, 0));
		btnXaSnPhm.setBounds(619, 60, 141, 21);
		getContentPane().add(btnXaSnPhm);
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(277, 28, 308, 20);
		getContentPane().add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
				btnTimKiem = new JButton("Tìm Kiếm");
				btnTimKiem.setBounds(619, 28, 141, 20);
				getContentPane().add(btnTimKiem);
				btnTimKiem.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        timKiemSanPham();
				    }
				});
				btnTimKiem.setBackground(Color.BLACK);
				btnTimKiem.setForeground(Color.WHITE);
				
				lbhinhanh = new JLabel("");
				lbhinhanh.setBounds(809, 60, 130, 116);
				getContentPane().add(lbhinhanh);
				
				JButton btnedthinhanh = new JButton("");
				btnedthinhanh.setBackground(new Color(255, 255, 255));
				btnedthinhanh.addActionListener(e->{
					JFileChooser fileChooser = new JFileChooser();
		            fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
		            int result = fileChooser.showOpenDialog(this);
		            if (result == JFileChooser.APPROVE_OPTION) {
		                selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
		                ImageIcon icon = new ImageIcon(selectedImagePath);
		                Image img = icon.getImage().getScaledInstance(lbhinhanh.getWidth(), lbhinhanh.getHeight(),
		                        Image.SCALE_SMOOTH);
		                lbhinhanh.setIcon(new ImageIcon(img));
		            }
				});
				btnedthinhanh.setBounds(680, 112, 62, 48);
				btnedthinhanh.setIcon(new ImageIcon(FormSanPham.class.getResource("/Icon/documents.png")));
				getContentPane().add(btnedthinhanh);
				
				
				
					

		
		
		defaultTableModel=(DefaultTableModel)table.getModel();
		defaultTableModel.setColumnIdentifiers(new Object[] {
				"MaSP","Tên SP","Kich cỡ","Màu","Thể loại","Số lượng","Giá bán","Mô tả"
		});
		
		showTableSanPham();
		showcbxkichco();
		showcbxMau();
		showcbxNCC();
		showcbxTL();
		
		listSanPham = getListSanpham();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
	                if(table.getSelectedRow() >= 0)
	                {
	                	 SanPham sanpham =  listSanPham.get(table.getSelectedRow());
	                	edtmasp.setText(sanpham.getMaSP()+"");
		                edttnsp.setText(sanpham.getTenSP());
		                cbxkichco.setSelectedItem(sanpham.getKichCo());
		                cbxmau.setSelectedItem(sanpham.getMau());
		                cbxtheloai.setSelectedItem(sanpham.getTheLoai());
		                edtgiaban.setText(sanpham.getGiaBan()+"");
		                edtsoluong.setText(sanpham.getSoLuong()+"");
		                String imgPathString = sanpham.getAnh();
		                ImageIcon icon = null;
		                try {
		                	icon = new ImageIcon(imgPathString);
							
						} catch (NullPointerException ex) {
							// TODO: handle exception
							System.out.print("Image not found: "+ imgPathString);
						}
		                if(icon != null) {
		                	Image image = icon.getImage().getScaledInstance(lbhinhanh.getWidth(), lbhinhanh.getHeight(),Image.SCALE_SMOOTH);
		                	lbhinhanh.setIcon(new ImageIcon(image));
		                }
		                else {
							lbhinhanh.setIcon(null);
						}
		                
	                }
	                
			}
		});
		

	}
	public void showTableSanPham() {
	    defaultTableModel.setRowCount(0);
	    CallableStatement callableStatement = null;
	    ResultSet resultSet = null;

	    try {
	        String sql = "{call proc_hienthisp(?)}";
	        callableStatement = connection.prepareCall(sql);
	        callableStatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);

	        callableStatement.execute();

	        resultSet = (ResultSet) callableStatement.getObject(1);

	        while (resultSet.next()) {
	        	int masp =Integer.parseInt(resultSet.getString("maSP"));
	        	String tesp =resultSet.getString("tenSP");
	        	int kichco = Integer.parseInt(resultSet.getString("kichCo"));
	        	int mau = Integer.parseInt(resultSet.getString("mau"));
	        	int theloai = Integer.parseInt(resultSet.getString("theLoai"));
	        	int soluong = Integer.parseInt(resultSet.getString("soluong"));
	        	int giaban = Integer.parseInt(resultSet.getString("giaBan"));
	        	String mota = resultSet.getString("mota");
	            defaultTableModel.addRow(new Object[] {masp,tesp, kichco,mau,theloai,soluong,giaban,mota});
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị san phẩm: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (callableStatement != null) callableStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public ArrayList<SanPham> getListSanpham() {
	    ArrayList<SanPham> list = new ArrayList<SanPham>();
	    String sqlString = "SELECT * FROM SanPham";
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            SanPham sp = new SanPham();
	            sp.setMaSP(resultSet.getInt("maSP"));
	            sp.setTenSP(resultSet.getString("tenSP"));
	            sp.setKichCo(resultSet.getInt("kichCo"));
	            sp.setMau(resultSet.getInt("mau"));
	            sp.setTheLoai(resultSet.getInt("theLoai"));
	            sp.setAnh(resultSet.getString("anh"));
	            sp.setNhaCungCap(resultSet.getInt("nhaCungCap"));
	            sp.setSoLuong(resultSet.getInt("soLuong"));
	            sp.setGiaNhap(resultSet.getInt("giaNhap"));
	            sp.setGiaBan(resultSet.getInt("giaBan"));
	            sp.setGiaBanSi(resultSet.getInt("giaBanSi"));
	            sp.setGiaTang(resultSet.getInt("giaTang"));
	            sp.setMoTa(resultSet.getString("mota"));

	            list.add(sp);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	public void showcbxkichco()
	{
		try {
			String sqlString="Select maKC from KichCo";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cbxkichco.addItem(resultSet.getString("maKC"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void showcbxTL()
	{
		try {
			String sqlString="Select maTL from TheLoai";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cbxtheloai.addItem(resultSet.getString("maTL"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void showcbxNCC()
	{
		try {
			String sqlString="Select maNCC from NhaCungCap";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cbxnhacungcap.addItem(resultSet.getString("maNCC"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void showcbxMau()
	{
		try {
			String sqlString="Select maMau from Mau";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				cbxmau.addItem(resultSet.getString("maMau"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void themSP() {
	    try {
	        int maSP = Integer.parseInt(edtmasp.getText().toString());
	        String tenSP = edttnsp.getText();
	        int kichCo = Integer.parseInt(cbxkichco.getSelectedItem().toString());
	        int mau = Integer.parseInt(cbxmau.getSelectedItem().toString());
	        int theLoai = Integer.parseInt(cbxtheloai.getSelectedItem().toString());
	       
	        int nhaCungCap = Integer.parseInt(cbxnhacungcap.getSelectedItem().toString());
	        int soLuong = Integer.parseInt(edtsoluong.getText().toString());
	        int giaNhap = Integer.parseInt(edtgianhap.getText().toString());
	        int giaBan = Integer.parseInt(edtgiaban.getText().toString());
	        int giaBanSi = Integer.parseInt(edtgiasi.getText().toString());
	        int giaTang = Integer.parseInt(edtgiatang.getText().toString());
	        String moTa = edtmota.getText();

	        String sql = "{CALL AddProduct(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	        CallableStatement callableStatement = connection.prepareCall(sql);
	        callableStatement.setInt(1, maSP);
	        callableStatement.setString(2, tenSP);
	        callableStatement.setInt(3, kichCo);
	        callableStatement.setInt(4, mau);
	        callableStatement.setInt(5, theLoai);
	        callableStatement.setString(6, selectedImagePath);
	        callableStatement.setInt(7, nhaCungCap);
	        callableStatement.setInt(8, soLuong);
	        callableStatement.setInt(9, giaNhap);
	        callableStatement.setInt(10, giaBan);
	        callableStatement.setInt(11, giaBanSi);
	        callableStatement.setInt(12, giaTang);
	        callableStatement.setString(13, moTa);

	        callableStatement.execute();
	        JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
	        showTableSanPham(); // Refresh the table to show the new product
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi thêm sản phẩm: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi định dạng dữ liệu: " + e.getMessage());
	    }
	}
	public void xoaSP() {
	    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        try {
	            int maSP = Integer.parseInt(edtmasp.getText().toString().trim());

	            String sql = "DELETE FROM SanPham WHERE maSP = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, maSP);

	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công!");
	            } else {
	                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm để xóa.");
	            }

	            showTableSanPham(); // Refresh the table to show the changes
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi định dạng dữ liệu: " + e.getMessage());
	        }
	    }
	}
	public void suaSP() {
	    try {
	        int maSP = Integer.parseInt(edtmasp.getText().toString().trim());
	        String tenSP = edttnsp.getText();
	        String kichCo = cbxkichco.getSelectedItem().toString();
	        String mau = cbxmau.getSelectedItem().toString();
	        String theLoai = cbxtheloai.getSelectedItem().toString();
	        String nhaCungCap = cbxnhacungcap.getSelectedItem().toString();
	      
	        float giaBan = Float.parseFloat(edtgiaban.getText().toString().trim());
	        String moTa = edtmota.getText();

	        String sql = "UPDATE SanPham SET tenSP = ?, kichCo = ?, mau = ?, theLoai = ?, nhaCungCap = ?, anh = ?, giaBan = ?, moTa = ? WHERE maSP = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, tenSP);
	        preparedStatement.setString(2, kichCo);
	        preparedStatement.setString(3, mau);
	        preparedStatement.setString(4, theLoai);
	        preparedStatement.setString(5, nhaCungCap);
	        preparedStatement.setString(6, selectedImagePath);
	        preparedStatement.setFloat(7, giaBan);
	        preparedStatement.setString(8, moTa);
	        preparedStatement.setInt(9, maSP);

	        int rowsUpdated = preparedStatement.executeUpdate();
	        if (rowsUpdated > 0) {
	            JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công!");
	            showTableSanPham(); // Refresh the table to show the updated product
	        } else {
	            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã sản phẩm: " + maSP);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi sửa sản phẩm: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi định dạng dữ liệu: " + e.getMessage());
	    }
	}
	public void timKiemSanPham() {
	    String tenSanPham = txtTimKiem.getText().trim();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	    table.setRowSorter(sorter);
	    RowFilter<DefaultTableModel, Object> filter = RowFilter.regexFilter("(?i)" + tenSanPham, 1);
	    sorter.setRowFilter(filter);
	}
}
