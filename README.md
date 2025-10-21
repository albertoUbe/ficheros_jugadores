# 🗃️ Creacion de ficheros para jugadores-usuarios

### Pasos

- Creación de un fichero.dat a partir de datos de jugadores.
- Lectura y modificación de ciertos datos buscando por el id.
- Creación de un fichero.xml a partir del fichero.dat.
- Lectura del fichero.xml mediante SAX.
- Generación de un fichero.html a partir del fichero.xml.

## 📦 Estructura del Proyecto

📁 com.fichero.jugador

   📁 Ficheros
  
      📄 CreacionHTML_XSLT_AUPB.java

      📄 CrearFichero_AUPB.java

      📄 CrearXML_AUPB.java

      📄 GestionContenido.java

      📄 LeerFicheroXML_AUPB.java

      📄 ModificarFichero_AUPB.java
 
  📁 Jugador
  
      📄 Jugador.java

---

## 🧑‍💻 Ejecución

Compila y ejecuta el programa por consola con maven: desde la carpeta raíz donde se encuentra el `pom.xml`.

```bash
mvn clean compile `(desde target/classes)`

`CrearFichero_AUPB`
java -cp target/classes com.fichero.jugador.Ficheros.CrearFichero_AUPB carpeta_jugadores

`ModificarFichero_AUPB`
java -cp target/classes com.fichero.jugador.Ficheros.ModificarFichero_AUPB 1 "Alberto" alber17" 28 43.89

`CrearXML_AUPB`
java -cp target/classes com.fichero.jugador.Ficheros.CrearXML_AUPB

`LeerFicheroXML_AUPB`
java -cp target/classes com.fichero.jugador.Ficheros.LeerFicheroXML_AUPB

`CreacionHTML_XSLT_AUPB`
java -cp target/classes com.fichero.jugador.Ficheros.CreacionHTML_XSLT_AUPB

```

Mostraran la siguiente ficheros:

> jugadores.dat
>
> jugadores.xml
>
> jugadoresPlantilla.xsl
>
> mipagina_jugadores.html
