//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.24 at 04:53:17 PM BRST 
//


package br.inf.portalfiscal.nfe;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * Tipo: Dados do IPI
 * 
 * <p>Java class for TIpi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TIpi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clEnq" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CNPJProd" type="{http://www.portalfiscal.inf.br/nfe}TCnpj" minOccurs="0"/>
 *         &lt;element name="cSelo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="qSelo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[0-9]{1,12}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cEnq">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="IPITrib">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="CST">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;whiteSpace value="preserve"/>
 *                           &lt;enumeration value="00"/>
 *                           &lt;enumeration value="49"/>
 *                           &lt;enumeration value="50"/>
 *                           &lt;enumeration value="99"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;choice>
 *                       &lt;sequence>
 *                         &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *                         &lt;element name="pIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302a04"/>
 *                       &lt;/sequence>
 *                       &lt;sequence>
 *                         &lt;element name="qUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1204v"/>
 *                         &lt;element name="vUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1104"/>
 *                       &lt;/sequence>
 *                     &lt;/choice>
 *                     &lt;element name="vIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="IPINT">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="CST">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;whiteSpace value="preserve"/>
 *                           &lt;enumeration value="01"/>
 *                           &lt;enumeration value="02"/>
 *                           &lt;enumeration value="03"/>
 *                           &lt;enumeration value="04"/>
 *                           &lt;enumeration value="05"/>
 *                           &lt;enumeration value="51"/>
 *                           &lt;enumeration value="52"/>
 *                           &lt;enumeration value="53"/>
 *                           &lt;enumeration value="54"/>
 *                           &lt;enumeration value="55"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIpi", propOrder = {
    "clEnq",
    "cnpjProd",
    "cSelo",
    "qSelo",
    "cEnq",
    "ipiTrib",
    "ipint"
})
@Entity(name = "TIpi")
@Table(name = "TIPI")
@Inheritance(strategy = InheritanceType.JOINED)
public class TIpi implements Equals, HashCode
{

    protected String clEnq;
    @XmlElement(name = "CNPJProd")
    protected String cnpjProd;
    protected String cSelo;
    protected String qSelo;
    @XmlElement(required = true)
    protected String cEnq;
    @XmlElement(name = "IPITrib")
    protected TIpi.IPITrib ipiTrib;
    @XmlElement(name = "IPINT")
    protected TIpi.IPINT ipint;
    @XmlAttribute(name = "Hjid")
    protected Long hjid;

    /**
     * Gets the value of the clEnq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CLENQ", length = 5)
    public String getClEnq() {
        return clEnq;
    }

    /**
     * Sets the value of the clEnq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClEnq(String value) {
        this.clEnq = value;
    }

    /**
     * Gets the value of the cnpjProd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CNPJPROD", length = 14)
    public String getCNPJProd() {
        return cnpjProd;
    }

    /**
     * Sets the value of the cnpjProd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJProd(String value) {
        this.cnpjProd = value;
    }

    /**
     * Gets the value of the cSelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CSELO", length = 60)
    public String getCSelo() {
        return cSelo;
    }

    /**
     * Sets the value of the cSelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSelo(String value) {
        this.cSelo = value;
    }

    /**
     * Gets the value of the qSelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "QSELO")
    public String getQSelo() {
        return qSelo;
    }

    /**
     * Sets the value of the qSelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQSelo(String value) {
        this.qSelo = value;
    }

    /**
     * Gets the value of the cEnq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CENQ", length = 3)
    public String getCEnq() {
        return cEnq;
    }

    /**
     * Sets the value of the cEnq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEnq(String value) {
        this.cEnq = value;
    }

    /**
     * Gets the value of the ipiTrib property.
     * 
     * @return
     *     possible object is
     *     {@link TIpi.IPITrib }
     *     
     */
    @ManyToOne(targetEntity = TIpi.IPITrib.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "IPITRIB_TIPI_HJID")
    public TIpi.IPITrib getIPITrib() {
        return ipiTrib;
    }

