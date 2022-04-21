import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham extends HangHoa {
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private Date NgaySX;
    private Date ngayHH;
    private String NhaCungCap;

    protected HangThucPham(String MaHang , String TenHang , int SoLuong , double DonGia , Date NgaySX , Date ngayHH , String NhaCungCap){
        super(MaHang , TenHang , SoLuong , DonGia );
        this.NgaySX = NgaySX;
        this.ngayHH = ngayHH;
        this.NhaCungCap = NhaCungCap;
    }

    protected Date getNgaySX() {
        return NgaySX;
    }

    protected void setNgaySX (Date ngaySX) {
        this.NgaySX = ngaySX;
    }

    protected Date getngayHH() {
        return ngayHH;
    }

    protected void setngayHH (Date ngayHH) {
        this.ngayHH = ngayHH;
    }

    protected String getNhaCungCap() {
        return NhaCungCap;
    }

    protected void setNhaCungCap(String NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }

    public String toString() {
        String result = super.toString() + String.format(" ngay san xuat : %-13s ngay het han : %-13s  Nha Cung cap : %-10s",  date.format(NgaySX) , date.format(ngayHH) , getNhaCungCap());
        return result ;
    }


}
