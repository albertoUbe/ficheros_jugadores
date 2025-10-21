package com.fichero.jugador.Ficheros;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class LeerFicheroXML_AUPB {
    public static final String RUTA = "src/main/resources/carpeta_jugadores";
    public static final String NOMBRE_XML = "jugadores.xml";
    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            GestionContenido gestor = new GestionContenido();
            parser.parse(RUTA + "/" + NOMBRE_XML, gestor);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
