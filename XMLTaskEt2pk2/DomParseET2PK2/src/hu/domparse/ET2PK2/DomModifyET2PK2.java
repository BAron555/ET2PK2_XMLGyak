package hu.domparse.ET2PK2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyET2PK2{

	public static void main(String[] args) throws TransformerException {
		// Dom-dokumentum létrehozása az XML dokumentum eléréséhez
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try (InputStream is = new FileInputStream("src/XmlET2PK2.xml")) {

			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(is);
			// Itt bescanneljük az elemetket
			Scanner rootElem = new Scanner(System.in);
			System.out.println("Modositani kivant elem?");
			String element = rootElem.nextLine();

			Scanner elemID = new Scanner(System.in);
			System.out.println("Add meg az ID-t!");
			String childElementID = elemID.nextLine();

			NodeList listOffishshop = doc.getElementsByTagName(element);

			Scanner elem = new Scanner(System.in);
			System.out.println("Melyik gyerek elemet módosítsuk?");
			String childElement = elem.nextLine();

			System.out.println("Mi legyen az uj elem erteke?");
			Scanner ujElem = new Scanner(System.in);
			String childElementElementNew = ujElem.nextLine();
			
			//Végigmegyünk az xml dokumentumon
			for (int i = 0; i < listOffishshop.getLength(); i++) {
				//a temp megkapja a kiválasztott elemeket
				Node temp = listOffishshop.item(i);
				if (temp.getNodeType() == Node.ELEMENT_NODE) {
					//Megadjuk melyik az az  ID-jű elem amit modosítunk
					String id = temp.getAttributes().getNamedItem("id").getTextContent();
					//ha egyezik valamelyik id-vel akkor tovább hajtódik az utasítás
					if (childElementID.equals(id.trim())) {
						//A childNodes-ba beolvassuk a Root elementnek a gyerekeit
						NodeList childNodes = temp.getChildNodes();
						//Itt történik utána a módosítás
						for (int j = 0; j < childNodes.getLength(); j++) {
							Node item = childNodes.item(j);
							if (item.getNodeType() == Node.ELEMENT_NODE) {

								if (childElement.equalsIgnoreCase(item.getNodeName())) {
									item.setTextContent(childElementElementNew);
								}

							}

						}

					}

				}

			}
			
			
			// Létrehozunk egy TransformerFactory és egy DOMSource objektumot ezzel leegyszerűsítve a kiíratást 
			//A transformerfactory-val bármilyen szöveges tartalmat egyszerűen kiírathatunk 
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// itt megadjuk a saját xmelünket amit már az elején deklalártunk
			DOMSource source = new DOMSource(doc);
			//Itt a streamet adjuk meg jelen esetben a console-ra fogunk kiíratni
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
