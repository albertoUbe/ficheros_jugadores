package com.fichero.jugador.Ficheros;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fichero.jugador.Jugador.Jugador;

public class CrearFichero_AUPB {

    public static final String RUTA = "src/main/resources/carpeta_jugadores";
    public static final String NOMBRE_FICHERO = "jugadores.dat";
    public static final String MSG_CORRECTO = "Directorio creado: ";
    public static final String MSG_ERROR = "El directorio ya existe.";

    public static void main(String[] args) throws IOException {
        File directorio = new File(RUTA);
        File file = new File(directorio, NOMBRE_FICHERO);

        if (!directorio.exists()) {
            directorio.mkdirs();
            System.out.println(MSG_CORRECTO + RUTA);
        } else {
            System.out.println(MSG_ERROR);
        }

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < Jugador.VALORES_ID.length; i++) {
                dataOut.writeInt(Jugador.VALORES_ID[i]);
                dataOut.writeUTF(Jugador.VALORES_NOMBRE[i]);
                dataOut.writeUTF(Jugador.VALORES_USUARIO[i]);
                dataOut.writeInt(Jugador.VALORES_EDAD[i]);
                dataOut.writeFloat(Jugador.VALORES_PORCENTAJE_VICTORIAS[i]);
            }
            System.out.println("Fichero binario creado: " + NOMBRE_FICHERO);
        } catch (IOException e) {
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }
    }
}
