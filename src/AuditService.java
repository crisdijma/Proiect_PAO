import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AuditService {

    public void scriere(String comanda, String data){
        try(FileWriter fisier = new FileWriter("src/audit.csv",true)){
            fisier.write(comanda+"," +data+'\n');
            fisier.flush();
        }catch (IOException ex){
            System.out.println("Error writing to file!");
        }
    }
}
