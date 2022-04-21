import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class ListHangHoa {
    private List<HangHoa> danhSach = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    protected void them(HangHoa HangHoa) {
        
        if( danhSach.size() >= 0 ){
            int kt = 0;
            for (HangHoa hh : danhSach) {
            
                if(hh.getMaHang().equalsIgnoreCase(HangHoa.getMaHang()) || HangHoa.getMaHang() == null ){
                    kt = 1;
                }
                if(HangHoa.getTenHang() == null ){
                    kt = 7;
                }
                if(HangHoa.getSoLuong() <= 0){
                    kt = 2;
                }
                if(HangHoa.getDonGia() <= 0d){
                    kt = 3;
                }

                int loaihang = 0;
                if( HangHoa instanceof HangThucPham ){
                    loaihang = 1;
                }    
                if( HangHoa instanceof HangDienMay){
                    loaihang = 2;     
                }

                if ( loaihang == 1){
                    if(((HangThucPham) HangHoa).getNgaySX().after(((HangThucPham) HangHoa).getngayHH())){
                        kt = 6;
                    }
                }
                if ( loaihang == 2 ){
                    if(((HangDienMay) HangHoa).getKw() <= 0){
                        kt = 4; 
                    }
                    if(((HangDienMay) HangHoa).getThoiGianBaoHanh() <= 0){
                        kt = 5;
                    }
                }
            }

            if (kt == 0) {
                danhSach.add(HangHoa);
                System.out.println(" them hang thanh cong");
            } else if(kt == 1 ){
                System.out.println(" them hang that bai , Ma hang bi trung hoac Ma Hang dang trong ");
            } else if(kt == 2 ){
                System.out.println(" them hang that bai , so luong phai > 0  ");
            } else if(kt == 3 ){
                System.out.println(" them hang that bai , Don Gia phai sai > 0    ");
            } else if(kt == 4 ){
                System.out.println(" them hang that bai , Kw phai > 0    ");
            } else if(kt == 5 ){
                System.out.println(" them hang that bai , Thoi Gian Bao Hanh > 0   ");
            } else if(kt == 6 ){
                System.out.println(" them hang that bai , ngay SX phai truoc ngay HH   ");
            } else if(kt == 7 ){
                System.out.println(" them hang that bai , ten Hang Khong Duoc de rong  ");
            }

        } else {
            danhSach.add(HangHoa);
            System.out.println(" them hang thanh cong");
        }    
    }   

    protected void DanhGiaSanPham(){
        for (HangHoa HangHoa : danhSach) {
            int danhgia = 0;
            System.out.println(HangHoa);
            if(HangHoa instanceof HangDienMay){
                if(((HangDienMay) HangHoa).getSoLuong() < 3){
                    System.out.println(" Danh Gia : Hang ban duoc");
                    System.out.println("");
                }else{
                    danhgia = 1;
                }
            }
            if(HangHoa instanceof HangThucPham){
                if(((HangThucPham) HangHoa).getngayHH().before(new Date())){
                    System.out.println(" Danh Gia : Hang Kho Ban ");
                    System.out.println("");
                }else{
                    danhgia = 1;
                }
            }
            if(HangHoa instanceof HangSanhSu){
                if(((HangSanhSu) HangHoa).getSoLuong() > 50  && ((HangSanhSu) HangHoa).getNgayNK().compareTo(new Date()) < 10){
                    System.out.println(" Danh Gia : Hang Kho Ban ");
                    System.out.println("");
                }else{
                    danhgia = 1;
                }
            }

                if( danhgia == 1 ){
                    System.out.println(" khong danh gia ");
                    System.out.println("");
                }
            }
        }

    protected void inDanhSachHangHoa(){
        for (HangHoa HangHoa : danhSach) {
            System.out.println(HangHoa);
        }
    }

    protected void inDanhSachHangHoaTheoMaHang( HangHoa HangHoa){
        if (HangHoa == null) {
            System.out.println(" hang hoa khong co trong kho");
        } else {
            System.out.println(HangHoa);
        }
    } 

    protected HangHoa timKiemHangHoa(){
        System.out.print("Nhap Ma Hang Hoa ");
        String MaHang = scanner.nextLine();
        HangHoa HangHoa = null;
        for (HangHoa hh : danhSach) {
            if(hh.getMaHang().equalsIgnoreCase(MaHang)){
                HangHoa = hh;
            }else{

            }
        }
        return HangHoa;
    }

    protected void xoaHangHoa(HangHoa HangHoa){
        this.danhSach.remove(HangHoa);
        System.out.println(" xoa thanh cong");
    }


    protected int timViTriCuaHangHoa(HangHoa HangHoa){
        int viTri = -1;
        viTri = this.danhSach.indexOf(HangHoa);
        return viTri;
    }

    protected void suaHangHoa(int viTri, HangHoa HangHoa){
        if (HangHoa == null) {
            System.out.println("");
        } else {
        System.out.println(" ban muon sua thong tin gi ");
        System.out.println(" >> - 1 sua ten hang hang hoa      ");
        System.out.println(" >> - 2 sua so luong hang hoa      ");
        System.out.println(" >> - 3 sua don gia hang hoa       ");
        int loai = 0;
        try {
            loai = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(" chi nhap so thoi ban oi !! ");
        }
        scanner.nextLine();
        if( loai == 1 ){
            System.out.println(" vui long nhap lai ten hang hoa ");
            String TenHang = scanner.nextLine();
            HangHoa.setTenHang(TenHang);
        }else if( loai == 2 ){
            System.out.println(" vui long nhap lai so luong hang hoa ");
            int SoLuong = scanner.nextInt();
            HangHoa.setSoLuong(SoLuong);
        }else if( loai == 3 ){
            System.out.println(" vui long nhap lai Don Gia hang hoa ");
            Double DonGia = scanner.nextDouble();
            HangHoa.setDonGia(DonGia);
        }
        this.danhSach.set(viTri, HangHoa);
        System.out.println(" sua thanh cong");
    }
}
    protected int TongSoLuongHangHoa(){
        int TongSoLuong = 0;
        for (HangHoa hh : danhSach) {
            TongSoLuong += hh.getSoLuong();
        }
    return TongSoLuong;
    }


    protected void XuatTongSoLuongHangHoa(){
        System.out.println(" Tong So Luong Hang Hoa co trong kho " + TongSoLuongHangHoa() + " hang hoa ");
    }

    protected Double TongGiaTriHangHoa(){
        Double TongGiaTriHangHoa = 0d;
        for (HangHoa hh : danhSach) {
            TongGiaTriHangHoa += hh.getDonGia() * hh.getSoLuong();
        }
    return TongGiaTriHangHoa;
    }


    protected void XuatTongGiaTriHangHoa(){
        System.out.println(" Tong Gia tri Hang Hoa co trong kho " + TongGiaTriHangHoa() + " vnd ");
    }

    protected void Xuatsoluongtungloai() {
        int thucpham = 0;
        int dienmay = 0;
        int sanhsu = 0; 
        for (HangHoa hh : danhSach) {
            if( hh instanceof HangThucPham ){
                thucpham++;
            }else if( hh instanceof HangSanhSu){
                sanhsu++;
            }else if( hh instanceof HangDienMay){
                dienmay++;
            }
        }
        System.out.println(" số loại thực phẩm có trong kho là :" + thucpham);
        System.out.println(" số loại điện máy có trong kho là :" + dienmay);
        System.out.println(" số loại sành sứ có trong kho là :" + sanhsu);
    }

    protected void SapXepTangDan(){
  
    Collections.sort(danhSach, new Comparator<HangHoa>() {
        @Override
        public int compare(HangHoa o1, HangHoa o2) {
            if(o1.getDonGia() > o2.getDonGia()) {
                return 0 ;
            }
            return -1;
        }
    });
}

    protected void SapXepGiamDan(){
  
    Collections.sort(danhSach, new Comparator<HangHoa>() {
        @Override
        public int compare(HangHoa o1, HangHoa o2) {
            if(o1.getDonGia() < o2.getDonGia()) {
                return 0 ;
            }
            return -1;
        }
    });

    }

    protected void GhiDuLieuTrongListVaoFile(){
        WritingObject a = new WritingObject();
        FileOutputStream fileA = a.createFile("hanghoa.dat");
        try {
            a.addDataToFile(fileA, danhSach);
            System.out.println(" them du lieu vao file thanh cong");
        } catch (IOException e) {
            System.out.println( "Error: " + e.toString());
            e.printStackTrace();
        }
    }

    protected void GhiDuLieuTuFileVaoTrongList(){
        List<HangHoa> listRead = null;
        try {
            listRead = ReadingObject.ReadFile("hanghoa.dat");
        } catch (IOException e) {
            System.out.println( "Error: " + e.toString());
        }
        for(HangHoa v : listRead) {
            them(v);
        }
    }
    protected void DocDuLieuCoTrongFileHienTai(){
        List<HangHoa> listRead = null;
        try {
            listRead = ReadingObject.ReadFile("hanghoa.dat");
        } catch (IOException e) {
            System.out.println( "Error: " + e.toString());
        }
        for(HangHoa xdl : listRead) {
            System.out.println(xdl);
        }
    }
    
}
