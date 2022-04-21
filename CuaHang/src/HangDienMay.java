public class HangDienMay extends HangHoa {
    
    private Double Kw;
    private int ThoiGianBaoHanh;

    protected HangDienMay(){

    }
    
    protected HangDienMay ( String MaHang , String TenHang , int SoLuong , double DonGia , Double Kw , int ThoiGianBaoHanh){
        super(MaHang , TenHang , SoLuong , DonGia );
        this.Kw = Kw;
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
    }

    protected double getKw() {
        return Kw;
    }

    protected void setKw(double Kw) {
        this.Kw = Kw;
    } 

    protected int getThoiGianBaoHanh() {
        return ThoiGianBaoHanh;
    }

    protected void setThoiGianBaoHanh(int ThoiGianBaoHanh) {
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
    }

    public String toString() {
        String result = super.toString() + String.format( "  so kw : %-15.2f  Thoi Gian Bao hanh : %d thang ", getKw() , getThoiGianBaoHanh());
        return result ;
    }


}
