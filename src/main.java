
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = null;
        File file = new File(args[0]);
        reader = new BufferedReader(new FileReader(file));
        
        String line;
        
        while ((line = reader.readLine()) != null) {
            System.out.println(FSA.validate(line));
        }
        
        reader.close();       
        
    }
}
