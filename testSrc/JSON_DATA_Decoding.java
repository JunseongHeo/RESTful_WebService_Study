package CallingURL;

import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class JSON_DATA_Decoding {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\oksk4\\Downloads\\demo\\src\\main\\java\\CallingURL\\JSON_raw_DATA.txt";
        try {
            File jsonFile = new File(filePath);
            Scanner scanner = new Scanner(jsonFile);

            Base64.Decoder decoder = Base64.getDecoder();
            String decoded = new String(decoder.decode(scanner.next()));
            System.out.println(decoded);

            String jsonWritePath = "C:\\Users\\oksk4\\Downloads\\demo\\src\\main\\java\\CallingURL\\JSON_write.txt";

            BufferedWriter out_file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jsonWritePath),"UTF8"));

            out_file.write(decoded);
            out_file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
