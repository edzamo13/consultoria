//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.24 at 03:22:21 PM ECT 
//


package ec.gob.mag.interoperabilidad.soap_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.gob.mag.interoperabilidad.soap_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DetalleGuiaPrimariaEspId_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "espId");
    private final static QName _DetalleGuiaPrimariaGesLargo_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesLargo");
    private final static QName _DetalleGuiaPrimariaGesAncho_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesAncho");
    private final static QName _DetalleGuiaPrimariaGesTipo_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesTipo");
    private final static QName _DetalleGuiaPrimariaEspecie_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "especie");
    private final static QName _DetalleGuiaPrimariaTipoEspecie_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "tipoEspecie");
    private final static QName _DetalleGuiaPrimariaEspTipo_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "espTipo");
    private final static QName _DetalleGuiaPrimariaGesUnidades_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesUnidades");
    private final static QName _DetalleGuiaPrimariaGesVolumenMovilizado_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesVolumenMovilizado");
    private final static QName _DetalleGuiaPrimariaEspNombre_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "espNombre");
    private final static QName _DetalleGuiaPrimariaGesVolumen_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesVolumen");
    private final static QName _DetalleGuiaPrimariaLicId_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "licId");
    private final static QName _DetalleGuiaPrimariaGesEspesor_QNAME = new QName("http://mag.gob.ec/interoperabilidad/soap-service", "gesEspesor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.gob.mag.interoperabilidad.soap_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCabeceraGuiaPrimariaResponse }
     * 
     */
    public GetCabeceraGuiaPrimariaResponse createGetCabeceraGuiaPrimariaResponse() {
        return new GetCabeceraGuiaPrimariaResponse();
    }

    /**
     * Create an instance of {@link CabeceraGuiaPrimaria }
     * 
     */
    public CabeceraGuiaPrimaria createCabeceraGuiaPrimaria() {
        return new CabeceraGuiaPrimaria();
    }

    /**
     * Create an instance of {@link GetCabeceraGuiaPrimariaRequest }
     * 
     */
    public GetCabeceraGuiaPrimariaRequest createGetCabeceraGuiaPrimariaRequest() {
        return new GetCabeceraGuiaPrimariaRequest();
    }

    /**
     * Create an instance of {@link DestinoClienteFinalGp }
     * 
     */
    public DestinoClienteFinalGp createDestinoClienteFinalGp() {
        return new DestinoClienteFinalGp();
    }

    /**
     * Create an instance of {@link DetalleGuiaPrimaria }
     * 
     */
    public DetalleGuiaPrimaria createDetalleGuiaPrimaria() {
        return new DetalleGuiaPrimaria();
    }

    /**
     * Create an instance of {@link DestinoIndustriaForestalGp }
     * 
     */
    public DestinoIndustriaForestalGp createDestinoIndustriaForestalGp() {
        return new DestinoIndustriaForestalGp();
    }

    /**
     * Create an instance of {@link DestinoExportacionGp }
     * 
     */
    public DestinoExportacionGp createDestinoExportacionGp() {
        return new DestinoExportacionGp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "espId", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<Integer> createDetalleGuiaPrimariaEspId(Integer value) {
        return new JAXBElement<Integer>(_DetalleGuiaPrimariaEspId_QNAME, Integer.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesLargo", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesLargo(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesLargo_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesAncho", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesAncho(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesAncho_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesTipo", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesTipo(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesTipo_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "especie", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaEspecie(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaEspecie_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "tipoEspecie", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaTipoEspecie(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaTipoEspecie_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "espTipo", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaEspTipo(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaEspTipo_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesUnidades", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesUnidades(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesUnidades_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesVolumenMovilizado", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesVolumenMovilizado(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesVolumenMovilizado_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "espNombre", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaEspNombre(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaEspNombre_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesVolumen", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesVolumen(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesVolumen_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "licId", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaLicId(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaLicId_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mag.gob.ec/interoperabilidad/soap-service", name = "gesEspesor", scope = DetalleGuiaPrimaria.class)
    public JAXBElement<String> createDetalleGuiaPrimariaGesEspesor(String value) {
        return new JAXBElement<String>(_DetalleGuiaPrimariaGesEspesor_QNAME, String.class, DetalleGuiaPrimaria.class, value);
    }

}
