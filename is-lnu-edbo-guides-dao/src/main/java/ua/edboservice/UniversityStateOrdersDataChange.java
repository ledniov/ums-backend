
package ua.edboservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="SessionGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id_UniversityStateOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UniversityStateOrdersDatas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sessionGUID",
    "idUniversityStateOrder",
    "universityStateOrdersDatas"
})
@XmlRootElement(name = "UniversityStateOrdersDataChange")
public class UniversityStateOrdersDataChange {

    @XmlElement(name = "SessionGUID")
    protected String sessionGUID;
    @XmlElement(name = "Id_UniversityStateOrder")
    protected int idUniversityStateOrder;
    @XmlElement(name = "UniversityStateOrdersDatas")
    protected String universityStateOrdersDatas;

    /**
     * Gets the value of the sessionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionGUID() {
        return sessionGUID;
    }

    /**
     * Sets the value of the sessionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionGUID(String value) {
        this.sessionGUID = value;
    }

    /**
     * Gets the value of the idUniversityStateOrder property.
     * 
     */
    public int getIdUniversityStateOrder() {
        return idUniversityStateOrder;
    }

    /**
     * Sets the value of the idUniversityStateOrder property.
     * 
     */
    public void setIdUniversityStateOrder(int value) {
        this.idUniversityStateOrder = value;
    }

    /**
     * Gets the value of the universityStateOrdersDatas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniversityStateOrdersDatas() {
        return universityStateOrdersDatas;
    }

    /**
     * Sets the value of the universityStateOrdersDatas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniversityStateOrdersDatas(String value) {
        this.universityStateOrdersDatas = value;
    }

}
