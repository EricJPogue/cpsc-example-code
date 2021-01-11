import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HttpRequestFile {
    private String fileName;
    private ArrayList<String> urlList;
    
    HttpRequestFile() {
        fileName = "";
        urlList = new ArrayList<String>();
    }

    public Boolean readFileURLs(String fileNameIn) {
        Boolean returnValue = false; 
        fileName = fileNameIn;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] elements = line.split("\"");
                if (elements.length > 1) {
                    if (elements[11].indexOf("http") > -1) {
                        System.out.println("Element 11:" + elements[11]);
                        urlList.add(elements[11]);
                        returnValue = true;
                    }
                }
            }
            br.close();
        }
        catch (IOException e) {
            returnValue = false;
            System.out.println("An exception occurred in HttpRequest!");
        }
        
        return returnValue;
    }

    public Boolean processURLs () {
        Boolean returnValue = true;
        for (String s : urlList) {
            HttpRequest request = new HttpRequest(s);
            if (request.readURL()) {
                System.out.println(request);
            } else {
                returnValue = false;
            }
        }
        return returnValue; 
    }

    public String toString() {
        String returnValue = "URLs in: \""+fileName+"\"\n";
        for (String s : urlList) {
            returnValue = returnValue + s + "\n";
        } 
        return returnValue;
    }
}