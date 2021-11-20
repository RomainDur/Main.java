import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DicoFile extends ArbrePrefixe{
    public String filename;

    public DicoFile(String file) {
        filename = file;
    }

    public ArbrePrefixe Dictionnaire() {
        ArbrePrefixe Dico = new ArbrePrefixe();
        Dico.add("");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Addmot(line,Dico);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Dico;
    }
}



