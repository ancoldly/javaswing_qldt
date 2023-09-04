package Model;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String giaSanPham;
    private String sizeSanPham;
    private String loaiSanPham;
    private String soLuongSanPham;
    private String moTa;
    private String tinhTrang;
    private String checkMaSP;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String giaSanPham, String sizeSanPham, String loaiSanPham, String soLuongSanPham, String moTa, String tinhTrang, String checkMaSP) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.sizeSanPham = sizeSanPham;
        this.loaiSanPham = loaiSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.moTa = moTa;
        this.tinhTrang = tinhTrang;
        this.checkMaSP = checkMaSP;
    }

    public String getCheckMaSP() {
        return checkMaSP;
    }

    public void setCheckMaSP(String checkMaSP) {
        this.checkMaSP = checkMaSP;
    }

    public String getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(String soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public String getSizeSanPham() {
        return sizeSanPham;
    }

    public void setSizeSanPham(String sizeSanPham) {
        this.sizeSanPham = sizeSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
