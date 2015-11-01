package arquivos15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Arquivos15 {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
       XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("autores.xml"));
       
       while (reader.hasNext()) {
                reader.next();

                if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {

                    String nombreElem = reader.getAttributeLocalName(0);
                    String nombreAtri = reader.getAttributeValue(0);
                    if (nombreElem != null && nombreAtri != null) {
                        System.out.print("<" + reader.getLocalName() + " " + nombreElem + "=" + '"' + nombreAtri + '"' + ">");
                    } else {
                        System.out.print("<" + reader.getLocalName() + ">");
                    }
                } else if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                    System.out.print(reader.getText());
                } else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    System.out.print("</" + reader.getLocalName() + ">");
                }
            }

            reader.close();
    }
    
}
