import java.io.Serializable;
public abstract class HangHoa implements Serializable{
    private String MaHang;
    private String TenHang;
    private int SoLuong;
    private double DonGia;

    protected HangHoa(){

    }

    protected HangHoa(String MaHang , String TenHang , int SoLuong , double DonGia ){
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }


    protected String getMaHang() {
        return MaHang;
    }

    protected void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    protected String getTenHang() {
        return TenHang;
    }

    protected void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    protected int getSoLuong() {
        return SoLuong;
    }

    protected void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    protected double getDonGia() {
        return DonGia;
    }

    protected void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public String toString() {
        String result = String.format( " Ma hang : %-10s Ten Hang : %-15s So Luong : %-10d DonGia : %1.3f vnd  %-2s ",  getMaHang() , getTenHang() , getSoLuong() , getDonGia(), ""); 
        return result ;
    }
    
}
