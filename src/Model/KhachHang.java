package Model;

public class KhachHang {
    private String maKh;
    private String ten;
    private String gioiTinh;
    private String sdt;
    private String soHangDaMua;
    private String checkMaKh;

    public KhachHang() {
    }

    public KhachHang(String maKh, String ten, String gioiTinh, String sdt, String soHangDaMua, String checkMaKh) {
        this.maKh = maKh;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.soHangDaMua = soHangDaMua;
        this.checkMaKh = checkMaKh;
    }

    public String getCheckMaKh() {
        return checkMaKh;
    }

    public void setCheckMaKh(String checkMaKh) {
        this.checkMaKh = checkMaKh;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTen() {
        return ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getSoHangDaMua() {
        return soHangDaMua;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setSoHangDaMua(String soHangDaMua) {
        this.soHangDaMua = soHangDaMua;
    }
}
