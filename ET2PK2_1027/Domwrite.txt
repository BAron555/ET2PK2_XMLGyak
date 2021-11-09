public class DomWriteKPR {

	public static void main (String[] args) throws ParserConfigurationException,
	TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.newDocument();

		Element root = doc.createElementNS ("domkprlnb", "users");
		doc.appendChild(root);

		root.appendChild(createUser(doc, "1", "Pal", "Kiss", "programmer"));
		root.appendChild(createUser(doc, "2", "Piroska", "Zold", "writer"));
		root.appendChild(createUser(doc, "3", "Alma", "Gordon", "teacher"));

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();

		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		
		DOMSource source = new DOMSource(doc);

		File myFile = new File("users1.xml");

		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, console);
		transf.transform(source, file);
	}
	private static Node createUser(Document doc, String id, String firstName, String lastName, String profession) {

		Element user = doc.createElement("user");

		user.setAttribute("id", id);
		user.appendChild(createUserELement(doc, "firstname", firstName));
		user.appendChild(createUserELement(doc, "lastname", lastName));
		user.appendChild(createUserELement(doc, "profession", profession));

		return user;
	}
	private static Node createUserElement(Document doc, String name, String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}
}
