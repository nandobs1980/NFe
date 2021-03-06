//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.24 at 04:53:17 PM BRST 
//


package org.w3._2000._09.xmldsig_;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
 * <p>Java class for TransformsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransformsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Transform" type="{http://www.w3.org/2000/09/xmldsig#}TransformType" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformsType", propOrder = {
    "transform"
})
@Entity(name = "TransformsType")
@Table(name = "TRANSFORMSTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class TransformsType
    implements Equals, HashCode
{

    @XmlElement(name = "Transform", required = true)
    protected List<TransformType> transform;
    @XmlAttribute(name = "Hjid")
    protected Long hjid;

    /**
     * Gets the value of the transform property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transform property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransform().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransformType }
     * 
     * 
     */
    @OneToMany(targetEntity = TransformType.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "TRANSFORM__TRANSFORMSTYPE_HJ_0")
    public List<TransformType> getTransform() {
        if (transform == null) {
            transform = new ArrayList<TransformType>();
        }
        return this.transform;
    }

    /**
     * 
     * 
     */
    public void setTransform(List<TransformType> transform) {
        this.transform = transform;
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
        if (!(object instanceof TransformsType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TransformsType that = ((TransformsType) object);
        {
            List<TransformType> lhsTransform;
            lhsTransform = (((this.transform!= null)&&(!this.transform.isEmpty()))?this.getTransform():null);
            List<TransformType> rhsTransform;
            rhsTransform = (((that.transform!= null)&&(!that.transform.isEmpty()))?that.getTransform():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transform", lhsTransform), LocatorUtils.property(thatLocator, "transform", rhsTransform), lhsTransform, rhsTransform)) {
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
            List<TransformType> theTransform;
            theTransform = (((this.transform!= null)&&(!this.transform.isEmpty()))?this.getTransform():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transform", theTransform), currentHashCode, theTransform);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
