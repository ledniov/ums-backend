
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
 *         &lt;element name="PersonEducationsStatusChangeAcademicLeaveContinueResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "personEducationsStatusChangeAcademicLeaveContinueResult"
})
@XmlRootElement(name = "PersonEducationsStatusChangeAcademicLeaveContinueResponse")
public class PersonEducationsStatusChangeAcademicLeaveContinueResponse {

    @XmlElement(name = "PersonEducationsStatusChangeAcademicLeaveContinueResult")
    protected String personEducationsStatusChangeAcademicLeaveContinueResult;

    /**
     * Gets the value of the personEducationsStatusChangeAcademicLeaveContinueResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonEducationsStatusChangeAcademicLeaveContinueResult() {
        return personEducationsStatusChangeAcademicLeaveContinueResult;
    }

    /**
     * Sets the value of the personEducationsStatusChangeAcademicLeaveContinueResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonEducationsStatusChangeAcademicLeaveContinueResult(String value) {
        this.personEducationsStatusChangeAcademicLeaveContinueResult = value;
    }

}
