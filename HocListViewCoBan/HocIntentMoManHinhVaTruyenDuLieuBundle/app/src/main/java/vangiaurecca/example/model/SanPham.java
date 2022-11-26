package vangiaurecca.example.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int ma;
    private String ten;
    private double gia;

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public SanPham() {
    }

    public SanPham(int ma, String ten, double gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return this.ma + "\n" + this.ten + "\n" + this.gia;
    }
}
