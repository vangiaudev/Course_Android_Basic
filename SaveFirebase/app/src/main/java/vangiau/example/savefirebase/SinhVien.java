package vangiau.example.savefirebase;

public class SinhVien {
    public String hoTen;
    public String diaChi;
    public Integer namSinh;

    public SinhVien() {
        //mặc định firebase cần 1 constructor rỗng khi nhận data
    }

    public SinhVien(String hoTen, String diaChi, Integer namSinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.namSinh = namSinh;
    }
}
