package hu.domparse.ET2PK2;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomReadET2PK2 {

	public static void main(String[] args) {
		try {
			// Fájl elérése
			File inputFile = new File("src/XmlET2PK2.xml");
			// Dom-dokumentum létrehozása az XML dokumentum eléréséhez
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Aktualis elem :" + doc.getDocumentElement().getNodeName());
			System.out.println("\n");

			// Elemek Kiiratasa metódus hívásokkal
			NodeList nList = doc.getElementsByTagName("horgaszbolt");
			horgaszboltRead(nList);

			NodeList nList2 = doc.getElementsByTagName("horgaszbot");
			horgaszbotokRead(nList2);

			NodeList nList3 = doc.getElementsByTagName("gyarto");
			gyartoRead(nList3);

			NodeList nList4 = doc.getElementsByTagName("vasarlo");
			vasarloRead(nList4);

			NodeList nList5 = doc.getElementsByTagName("vasarlas");
			vasarlasokRead(nList5);

			NodeList nList6 = doc.getElementsByTagName("kapcsvasarlasok");
			vasarlasok_kapcsolotablaRead(nList6);

			NodeList nList7 = doc.getElementsByTagName("fizetes");
			fizetesekRead(nList7);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Saját metódus ami egyszerűsíti a kiíratást
	public static void getElement(Element eElement, String elementOut, String elementName) {

		System.out.println(elementOut + " : " + eElement.getElementsByTagName(elementName).item(0).getTextContent());
	}

	//Itt implementálom a metódusokat amiket később meghívok
	//ezek olvassák ki az xml fájlból az adatokat
	public static void horgaszboltRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "nev", "nev");
				getElement(eElement, "utca", "utca");
				getElement(eElement, "varos", "varos");
				getElement(eElement, "hazszam", "hazszam");
				getElement(eElement, "telefonszam", "telefonszam");
				getElement(eElement, "fk_id_horgaszbot", "fk_id_horgaszbot");
				getElement(eElement, "fk_id_vasarlo", "fk_id_vasarlo");

			}
		}
	}

	public static void horgaszbotokRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "modell", "modell");
				getElement(eElement, "hossz", "hossz");
				getElement(eElement, "minoseg", "minoseg");
				getElement(eElement, "suly", "suly");
				getElement(eElement, "fk_id_gyarto", "fk_id_gyarto");

			}
		}
	}

	public static void gyartoRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "nev", "nev");
				getElement(eElement, "szarmazasihely", "szarmazasihely");
				getElement(eElement, "telefonszam", "telefonszam");

			}
		}
	}

	public static void vasarloRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "nev", "nev");
				getElement(eElement, "email", "email");
				getElement(eElement, "utca", "utca");
				getElement(eElement, "varos", "varos");
				getElement(eElement, "hazszam", "hazszam");

			}
		}
	}

	public static void vasarlasokRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "jotallas", "jotallas");
				getElement(eElement, "termek", "termek");
				getElement(eElement, "beszallito", "beszallito");
				getElement(eElement, "fk_id_fiz", "fk_id_fiz");

			}
		}
	}

	public static void vasarlasok_kapcsolotablaRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));
				getElement(eElement, "fk_id_vasarlo", "fk_id_vasarlo");
				getElement(eElement, "fk_id_vasarlas", "fk_id_vasarlas");
				getElement(eElement, "darab", "darab");
				getElement(eElement, "datum", "datum");

			}
		}
	}

	public static void fizetesekRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Aktualis elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));
				getElement(eElement, "datum", "datum");
				getElement(eElement, "osszeg", "osszeg");
				getElement(eElement, "szamla", "szamla");

			}
		}
	}
}