    /**
     * Sets the value of the ipiTrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIpi.IPITrib }
     *     
     */
    public void setIPITrib(TIpi.IPITrib value) {
        this.ipiTrib = value;
    }

    /**
     * Gets the value of the ipint property.
     * 
     * @return
     *     possible object is
     *     {@link TIpi.IPINT }
     *     
     */
    @ManyToOne(targetEntity = TIpi.IPINT.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "IPINT_TIPI_HJID")
    public TIpi.IPINT getIPINT() {
        return ipint;
    }

    /**
     * Sets the value of the ipint property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIpi.IPINT }
     *     
     */
    public void setIPINT(TIpi.IPINT value) {
        this.ipint = value;
    }

    /**
     * Gets the value of the hjid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getHjid() {
        return hjid;
    }

    /**
     * Sets the value of the hjid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TIpi)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TIpi that = ((TIpi) object);
        {
            String lhsClEnq;
            lhsClEnq = this.getClEnq();
            String rhsClEnq;
            rhsClEnq = that.getClEnq();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clEnq", lhsClEnq), LocatorUtils.property(thatLocator, "clEnq", rhsClEnq), lhsClEnq, rhsClEnq)) {
                return false;
            }
        }
        {
            String lhsCNPJProd;
            lhsCNPJProd = this.getCNPJProd();
            String rhsCNPJProd;
            rhsCNPJProd = that.getCNPJProd();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cnpjProd", lhsCNPJProd), LocatorUtils.property(thatLocator, "cnpjProd", rhsCNPJProd), lhsCNPJProd, rhsCNPJProd)) {
                return false;
            }
        }
        {
            String lhsCSelo;
            lhsCSelo = this.getCSelo();
            String rhsCSelo;
            rhsCSelo = that.getCSelo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cSelo", lhsCSelo), LocatorUtils.property(thatLocator, "cSelo", rhsCSelo), lhsCSelo, rhsCSelo)) {
                return false;
            }
        }
        {
            String lhsQSelo;
            lhsQSelo = this.getQSelo();
            String rhsQSelo;
            rhsQSelo = that.getQSelo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "qSelo", lhsQSelo), LocatorUtils.property(thatLocator, "qSelo", rhsQSelo), lhsQSelo, rhsQSelo)) {
                return false;
            }
        }
        {
            String lhsCEnq;
            lhsCEnq = this.getCEnq();
            String rhsCEnq;
            rhsCEnq = that.getCEnq();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cEnq", lhsCEnq), LocatorUtils.property(thatLocator, "cEnq", rhsCEnq), lhsCEnq, rhsCEnq)) {
                return false;
            }
        }
        {
            TIpi.IPITrib lhsIPITrib;
            lhsIPITrib = this.getIPITrib();
            TIpi.IPITrib rhsIPITrib;
            rhsIPITrib = that.getIPITrib();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ipiTrib", lhsIPITrib), LocatorUtils.property(thatLocator, "ipiTrib", rhsIPITrib), lhsIPITrib, rhsIPITrib)) {
                return false;
            }
        }
        {
            TIpi.IPINT lhsIPINT;
            lhsIPINT = this.getIPINT();
            TIpi.IPINT rhsIPINT;
            rhsIPINT = that.getIPINT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ipint", lhsIPINT), LocatorUtils.property(thatLocator, "ipint", rhsIPINT), lhsIPINT, rhsIPINT)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theClEnq;
            theClEnq = this.getClEnq();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clEnq", theClEnq), currentHashCode, theClEnq);
        }
        {
            String theCNPJProd;
            theCNPJProd = this.getCNPJProd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cnpjProd", theCNPJProd), currentHashCode, theCNPJProd);
        }
        {
            String theCSelo;
            theCSelo = this.getCSelo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cSelo", theCSelo), currentHashCode, theCSelo);
        }
        {
            String theQSelo;
            theQSelo = this.getQSelo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "qSelo", theQSelo), currentHashCode, theQSelo);
        }
        {
            String theCEnq;
            theCEnq = this.getCEnq();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cEnq", theCEnq), currentHashCode, theCEnq);
        }
        {
            TIpi.IPITrib theIPITrib;
            theIPITrib = this.getIPITrib();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ipiTrib", theIPITrib), currentHashCode, theIPITrib);
        }
        {
            TIpi.IPINT theIPINT;
            theIPINT = this.getIPINT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ipint", theIPINT), currentHashCode, theIPINT);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CST">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;whiteSpace value="preserve"/>
     *               &lt;enumeration value="01"/>
     *               &lt;enumeration value="02"/>
     *               &lt;enumeration value="03"/>
     *               &lt;enumeration value="04"/>
     *               &lt;enumeration value="05"/>
     *               &lt;enumeration value="51"/>
     *               &lt;enumeration value="52"/>
     *               &lt;enumeration value="53"/>
     *               &lt;enumeration value="54"/>
     *               &lt;enumeration value="55"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cst"
    })
    @Entity(name = "TIpi$IPINT")
    @Table(name = "IPINT")
    @Inheritance(strategy = InheritanceType.JOINED)
    public static class IPINT
        implements Equals, HashCode
    {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlAttribute(name = "Hjid")
        protected Long hjid;

        /**
         * Gets the value of the cst property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "CST")
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCST(String value) {
            this.cst = value;
        }

        /**
         * Gets the value of the hjid property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        @Id
        @Column(name = "HJID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getHjid() {
            return hjid;
        }

        /**
         * Sets the value of the hjid property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setHjid(Long value) {
            this.hjid = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof TIpi.IPINT)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final TIpi.IPINT that = ((TIpi.IPINT) object);
            {
                String lhsCST;
                lhsCST = this.getCST();
                String rhsCST;
                rhsCST = that.getCST();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "cst", lhsCST), LocatorUtils.property(thatLocator, "cst", rhsCST), lhsCST, rhsCST)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
            return equals(null, null, object, strategy);
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theCST;
                theCST = this.getCST();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cst", theCST), currentHashCode, theCST);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CST">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;whiteSpace value="preserve"/>
     *               &lt;enumeration value="00"/>
     *               &lt;enumeration value="49"/>
     *               &lt;enumeration value="50"/>
     *               &lt;enumeration value="99"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;choice>
     *           &lt;sequence>
     *             &lt;element name="vBC" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
     *             &lt;element name="pIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_0302a04"/>
     *           &lt;/sequence>
     *           &lt;sequence>
     *             &lt;element name="qUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1204v"/>
     *             &lt;element name="vUnid" type="{http://www.portalfiscal.inf.br/nfe}TDec_1104"/>
     *           &lt;/sequence>
     *         &lt;/choice>
     *         &lt;element name="vIPI" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cst",
        "vbc",
        "pipi",
        "qUnid",
        "vUnid",
        "vipi"
    })
    @Entity(name = "TIpi$IPITrib")
    @Table(name = "IPITRIB")
    @Inheritance(strategy = InheritanceType.JOINED)
    public static class IPITrib
        implements Equals, HashCode
    {

        @XmlElement(name = "CST", required = true)
        protected String cst;
        @XmlElement(name = "vBC")
        protected String vbc;
        @XmlElement(name = "pIPI")
        protected String pipi;
        protected String qUnid;
        protected String vUnid;
        @XmlElement(name = "vIPI", required = true)
        protected String vipi;
        @XmlAttribute(name = "Hjid")
        protected Long hjid;

        /**
         * Gets the value of the cst property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "CST")
        public String getCST() {
            return cst;
        }

        /**
         * Sets the value of the cst property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCST(String value) {
            this.cst = value;
        }

        /**
         * Gets the value of the vbc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "VBC", length = 255)
        public String getVBC() {
            return vbc;
        }

        /**
         * Sets the value of the vbc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVBC(String value) {
            this.vbc = value;
        }

        /**
         * Gets the value of the pipi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "PIPI", length = 255)
        public String getPIPI() {
            return pipi;
        }

        /**
         * Sets the value of the pipi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPIPI(String value) {
            this.pipi = value;
        }

        /**
         * Gets the value of the qUnid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "QUNID", length = 255)
        public String getQUnid() {
            return qUnid;
        }

        /**
         * Sets the value of the qUnid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQUnid(String value) {
            this.qUnid = value;
        }

        /**
         * Gets the value of the vUnid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "VUNID", length = 255)
        public String getVUnid() {
            return vUnid;
        }

        /**
         * Sets the value of the vUnid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVUnid(String value) {
            this.vUnid = value;
        }

        /**
         * Gets the value of the vipi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Basic
        @Column(name = "VIPI", length = 255)
        public String getVIPI() {
            return vipi;
        }

        /**
         * Sets the value of the vipi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVIPI(String value) {
            this.vipi = value;
        }

        /**
         * Gets the value of the hjid property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        @Id
        @Column(name = "HJID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getHjid() {
            return hjid;
        }

        /**
         * Sets the value of the hjid property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setHjid(Long value) {
            this.hjid = value;
        }

        public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
            if (!(object instanceof TIpi.IPITrib)) {
                return false;
            }
            if (this == object) {
                return true;
            }
            final TIpi.IPITrib that = ((TIpi.IPITrib) object);
            {
                String lhsCST;
                lhsCST = this.getCST();
                String rhsCST;
                rhsCST = that.getCST();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "cst", lhsCST), LocatorUtils.property(thatLocator, "cst", rhsCST), lhsCST, rhsCST)) {
                    return false;
                }
            }
            {
                String lhsVBC;
                lhsVBC = this.getVBC();
                String rhsVBC;
                rhsVBC = that.getVBC();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "vbc", lhsVBC), LocatorUtils.property(thatLocator, "vbc", rhsVBC), lhsVBC, rhsVBC)) {
                    return false;
                }
            }
            {
                String lhsPIPI;
                lhsPIPI = this.getPIPI();
                String rhsPIPI;
                rhsPIPI = that.getPIPI();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "pipi", lhsPIPI), LocatorUtils.property(thatLocator, "pipi", rhsPIPI), lhsPIPI, rhsPIPI)) {
                    return false;
                }
            }
            {
                String lhsQUnid;
                lhsQUnid = this.getQUnid();
                String rhsQUnid;
                rhsQUnid = that.getQUnid();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "qUnid", lhsQUnid), LocatorUtils.property(thatLocator, "qUnid", rhsQUnid), lhsQUnid, rhsQUnid)) {
                    return false;
                }
            }
            {
                String lhsVUnid;
                lhsVUnid = this.getVUnid();
                String rhsVUnid;
                rhsVUnid = that.getVUnid();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "vUnid", lhsVUnid), LocatorUtils.property(thatLocator, "vUnid", rhsVUnid), lhsVUnid, rhsVUnid)) {
                    return false;
                }
            }
            {
                String lhsVIPI;
                lhsVIPI = this.getVIPI();
                String rhsVIPI;
                rhsVIPI = that.getVIPI();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "vipi", lhsVIPI), LocatorUtils.property(thatLocator, "vipi", rhsVIPI), lhsVIPI, rhsVIPI)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
            return equals(null, null, object, strategy);
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
            int currentHashCode = 1;
            {
                String theCST;
                theCST = this.getCST();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cst", theCST), currentHashCode, theCST);
            }
            {
                String theVBC;
                theVBC = this.getVBC();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vbc", theVBC), currentHashCode, theVBC);
            }
            {
                String thePIPI;
                thePIPI = this.getPIPI();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pipi", thePIPI), currentHashCode, thePIPI);
            }
            {
                String theQUnid;
                theQUnid = this.getQUnid();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "qUnid", theQUnid), currentHashCode, theQUnid);
            }
            {
                String theVUnid;
                theVUnid = this.getVUnid();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vUnid", theVUnid), currentHashCode, theVUnid);
            }
            {
                String theVIPI;
                theVIPI = this.getVIPI();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vipi", theVIPI), currentHashCode, theVIPI);
            }
            return currentHashCode;
        }

        public int hashCode() {
            final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
            return this.hashCode(null, strategy);
        }

    }

}
