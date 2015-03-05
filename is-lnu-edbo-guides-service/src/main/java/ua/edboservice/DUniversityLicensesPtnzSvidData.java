
package ua.edboservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dUniversityLicensesPtnzSvidData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dUniversityLicensesPtnzSvidData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_UniversityLicensePtnzSvidData" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_UniversityLicensePtnzSvid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UniversityLicensePtnzSvidDataDateLastChange" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SpecProfessionCode1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionCode2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionCode3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionCode4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionCode5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UniversityLicensesSubTypesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ptnz_sId_UniversityLicensesSubTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionClassifierCode1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionClassifierCode2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionClassifierCode3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionClassifierCode4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionClassifierCode5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionName1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionName2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionName3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionName4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionName5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecProfessionComplexNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dUniversityLicensesPtnzSvidData", propOrder = {
    "idUniversityLicensePtnzSvidData",
    "idUniversityLicensePtnzSvid",
    "universityLicensePtnzSvidDataDateLastChange",
    "specProfessionCode1",
    "specProfessionCode2",
    "specProfessionCode3",
    "specProfessionCode4",
    "specProfessionCode5",
    "universityLicensesSubTypesName",
    "ptnzSIdUniversityLicensesSubTypes",
    "specProfessionClassifierCode1",
    "specProfessionClassifierCode2",
    "specProfessionClassifierCode3",
    "specProfessionClassifierCode4",
    "specProfessionClassifierCode5",
    "specProfessionName1",
    "specProfessionName2",
    "specProfessionName3",
    "specProfessionName4",
    "specProfessionName5",
    "specProfessionComplexNames"
})
public class DUniversityLicensesPtnzSvidData {

