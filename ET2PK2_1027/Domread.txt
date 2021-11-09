public class DomRead {
	public static void main (String argv[]) throwss SAXException,
	IOException, ParserConfigurationException {

		File xmlFile = new File("users.xml");

		DocumentBuilderFactiory factory = DocumentBuilderFactory.newInstance();
		DocumentumBuilder dBuilder = factory.newDocumentBuilder();

		Document doc = dBuilder.parse(xmlFile);

		Doc.getDocumentElement().normalize();

		System.out.println("Root element: " + doc.getDocumentelem().getNodeName());	

		NodeList nList = doc.getElementsByTagNa	me("user");
	
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);

			System.out.println("\nCurrent Element: " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element elem = (Element) nNode;

				String uid = elem.getAttribute("id");

				Node node1 = elem.getElementsByTagName("firstname").item(0);
				String fname = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("lastname").item(0);
				String lname = node2.getTextContent();

				Node node3 = elem.getElementsByTagName("profession").item(0);
				String pname = node3.getTextContent();
	
				System.out.printf("User id: %s%n", uid);
				System.out.printf("First name: %s%n", fname);
				System.out.printf("Last name: %s%n", lname);
				System.out.printf("Profession: %s%n", pname);
			}
		}
	}
}