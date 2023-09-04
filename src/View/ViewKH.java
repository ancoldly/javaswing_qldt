package View;

import javax.swing.*;
import java.awt.*;

public class ViewKH extends JFrame {
    public static JButton nhap,xoa,sua,thoat;
    public static JTextField nhaptenkh,nhapsdt,nhapmakh;
    public static JRadioButton nam,nu;
    public ViewKH() {
        super("Thông tin khách hàng");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,380);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(View.class.getResource("/img/rating (1).png"))).getImage());

        Container container = getContentPane();

        //Jlabel
        JLabel makh = new JLabel("Mã khách hàng");
        JLabel tenkh = new JLabel("Tên khách hàng");
        JLabel gioitinh = new JLabel("Giới tính");
        JLabel sdt = new JLabel("Số điện thoại");

        JPanel ttkh = new JPanel();
        ttkh.setLayout(new GridLayout(4,1,1,23));
        ttkh.add(makh);
        ttkh.add(tenkh);
        ttkh.add(gioitinh);
        ttkh.add(sdt);

        nhapmakh = new JTextField(10);
        nhaptenkh = new JTextField(20);
        nhapsdt = new JTextField(20);
        nam = new JRadioButton("Nam");
        nu = new JRadioButton("Nữ");

        JPanel nhapgioitinh = new JPanel();
        nhapgioitinh.setLayout(new FlowLayout(5));
        nhapgioitinh.add(nam);
        nhapgioitinh.add(nu);

        JPanel nhapttkh = new JPanel();
        nhapttkh.setLayout(new GridLayout(4,1,1,5));
        nhapttkh.add(nhapmakh);
        nhapttkh.add(nhaptenkh);
        nhapttkh.add(nhapgioitinh);
        nhapttkh.add(nhapsdt);

        ButtonGroup grgioitinh = new ButtonGroup();
        grgioitinh.add(nam);
        grgioitinh.add(nu);

        JPanel centerkh = new JPanel();
        centerkh.setLayout(new FlowLayout(1,20,20));
        centerkh.add(ttkh);
        centerkh.add(nhapttkh);

        nhap = new JButton("Thêm");
        nhap.setBackground(new Color(50,205,50));
        nhap.setForeground(Color.WHITE);
        xoa = new JButton("Xóa");
        xoa.setBackground(new Color(50,205,50));
        xoa.setForeground(Color.WHITE);
        sua = new JButton("Sửa");
        sua.setBackground(new Color(50,205,50));
        sua.setForeground(Color.WHITE);
        thoat = new JButton("Thoát");
        thoat.setBackground(new Color(50,205,50));
        thoat.setForeground(Color.WHITE);

        JPanel centerbutton = new JPanel();
        centerbutton.setLayout(new FlowLayout(1,25,30));
        centerbutton.add(nhap);
        centerbutton.add(xoa);
        centerbutton.add(sua);
        centerbutton.add(thoat);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,1,1,0));
        center.add(centerkh);
        center.add(centerbutton);
        container.add(center);
    }

    public static void main(String[] args) {
        ViewKH viewKH = new ViewKH();
        viewKH.setVisible(true);
    }
}
