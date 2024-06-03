package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.sqlconnect;
import Model.HoaDon;
import javax.swing.border.TitledBorder;

public class FormHD extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbxMaNV;
    private JButton btnTaoHoaDon;
    private JLabel lblMKhuynMi;
    private JComboBox<String> cbxmakhuyenmai;
    private JLabel lblNewLabel;

    private sqlconnect con;
    private Connection connection;
    ArrayList<HoaDon> listhoadon;
    private JComboBox<String> cbxMaKH;
    private JButton btnUpdate;
    private JButton btnResport;
    DefaultTableModel defaultTableModel;
    JTable table;
    private JTextField txtsearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormHD frame = new FormHD();
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
	public FormHD() {
		
		con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
        connection = con.getCon();
        setBounds(327, 0, 1008, 734);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbngayhethong = new JLabel("");
        lbngayhethong.setForeground(new Color(0, 0, 255));
        lbngayhethong.setFont(new Font("Times New Roman", Font.ITALIC, 10));
        lbngayhethong.setBounds(855, 26, 100, 20);
        contentPane.add(lbngayhethong);
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        lbngayhethong.setText(currentDate.format(formatter));

        JLabel lblNgayLap = new JLabel("Ngày Lập:");
        lblNgayLap.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNgayLap.setBounds(702, 25, 100, 20);
        contentPane.add(lblNgayLap);

        JLabel lblMaKH = new JLabel("Mã Khách Hàng:");
        lblMaKH.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblMaKH.setBounds(731, 122, 246, 20);
        contentPane.add(lblMaKH);

        JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
        lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblMaNV.setBounds(731, 152, 100, 20);
        contentPane.add(lblMaNV);

        cbxMaNV = new JComboBox<>();
        cbxMaNV.setBounds(841, 152, 136, 20);
        contentPane.add(cbxMaNV);

        btnTaoHoaDon = new JButton("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String ngayLap = lbngayhethong.getText().toString().trim();
                    String maKH = cbxMaKH.getSelectedItem().toString();
                    String maNV = cbxMaNV.getSelectedItem().toString();
                    String maKM = cbxmakhuyenmai.getSelectedItem().toString();

                    String sql = "INSERT INTO HoaDon(ngayLap, maKH, maNV, maKM) VALUES (TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

                    PreparedStatement statement = connection.prepareStatement(sql);

                    statement.setString(1, ngayLap);
                    statement.setString(2, maKH);
                    statement.setString(3, maNV);
                    statement.setString(4, maKM);

                    int rowsInserted = statement.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(FormHD.this, "Hóa đơn đã được tạo thành công!");

                        cbxMaKH.setSelectedIndex(0);
                        cbxMaNV.setSelectedIndex(0);
                        cbxmakhuyenmai.setSelectedIndex(0);

                        showTableHoaDon(); // Refresh table data after adding new invoice
                    } else {
                        JOptionPane.showMessageDialog(FormHD.this, "Đã xảy ra lỗi khi tạo hóa đơn. Vui lòng thử lại sau!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FormHD.this, "Đã xảy ra lỗi khi tạo hóa đơn. Vui lòng thử lại sau!");
                }
            }
        });

        btnTaoHoaDon.setBackground(new Color(0, 0, 0));
        btnTaoHoaDon.setForeground(new Color(255, 255, 255));
        btnTaoHoaDon.setBounds(780, 258, 150, 30);
        contentPane.add(btnTaoHoaDon);

        lblMKhuynMi = new JLabel("Mã Khuyến mãi:");
        lblMKhuynMi.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblMKhuynMi.setBounds(731, 182, 100, 20);
        contentPane.add(lblMKhuynMi);

        cbxmakhuyenmai = new JComboBox<>();
        cbxmakhuyenmai.setBounds(841, 182, 136, 20);
        contentPane.add(cbxmakhuyenmai);

        lblNewLabel = new JLabel("Tạo Hóa Đơn");
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setBounds(76, 39, 199, 42);
        contentPane.add(lblNewLabel);

        cbxMaKH = new JComboBox<>();
        cbxMaKH.setBounds(841, 122, 136, 20);
        contentPane.add(cbxMaKH);

        JPanel panel = new JPanel();
        panel.setBounds(46, 107, 675, 384);

        contentPane.add(panel);
        panel.setLayout(null);
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setBackground(new Color(255, 255, 255));
        JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setBounds(0, 0, 675, 384);
        panel.add(jScrollPane);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
                    int selectedRow = table.getSelectedRow();
                    cbxMaKH.setSelectedItem(defaultTableModel.getValueAt(selectedRow, 2).toString());
                    cbxMaNV.setSelectedItem(defaultTableModel.getValueAt(selectedRow, 3).toString());
                    cbxmakhuyenmai.setSelectedItem(defaultTableModel.getValueAt(selectedRow, 4).toString());
                }
            }
        });

        showcbxmaKM();
        showcbxMANV();
        showcbxmaKH();

        defaultTableModel.setColumnIdentifiers(new Object[]{"Mã HD", "Ngày Lập", "Mã Khách Hàng", "Mã Nhân Viên", "Mã KM", "Thành Tiền"});
        table.setModel(defaultTableModel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Th\u1EF1c hi\u1EC7n ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(76, 546, 824, 148);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        txtsearch = new JTextField();
        txtsearch.setBounds(60, 23, 430, 25);
        panel_1.add(txtsearch);
        txtsearch.setColumns(10);
        
        JButton btntimkiem = new JButton("Tìm kiếm hóa đơn");
        btntimkiem.setBounds(584, 20, 123, 30);
        panel_1.add(btntimkiem);
        btntimkiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = txtsearch.getText().toString().trim();

                if (!searchText.isEmpty()) {
                    defaultTableModel.setRowCount(0);

                    String sql = "SELECT maHD, ngayLap, maKH, maNV, maKM, thanhTien FROM HoaDon WHERE 1=1";
                    
                    // Determine if the searchText is a number (potential maHD) or a date (potential ngayLap)
                    try {
                        Integer.parseInt(searchText); // Check if it can be parsed as an integer
                        sql += " AND maHD LIKE '%" + searchText + "%'";
                    } catch (NumberFormatException ex) {
                        // Not a number, assume it's a date
                        sql += " AND TO_CHAR(ngayLap, 'YYYY-MM-DD') = ?";
                    }

                    PreparedStatement preparedStatement = null;
                    ResultSet resultSet = null;

                    try {
                        preparedStatement = connection.prepareStatement(sql);

                        // If it's a date, set the parameter for the date
                        if (!sql.contains("maHD")) {
                            preparedStatement.setString(1, searchText);
                        }

                        resultSet = preparedStatement.executeQuery();

                        while (resultSet.next()) {
                            int maHD = resultSet.getInt("maHD");
                            Date ngayLap = resultSet.getDate("ngayLap");
                            int maKH = resultSet.getInt("maKH");
                            int maNV = resultSet.getInt("maNV");
                            int maKM = resultSet.getInt("maKM");
                            int thanhTien = resultSet.getInt("thanhTien");

                            defaultTableModel.addRow(new Object[]{maHD, ngayLap, maKH, maNV, maKM, thanhTien});
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(btntimkiem, "Không tìm thấy hóa đơn yêu cầu!");
                        e1.printStackTrace();
                    } finally {
                        try {
                            if (resultSet != null) resultSet.close();
                            if (preparedStatement != null) preparedStatement.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(btntimkiem, "Vui lòng nhập mã hóa đơn hoặc ngày lập để tìm kiếm!");
                }
            }
        });

        btntimkiem.setForeground(Color.WHITE);
        btntimkiem.setBackground(new Color(0, 0, 0));
        
                btnUpdate = new JButton("Cập nhât thành tiền");
                btnUpdate.setBounds(133, 80, 150, 30);
                panel_1.add(btnUpdate);
                btnUpdate.addActionListener(e -> {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int maHD = Integer.parseInt(defaultTableModel.getValueAt(selectedRow, 0).toString());
                        updateThanhTien(maHD);
                        showTableHoaDon(); // Refresh table data
                    } else {
                        JOptionPane.showMessageDialog(FormHD.this, "Vui lòng chọn một hóa đơn để cập nhật!");
                    }
                });
                btnUpdate.setForeground(new Color(255, 255, 255));
                btnUpdate.setBackground(new Color(0, 0, 0));
                
                        btnResport = new JButton("In Hóa Đơn");
                        btnResport.setBounds(443, 80, 150, 30);
                        panel_1.add(btnResport);
                        btnResport.setForeground(Color.WHITE);
                        btnResport.setBackground(new Color(0, 0, 0));

        showTableHoaDon();

	}
	 public ArrayList<HoaDon> getlistHoadon() {
	        ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
	        String sqlString = "Select * from HoaDon";
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                HoaDon hd = new HoaDon();
	                hd.setMahd(Integer.parseInt(resultSet.getString("maHD")));
	                hd.setNgaylap(resultSet.getDate("ngayLap"));
	                hd.setManv(Integer.parseInt(resultSet.getString("maNV")));
	                hd.setMakh(Integer.parseInt(resultSet.getString("maKH")));
	                hd.setMakm(Integer.parseInt(resultSet.getString("maKM")));
	                hd.setThanhtien(Integer.parseInt(resultSet.getString("thanhtien")));
	                listHD.add(hd);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return listHD;
	    }

	    public void showTableHoaDon() {
	        defaultTableModel.setRowCount(0);
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            String sql = "SELECT maHD, ngayLap, maKH, maNV, maKM, thanhTien FROM HoaDon";
	            preparedStatement = connection.prepareStatement(sql);
	            resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int maHD = resultSet.getInt("maHD");
	                Date ngayLap = resultSet.getDate("ngayLap");
	                int maKH = resultSet.getInt("maKH");
	                int maNV = resultSet.getInt("maNV");
	                int maKM = resultSet.getInt("maKM");
	                int thanhTien = resultSet.getInt("thanhTien");

	                defaultTableModel.addRow(new Object[]{maHD, ngayLap, maKH, maNV, maKM, thanhTien});
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị hóa đơn: " + e.getMessage());
	        } finally {
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void showcbxMANV() {
	        try {
	            String sqlString = "Select maNV from NhanVien";
	            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                cbxMaNV.addItem(resultSet.getString("maNV"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void showcbxmaKM() {
	        try {
	            String sqlString = "Select maKM from KhuyenMai";
	            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                cbxmakhuyenmai.addItem(resultSet.getString("maKM"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void showcbxmaKH() {
	        try {
	            String sqlString = "Select maKH from KhachHang";
	            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                cbxMaKH.addItem(resultSet.getString("maKH"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private void updateThanhTien(int maHD) {
	        CallableStatement callableStatement = null;
	        try {
	            callableStatement = connection.prepareCall("{CALL PROC_CAPNHAT_THANHTIEN(?)}");
	            callableStatement.setInt(1, maHD);
	            callableStatement.execute();
	            JOptionPane.showMessageDialog(this, "Cập nhật thành tiền thành công!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thành tiền: " + e.getMessage());
	        } finally {
	            try {
	                if (callableStatement != null) callableStatement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}