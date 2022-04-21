import java.text.SimpleDateFormat;
import java.util.Date;

public class HangSanhSu extends HangHoa{
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private Date NgayNK;
    private String NhaSanXuat;
    
    protected HangSanhSu(String MaHang , String TenHang , int SoLuong , double DonGia , Date NgayNK , String NhaSanXuat){
        super(MaHang , TenHang ,  SoLuong , DonGia);
        this.NgayNK = NgayNK;
        this.NhaSanXuat = NhaSanXuat;
    }
    protected Date getNgayNK() {
        return NgayNK;
    }

    protected void setNgayNK (Date NgayNK) {
        this.NgayNK = NgayNK;
    }

    protected String getNhaSanXuat() {
        return NhaSanXuat;
    }

    protected void setNhaSanXuat(String NhaSanXuat) {
        this.NhaSanXuat = NhaSanXuat;
    }

    public String toString() {
        String result =  super.toString() + String.format(" Ngay Nhap Kho : %-13s Nha San Xuat : %-10s " , date.format(NgayNK),  getNhaSanXuat());
        return result ;
    }


}
