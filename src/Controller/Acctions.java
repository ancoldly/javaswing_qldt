package Controller;

import Connection.Connections;
import Model.KhachHang;
import Model.SanPham;
import View.View;
import View.ViewKH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;

public class Acctions extends JFrame {
    public static void Updatesp() {
        View.dfspgd.setRowCount(0);
        String cauLenhSQL = "Select * from SanPham";
        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
        DefaultTableModel model = (DefaultTableModel) View.tbspgd.getModel();
        Object objListSP [] = new Object[10];
        try{
            while (rs.next()) {
                objListSP [0] = rs.getString(1);
                objListSP [1] = rs.getString(2);
                objListSP [2] = rs.getString(3);
                objListSP [3] = rs.getString(4);
                objListSP [4] = rs.getString(5);
                objListSP [5] = rs.getString(6);
                objListSP [6] = rs.getString(7);
                objListSP [7] = rs.getString(8);
                model.addRow(objListSP);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void HTKH() {
        View.dfkhachhang.setRowCount(0);
        String cauLenhSQLKH = "Select * from KhachHang";
        ResultSet rsKH = Connections.ThucThiLenhSelect(cauLenhSQLKH);
        DefaultTableModel model = (DefaultTableModel) View.tbkhachhang.getModel();
        Object objListKH [] = new Object[10];
        try{
            while (rsKH.next()) {
                objListKH [0] = rsKH.getString(1);
                objListKH [1] = rsKH.getString(2);
                objListKH [2] = rsKH.getString(3);
                objListKH [3] = rsKH.getString(4);
                objListKH [4] = rsKH.getString(5);
                model.addRow(objListKH);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void HTDT()
    {
        //Hiển thị tổng doanh thu
        View.doanhthu.setText("0");
        String cauLenhSQL2 = "Select * from SanPhamBan";
        ResultSet rs2 = Connections.ThucThiLenhSelect(cauLenhSQL2);
        try {
            while (rs2.next()) {
                int doanhthu = Integer.parseInt(rs2.getString(5));
                int soluongban = Integer.parseInt(rs2.getString(8));
                int tongdoanhthu = doanhthu*soluongban;
                int doanhthuhienthi = Integer.parseInt(View.doanhthu.getText());
                int doanhthuview = tongdoanhthu+doanhthuhienthi;
                View.doanhthu.setText(String.valueOf(doanhthuview));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Acctions() {
        Connections.getColection();
        ViewKH viewKH = new ViewKH();
        //số sp
        String cauLenhSQL = "Select * from SanPham";
        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
        try {
            while (rs.next()) {
                View.soluongsp.setText(String.valueOf(rs.getRow()));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        //số khách hàng
        String cauLenhSQL1 = "Select * from KhachHang";
        ResultSet rs1 = Connections.ThucThiLenhSelect(cauLenhSQL1);
        try {
            while (rs1.next()) {
                View.khachhang.setText(String.valueOf(rs1.getRow()));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        //hiển thị doanh thu
        HTDT();
        //hiển thị tb kh
        HTKH();
        View.trangchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout center =(CardLayout)View.cardcenter.getLayout();
                center.show(View.cardcenter, "center1");

                CardLayout north =(CardLayout)View.cardnorth.getLayout();
                north.show(View.cardnorth, "north1");

                String cauLenhSQL = "Select * from SanPham";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                try {
                    while (rs.next()) {
                        View.soluongsp.setText(String.valueOf(rs.getRow()));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                String cauLenhSQL1 = "Select * from KhachHang";
                ResultSet rs1 = Connections.ThucThiLenhSelect(cauLenhSQL1);
                try {
                    while (rs1.next()) {
                        View.khachhang.setText(String.valueOf(rs1.getRow()));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                HTKH();
                HTDT();
            }
        });
        View.khach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewKH.nhapmakh.setText(null);
                ViewKH.nhapmakh.setEditable(false);
                ViewKH.nhaptenkh.setText(null);
                ViewKH.nhapsdt.setText(null);
                viewKH.setVisible(true);
                ViewKH.nhap.setEnabled(true);
                ViewKH.xoa.setEnabled(false);
                ViewKH.sua.setEnabled(false);
            }
        });
        ViewKH.thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewKH.setVisible(false);
            }
        });
        View.hanghoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout center =(CardLayout)View.cardcenter.getLayout();
                center.show(View.cardcenter, "center2");

                CardLayout north =(CardLayout)View.cardnorth.getLayout();
                north.show(View.cardnorth, "north2");

                View.dfsanpham.setRowCount(0);
                String cauLenhSQL = "Select * from SanPham";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                Object objListSP [] = new Object[10];
                try{
                    while (rs.next()) {
                        objListSP [0] = rs.getString(1);
                        objListSP [1] = rs.getString(2);
                        objListSP [2] = rs.getString(3);
                        objListSP [3] = rs.getString(4);
                        objListSP [4] = rs.getString(5);
                        objListSP [5] = rs.getString(6);
                        objListSP [6] = rs.getString(7);
                        objListSP [7] = rs.getString(8);
                        model.addRow(objListSP);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                View.nhapmasp.setEditable(false);
            }
        });
        View.giaodich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout center =(CardLayout)View.cardcenter.getLayout();
                center.show(View.cardcenter, "center3");

                CardLayout north =(CardLayout)View.cardnorth.getLayout();
                north.show(View.cardnorth, "north3");

                Updatesp();
                //hiển thị kh lên combox
                View.dskh.removeAllItems();
                View.dskh.addItem("Khách hàng bán lẻ");
                String cauLenhSQLHT = "Select * from KhachHang";
                ResultSet rsKH =  Connections.ThucThiLenhSelect(cauLenhSQLHT);
                try {
                    while (rsKH.next()) {
                        String tenkh = rsKH.getString(2);
                        View.dskh.addItem(tenkh);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //them sp
        View.nhapsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SanPham s = new SanPham();
                Random random = new Random();
                int ranNum = random.nextInt(300)+1;
                s.setMaSanPham("sp"+ranNum);

                String cauLenhSQLKTSP = "Select * from SanPham where masp = '"+s.getMaSanPham()+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQLKTSP);
                try {
                    while (rs.next()) {
                        s.setCheckMaSP(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(s.getCheckMaSP()==null) {
                    String tinhtrang = "";
                    if(View.dangkinhdoanh.isSelected()) {
                        tinhtrang+="Đang kinh doanh";
                    }
                    if(View.ngungkinhdoanh.isSelected()) {
                        tinhtrang+="Ngừng kinh doanh";
                    }
                    s.setTenSanPham(View.nhaptensp.getText());
                    s.setGiaSanPham(View.nhapgiasp.getText());
                    s.setSizeSanPham(String.valueOf(View.nhapsizesp.getSelectedItem()));
                    s.setLoaiSanPham(String.valueOf(View.nhaploaisp.getSelectedItem()));
                    s.setSoLuongSanPham(View.nhapsoluongsp.getText());
                    s.setMoTa(View.nhapmotasp.getText());
                    s.setTinhTrang(tinhtrang);

                    String cauLenhSQL = "INSERT INTO SanPham(masp,tensp,giasp,sizesp,loaisp,soluongsp,motasp,tinhtrangsp)"+
                            "VALUES"+
                            "('"+ s.getMaSanPham() + "'"+
                            ",N'"+ s.getTenSanPham() + "'"+
                            ",'"+ s.getGiaSanPham() + "'"+
                            ",'"+ s.getSizeSanPham() + "'"+
                            ",N'"+ s.getLoaiSanPham() + "'"+
                            ",'"+ s.getSoLuongSanPham() + "'"+
                            ",N'"+ s.getMoTa() + "'"+
                            ",N'"+ s.getTinhTrang() + "')";
                    Connections.ThucThi3Lenh(cauLenhSQL);
                    View.dfsanpham.addRow(new String [] {s.getMaSanPham(),s.getTenSanPham(),s.getGiaSanPham(),s.getSizeSanPham(),
                            s.getLoaiSanPham(),s.getSoLuongSanPham(),s.getMoTa(),s.getTinhTrang()});
                    View.nhapmasp.setText(s.getMaSanPham());
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sản phẩm đã được thêm!");
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Mã sản phẩm đã tồn tại!");
                }
            }
        });
        // nhap lai sp
        View.nhaplaisp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.nhapmasp.setText(null);
                View.nhaptensp.setText(null);
                View.nhapgiasp.setText(null);
                View.nhaploaisp.setSelectedItem(null);
                View.nhapsizesp.setSelectedItem(null);
                View.nhapmotasp.setText(null);
                View.nhapsoluongsp.setText(null);
                View.nhapmasp.setEditable(true);
            }
        });
        //xoa sp
        View.xoasp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = View.tbsanpham.getSelectedRow();
                int DSViTriXoaSP [] = View.tbsanpham.getSelectedRows();
                if(removeIndex == -1 ) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn sản phẩm cần xóa!");
                } else {
                    for(int i=DSViTriXoaSP.length-1;i>=0;i--) {
                        DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                        String MaSP = View.tbsanpham.getValueAt(DSViTriXoaSP[i],0).toString();
                        String cauLenhSQL = "Delete from SanPham where masp= "+"'"+MaSP+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                    }
                    View.dfsanpham.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sản phẩm đã được xóa!");
                }
            }
        });
        //sua sp
        View.suasp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SanPham s = new SanPham();
                String tinhtrang = "";
                if(View.dangkinhdoanh.isSelected()) {
                    tinhtrang+="Đang kinh doanh";
                }
                if(View.ngungkinhdoanh.isSelected()) {
                    tinhtrang+="Ngừng kinh doanh";
                }
                s.setMaSanPham(View.nhapmasp.getText());
                s.setTenSanPham(View.nhaptensp.getText());
                s.setGiaSanPham(View.nhapgiasp.getText());
                s.setLoaiSanPham(String.valueOf(View.nhaploaisp.getSelectedItem()));
                s.setSoLuongSanPham(View.nhapsoluongsp.getText());
                s.setSizeSanPham(String.valueOf(View.nhapsizesp.getSelectedItem()));
                s.setMoTa(View.nhapmotasp.getText());
                s.setTinhTrang(tinhtrang);
                int removeIndex = View.tbsanpham.getSelectedRow();
                String cauLenhSQL = "Update SanPham" +
                        " set tensp = N'"+ s.getTenSanPham() +"'"+
                        ", giasp = '"+ s.getGiaSanPham()+ "'" +
                        ", sizesp = '"+ s.getSizeSanPham()+ "'" +
                        ", loaisp = N'"+ s.getLoaiSanPham()+ "'" +
                        ", soluongsp = '"+ s.getSoLuongSanPham()+ "'" +
                        ", motasp   = N'"+ s.getMoTa()+ "'" +
                        ", tinhtrangsp = N'"+ s.getTinhTrang()+ "'" +
                        " Where masp = +'"+s.getMaSanPham()+"'";
                Connections.ThucThi3Lenh(cauLenhSQL);
                View.dfsanpham.removeRow(removeIndex);
                View.dfsanpham.addRow(new String [] {s.getMaSanPham(),s.getTenSanPham(),s.getGiaSanPham(),s.getSizeSanPham(),s.getLoaiSanPham(),s.getSoLuongSanPham(),s.getMoTa(),s.getTinhTrang()});
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sửa thông tin sản phẩm thành công!");
            }
        });
        //hienthi sp
        View.tbsanpham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = View.tbsanpham.getSelectedRow();
                String masp = View.tbsanpham.getValueAt(row,0).toString();
                String tensp = View.tbsanpham.getValueAt(row,1).toString();
                String giasp = View.tbsanpham.getValueAt(row,2).toString();
                String sizesp = View.tbsanpham.getValueAt(row,3).toString();
                String loaisp = View.tbsanpham.getValueAt(row,4).toString();
                String soluongsp = View.tbsanpham.getValueAt(row,5).toString();
                String motasp = View.tbsanpham.getValueAt(row,6).toString();
                String tinhtrangsp = View.tbsanpham.getValueAt(row,7).toString();
                //set gia tri len text
                View.nhapmasp.setText(masp);
                View.nhaptensp.setText(tensp);
                View.nhapgiasp.setText(giasp);
                View.nhapsizesp.setSelectedItem(sizesp);
                View.nhaploaisp.setSelectedItem(loaisp);
                View.nhapsoluongsp.setText(soluongsp);
                View.nhapmotasp.setText(motasp);
                if(tinhtrangsp.equals("Đang kinh doanh")) {
                    View.dangkinhdoanh.setSelected(true);
                }
                if(tinhtrangsp.equals("Ngừng kinh doanh")) {
                    View.ngungkinhdoanh.setSelected(true);
                }
                View.nhapmasp.setEditable(false);
            }
        });
        View.timkiemsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.dfsanpham.setRowCount(0);
                String tttt = View.nhapsptimkiem.getText();
                String cauLenhSQL = "Select * from SanPham where tensp like N'%"+tttt+"%' or masp = '"+tttt+"' or giasp = '"+tttt+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                Object objListSP [] = new Object[10];
                try {
                    while (rs.next()) {
                        objListSP [0] = rs.getString(1);
                        objListSP [1] = rs.getString(2);
                        objListSP [2] = rs.getString(3);
                        objListSP [3] = rs.getString(4);
                        objListSP [4] = rs.getString(5);
                        objListSP [5] = rs.getString(6);
                        objListSP [6] = rs.getString(7);
                        objListSP [7] = rs.getString(8);
                        model.addRow(objListSP);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        View.nhapsptimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==View.nhapsptimkiem) {
                    View.dfsanpham.setRowCount(0);
                    String tttt = View.nhapsptimkiem.getText();
                    String cauLenhSQL = "Select * from SanPham where tensp like N'%"+tttt+"%' or masp = '"+tttt+"' or giasp = '"+tttt+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                    DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                    Object objListSP [] = new Object[10];
                    try {
                        while (rs.next()) {
                            objListSP [0] = rs.getString(1);
                            objListSP [1] = rs.getString(2);
                            objListSP [2] = rs.getString(3);
                            objListSP [3] = rs.getString(4);
                            objListSP [4] = rs.getString(5);
                            objListSP [5] = rs.getString(6);
                            objListSP [6] = rs.getString(7);
                            objListSP [7] = rs.getString(8);
                            model.addRow(objListSP);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        View.timkiemtheoloai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==View.timkiemtheoloai) {
                    View.dfsanpham.setRowCount(0);
                    String tttt = String.valueOf(View.timkiemtheoloai.getSelectedItem());
                    String cauLenhSQL = "Select * from SanPham where loaisp = N'"+tttt+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                    DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                    Object objListSP [] = new Object[10];
                    try {
                        while (rs.next()) {
                            objListSP [0] = rs.getString(1);
                            objListSP [1] = rs.getString(2);
                            objListSP [2] = rs.getString(3);
                            objListSP [3] = rs.getString(4);
                            objListSP [4] = rs.getString(5);
                            objListSP [5] = rs.getString(6);
                            objListSP [6] = rs.getString(7);
                            objListSP [7] = rs.getString(8);
                            model.addRow(objListSP);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        View.timkiemtheotinhtrang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==View.timkiemtheotinhtrang) {
                    View.dfsanpham.setRowCount(0);
                    String tttt = String.valueOf(View.timkiemtheotinhtrang.getSelectedItem());
                    String cauLenhSQL = "Select * from SanPham where tinhtrangsp = N'"+tttt+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                    DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                    Object objListSP [] = new Object[10];
                    try {
                        while (rs.next()) {
                            objListSP [0] = rs.getString(1);
                            objListSP [1] = rs.getString(2);
                            objListSP [2] = rs.getString(3);
                            objListSP [3] = rs.getString(4);
                            objListSP [4] = rs.getString(5);
                            objListSP [5] = rs.getString(6);
                            objListSP [6] = rs.getString(7);
                            objListSP [7] = rs.getString(8);
                            model.addRow(objListSP);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        View.timkiemtheosize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==View.timkiemtheosize) {
                    View.dfsanpham.setRowCount(0);
                    String tttt = String.valueOf(View.timkiemtheosize.getSelectedItem());
                    String cauLenhSQL = "Select * from SanPham where sizesp = '"+tttt+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                    DefaultTableModel model = (DefaultTableModel) View.tbsanpham.getModel();
                    Object objListSP [] = new Object[10];
                    try {
                        while (rs.next()) {
                            objListSP [0] = rs.getString(1);
                            objListSP [1] = rs.getString(2);
                            objListSP [2] = rs.getString(3);
                            objListSP [3] = rs.getString(4);
                            objListSP [4] = rs.getString(5);
                            objListSP [5] = rs.getString(6);
                            objListSP [6] = rs.getString(7);
                            objListSP [7] = rs.getString(8);
                            model.addRow(objListSP);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        ViewKH.nhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KhachHang s = new KhachHang();
                Random random = new Random();
                int ranNum = random.nextInt(300)+1;
                s.setMaKh("KH"+ranNum);

                String cauLenhSQLKTKH = "Select * from KhachHang where makh = '"+s.getMaKh()+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQLKTKH);
                try {
                    while (rs.next()) {
                        s.setCheckMaKh(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(s.getCheckMaKh()==null) {
                    ViewKH.nhapmakh.setText(s.getMaKh());
                    s.setTen(ViewKH.nhaptenkh.getText());
                    s.setSdt(ViewKH.nhapsdt.getText());
                    String gioitinh = "";
                    if(ViewKH.nam.isSelected()) {
                        gioitinh+="Nam";
                    }
                    if(ViewKH.nu.isSelected()) {
                        gioitinh+="Nữ";
                    }
                    s.setGioiTinh(gioitinh);
                    String cauLenhSQL = "INSERT INTO KhachHang(makh,tenkh,gioitinh,sdt)"+
                            "VALUES"+
                            "('"+ s.getMaKh() + "'"+
                            ",N'"+ s.getTen() + "'"+
                            ",N'"+ s.getGioiTinh() + "'"+
                            ",'"+ s.getSdt() + "')";
                    Connections.ThucThi3Lenh(cauLenhSQL);
                    View.dfkhachhang.addRow(new String [] {s.getMaKh(),s.getTen(),s.getGioiTinh(),s.getSdt(),s.getSoHangDaMua()});
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thêm thành công!");
                    ViewKH.nhapmakh.setText(null);
                    ViewKH.nhaptenkh.setText(null);
                    ViewKH.nhapsdt.setText(null);
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Mã khách hàng đã tồn tại!");
                }
            }
        });
        View.tbkhachhang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = View.tbkhachhang.getSelectedRow();

                String ma = View.tbkhachhang.getValueAt(row,0).toString();
                String ten = View.tbkhachhang.getValueAt(row,1).toString();
                String gioitinh = View.tbkhachhang.getValueAt(row,2).toString();
                String sdt = View.tbkhachhang.getValueAt(row,3).toString();

                ViewKH.nhaptenkh.setText(ten);
                if(gioitinh.equals("Nam")) {
                    ViewKH.nam.setSelected(true);
                }
                if(gioitinh.equals("Nữ")) {
                    ViewKH.nu.setSelected(true);
                }
                ViewKH.nhapsdt.setText(sdt);
                ViewKH.nhapmakh.setText(ma);
                ViewKH.nhapmakh.setEditable(false);
                viewKH.setVisible(true);
                ViewKH.nhap.setEnabled(false);
                ViewKH.xoa.setEnabled(true);
                ViewKH.sua.setEnabled(true);
            }
        });
        ViewKH.xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = View.tbkhachhang.getSelectedRow();
                int DSViTri [] = View.tbkhachhang.getSelectedRows();
                if(removeIndex == -1) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn khách hàng cần xóa!");
                } else {
                    for(int i=DSViTri.length-1;i>=0;i--) {
                        String makh = View.tbkhachhang.getValueAt(DSViTri [i],0).toString();
                        DefaultTableModel model = (DefaultTableModel) View.tbkhachhang.getModel();
                        String cauLenhSQL = "Delete from KhachHang where makh = '"+makh+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                    }
                    View.dfkhachhang.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Khách hàng đã được xóa!");
                    viewKH.setVisible(false);
                }
            }
        });
        ViewKH.sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KhachHang s = new KhachHang();
                s.setMaKh(ViewKH.nhapmakh.getText());
                s.setTen(ViewKH.nhaptenkh.getText());
                s.setSdt(ViewKH.nhapsdt.getText());
                String gioitinh = "";
                if(ViewKH.nam.isSelected()) {
                    gioitinh+="Nam";
                }
                if(ViewKH.nu.isSelected()) {
                    gioitinh+="Nữ";
                }
                s.setGioiTinh(gioitinh);
                int removeIndex = View.tbkhachhang.getSelectedRow();
                String cauLenhSQL = "Update KhachHang" +
                        " set tenkh = N'"+ s.getTen() +"'"+
                        ", gioitinh = N'"+ s.getGioiTinh()+ "'" +
                        ", sdt = '"+ s.getSdt()+ "'" +
                        " Where makh = '"+s.getMaKh()+"'";
                Connections.ThucThi3Lenh(cauLenhSQL);
                View.dfkhachhang.removeRow(removeIndex);
                View.dfkhachhang.addRow(new String [] {s.getMaKh(),s.getTen(),s.getGioiTinh(),s.getSdt(),s.getSoHangDaMua()});
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sửa thành công!");
                viewKH.setVisible(false);
            }
        });
        View.timkiemspgd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.dfspgd.setRowCount(0);
                String tttt = View.nhaptimkiemspgd.getText();
                String cauLenhSQL = "Select * from SanPham where tensp like N'%"+tttt+"%' or masp = '"+tttt+"' or giasp = '"+tttt+"' or sizesp = '"+tttt+"' or loaisp = '"+tttt+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) View.tbspgd.getModel();
                Object objListSP [] = new Object[10];
                try {
                    while (rs.next()) {
                        objListSP [0] = rs.getString(1);
                        objListSP [1] = rs.getString(2);
                        objListSP [2] = rs.getString(3);
                        objListSP [3] = rs.getString(4);
                        objListSP [4] = rs.getString(5);
                        objListSP [5] = rs.getString(6);
                        objListSP [6] = rs.getString(7);
                        objListSP [7] = rs.getString(8);
                        model.addRow(objListSP);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        View.nhaptongtien.setText("0");
        View.nhaptongtien.setEditable(false);
        //lưu tạm
        View.luusoluongban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = View.tbspgd.getSelectedRow();
                String ttsp [] = new String[10];
                ttsp [0] = String.valueOf(View.dskh.getSelectedItem());
                ttsp [1] = View.nhapghichu.getText();
                ttsp [2] = View.tbspgd.getValueAt(row,0).toString();
                ttsp [3] = View.tbspgd.getValueAt(row,1).toString();
                ttsp [4] = View.tbspgd.getValueAt(row,2).toString();
                ttsp [5] = View.tbspgd.getValueAt(row,3).toString();
                ttsp [6] = View.tbspgd.getValueAt(row,4).toString();
                ttsp [7] = View.nhapsoluongban.getText();
                ttsp [8] = String.valueOf(java.time.LocalDate.now());

                int soluongsp = Integer.parseInt(View.tbspgd.getValueAt(row,5).toString());
                String soluongconlai = String.valueOf(soluongsp-Integer.parseInt(View.nhapsoluongban.getText()));

                String cauLenhSQLupdate = "Update SanPham"+
                        " set soluongsp = '"+ soluongconlai+ "'"+
                        " Where masp = '"+ttsp [2]+"'";
                Connections.ThucThi3Lenh(cauLenhSQLupdate);

                Updatesp();

                int giasp = Integer.parseInt(View.tbspgd.getValueAt(row,2).toString());
                int tongtiensp = giasp*Integer.parseInt(View.nhapsoluongban.getText());

                int tongtien = Integer.parseInt(View.nhaptongtien.getText())+tongtiensp;
                View.nhaptongtien.setText(String.valueOf(tongtien));

                View.dfspban.addRow(ttsp);
            }
        });
        View.xoaspmua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = View.tbspban.getSelectedRow();
                int DSViTri [] = View.tbspban.getSelectedRows();

                int row = View.tbspban.getSelectedRow();

                int tongtien = Integer.parseInt(View.nhaptongtien.getText());

                int tienban = Integer.parseInt(View.tbspban.getValueAt(row,4).toString())*Integer.parseInt(View.tbspban.getValueAt(row,7).toString());

                int tongtiennew = tongtien-tienban;

                View.nhaptongtien.setText(String.valueOf(tongtiennew));
                ////
                String maspban = View.tbspban.getValueAt(row,2).toString();

                String cauLenhSelectsp = "Select * from SanPham where masp = '"+maspban+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSelectsp);

                try {
                    while (rs.next()) {
                        String soluongsp = rs.getString(6);
                        int soluongspxoa = Integer.parseInt(View.tbspban.getValueAt(row,7).toString());
                        int soluongnew = Integer.parseInt(soluongsp)+soluongspxoa;

                        String cauLenhSQLupdate = "Update SanPham"+
                                " set soluongsp = '"+soluongnew+ "'"+
                                " Where masp = '"+maspban+"'";
                        Connections.ThucThi3Lenh(cauLenhSQLupdate);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Updatesp();
                if(removeIndex == -1) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn sản phẩm cần xóa!");
                } else {
                    View.dfspban.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sản phẩm đã được xóa!");
                }
            }
        });
        View.nhaptientralai.setEditable(false);
        View.nhaptientralai.setText("0");
        View.hoanthanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sospbanra = View.tbspban.getRowCount();
                int tienkhachdua = Integer.parseInt(View.nhaptienkhachdua.getText());
                int tongtien = Integer.parseInt(View.nhaptongtien.getText());
                int tientralai = tienkhachdua-tongtien;
                View.nhaptientralai.setText(String.valueOf(tientralai));
                String ttsp [] = new String[10];
                for(int i=0;i<sospbanra;i++)
                {
                    ttsp [0] = View.tbspban.getValueAt(i,0).toString();
                    ttsp [1] = View.tbspban.getValueAt(i,1).toString();
                    ttsp [2] = View.tbspban.getValueAt(i,2).toString();
                    ttsp [3] = View.tbspban.getValueAt(i,3).toString();
                    ttsp [4] = View.tbspban.getValueAt(i,4).toString();
                    ttsp [5] = View.tbspban.getValueAt(i,5).toString();
                    ttsp [6 ] = View.tbspban.getValueAt(i,6).toString();
                    ttsp [7 ] = View.tbspban.getValueAt(i,7).toString();
                    ttsp [8 ] = View.tbspban.getValueAt(i,8).toString();
                    String cauLenhSQL = "INSERT INTO SanPhamBan(tenkh,ghichu,masp,tensp,giasp,sizesp,loaisp,soluongsp,ngayban)"+
                            "VALUES"+
                            "(N'"+ ttsp [0] + "'"+
                            ",N'"+ ttsp [1] + "'"+
                            ",'"+ ttsp [2] + "'"+
                            ",N'"+ ttsp [3] + "'"+
                            ",'"+ ttsp [4] + "'"+
                            ",'"+ ttsp [5] + "'"+
                            ",N'"+ ttsp [6] + "'"+
                            ",'"+ ttsp [7] + "'"+
                            ",'"+ttsp [8] + "')";
                    Connections.ThucThi3Lenh(cauLenhSQL);
                }
            }
        });
        View.taomoidon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View.dfspban.setRowCount(0);
                View.dskh.setSelectedItem("Khách hàng bán lẻ");
                View.nhapghichu.setText(null);
                View.nhaptongtien.setText("0");
                View.nhaptienkhachdua.setText(null);
                View.nhaptientralai.setText("0");
                View.nhapsoluongban.setText(null);
            }
        });
    }
}
