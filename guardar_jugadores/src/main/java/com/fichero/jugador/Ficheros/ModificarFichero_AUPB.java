package com.fichero.jugador.Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificarFichero_AUPB {
    
    public static final String RUTA = "src/main/resources/carpeta_jugadores";
    public static final String MSG_ERROR = "Posición no encontrada.";
    public static void main(String[] args) throws IOException {

        File file = new File(RUTA, CrearFichero_AUPB.NOMBRE_FICHERO);

        int id = Integer.parseInt(args[0]);
        String nombre = args[1];
        String usuario = args[2];
        int edad = Integer.parseInt(args[3]);
        float porcentaje = Float.parseFloat(args[4]);

        int tamanioBytes = 4 + 40 + 40 + 4 + 4;

        try {
            RandomAccessFile random = new RandomAccessFile(file, "rw");

            long posicion = (id - 1) * tamanioBytes;

            while (posicion >= random.length()) {
                System.out.println(MSG_ERROR);
                random.close();
                return;
            }

            random.seek(posicion);

            random.writeInt(id);
            random.writeUTF(nombre);
            random.writeUTF(usuario);
            random.writeInt(edad);
            random.writeFloat(porcentaje);

        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

}
