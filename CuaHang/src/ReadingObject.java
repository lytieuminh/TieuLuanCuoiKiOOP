import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadingObject {

    protected static List<HangHoa> ReadFile (String name) throws IOException  {
        ObjectInputStream objIn = null;
        try {
            FileInputStream inFile = new FileInputStream(name);
            objIn = new ObjectInputStream(inFile);
            List<HangHoa> list = (List) objIn.readObject();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println( "Error: " + e.toString());
            return null;
        } finally {
            objIn.close();
        }

    }

}

