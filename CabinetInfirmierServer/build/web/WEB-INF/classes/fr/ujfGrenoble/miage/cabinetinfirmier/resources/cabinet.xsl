<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="utf-8"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Infirmier XSLT</title>
                <link type="text/css" rel="stylesheet" href="css/cabinet.css"/>
                <script type="text/javascript" src="js/facture.js"></script>
            </head>
            <body>
                <xsl:call-template name="infTemplate">
                    <xsl:with-param name="IDinf" select="001"/>
                </xsl:call-template>
            </body>
        </html>
    </xsl:template>
    <xsl:template name="infTemplate">
        <xsl:param name="IDinf"/>
        <h2 id="bigH2">Bonjour, <xsl:value-of select="//infirmier[position() = $IDinf]/nom"/></h2>
        <h2>
            Vous avez,
            <xsl:value-of select="count(//visite[@intervenant = $IDinf])"/>
            Patient(s).
        </h2>
        <table border="1">
            <xsl:for-each select="//visite[@intervenant = $IDinf]">
                <tr>
                    <th>Patient <xsl:value-of select="position()"/></th>
                    <tr>
                        <td>
                            <label>Nom : </label><xsl:value-of select="preceding-sibling::nom"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Prénom : </label><xsl:value-of select="preceding-sibling::prénom"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Adresse : </label><xsl:value-of select="preceding-sibling::adresse"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Liste des soins</th>
                    </tr>
                    <tr>
                        <td>
                            <xsl:for-each select="acte">
                                <ul>
                                    <li>
                                        <xsl:call-template name="soinsList">
                                            <xsl:with-param name="idSoin" select="./@id"/>
                                        </xsl:call-template>
                                    </li>
                                </ul>
                            </xsl:for-each>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input id="btnFacture" type="button" value="Facture">
                                <xsl:attribute name="onclick">
                                    openFacture ('<xsl:value-of select='preceding-sibling::nom'/>',
                                                  '<xsl:value-of select='preceding-sibling::prénom'/>',
                                                  '<xsl:value-of select='acte'/>')
                                </xsl:attribute>
                            </input>
                        </td>
                    </tr>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
    <xsl:template name="soinsList">
        <xsl:param name="idSoin"/>
        <xsl:variable name="actes" select="document('acte.xml')//actes"/>
        <xsl:value-of select="$actes/acte[@id = $idSoin]"/>
    </xsl:template>
</xsl:stylesheet>