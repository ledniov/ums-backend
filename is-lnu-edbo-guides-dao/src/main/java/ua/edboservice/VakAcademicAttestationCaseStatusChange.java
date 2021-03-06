
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
 *         &lt;element name="Id_AcademicAttestationCase" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_AcademicAttestationCaseSatusHistoryType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "idAcademicAttestationCase",
    "idAcademicAttestationCaseSatusHistoryType"
})
@XmlRootElement(name = "VakAcademicAttestationCaseStatusChange")
public class VakAcademicAttestationCaseStatusChange {

    @XmlElement(name = "SessionGUID")
    protected String sessionGUID;
    @XmlElement(name = "Id_AcademicAttestationCase")
    protected int idAcademicAttestationCase;
    @XmlElement(name = "Id_AcademicAttestationCaseSatusHistoryType")
    protected int idAcademicAttestationCaseSatusHistoryType;

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
     * Gets the value of the idAcademicAttestationCase property.
     * 
     */
    public int getIdAcademicAttestationCase() {
        return idAcademicAttestationCase;
    }

    /**
     * Sets the value of the idAcademicAttestationCase property.
     * 
     */
    public void setIdAcademicAttestationCase(int value) {
        this.idAcademicAttestationCase = value;
    }

    /**
     * Gets the value of the idAcademicAttestationCaseSatusHistoryType property.
     * 
     */
    public int getIdAcademicAttestationCaseSatusHistoryType() {
        return idAcademicAttestationCaseSatusHistoryType;
    }

    /**
     * Sets the value of the idAcademicAttestationCaseSatusHistoryType property.
     * 
     */
    public void setIdAcademicAttestationCaseSatusHistoryType(int value) {
        this.idAcademicAttestationCaseSatusHistoryType = value;
    }

}
