
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WritingObject {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        FileOutputStream fileA = createFile("hanghoa.dat");
        
        HangHoa htp5 = new HangThucPham("TP5" , " banh bao " , 20 , 200.50 , date.parse("3/4/2004") , date.parse("7/5/2004") , "Ai");
        HangHoa htp6 = new HangThucPham("TP6" , " khoai san" , 20 , 200.50 , date.parse("3/4/2004") , date.parse("7/5/2004") , "tada");
        HangHoa htp7 = new HangThucPham("TP7" , " banh kem" , 20 , 200.50 , date.parse("3/4/2004") ,  date.parse("7/5/2004") , "io");
        HangHoa htp8 = new HangThucPham("TP8" , " mi hao hao" , 20 , 200.50 , date.parse("3/4/2004") ,  date.parse("7/5/2004"), "tels");
        HangHoa hss5 = new HangSanhSu("SS5" , " chai lo" , 20 , 200.50 , date.parse("3/4/2004") ,   "omge");
        HangHoa hss6 = new HangSanhSu("SS6" , "  to mien " , 20 , 200.50 , date.parse("3/4/2004") ,  "isfoe");
        HangHoa hss7 = new HangSanhSu("SS7" , " chuong " , 20 , 200.50 , date.parse("3/4/2004") ,  "kiwari");
        HangHoa hss8 = new HangSanhSu("SS8" , " lac tay" , 20 , 200.50 , date.parse("3/4/2004") ,  "super ");
        HangHoa hdm3 = new HangDienMay("Dm3" , " tivi " , 20 , 200.50 , 523d , 2);
        HangHoa hdm4 = new HangDienMay("Dm4" , " tu lanh" , 20 , 200.50 , 32.2 ,  2 );

        //code voi abstract
        List<HangHoa> danhsach = new ArrayList<>();
        danhsach.add(htp5);
        danhsach.add(htp6);
        danhsach.add(htp7);
        danhsach.add(htp8);
        danhsach.add(hss5);
        danhsach.add(hss6);
        danhsach.add(hss7);
        danhsach.add(hss8);
        danhsach.add(hdm3);
        danhsach.add(hdm4);

        addDataToFile(fileA, danhsach);

    }

    protected static FileOutputStream createFile (String name) {
        try {
            FileOutputStream outFile = new FileOutputStream(name);
            return outFile;
        } catch (Exception e){
            System.out.println( "Error: " + e.toString());
            return null;
        }
    }

    protected static void addDataToFile (FileOutputStream file, List<HangHoa> a) throws IOException {
        ObjectOutputStream objOut = null;
        try {
            if (a.size() > 0) {
                objOut = new ObjectOutputStream(file);
                objOut.writeObject(a);
            }
        } catch (IOException e) {
            System.out.println( "Error: " + e.toString());
        } finally {
            objOut.close();
        }
    }
}
