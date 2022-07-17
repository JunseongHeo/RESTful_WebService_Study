package CallingURL;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.List;

public class XML_DATA_Parsing {
    public static void main(String[] args) {
        // 1-2. 파일 파싱 시
        try {
            String filePath = "C:\\Users\\oksk4\\Downloads\\demo\\src\\main\\java\\CallingURL\\XML_wirte.txt";
            Document document = new SAXBuilder().build(new File(filePath));

            // 2. Root Element (catalog)
            Element rootElement = document.getRootElement();

            // 3. Root Element (book)
            List<Element> bookElements = rootElement.getChildren();
            for(Element bookElement : bookElements){

                String bookAttributeId = bookElement.getAttributeValue("id");
                System.out.println("==== ==== ==== ==== ====");

                // 4. Book Children Element (author, title, genre, price, publish_date, description)
                List<Element> bookChildrenElements =  bookElement.getChildren();
                for(Element bookChildrenElement : bookChildrenElements){
                    String name = bookChildrenElement.getName();
                    String value = bookChildrenElement.getValue();
                    System.out.println(name + " : " + value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
