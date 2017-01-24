<?xml version="1.0" encoding='ISO-8859-1'?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='ListaDepartamentosLocalidad'>
    <head><title>LISTADO DE DEPARTAMENTOS</title></head>
    <body> 
    <h1>LISTA DE DEPARTAMENTOS</h1>
    <table border='1'>
    <tr><th>Departamento</th><th>Localidad</th><th>Nº Departamento</th></tr>
      <xsl:apply-templates select='DatosDepartamento' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='DatosDepartamento'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='departamento|localidad|dep'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>