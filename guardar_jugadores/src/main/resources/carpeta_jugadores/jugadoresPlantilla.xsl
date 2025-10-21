<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/Jugadores">
        <html>
            <head><title>Listado de Jugadores</title></head>
            <body>
                <h1>Jugadores</h1>
                <table border="1">
                    <tr>
                        <th>ID</th><th>Nombre</th><th>Usuario</th><th>Edad</th><th>% Victorias</th>
                    </tr>
                    <xsl:for-each select="jugador">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="usuario"/></td>
                            <td><xsl:value-of select="edad"/></td>
                            <td><xsl:value-of select="porcentaje_victorias"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
