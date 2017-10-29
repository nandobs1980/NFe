//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.24 at 04:53:17 PM BRST 
//


package br.inf.portalfiscal.nfe;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
 * Tipo Dados do Local de Retirada ou Entrega // 24/10/08 - tamanho mínimo // v2.0
 * 
 * <p>Java class for TLocal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TLocal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *         &lt;/choice>
 *         &lt;element name="xLgr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nro">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="xCpl" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="xBairro">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cMun" type="{http://www.portalfiscal.inf.br/nfe}TCodMunIBGE"/>
 *         &lt;element name="xMun">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;maxLength value="60"/>
 *               &lt;minLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUf"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLocal", propOrder = {
    "cnpj",
    "cpf",
    "xLgr",
    "nro",
    "xCpl",
    "xBairro",
    "cMun",
    "xMun",
    "uf"
})
@Entity(name = "TLocal")
@Table(name = "TLOCAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class TLocal
    implements Equals, HashCode
{

    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(required = true)
    protected String xLgr;
    @XmlElement(required = true)
    protected String nro;
    protected String xCpl;
    @XmlElement(required = true)
    protected String xBairro;
    @XmlElement(required = true)
    protected String cMun;
    @XmlElement(required = true)
    protected String xMun;
    @XmlElement(name = "UF", required = true)
    protected TUf uf;
    @XmlAttribute(name = "Hjid")
    protected Long hjid;

    /**
     * Gets the value of the cnpj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CNPJ", length = 14)
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Sets the value of the cnpj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Gets the value of the cpf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CPF", length = 11)
    public String getCPF() {
        return cpf;
    }

    /**
     * Sets the value of the cpf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

    /**
     * Gets the value of the xLgr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "XLGR", length = 60)
    public String getXLgr() {
        return xLgr;
    }

    /**
     * Sets the value of the xLgr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXLgr(String value) {
        this.xLgr = value;
    }

    /**
     * Gets the value of the nro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "NRO", length = 60)
    public String getNro() {
        return nro;
    }

    /**
     * Sets the value of the nro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNro(String value) {
        this.nro = value;
    }

    /**
     * Gets the value of the xCpl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "XCPL", length = 60)
    public String getXCpl() {
        return xCpl;
    }

    /**
     * Sets the value of the xCpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXCpl(String value) {
        this.xCpl = value;
    }

    /**
     * Gets the value of the xBairro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "XBAIRRO", length = 60)
    public String getXBairro() {
        return xBairro;
    }

    /**
     * Sets the value of the xBairro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXBairro(String value) {
        this.xBairro = value;
    }

    /**
     * Gets the value of the cMun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CMUN", length = 255)
    public String getCMun() {
        return cMun;
    }

    /**
     * Sets the value of the cMun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMun(String value) {
        this.cMun = value;
    }

    /**
     * Gets the value of the xMun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "XMUN", length = 60)
    public String getXMun() {
        return xMun;
    }

    /**
     * Sets the value of the xMun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMun(String value) {
        this.xMun = value;
    }

    /**
     * Gets the value of the uf property.
     * 
     * @return
     *     possible object is
     *     {@link TUf }
     *     
     */
    @Basic
    @Column(name = "UF", length = 255)
    @Enumerated(EnumType.STRING)
    public TUf getUF() {
        return uf;
    }

    /**
     * Sets the value of the uf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUf }
     *     
     */
    public void setUF(TUf value) {
        this.uf = value;
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
        if (!(object instanceof TLocal)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TLocal that = ((TLocal) object);
        {
            String lhsCNPJ;
            lhsCNPJ = this.getCNPJ();
            String rhsCNPJ;
            rhsCNPJ = that.getCNPJ();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cnpj", lhsCNPJ), LocatorUtils.property(thatLocator, "cnpj", rhsCNPJ), lhsCNPJ, rhsCNPJ)) {
                return false;
            }
        }
        {
            String lhsCPF;
            lhsCPF = this.getCPF();
            String rhsCPF;
            rhsCPF = that.getCPF();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cpf", lhsCPF), LocatorUtils.property(thatLocator, "cpf", rhsCPF), lhsCPF, rhsCPF)) {
                return false;
            }
        }
        {
            String lhsXLgr;
            lhsXLgr = this.getXLgr();
            String rhsXLgr;
            rhsXLgr = that.getXLgr();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "xLgr", lhsXLgr), LocatorUtils.property(thatLocator, "xLgr", rhsXLgr), lhsXLgr, rhsXLgr)) {
                return false;
            }
        }
        {
            String lhsNro;
            lhsNro = this.getNro();
            String rhsNro;
            rhsNro = that.getNro();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nro", lhsNro), LocatorUtils.property(thatLocator, "nro", rhsNro), lhsNro, rhsNro)) {
                return false;
            }
        }
        {
            String lhsXCpl;
            lhsXCpl = this.getXCpl();
            String rhsXCpl;
            rhsXCpl = that.getXCpl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "xCpl", lhsXCpl), LocatorUtils.property(thatLocator, "xCpl", rhsXCpl), lhsXCpl, rhsXCpl)) {
                return false;
            }
        }
        {
            String lhsXBairro;
            lhsXBairro = this.getXBairro();
            String rhsXBairro;
            rhsXBairro = that.getXBairro();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "xBairro", lhsXBairro), LocatorUtils.property(thatLocator, "xBairro", rhsXBairro), lhsXBairro, rhsXBairro)) {
                return false;
            }
        }
        {
            String lhsCMun;
            lhsCMun = this.getCMun();
            String rhsCMun;
            rhsCMun = that.getCMun();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cMun", lhsCMun), LocatorUtils.property(thatLocator, "cMun", rhsCMun), lhsCMun, rhsCMun)) {
                return false;
            }
        }
        {
            String lhsXMun;
            lhsXMun = this.getXMun();
            String rhsXMun;
            rhsXMun = that.getXMun();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "xMun", lhsXMun), LocatorUtils.property(thatLocator, "xMun", rhsXMun), lhsXMun, rhsXMun)) {
                return false;
            }
        }
        {
            TUf lhsUF;
            lhsUF = this.getUF();
            TUf rhsUF;
            rhsUF = that.getUF();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "uf", lhsUF), LocatorUtils.property(thatLocator, "uf", rhsUF), lhsUF, rhsUF)) {
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
            String theCNPJ;
            theCNPJ = this.getCNPJ();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cnpj", theCNPJ), currentHashCode, theCNPJ);
        }
        {
            String theCPF;
            theCPF = this.getCPF();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cpf", theCPF), currentHashCode, theCPF);
        }
        {
            String theXLgr;
            theXLgr = this.getXLgr();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "xLgr", theXLgr), currentHashCode, theXLgr);
        }
        {
            String theNro;
            theNro = this.getNro();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nro", theNro), currentHashCode, theNro);
        }
        {
            String theXCpl;
            theXCpl = this.getXCpl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "xCpl", theXCpl), currentHashCode, theXCpl);
        }
        {
            String theXBairro;
            theXBairro = this.getXBairro();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "xBairro", theXBairro), currentHashCode, theXBairro);
        }
        {
            String theCMun;
            theCMun = this.getCMun();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cMun", theCMun), currentHashCode, theCMun);
        }
        {
            String theXMun;
            theXMun = this.getXMun();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "xMun", theXMun), currentHashCode, theXMun);
        }
        {
            TUf theUF;
            theUF = this.getUF();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "uf", theUF), currentHashCode, theUF);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}