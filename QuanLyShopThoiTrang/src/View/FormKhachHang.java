package View;

import java.awt.BorderLayout;
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
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.sqlconnect;
import Model.KhachHang;

public class FormKhachHang extends JInternalFrame {

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
    private JRadioButton rdNam, rdNu;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormKhachHang frame = new FormKhachHang();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FormKhachHang() {
        con = new sqlconnect("jdbc:oracle:thin:@localhost:1521:orclp", "SYS as SYSDBA", "123");
        connection = con.getCon();
        setBounds(327, 0, 1008, 734);

        getContentPane().setBackground(new Color(240, 240, 240));
        getContentPane().setLayout(null);

        JLabel lblQunLNhn = new JLabel("Quản Lý Thông Tin Khách Hàng");
        lblQunLNhn.setForeground(Color.RED);
        lblQunLNhn.setFont(new Font("Dialog", Font.BOLD, 36));
        lblQunLNhn.setBounds(62, 22, 567, 64);
        getContentPane().add(lblQunLNhn);

        JPanel panel = new JPanel();
        panel.setBounds(37, 101, 576, 509);
        getContentPane().add(panel);
        panel.setLayout(null);
        table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        panel.setLayout(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(jScrollPane, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(637, 101, 332, 539);
        getContentPane().add(panel_1);

        JLabel lblMaKH = new JLabel("Mã khách hàng: ");
        lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaKH.setBounds(24, 44, 140, 13);
        panel_1.add(lblMaKH);

        edtma = new JTextField();
        edtma.setColumns(10);
        edtma.setBounds(155, 43, 167, 19);
        panel_1.add(edtma);

        JLabel lblTenKH = new JLabel("Tên khách hàng:");
        lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTenKH.setBounds(24, 82, 140, 13);
        panel_1.add(lblTenKH);

        edtten = new JTextField();
        edtten.setColumns(10);
        edtten.setBounds(155, 81, 167, 19);
        panel_1.add(edtten);

        edtdate = new JTextField();
        edtdate.setColumns(10);
        edtdate.setBounds(155, 120, 167, 19);
        panel_1.add(edtdate);

        rdNam = new JRadioButton("Nam");
        buttonGroup.add(rdNam);
        rdNam.setBounds(189, 164, 62, 21);
        panel_1.add(rdNam);

        rdNu = new JRadioButton("Nữ");
        buttonGroup.add(rdNu);
        rdNu.setBounds(253, 164, 51, 21);
        panel_1.add(rdNu);

        edtsdt = new JTextField();
        edtsdt.setColumns(10);
        edtsdt.setBounds(155, 203, 167, 19);
        panel_1.add(edtsdt);

        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNgaySinh.setBounds(24, 123, 140, 13);
        panel_1.add(lblNgaySinh);

        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGioiTinh.setBounds(24, 168, 140, 19);
        panel_1.add(lblGioiTinh);

        JLabel lblSdt = new JLabel("Số điện thoại:");
        lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSdt.setBounds(24, 206, 140, 19);
        panel_1.add(lblSdt);

        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDiaChi.setBounds(24, 245, 140, 21);
        panel_1.add(lblDiaChi);

        edtdiachi = new JTextField();
        edtdiachi.setColumns(10);
        edtdiachi.setBounds(155, 248, 167, 19);
        panel_1.add(edtdiachi);

        edtmail = new JTextField();
        edtmail.setColumns(10);
        edtmail.setBounds(155, 288, 167, 19);
        panel_1.add(edtmail);

        JLabel lblEmail = new JLabel("Email: ");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmail.setBounds(24, 285, 140, 21);
        panel_1.add(lblEmail);

        JButton btnXoaKH = new JButton("Xóa khách hàng");
        btnXoaKH.setForeground(new Color(0, 0, 255));
        btnXoaKH.setBounds(24, 408, 140, 21);
        panel_1.add(btnXoaKH);

        JButton btnThemKH = new JButton("Thêm khách hàng");
        btnThemKH.setForeground(new Color(0, 0, 255));
        btnThemKH.setBounds(24, 365, 140, 21);
        panel_1.add(btnThemKH);

        btnThemKH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String maKH = edtma.getText();
                String tenKH = edtten.getText();
                String ngaySinh = edtdate.getText();
                String gioiTinh = rdNam.isSelected() ? "Nam" : "Nữ";
                String diaChi = edtdiachi.getText();
                String email = edtmail.getText();
                String sdt = edtsdt.getText();

                // Call the stored procedure to add a new customer
                try {
                    CallableStatement callableStatement = connection.prepareCall("{call Pr_ThemKhachHang(?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)}");
                    callableStatement.setString(1, maKH);
                    callableStatement.setString(2, tenKH);
                    callableStatement.setString(3, gioiTinh);
                    callableStatement.setString(4, ngaySinh);
                    callableStatement.setString(5, diaChi);
                    callableStatement.setString(6, sdt);
                    callableStatement.setString(7, email);
                    callableStatement.execute();

                    JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
                    showTableKhachHang();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi thêm khách hàng: " + ex.getMessage());
                }
            }
        });

        btnXoaKH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xoaKhachHang();
            }
        });

        
        defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setColumnIdentifiers(new Object[]{
                "Mã KH", "Tên KH", "Ngày Sinh", "Giới Tính", "Địa chỉ", "Email", "SDT"
        });
        showTableKhachHang();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String maKH = (String) table.getValueAt(selectedRow, 0);
                        String tenKH = (String) table.getValueAt(selectedRow, 1);
                        Date ngaySinh = (Date) table.getValueAt(selectedRow, 2);
                        String gioiTinh = (String) table.getValueAt(selectedRow, 3);
                        String diaChi = (String) table.getValueAt(selectedRow, 4);
                        String email = (String) table.getValueAt(selectedRow, 5);
                        String sdt = (String) table.getValueAt(selectedRow, 6);

                        // Display information in the corresponding JTextFields
                        edtma.setText(maKH);
                        edtten.setText(tenKH);
                        edtdate.setText(ngaySinh.toString());
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

    public void showTableKhachHang() {
        defaultTableModel.setRowCount(0);
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "{call proc_hienthi_khachhang(?)}";
            callableStatement = connection.prepareCall(sql);
            callableStatement.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            callableStatement.execute();
            resultSet = (ResultSet) callableStatement.getObject(1);

            while (resultSet.next()) {
                String maKH = resultSet.getString("maKH");
                String tenKH = resultSet.getString("tenKH");
                String gioiTinh = resultSet.getString("gioiTinh");
                Date date = resultSet.getDate("ngaySinh");
                String diaChi = resultSet.getString("diachi");
                String email = resultSet.getString("email");
                String sdt = resultSet.getString("sdt");
                defaultTableModel.addRow(new Object[]{maKH, tenKH, date, gioiTinh, diaChi, email, sdt});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị khách hàng: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (callableStatement != null) callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    

    // Method to delete a customer
    private void xoaKhachHang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String maKH = (String) table.getValueAt(selectedRow, 0);
            try {
                String sql = "DELETE FROM KhachHang WHERE maKH = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, maKH);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công");
                    showTableKhachHang(); // Refresh the table after deletion
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa khách hàng không thành công");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi xóa khách hàng: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng để xóa.");
        }
    }
}