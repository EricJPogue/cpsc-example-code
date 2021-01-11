import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

class JSONFileReader extends HttpRequest {
    String fileOrURLName = null;
    private File f;

    JSONFileReader(String fileOrURLNameIn) {
        fileOrURLName = fileOrURLNameIn;        
    }

    void readAndParseFile() throws Exception {
        f = new File(fileOrURLName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);

        String line;
        while ((line = bfr.readLine()) != null) {
            parseLine(line);
        }
    }

    void readAndParseURL() throws Exception {
        readURL(fileOrURLName);
        for (String line: urlContent) {
            parseLine(line);
        }
    }

    void parseLine(String line) {
//       System.out.println("\n"+line);

        String[] splitList = line.split("\"");
/*
        int i = 0;
        for (String s: splitList) {
            System.out.println(i+"-"+s);
            i++;
        }
*/

        if (splitList.length > 7) {
            System.out.println("\nUsing split()");
            if (splitList[5].equals("Email")) {
                    System.out.println("Email: "+splitList[7]);
            }
        }

        if (splitList.length > 9) {
            if (splitList[9].equals("ContactURL")) {
                System.out.println("URL: "+splitList[11]);
            }
        }

        // Using substring()
        String email = findDataAssociatedWithKey(line, "\"Email\":\"");
        String contactURL = findDataAssociatedWithKey(line, "\"ContactURL\":\"");

        if ((email!=null)&&(contactURL!=null)) {
            System.out.println("\nUsing subString()");
            System.out.println("Email: " + email);
            System.out.println("URL: " + contactURL);
        }
    }

    private String findDataAssociatedWithKey(String data, String key) {
        int firstIndex = data.indexOf(key);
        if (firstIndex < 0) {
            return null;
        }

        String s = data.substring(firstIndex + key.length());
        int closingQuoteIndex = s.indexOf("\"");

        if (closingQuoteIndex > -1) {
            s = s.substring(0,closingQuoteIndex);
        }

        return s;
    }
}
