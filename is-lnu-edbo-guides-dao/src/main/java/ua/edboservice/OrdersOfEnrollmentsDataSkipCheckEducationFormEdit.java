
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
 *         &lt;element name="Id_OrderOfEnrollment" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SkipCheckEducationForm" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_OrderOfEnrollmentDatas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "idOrderOfEnrollment",
    "skipCheckEducationForm",
    "idOrderOfEnrollmentDatas"
})
@XmlRootElement(name = "OrdersOfEnrollmentsDataSkipCheckEducationFormEdit")
public class OrdersOfEnrollmentsDataSkipCheckEducationFormEdit {

    @XmlElement(name = "SessionGUID")
    protected String sessionGUID;
    @XmlElement(name = "Id_OrderOfEnrollment")
    protected int idOrderOfEnrollment;
    @XmlElement(name = "SkipCheckEducationForm")
    protected int skipCheckEducationForm;
    @XmlElement(name = "Id_OrderOfEnrollmentDatas")
    protected String idOrderOfEnrollmentDatas;

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
     * Gets the value of the idOrderOfEnrollment property.
     * 
     */
    public int getIdOrderOfEnrollment() {
        return idOrderOfEnrollment;
    }

    /**
     * Sets the value of the idOrderOfEnrollment property.
     * 
     */
    public void setIdOrderOfEnrollment(int value) {
        this.idOrderOfEnrollment = value;
    }

    /**
     * Gets the value of the skipCheckEducationForm property.
     * 
     */
    public int getSkipCheckEducationForm() {
        return skipCheckEducationForm;
    }

    /**
     * Sets the value of the skipCheckEducationForm property.
     * 
     */
    public void setSkipCheckEducationForm(int value) {
        this.skipCheckEducationForm = value;
    }

    /**
     * Gets the value of the idOrderOfEnrollmentDatas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOrderOfEnrollmentDatas() {
        return idOrderOfEnrollmentDatas;
    }

    /**
     * Sets the value of the idOrderOfEnrollmentDatas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOrderOfEnrollmentDatas(String value) {
        this.idOrderOfEnrollmentDatas = value;
    }

}
