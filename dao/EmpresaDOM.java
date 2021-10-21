package dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.nio.file.Path;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import modelo.Empresa;
import modelo.Empleado;

public class EmpresaDOM{

	private static final String DOM_XML_FILE = "xml/EmpresaDOM.xml";


	public boolean leer(Path empresaXML) {
		return false;
		
	}
	

	public boolean guardar(Empresa empresa) {
try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			DOMImplementation implementation = builder.getDOMImplementation();

			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

			for (Empleado e: empresa.getEmpleados()) {
				Element raiz = document.createElement("empleado");

				document.getDocumentElement().appendChild(raiz);

				CrearElemento("id", Integer.toString(e.getId()), raiz, document);
				CrearElemento("nombre", e.getNombre(), raiz, document);
				CrearElemento("titulo", e.getTitulo(), raiz, document);
				CrearElemento("activo", Boolean.toString(e.isActivo()), raiz, document);
        CrearElemento("numeroEmpl", Integer.toString(e.getNumeroEmpl()), raiz, document);
         CrearElemento("fechaAlta", e.getFechaAlta().toString(), raiz, document);
			}

			// Creamos la fuente XML a partir del documento
			Source source = new DOMSource(document);
			// Creamos el resultado en el fichero Empleados.xml
			Result result = new StreamResult(new java.io.File(DOM_XML_FILE));
			// Obtenemos un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// Le damos formato y realizamos la transformación del documento a fichero
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
			// Mostramos el documento por pantalla especificando el canal de salida el
			// System.out
			Result console = new StreamResult(System.out);

			transformer.transform(source, console);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
      return false;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
      return false;
		}		
    return true;
	}

	// obtener información de un nodo
	private String getNodo(String etiqueta, Element elem) {
		NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) nodo.item(0);
		return valornodo.getNodeValue(); // devuelve el valor del nodo
	}

  	private void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}
