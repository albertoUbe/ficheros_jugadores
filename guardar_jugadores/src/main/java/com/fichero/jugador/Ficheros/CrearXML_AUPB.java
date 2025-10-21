package com.fichero.jugador.Ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXML_AUPB {

    public static final String RUTA = "src/main/resources/carpeta_jugadores";
    public static final String NOMBRE_XML = "jugadores.xml";
    public static final String MSG_ERROR = "Fichero binario no encontrado.";

    public static void main(String[] args) throws IOException {
        File file = new File(RUTA, CrearFichero_AUPB.NOMBRE_FICHERO);
        
        if (!file.exists()) {
            System.err.println(MSG_ERROR);
            return;
        }

        try (RandomAccessFile random = new RandomAccessFile(file, "r")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Jugadores", null);
            document.setXmlVersion("1.0");

            long posicion = 0;
            while (posicion < random.length()) {
                random.seek(posicion);

                int id = random.readInt();
                String nombre = random.readUTF();
                String usuario = random.readUTF();
                int edad = random.readInt();
                float porcentaje = random.readFloat();

                Element jugador = document.createElement("jugador");
                document.getDocumentElement().appendChild(jugador);

                CrearElemento("id", Integer.toString(id), jugador, document);
                CrearElemento("nombre", nombre, jugador, document);
                CrearElemento("usuario", usuario, jugador, document);
                CrearElemento("edad", Integer.toString(edad), jugador, document);
                CrearElemento("porcentaje_victorias", Float.toString(porcentaje), jugador, document);

                posicion = random.getFilePointer();
            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File(RUTA, NOMBRE_XML));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);

        } catch (Exception e) {
            System.err.println("Error al generar XML: " + e.getMessage());
        }
    }

    private static void CrearElemento(String etiqueta, String valor, Element raiz, Document document) {
        Element elem = document.createElement(etiqueta);
        Text text = document.createTextNode(valor);
        elem.appendChild(text);
        raiz.appendChild(elem);
    }
}
