import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoDoc {

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;

        List<ClassStructure> classes = new ArrayList<>();
        try {
            inputStream = new BufferedReader(new FileReader("sampleHeader.h"));

            boolean expectClassName = false;


            String l;
            while ((l = inputStream.readLine()) != null) {

                String[] words = l.split(" ");

                for (String word : words) {

                    if (expectClassName && !word.isEmpty()) {

                        ClassStructure cs = new ClassStructure(word);
                        classes.add(cs);
                        expectClassName = false;

                    }

                    if (word.compareTo("class") == 0) {

                        System.out.println("Found class");
                        expectClassName = true;
                    }

                }
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

        }

        for (ClassStructure var : classes) {
         System.out.println(var.GetName());   
        }
    }
}