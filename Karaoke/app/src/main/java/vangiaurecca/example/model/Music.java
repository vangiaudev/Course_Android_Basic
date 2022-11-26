package vangiaurecca.example.model;

public class Music {
    private String ma;
    private String ten;
    private String caSi;
    private boolean thich;

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getCaSi() {
        return caSi;
    }

    public boolean isThich() {
        return thich;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public void setThich(boolean thich) {
        this.thich = thich;
    }

    public Music(String ma, String ten, String caSi, boolean thich) {
        this.ma = ma;
        this.ten = ten;
        this.caSi = caSi;
        this.thich = thich;
    }

    public Music() {
    }
}
