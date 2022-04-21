
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Main {
    static{
        System.out.println(" Chao Buoi Sang !!!    ");
        System.out.println(" Hi user !!!        ");
    }

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        ListHangHoa HH = new ListHangHoa();
        // dữ liệu mồi
        HangHoa sanpham1 = new HangThucPham( "TP1" , " banh mi " , 20 , 45.50 , date.parse("20/03/2004"), date.parse("20/04/2004")   , "Ai" );
        HangHoa sanpham2 = new HangThucPham( "TP2" , " khoai mon" , 20 , 20.50 , date.parse("20/03/2004"), date.parse("24/5/2004") , "tada" );
        HangHoa sanpham3 = new HangThucPham( "TP3" , " banh trang" , 20 , 36.50 ,date.parse("24/06/2004"),  date.parse("24/07/2005"), "io");
        HangHoa sanpham4 = new HangThucPham("TP4" , " mi goi" , 20 , 4.50 , date.parse("20/03/2004"), date.parse("24/5/2004") ,  "tels");
        HangHoa sanpham5 = new HangSanhSu("SS1" , " chen su" , 80 , 2034.50 , date.parse("20/03/2004") ,   "omge");
        HangHoa sanpham6 = new HangSanhSu("SS2" , " binh hoa" , 60 , 250.50 , date.parse("20/03/2004") ,  "isfoe");
        HangHoa sanpham7 = new HangSanhSu("SS3" , " vong tay " , 40 , 240.50 , date.parse("20/03/2004") ,  "kiwari"); 
        HangHoa sanpham8 = new HangSanhSu("SS4" , " nhan  " , 30 , 220.50 , date.parse("20/03/2004"),  " super ");
        HangHoa sanpham9 = new HangDienMay("Dm1" , " tivi " , 2 , 253.50 , 523d , 4);
        HangHoa sanpham10 = new HangDienMay("Dm2" , " may lanh " , 1 , 200.50 , 523d , 2);

        HH.them(sanpham1);
        HH.them(sanpham2);
        HH.them(sanpham3);
        HH.them(sanpham4);
        HH.them(sanpham5);
        HH.them(sanpham6);
        HH.them(sanpham7);
        HH.them(sanpham8);
        HH.them(sanpham9);
        HH.them(sanpham10);


        ConsoleInput ConsoleInput = new ConsoleInput();
        Scanner a = new Scanner(System.in);
        int key;
        do { 
            System.out.println("=====================MENU======================");
            System.out.println(">>1. Them Hang Hoa                             ");
            System.out.println(">>2. Xoa Hang Hoa                              ");
            System.out.println(">>3. Sua Hang Hoa                              ");
            System.out.println(">>4. In Thong Tin Hang Hoa                     ");
            System.out.println(">>5. Tim Kiem va in Hang Hoa Theo Ma Hang Hoa  ");
            System.out.println(">>6. Thong ke hang hoa                         ");
            System.out.println(">>7. sap xep tang dan theo don gia             ");
            System.out.println(">>8. sap xep giam dan theo don gia             ");
            System.out.println(">>9. Danh Gia san pham                         ");
            System.out.println(">>10 Xem Du Lieu Co Trong File                 ");
            System.out.println(">>11 Them Du Lieu cua danh sach Vao Trong file ");
            System.out.println(">>12 Them Du Lieu cua File Vao Trong danh sach ");
            System.out.println(">>0. Exit.                                     ");
            System.out.println("===============================================");
            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch(key){
                case 1: 
                    HangHoa hangHoa = ConsoleInput.nhapHangHoa();
                    HH.them(hangHoa);
                    break;
                case 2:
                    HangHoa xoahangHoa = HH.timKiemHangHoa();
                    HH.xoaHangHoa(xoahangHoa);
                    break;
                case 3: 
                    HangHoa suahangHoa = HH.timKiemHangHoa();
                    HH.inDanhSachHangHoaTheoMaHang(suahangHoa);
                    int viTri = HH.timViTriCuaHangHoa(suahangHoa);
                    HH.suaHangHoa(viTri, suahangHoa);
                    break;
                case 4:
                    HH.inDanhSachHangHoa(); 
                    break;
                case 5:
                    HangHoa timkiemhanghoa = HH.timKiemHangHoa();
                    HH.inDanhSachHangHoaTheoMaHang(timkiemhanghoa);
                    break;
                case 6:
                    HH.XuatTongSoLuongHangHoa();
                    HH.XuatTongGiaTriHangHoa();
                    HH.Xuatsoluongtungloai();
                    break;
                case 7:
                    HH.SapXepTangDan();
                    HH.inDanhSachHangHoa(); 
                    break;
                case 8:
                    HH.SapXepGiamDan();
                    HH.inDanhSachHangHoa();
                    break;
                case 9:
                    HH.DanhGiaSanPham();
                    break;
                case 10: 
                    HH.DocDuLieuCoTrongFileHienTai();
                    break;
                case 11: 
                    HH.GhiDuLieuTuFileVaoTrongList();
                    HH.GhiDuLieuTrongListVaoFile();
                    break;
                case 12:
                    HH.GhiDuLieuTuFileVaoTrongList();
                    break;
            }
    }while(key!=0);
        System.out.println(" Em xin lỗi cái Menu hơi tệ , em mò cái File ghi với đọc hơi lâu Thầy thông cảm ≧◠◡◠≦✌  ");
        a.close();
    }  

  
    }

