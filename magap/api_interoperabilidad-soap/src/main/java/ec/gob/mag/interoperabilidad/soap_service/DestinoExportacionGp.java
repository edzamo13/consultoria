//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.24 at 03:22:21 PM ECT 
//


package ec.gob.mag.interoperabilidad.soap_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for destinoExportacionGp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="destinoExportacionGp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gmvCodigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prgId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gmvFechaInicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codCanton" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinoExportacionGp", propOrder = {
    "gmvCodigo",
    "prgId",
    "gmvFechaInicio",
    "nombre",
    "direccion",
    "codCanton",
    "id"
})
public class DestinoExportacionGp {

    @XmlElement(required = true)
    protected String gmvCodigo;
    protected int prgId;
    @XmlElement(required = true)
    protected String gmvFechaInicio;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String direccion;
    @XmlElement(required = true)
    protected String codCanton;
    @XmlElement(required = true)
    protected String id;

    /**
     * Gets the value of the gmvCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGmvCodigo() {
        return gmvCodigo;
    }

    /**
     * Sets the value of the gmvCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGmvCodigo(String value) {
        this.gmvCodigo = value;
    }

    /**
     * Gets the value of the prgId property.
     * 
     */
    public int getPrgId() {
        return prgId;
    }

    /**
     * Sets the value of the prgId property.
     * 
     */
    public void setPrgId(int value) {
        this.prgId = value;
    }

    /**
     * Gets the value of the gmvFechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGmvFechaInicio() {
        return gmvFechaInicio;
    }

    /**
     * Sets the value of the gmvFechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGmvFechaInicio(String value) {
        this.gmvFechaInicio = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Gets the value of the codCanton property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCanton() {
        return codCanton;
    }

    /**
     * Sets the value of the codCanton property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCanton(String value) {
        this.codCanton = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}