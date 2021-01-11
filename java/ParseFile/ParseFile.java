import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class ParseFile {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting ParseFile...");

        String fileName = ".\\url-list.json";
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);

        String line;
        while ((line = bfr.readLine()) != null) {
            System.out.println(line);
        }

        JSONFileReader jfr = new JSONFileReader(fileName);
        jfr.readAndParseFile();

        JSONFileReader jfrFromURL = new JSONFileReader("https://thunderbird-data.azurewebsites.net/url-list.json");
        jfrFromURL.readAndParseURL();
    }
}