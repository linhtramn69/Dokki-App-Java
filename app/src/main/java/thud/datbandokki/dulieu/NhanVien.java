package thud.datbandokki.dulieu;

public class NhanVien {
    private int msnv;
    private String hoten;
    private String ngaysinh;
    private String gioitinh;
    private String sdt;

    public NhanVien() {
    }

    public NhanVien(int msnv, String hoten, String ngaysinh, String gioitinh, String sdt) {
        this.msnv = msnv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }

    public int getMsnv() {
        return msnv;
    }

    public void setMsnv(int msnv) {
        this.msnv = msnv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
