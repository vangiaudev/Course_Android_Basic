package vangiaurecca.example.model;

public class NhanVien {
    private String ten;
    private String thuBatDauCongTac;
    private int soNgayCongTacDuKien;

    public String getTen() {
        return ten;
    }

    public String getThuBatDauCongTac() {
        return thuBatDauCongTac;
    }

    public int getSoNgayCongTacDuKien() {
        return soNgayCongTacDuKien;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setThuBatDauCongTac(String thuBatDauCongTac) {
        this.thuBatDauCongTac = thuBatDauCongTac;
    }

    public void setSoNgayCongTacDuKien(int soNgayCongTacDuKien) {
        this.soNgayCongTacDuKien = soNgayCongTacDuKien;
    }

    public NhanVien(String ten, String thuBatDauCongTac, int soNgayCongTacDuKien) {
        this.ten = ten;
        this.thuBatDauCongTac = thuBatDauCongTac;
        this.soNgayCongTacDuKien = soNgayCongTacDuKien;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return this.ten +
                "\n Bắt đầu đi công tác vào thứ [" + this.thuBatDauCongTac + "]" +
                "\n Số ngày công tác dự kiến = " + this.soNgayCongTacDuKien;
    }
}
