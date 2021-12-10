package hu.domparse.ET2PK2;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.Scanner;
//Példányosítom a readosztályt és felhasználom a metódusait
public class DomQueryET2PK2 extends DomReadET2PK2 {

	public static void main(String[] args) {
		try {
			// Fájl Elérése
			File inputFile = new File("src/XmlET2PK2.xml");
			// Dom-dokumentum létrehozása az XML dokumentum eléréséhez
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Gyoker elem :" + doc.getDocumentElement().getNodeName());
			//Itt lehet kiválasztani melyik elemet irassuk ki
			//horgaszbolt
			//horgaszbot
			//gyarto
			//vasarlo
			//vasarlas
			//kapcsvasarlasok
			//fizetes
			String element = "fizetes";
			//itt adjuk meg melyik elemet hívjuk meg
			NodeList nList = doc.getElementsByTagName(element);
			//itt hívjuk meg a metódust
			//horgaszboltRead(nList);
			//horgaszbotokRead(nList);
			//gyartoRead(nList);
			//vasarloRead(nList);
			//vasarlasokRead(nList);
			//vasarlasok_kapcsolotablaRead(nList);
			fizetesekRead(nList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
