
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleInput {
    
        private Scanner input = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        
        protected Scanner getNhap() {
            return input;
        }


        protected HangHoa nhapHangHoa ()  {
            HangHoa HangHoa = null;
            try {
            System.out.println(" >> Nhap Ma Hang Hoa ");
            String MaHang = input.nextLine();
            System.out.println(" >> Nhap Ten Hang Hoa");
            String TenHang = input.nextLine();
            System.out.println(" >> Nhap So Luong Hang Hoa");
            int SoLuong = input.nextInt();
            System.out.println(" >> Nhap Don Gia Hang Hoa");
            Double DonGia = input.nextDouble();

            System.out.println(" >> Hay chon Loai Hang Hoa Ban Muon Nhap ");
            System.out.println(" >> - 1 Hang Thuc Pham                   ");
            System.out.println(" >> - 2 Hang Sanh Su                     ");
            System.out.println(" >> - 3 Hang Dien Tu                     ");
            int loai = input.nextInt();
            input.nextLine();
    
            if(loai == 1){
                System.out.print(">> Nhap Ngay San Xuat    ");
                Date NgaySX = date.parse(input.nextLine());
                System.out.print(">> Nhap Ngay Het Han     ");
                Date ngayHH = date.parse(input.nextLine());
                System.out.println(" Nhap ten Nha Cung Cap ");
                String NhaCungCap = input.nextLine();
                HangHoa = new HangThucPham( MaHang , TenHang , SoLuong , DonGia , NgaySX , ngayHH , NhaCungCap);
                
            }else if(loai == 2 ){
                
                System.out.print(">> Nhap Ngay Nhap Kho    ");
                Date NgayNK = date.parse(input.nextLine());
                System.out.println(">> Nhap ten Nha San Xuat ");
                String NhaCungCap = input.nextLine();
                HangHoa = new HangSanhSu( MaHang , TenHang , SoLuong ,  DonGia ,  NgayNK , NhaCungCap);
            
            
            }else{
                System.out.println(">> Nhap so Kw hang hoa su dung ");
                Double Kw = input.nextDouble();
                System.out.println(">> Nhap Thoi Gian Bao Hanh ");
                int ThoiGianBaoHanh = input.nextInt();
                input.nextLine();
                HangHoa = new HangDienMay(MaHang , TenHang , SoLuong ,  DonGia ,  Kw , ThoiGianBaoHanh);
            }
            } catch (Exception e) {
                System.out.println(" KHONG !!!  DUNG LAI DI !!! BAN NHAP SAI ROI ");
                System.out.println(" Thay Dung co y nhap sai chu  ｡ﾟ･ (︶︹︺) ･ﾟ｡ ");
                System.out.println( "Error: " + e.toString());
                e.printStackTrace();
            }
    
            return HangHoa;
        }
           

        
    }
