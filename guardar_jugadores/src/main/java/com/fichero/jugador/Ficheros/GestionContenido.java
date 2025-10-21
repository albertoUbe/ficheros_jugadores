package com.fichero.jugador.Ficheros;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }

    @Override
    public void startDocument() {
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument() {
        System.out.println("Fin del documento XML");
    }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atrbs) {
        System.out.println("\tPrincipio elemento: " + nombreC);
    }

    @Override
    public void endElement(String uri, String nombre, String nombreC) {
        System.out.println("\tFin elemento: " + nombreC);
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) {
        String car=new String(ch, inicio, longitud);
        car=car.replaceAll("[\t\n]", ""); //quitar saltos de línea
        System.out.println("\t\t"+ car);
    }
}