    @XmlElement(name = "Id_UniversityLicensePtnzSvidData")
    protected int idUniversityLicensePtnzSvidData;
    @XmlElement(name = "Id_UniversityLicensePtnzSvid")
    protected int idUniversityLicensePtnzSvid;
    @XmlElement(name = "UniversityLicensePtnzSvidDataDateLastChange", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar universityLicensePtnzSvidDataDateLastChange;
    @XmlElement(name = "SpecProfessionCode1")
    protected String specProfessionCode1;
    @XmlElement(name = "SpecProfessionCode2")
    protected String specProfessionCode2;
    @XmlElement(name = "SpecProfessionCode3")
    protected String specProfessionCode3;
    @XmlElement(name = "SpecProfessionCode4")
    protected String specProfessionCode4;
    @XmlElement(name = "SpecProfessionCode5")
    protected String specProfessionCode5;
    @XmlElement(name = "UniversityLicensesSubTypesName")
    protected String universityLicensesSubTypesName;
    @XmlElement(name = "Ptnz_sId_UniversityLicensesSubTypes")
    protected String ptnzSIdUniversityLicensesSubTypes;
    @XmlElement(name = "SpecProfessionClassifierCode1")
    protected String specProfessionClassifierCode1;
    @XmlElement(name = "SpecProfessionClassifierCode2")
    protected String specProfessionClassifierCode2;
    @XmlElement(name = "SpecProfessionClassifierCode3")
    protected String specProfessionClassifierCode3;
    @XmlElement(name = "SpecProfessionClassifierCode4")
    protected String specProfessionClassifierCode4;
    @XmlElement(name = "SpecProfessionClassifierCode5")
    protected String specProfessionClassifierCode5;
    @XmlElement(name = "SpecProfessionName1")
    protected String specProfessionName1;
    @XmlElement(name = "SpecProfessionName2")
    protected String specProfessionName2;
    @XmlElement(name = "SpecProfessionName3")
    protected String specProfessionName3;
    @XmlElement(name = "SpecProfessionName4")
    protected String specProfessionName4;
    @XmlElement(name = "SpecProfessionName5")
    protected String specProfessionName5;
    @XmlElement(name = "SpecProfessionComplexNames")
    protected String specProfessionComplexNames;

    /**
     * Gets the value of the idUniversityLicensePtnzSvidData property.
     * 
     */
    public int getIdUniversityLicensePtnzSvidData() {
        return idUniversityLicensePtnzSvidData;
    }

    /**
     * Sets the value of the idUniversityLicensePtnzSvidData property.
     * 
     */
    public void setIdUniversityLicensePtnzSvidData(int value) {
        this.idUniversityLicensePtnzSvidData = value;
    }

    /**
     * Gets the value of the idUniversityLicensePtnzSvid property.
     * 
     */
    public int getIdUniversityLicensePtnzSvid() {
        return idUniversityLicensePtnzSvid;
    }

    /**
     * Sets the value of the idUniversityLicensePtnzSvid property.
     * 
     */
    public void setIdUniversityLicensePtnzSvid(int value) {
        this.idUniversityLicensePtnzSvid = value;
    }

    /**
     * Gets the value of the universityLicensePtnzSvidDataDateLastChange property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUniversityLicensePtnzSvidDataDateLastChange() {
        return universityLicensePtnzSvidDataDateLastChange;
    }

    /**
     * Sets the value of the universityLicensePtnzSvidDataDateLastChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUniversityLicensePtnzSvidDataDateLastChange(XMLGregorianCalendar value) {
        this.universityLicensePtnzSvidDataDateLastChange = value;
    }

    /**
     * Gets the value of the specProfessionCode1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionCode1() {
        return specProfessionCode1;
    }

    /**
     * Sets the value of the specProfessionCode1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionCode1(String value) {
        this.specProfessionCode1 = value;
    }

    /**
     * Gets the value of the specProfessionCode2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionCode2() {
        return specProfessionCode2;
    }

    /**
     * Sets the value of the specProfessionCode2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionCode2(String value) {
        this.specProfessionCode2 = value;
    }

    /**
     * Gets the value of the specProfessionCode3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionCode3() {
        return specProfessionCode3;
    }

    /**
     * Sets the value of the specProfessionCode3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionCode3(String value) {
        this.specProfessionCode3 = value;
    }

    /**
     * Gets the value of the specProfessionCode4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionCode4() {
        return specProfessionCode4;
    }

    /**
     * Sets the value of the specProfessionCode4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionCode4(String value) {
        this.specProfessionCode4 = value;
    }

    /**
     * Gets the value of the specProfessionCode5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionCode5() {
        return specProfessionCode5;
    }

    /**
     * Sets the value of the specProfessionCode5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionCode5(String value) {
        this.specProfessionCode5 = value;
    }

    /**
     * Gets the value of the universityLicensesSubTypesName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniversityLicensesSubTypesName() {
        return universityLicensesSubTypesName;
    }

    /**
     * Sets the value of the universityLicensesSubTypesName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniversityLicensesSubTypesName(String value) {
        this.universityLicensesSubTypesName = value;
    }

    /**
     * Gets the value of the ptnzSIdUniversityLicensesSubTypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtnzSIdUniversityLicensesSubTypes() {
        return ptnzSIdUniversityLicensesSubTypes;
    }

    /**
     * Sets the value of the ptnzSIdUniversityLicensesSubTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtnzSIdUniversityLicensesSubTypes(String value) {
        this.ptnzSIdUniversityLicensesSubTypes = value;
    }

    /**
     * Gets the value of the specProfessionClassifierCode1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionClassifierCode1() {
        return specProfessionClassifierCode1;
    }

    /**
     * Sets the value of the specProfessionClassifierCode1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionClassifierCode1(String value) {
        this.specProfessionClassifierCode1 = value;
    }

    /**
     * Gets the value of the specProfessionClassifierCode2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionClassifierCode2() {
        return specProfessionClassifierCode2;
    }

    /**
     * Sets the value of the specProfessionClassifierCode2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionClassifierCode2(String value) {
        this.specProfessionClassifierCode2 = value;
    }

    /**
     * Gets the value of the specProfessionClassifierCode3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionClassifierCode3() {
        return specProfessionClassifierCode3;
    }

    /**
     * Sets the value of the specProfessionClassifierCode3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionClassifierCode3(String value) {
        this.specProfessionClassifierCode3 = value;
    }

    /**
     * Gets the value of the specProfessionClassifierCode4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionClassifierCode4() {
        return specProfessionClassifierCode4;
    }

    /**
     * Sets the value of the specProfessionClassifierCode4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionClassifierCode4(String value) {
        this.specProfessionClassifierCode4 = value;
    }

    /**
     * Gets the value of the specProfessionClassifierCode5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionClassifierCode5() {
        return specProfessionClassifierCode5;
    }

    /**
     * Sets the value of the specProfessionClassifierCode5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionClassifierCode5(String value) {
        this.specProfessionClassifierCode5 = value;
    }

    /**
     * Gets the value of the specProfessionName1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionName1() {
        return specProfessionName1;
    }

    /**
     * Sets the value of the specProfessionName1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionName1(String value) {
        this.specProfessionName1 = value;
    }

    /**
     * Gets the value of the specProfessionName2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionName2() {
        return specProfessionName2;
    }

    /**
     * Sets the value of the specProfessionName2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionName2(String value) {
        this.specProfessionName2 = value;
    }

    /**
     * Gets the value of the specProfessionName3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionName3() {
        return specProfessionName3;
    }

    /**
     * Sets the value of the specProfessionName3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionName3(String value) {
        this.specProfessionName3 = value;
    }

    /**
     * Gets the value of the specProfessionName4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionName4() {
        return specProfessionName4;
    }

    /**
     * Sets the value of the specProfessionName4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionName4(String value) {
        this.specProfessionName4 = value;
    }

    /**
     * Gets the value of the specProfessionName5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionName5() {
        return specProfessionName5;
    }

    /**
     * Sets the value of the specProfessionName5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionName5(String value) {
        this.specProfessionName5 = value;
    }

    /**
     * Gets the value of the specProfessionComplexNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecProfessionComplexNames() {
        return specProfessionComplexNames;
    }

    /**
     * Sets the value of the specProfessionComplexNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecProfessionComplexNames(String value) {
        this.specProfessionComplexNames = value;
    }

}
