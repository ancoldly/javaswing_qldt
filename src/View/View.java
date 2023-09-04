package View;
import Connection.Connections;
import Controller.Acctions;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.MemoryUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class View extends JFrame {
    public static JButton taomoidon,trangchu,hanghoa,giaodich,khach,nhapsp,xoasp,suasp,nhaplaisp,timkiemsp,luusoluongban,xoaspmua,hoanthanh,timkiemspgd;
    public static JLabel soluongsp,doanhthu,khachhang;
    public static DefaultTableModel dfkhachhang,dfsanpham,dfspgd,dfspban;
    public static JTable tbkhachhang,tbsanpham,tbspgd,tbspban;
    public static JTextField nhapmasp,nhaptensp,nhapgiasp,nhapsptimkiem,nhapsoluongsp,nhaptongtien,nhaptimkiemspgd,nhaptienkhachdua,nhapsoluongban,nhaptientralai;
    public static JRadioButton ngungkinhdoanh,dangkinhdoanh;
    public static JTextArea nhapmotasp,nhapghichu;
    public static JComboBox dskh,nhaploaisp,timkiemtheoloai,timkiemtheotinhtrang,nhapsizesp,timkiemtheosize;
    public static JPanel cardcenter,cardnorth;
    public View() {
        super("«SHOP QUẦN ÁO CỦA TRANG NGU NGƠ ♫»");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,900);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/online-shopping.png"))).getImage());

        Container container = getContentPane();

        //West
        JLabel tenshop = new JLabel("SHOP LNTT ♪");
        tenshop.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/shopping-bags.png"))));
        tenshop.setForeground(Color.GREEN);
        JPanel shop = new JPanel();
        shop.setLayout(new FlowLayout(1,10,10));
        shop.add(tenshop);
        shop.setBackground(new Color(147,112,219));

        trangchu = new JButton("Trang chủ");
        trangchu.setBorderPainted(false);
        trangchu.setContentAreaFilled(false);
        trangchu.setForeground(Color.WHITE);
        trangchu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/home.png"))));
        hanghoa = new JButton("Sản phẩm");
        hanghoa.setBorderPainted(false);
        hanghoa.setContentAreaFilled(false);
        hanghoa.setForeground(Color.WHITE);
        hanghoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/box.png"))));
        giaodich = new JButton("Giao dịch");
        giaodich.setBorderPainted(false);
        giaodich.setContentAreaFilled(false);
        giaodich.setForeground(Color.WHITE);
        giaodich.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/transaction.png"))));
        khach = new JButton("Khách hàng");
        khach.setBorderPainted(false);
        khach.setContentAreaFilled(false);
        khach.setForeground(Color.WHITE);
        khach.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/handshake.png"))));


        JPanel west = new JPanel();
        west.setLayout(new GridLayout(17,1,1,5));
        west.setBackground(new Color(147,112,219));
        west.add(shop);
        west.add(trangchu);
        west.add(hanghoa);
        west.add(giaodich);
        west.add(khach);
        container.add(west,BorderLayout.WEST);
        //Center
        //show sản phẩm
        JLabel tongsanpham = new JLabel("Tổng sản phẩm");
        tongsanpham.setForeground(Color.WHITE);
        soluongsp = new JLabel("00");
        soluongsp.setForeground(Color.WHITE);

        JPanel showsoluong = new JPanel();
        showsoluong.setBackground(new Color(255,0,255));
        showsoluong.setLayout(new GridLayout(2,1,1,5));
        showsoluong.add(tongsanpham);
        showsoluong.add(soluongsp);
        JLabel imgtongsanpham = new JLabel();
        imgtongsanpham.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/new-product.png"))));

        JPanel showsanpham = new JPanel();
        showsanpham.setLayout(new FlowLayout(5,30,20));
        showsanpham.setBackground(new Color(255,0,255));
        showsanpham.add(showsoluong);
        showsanpham.add(imgtongsanpham);

        //show doanh thu
        JLabel tongdoanhthu = new JLabel("Tổng doanh thu(VNĐ)");
        tongdoanhthu.setForeground(Color.WHITE);
        doanhthu = new JLabel("0");
        doanhthu.setForeground(Color.WHITE);

        JPanel showdoanhthu = new JPanel();
        showdoanhthu.setBackground(new Color(30,144,255));
        showdoanhthu.setLayout(new GridLayout(2,1,1,5));
        showdoanhthu.add(tongdoanhthu);
        showdoanhthu.add(doanhthu);
        JLabel imgtongdoanhthu = new JLabel();
        imgtongdoanhthu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/economy.png"))));

        JPanel showtongdoanhthu = new JPanel();
        showtongdoanhthu.setLayout(new FlowLayout(5,30,20));
        showtongdoanhthu.setBackground(new Color(30,144,255));
        showtongdoanhthu.add(showdoanhthu);
        showtongdoanhthu.add(imgtongdoanhthu);

        //show khách hàng
        JLabel tongkhachhang = new JLabel("Tổng khách hàng");
        tongkhachhang.setForeground(Color.WHITE);
        khachhang = new JLabel("00");
        khachhang.setForeground(Color.WHITE);

        JPanel showkhachhang = new JPanel();
        showkhachhang.setBackground(new Color(127,255,0));
        showkhachhang.setLayout(new GridLayout(2,1,1,5));
        showkhachhang.add(tongkhachhang);
        showkhachhang.add(khachhang);
        JLabel imgtongkhachhang = new JLabel();
        imgtongkhachhang.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/rating.png"))));

        JPanel showtongkhachhang = new JPanel();
        showtongkhachhang.setLayout(new FlowLayout(5,30,20));
        showtongkhachhang.setBackground(new Color(127,255,0));
        showtongkhachhang.add(showkhachhang);
        showtongkhachhang.add(imgtongkhachhang);
        //Tổng center show thông tin
        JPanel tongshow = new JPanel();
        tongshow.setLayout(new FlowLayout(5,53,15));
        tongshow.setBackground(new Color(240,255,255));
        tongshow.add(showtongkhachhang);
        tongshow.add(showsanpham);
        tongshow.add(showtongdoanhthu);

        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/cuahang.png"))));
        JLabel img2 = new JLabel();
        img2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/cuahang2.png"))));
        JLabel img3 = new JLabel();
        img3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/cuahang3.png"))));
        JPanel imgshop = new JPanel();
        imgshop.setLayout(new FlowLayout(1,0,0));
        imgshop.setBackground(new Color(240,255,255));
        imgshop.add(img);
        imgshop.add(img2);
        imgshop.add(img3);

        JPanel centershow = new JPanel();
        centershow.setLayout(new GridLayout(2,1,1,0));
        centershow.setBackground(new Color(240,255,255));
        centershow.add(tongshow);
        centershow.add(imgshop);
        //Bảng khách hàng
        dfkhachhang = new DefaultTableModel();
        dfkhachhang.addColumn("Mã Khách hàng");
        dfkhachhang.addColumn("Tên");
        dfkhachhang.addColumn("Giới tính");
        dfkhachhang.addColumn("Số điện thoại");
        dfkhachhang.addColumn("Số hàng đã mua");

        tbkhachhang = new JTable(dfkhachhang);
        TableColumnModel colkhachhang  = tbkhachhang.getColumnModel();
        colkhachhang.getColumn(0).setPreferredWidth(100);
        colkhachhang.getColumn(1).setPreferredWidth(100);
        colkhachhang.getColumn(2).setPreferredWidth(100);
        colkhachhang.getColumn(3).setPreferredWidth(100);
        colkhachhang.getColumn(4).setPreferredWidth(100);

        JScrollPane sckhachhang = new JScrollPane(tbkhachhang);
        sckhachhang.setBorder(new LineBorder(new Color(240,255,255)));
        sckhachhang.setPreferredSize(new Dimension(750,350));

        JPanel bodertitlesouthkhachhang = new JPanel();
        Border borderkhachhang = BorderFactory.createLineBorder(new Color(240,255,255));
        TitledBorder bordertitkhachhang = BorderFactory.createTitledBorder(borderkhachhang, " Danh sách khách hàng   ");
        bodertitlesouthkhachhang.setBorder(bordertitkhachhang);
        bodertitlesouthkhachhang.setBackground(new Color(240,255,255));
        bodertitlesouthkhachhang.add(sckhachhang);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,1,0,0));
        center.setBackground(new Color(240,255,255));
        center.add(centershow);
        center.add(bodertitlesouthkhachhang);

        JLabel title = new JLabel("QUẢN LÍ DOANH THU CỬA HÀNG QUẦN ÁO");
        title.setForeground(Color.WHITE);
        title.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/boutique.png"))));

        JPanel titlenorth = new JPanel();
        titlenorth.setLayout(new FlowLayout(1));
        titlenorth.add(title);
        titlenorth.setBackground(new Color(147,112,219));
        //////////////////////////////////////////////////////////////////////////////
        //Sản phẩm
        JLabel masp = new JLabel("Mã sản phẩm");
        JLabel tensp = new JLabel("Tên sản phẩm");
        JLabel giasp = new JLabel("Giá sản phẩm");
        JLabel sizesp = new JLabel("Size sản phẩm");
        JLabel loaisp = new JLabel("Loại sản phẩm");
        JLabel soluongsp = new JLabel("Số lượng sản phẩm");
        JLabel motasp = new JLabel("Mô tả sản phẩm");
        JLabel trinhtrangsp = new JLabel("Tình trạng sản phẩm");

        JPanel ttsp = new JPanel();
        ttsp.setLayout(new GridLayout(8,1,1,23));
        ttsp.add(masp);
        ttsp.add(tensp);
        ttsp.add(giasp);
        ttsp.add(sizesp);
        ttsp.add(loaisp);
        ttsp.add(soluongsp);
        ttsp.add(motasp);
        ttsp.add(trinhtrangsp);

        nhapmasp = new JTextField(10);
        nhaptensp = new JTextField(10);
        nhapgiasp = new JTextField(10);
        String allsizesp [] = {"","XS","S","M","L","XL","XXL","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44"};
        String tenloaisp [] = {"","Giày","Dép","Áo","Quần","Mũ"};
        nhapsizesp = new JComboBox(allsizesp);
        nhaploaisp = new JComboBox(tenloaisp);
        nhapsoluongsp = new JTextField(10);
        nhapmotasp = new JTextArea();
        nhapmotasp.setBackground(new Color(152,251,152));
        dangkinhdoanh = new JRadioButton("Đang kinh doanh");
        ngungkinhdoanh = new JRadioButton("Ngừng kinh doanh");
        ButtonGroup buttonGrouptinhtrang = new ButtonGroup();
        buttonGrouptinhtrang.add(dangkinhdoanh);
        buttonGrouptinhtrang.add(ngungkinhdoanh);

        JPanel nhaptrinhtrang = new JPanel();
        nhaptrinhtrang.setLayout(new FlowLayout(5));
        nhaptrinhtrang.add(dangkinhdoanh);
        nhaptrinhtrang.add(ngungkinhdoanh);

        JPanel nhapttsp = new JPanel();
        nhapttsp.setLayout(new GridLayout(8,1,1,5));
        nhapttsp.add(nhapmasp);
        nhapttsp.add(nhaptensp);
        nhapttsp.add(nhapgiasp);
        nhapttsp.add(nhapsizesp);
        nhapttsp.add(nhaploaisp);
        nhapttsp.add(nhapsoluongsp);
        nhapttsp.add(nhapmotasp);
        nhapttsp.add(nhaptrinhtrang);

        JLabel sanpham = new JLabel("Tên or mã or giá");
        sanpham.setForeground(Color.WHITE);
        nhapsptimkiem = new JTextField(10);
        nhapsptimkiem.setBorder(new LineBorder(Color.BLACK));
        timkiemsp = new JButton("Tìm");
        timkiemsp.setBackground(new Color(46,139,87));
        timkiemsp.setForeground(Color.WHITE);

        String loaisptimkiem [] = {"Loại","Giày","Dép","Áo","Quần","Mũ"};
        timkiemtheoloai = new JComboBox(loaisptimkiem);
        timkiemtheoloai.setBackground(new Color(255,182,193));

        String tinhtrangtimkiem [] = {"Tình trạng","Đang kinh doanh","Ngừng kinh doanh"};
        timkiemtheotinhtrang = new JComboBox(tinhtrangtimkiem);
        timkiemtheotinhtrang.setBackground(new Color(127,255,212));

        String sizetimkiem [] = {"Size","XS","S","M","L","XL","XXL","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44"};
        timkiemtheosize = new JComboBox(sizetimkiem);
        timkiemtheosize.setBackground(new Color(255,255,0));

        JPanel timkiemsanpham = new JPanel();
        timkiemsanpham.setLayout(new FlowLayout(1,20,30));
        timkiemsanpham.setBackground(new Color(147,112,219));
        timkiemsanpham.add(sanpham);
        timkiemsanpham.add(nhapsptimkiem);
        timkiemsanpham.add(timkiemsp);
        timkiemsanpham.add(timkiemtheosize);
        timkiemsanpham.add(timkiemtheoloai);
        timkiemsanpham.add(timkiemtheotinhtrang);

        nhapsp = new JButton("Nhập");
        nhaplaisp = new JButton("Nhập lại");
        xoasp = new JButton("Xóa");
        suasp = new JButton("Sửa");

        JPanel grbutton = new JPanel();
        grbutton.setLayout(new GridLayout(5,1,1,25));
        grbutton.add(nhapsp);
        grbutton.add(nhaplaisp);
        grbutton.add(xoasp);
        grbutton.add(suasp);

        JPanel thongtinsp = new JPanel();
        thongtinsp.setLayout(new FlowLayout(1,40,40));
        thongtinsp.add(ttsp);
        thongtinsp.add(nhapttsp);
        thongtinsp.add(grbutton);

        dfsanpham = new DefaultTableModel();
        dfsanpham.addColumn("Mã sản phẩm");
        dfsanpham.addColumn("Tên sản phẩm");
        dfsanpham.addColumn("Giá sản phẩm");
        dfsanpham.addColumn("Size");
        dfsanpham.addColumn("Loại sản phẩm");
        dfsanpham.addColumn("Số lượng");
        dfsanpham.addColumn("Mô tả");
        dfsanpham.addColumn("Tình trạng");

        tbsanpham = new JTable(dfsanpham);
        TableColumnModel colsanpham = tbsanpham.getColumnModel();
        colsanpham.getColumn(0).setPreferredWidth(50);
        colsanpham.getColumn(1).setPreferredWidth(130);
        colsanpham.getColumn(2).setPreferredWidth(60);
        colsanpham.getColumn(3).setPreferredWidth(30);
        colsanpham.getColumn(4).setPreferredWidth(60);
        colsanpham.getColumn(5).setPreferredWidth(60);
        colsanpham.getColumn(6).setPreferredWidth(120);
        colsanpham.getColumn(7).setPreferredWidth(70);

        JScrollPane scsanpham = new JScrollPane(tbsanpham);
        scsanpham.setBorder(new LineBorder(Color.BLACK,1));
        scsanpham.setPreferredSize(new Dimension(500,200));

        JPanel centersanpham = new JPanel();
        centersanpham.setLayout(new GridLayout(2,1,1,5));
        centersanpham.add(thongtinsp);
        centersanpham.add(scsanpham);

        ///////////////////////////////////////////////////////////////
        JLabel spgd = new JLabel("Thanh toán bán hàng");
        spgd.setForeground(Color.WHITE);

        nhaptimkiemspgd = new JTextField(10);

        timkiemspgd = new JButton("Tìm kiếm");
        timkiemspgd.setBackground(new Color(50,205,50));
        timkiemspgd.setForeground(Color.WHITE);

        JPanel timkiemgd = new JPanel();
        timkiemgd.setLayout(new FlowLayout(1,20,20));
        timkiemgd.setBackground(new Color(147,112,219));
        timkiemgd.add(spgd);
        timkiemgd.add(nhaptimkiemspgd);
        timkiemgd.add(timkiemspgd);
        container.add(timkiemgd);

        dfspgd = new DefaultTableModel();
        dfspgd.addColumn("Mã sản phẩm");
        dfspgd.addColumn("Tên sản phẩm");
        dfspgd.addColumn("Giá sản phẩm");
        dfspgd.addColumn("Size");
        dfspgd.addColumn("Loại sản phẩm");
        dfspgd.addColumn("Số lượng");
        dfspgd.addColumn("Mô tả");
        dfspgd.addColumn("Tình trạng");

        tbspgd = new JTable(dfspgd);
        TableColumnModel colspgd = tbspgd.getColumnModel();
        colspgd.getColumn(0).setPreferredWidth(50);
        colspgd.getColumn(1).setPreferredWidth(130);
        colspgd.getColumn(2).setPreferredWidth(60);
        colspgd.getColumn(3).setPreferredWidth(30);
        colspgd.getColumn(4).setPreferredWidth(60);
        colspgd.getColumn(5).setPreferredWidth(60);
        colspgd.getColumn(6).setPreferredWidth(120);
        colspgd.getColumn(7).setPreferredWidth(70);

        JScrollPane scspgd = new JScrollPane(tbspgd);
        scspgd.setBorder(new LineBorder(Color.BLACK,1));
        scspgd.setPreferredSize(new Dimension(500,150));

        dfspban = new DefaultTableModel();
        dfspban.addColumn("Khách hàng");
        dfspban.addColumn("Ghi chú");
        dfspban.addColumn("Mã sản phẩm");
        dfspban.addColumn("Tên sản phẩm");
        dfspban.addColumn("Đơn giá");
        dfspban.addColumn("Size");
        dfspban.addColumn("Loại sản phẩm");
        dfspban.addColumn("Số lượng bán");
        dfspban.addColumn("Ngày bán");
        tbspban = new JTable(dfspban);
        TableColumnModel colspban = tbspban.getColumnModel();
        colspban.getColumn(0).setPreferredWidth(100);
        colspban.getColumn(1).setPreferredWidth(100);
        colspban.getColumn(2).setPreferredWidth(50);
        colspban.getColumn(3).setPreferredWidth(90);
        colspban.getColumn(4).setPreferredWidth(40);
        colspban.getColumn(5).setPreferredWidth(15);
        colspban.getColumn(6).setPreferredWidth(50);
        colspban.getColumn(7).setPreferredWidth(50);
        colspban.getColumn(8).setPreferredWidth(35);

        JScrollPane scspban = new JScrollPane(tbspban);
        scspban.setBorder(new LineBorder(Color.BLACK,1));
        scspban.setPreferredSize(new Dimension(500,150));

        JLabel khachhangmua = new JLabel("Khách hàng");
        dskh = new JComboBox();
        dskh.addItem("Khách hàng bán lẻ");
        dskh.setBackground(new Color(106,90,205));
        dskh.setForeground(Color.WHITE);

        JPanel ttkhmua = new JPanel();
        ttkhmua.setLayout(new GridLayout(2,1,1,5));
        ttkhmua.add(khachhangmua);
        ttkhmua.add(dskh);

        JLabel ghichu = new JLabel("Ghi chú");
        nhapghichu = new JTextArea();

        JPanel ttghichu = new JPanel();
        ttghichu.setLayout(new GridLayout(2,1,1,5));
        ttghichu.add(ghichu);
        ttghichu.add(nhapghichu);

        JLabel tongtien = new JLabel("Tổng tiền");
        nhaptongtien = new JTextField(15);

        JPanel tttongtien = new JPanel();
        tttongtien.setLayout(new GridLayout(2,1,1,0));
        tttongtien.add(tongtien);
        tttongtien.add(nhaptongtien);

        JLabel tienkhachdua = new JLabel("Tiền khách đưa");
        nhaptienkhachdua = new JTextField(15);

        JPanel tttienkhachdua = new JPanel();
        tttienkhachdua.setLayout(new GridLayout(2,1,1,0));
        tttienkhachdua.add(tienkhachdua);
        tttienkhachdua.add(nhaptienkhachdua);

        JLabel tientralai = new JLabel("Tiền trả lại");
        nhaptientralai = new JTextField(15);

        JPanel tttientralai = new JPanel();
        tttientralai.setLayout(new GridLayout(2,1,1,0));
        tttientralai.add(tientralai);
        tttientralai.add(nhaptientralai);

        JPanel ghichumua = new JPanel();
        ghichumua.setLayout(new GridLayout(2,1,1,0));
        ghichumua.add(ttkhmua);
        ghichumua.add(ttghichu);

        JPanel tienall = new JPanel();
        tienall.setLayout(new GridLayout(3,1,1,5));
        tienall.add(tttongtien);
        tienall.add(tttienkhachdua);
        tienall.add(tttientralai);

        JLabel soluongban = new JLabel("Số lượng bán");

        nhapsoluongban = new JTextField(10);

        luusoluongban = new JButton("Lưu tạm");
        luusoluongban.setBackground(new Color(50,205,50));
        luusoluongban.setForeground(Color.WHITE);

        hoanthanh = new JButton("Hoàn thành");
        hoanthanh.setBackground(new Color(50,205,50));
        hoanthanh.setForeground(Color.WHITE);

        xoaspmua = new JButton("Xóa");
        xoaspmua.setBackground(new Color(50,205,50));
        xoaspmua.setForeground(Color.WHITE);

        taomoidon = new JButton("Tạo mới");
        taomoidon.setBackground(new Color(50,205,50));
        taomoidon.setForeground(Color.WHITE);

        JPanel luutamban = new JPanel();
        luutamban.setLayout(new FlowLayout(1,20,10));
        luutamban.add(soluongban);
        luutamban.add(nhapsoluongban);

        JPanel bttonmua = new JPanel();
        bttonmua.setLayout(new FlowLayout(5,20,10));
        bttonmua.add(taomoidon);
        bttonmua.add(luusoluongban);
        bttonmua.add(xoaspmua);
        bttonmua.add(hoanthanh);

        JPanel ttmua = new JPanel();
        ttmua.setLayout(new GridLayout(2,1,1,0));
        ttmua.add(luutamban);
        ttmua.add(bttonmua);

        JPanel tongallmua = new JPanel();
        tongallmua.setLayout(new FlowLayout(5,40,20));
        tongallmua.setBorder(new LineBorder(Color.BLACK));
        tongallmua.add(ghichumua);
        tongallmua.add(tienall);
        tongallmua.add(ttmua);

        JPanel centerspgd = new JPanel();
        centerspgd.setLayout(new GridLayout(4,1,1,0));
        centerspgd.add(scspgd);
        centerspgd.add(tongallmua);
        centerspgd.add(scspban);

        ///---Cardlayout----
        cardcenter = new JPanel();
        cardcenter.setLayout(new CardLayout());
        cardcenter.add(center,"center1");
        cardcenter.add(centersanpham,"center2");
        cardcenter.add(centerspgd,"center3");
        container.add(cardcenter,BorderLayout.CENTER);

        cardnorth = new JPanel();
        cardnorth.setLayout(new CardLayout());
        cardnorth.add(titlenorth,"north1");
        cardnorth.add(timkiemsanpham,"north2");
        cardnorth.add(timkiemgd,"north3");
        container.add(cardnorth,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        View view = new View();
        view.setVisible(true);
        Acctions.Acctions();
    }
}
