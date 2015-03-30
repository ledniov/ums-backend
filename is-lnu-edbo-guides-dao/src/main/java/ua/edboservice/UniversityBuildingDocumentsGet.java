
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
 *         &lt;element name="Id_UniversityBuilding" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_UniversityBuildingDocumentsTypes" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "idUniversityBuilding",
    "idUniversityBuildingDocumentsTypes"
})
@XmlRootElement(name = "UniversityBuildingDocumentsGet")
public class UniversityBuildingDocumentsGet {

    @XmlElement(name = "SessionGUID")
    protected String sessionGUID;
    @XmlElement(name = "Id_UniversityBuilding")
    protected int idUniversityBuilding;
    @XmlElement(name = "Id_UniversityBuildingDocumentsTypes")
    protected int idUniversityBuildingDocumentsTypes;

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
     * Gets the value of the idUniversityBuilding property.
     * 
     */
    public int getIdUniversityBuilding() {
        return idUniversityBuilding;
    }

    /**
     * Sets the value of the idUniversityBuilding property.
     * 
     */
    public void setIdUniversityBuilding(int value) {
        this.idUniversityBuilding = value;
    }

    /**
     * Gets the value of the idUniversityBuildingDocumentsTypes property.
     * 
     */
    public int getIdUniversityBuildingDocumentsTypes() {
        return idUniversityBuildingDocumentsTypes;
    }

    /**
     * Sets the value of the idUniversityBuildingDocumentsTypes property.
     * 
     */
    public void setIdUniversityBuildingDocumentsTypes(int value) {
        this.idUniversityBuildingDocumentsTypes = value;
    }

}