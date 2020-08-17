package utilities;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import java.io.File;
public class XmlReader {

	SAXReader saxReader = new SAXReader();

		static File inputFile = new File(System.getProperty("user.dir") +"\\src\\main\\resources\\ObjectRepository.xml");
		
		public Document xml() 
		{
			Document document = null;
			try {
				document = saxReader.read(inputFile);
			} catch (DocumentException e) {
				
				e.printStackTrace();
			}
			System.out.println(document);
			return document;
		}
		

	}


