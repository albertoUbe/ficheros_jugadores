package com.fichero.jugador.Ficheros;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class CreacionHTML_XSLT_AUPB {
    public static final String RUTA = "src/main/resources/carpeta_jugadores";
    public static final String NOMBRE_XML = "jugadores.xml";
    public static final String NOMBRE_XSLT = "jugadoresPlantilla.xsl";
    public static void main(String[] args) throws IOException {
        
        String hojaEstilo = RUTA + "/" + NOMBRE_XSLT;
        String datosJugadores = RUTA + "/" + NOMBRE_XML;
        File pagHTML = new File(RUTA, "mipagina_jugadores.html");
        FileOutputStream fileOut = new FileOutputStream(pagHTML); //Creacion HTML

        Source estilos =new StreamSource(hojaEstilo); //fuente XSL
        Source datos =new StreamSource(datosJugadores); //fuente XML
        Result result = new StreamResult(fileOut); 

        try{ 
            Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos); 
            transformer.transform(datos, result); //Obtener HTML
        } catch( TransformerException e1){
            System.err.println("Error: "+ e1);
        } catch(Exception e2){
            System.err.println("Error: "+ e2);
        }
        
        fileOut.close();
    }
    
    

}
