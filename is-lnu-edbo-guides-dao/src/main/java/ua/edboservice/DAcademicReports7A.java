
package ua.edboservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dAcademicReports7A complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dAcademicReports7A">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_AcademicReports7A" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateCreate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Id_UserAdd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateLastChange" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Id_UserEdit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UniversityKode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id_University" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UniversityFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vart_Zvit_PrevYearDenna" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Vart_Zvit_PrevYearZaoch" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Vart_Plan_CurYearDenna" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Vart_Plan_CurYearZaoch" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Vart_Prognoz_NextYearDenna" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Vart_Prognoz_NextYearZaoch" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Id_RegulationDocument" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsVerified" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_RegulationDocumentVerificationHistoryType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RegulationDocumentVerificationHistoryTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsExistFile" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dAcademicReports7A", propOrder = {
    "idAcademicReports7A",
    "year",
    "dateCreate",
    "idUserAdd",
    "dateLastChange",
    "idUserEdit",
    "universityKode",
    "idUniversity",
    "universityFullName",
    "vartZvitPrevYearDenna",
    "vartZvitPrevYearZaoch",
    "vartPlanCurYearDenna",
    "vartPlanCurYearZaoch",
    "vartPrognozNextYearDenna",
    "vartPrognozNextYearZaoch",
    "idRegulationDocument",
    "isVerified",
    "idRegulationDocumentVerificationHistoryType",
    "regulationDocumentVerificationHistoryTypeName",
    "isExistFile",
    "region"
})
public class DAcademicReports7A {

    @XmlElement(name = "Id_AcademicReports7A")
    protected int idAcademicReports7A;
    @XmlElement(name = "Year")
    protected int year;
    @XmlElement(name = "DateCreate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreate;
    @XmlElement(name = "Id_UserAdd")
    protected int idUserAdd;
    @XmlElement(name = "DateLastChange", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateLastChange;
    @XmlElement(name = "Id_UserEdit")
    protected int idUserEdit;
    @XmlElement(name = "UniversityKode")
    protected String universityKode;
    @XmlElement(name = "Id_University")
    protected int idUniversity;
    @XmlElement(name = "UniversityFullName")
    protected String universityFullName;
    @XmlElement(name = "Vart_Zvit_PrevYearDenna", required = true)
    protected BigDecimal vartZvitPrevYearDenna;
    @XmlElement(name = "Vart_Zvit_PrevYearZaoch", required = true)
    protected BigDecimal vartZvitPrevYearZaoch;
    @XmlElement(name = "Vart_Plan_CurYearDenna", required = true)
    protected BigDecimal vartPlanCurYearDenna;
    @XmlElement(name = "Vart_Plan_CurYearZaoch", required = true)
    protected BigDecimal vartPlanCurYearZaoch;
    @XmlElement(name = "Vart_Prognoz_NextYearDenna", required = true)
    protected BigDecimal vartPrognozNextYearDenna;
    @XmlElement(name = "Vart_Prognoz_NextYearZaoch", required = true)
    protected BigDecimal vartPrognozNextYearZaoch;
    @XmlElement(name = "Id_RegulationDocument")
    protected int idRegulationDocument;
    @XmlElement(name = "IsVerified")
    protected int isVerified;
    @XmlElement(name = "Id_RegulationDocumentVerificationHistoryType")
    protected int idRegulationDocumentVerificationHistoryType;
    @XmlElement(name = "RegulationDocumentVerificationHistoryTypeName")
    protected String regulationDocumentVerificationHistoryTypeName;
    @XmlElement(name = "IsExistFile")
    protected int isExistFile;
    @XmlElement(name = "Region")
    protected String region;

    /**
     * Gets the value of the idAcademicReports7A property.
     * 
     */
    public int getIdAcademicReports7A() {
        return idAcademicReports7A;
    }

    /**
     * Sets the value of the idAcademicReports7A property.
     * 
     */
    public void setIdAcademicReports7A(int value) {
        this.idAcademicReports7A = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * Gets the value of the dateCreate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreate() {
        return dateCreate;
    }

    /**
     * Sets the value of the dateCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreate(XMLGregorianCalendar value) {
        this.dateCreate = value;
    }

    /**
     * Gets the value of the idUserAdd property.
     * 
     */
    public int getIdUserAdd() {
        return idUserAdd;
    }

    /**
     * Sets the value of the idUserAdd property.
     * 
     */
    public void setIdUserAdd(int value) {
        this.idUserAdd = value;
    }

    /**
     * Gets the value of the dateLastChange property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastChange() {
        return dateLastChange;
    }

    /**
     * Sets the value of the dateLastChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastChange(XMLGregorianCalendar value) {
        this.dateLastChange = value;
    }

    /**
     * Gets the value of the idUserEdit property.
     * 
     */
    public int getIdUserEdit() {
        return idUserEdit;
    }

    /**
     * Sets the value of the idUserEdit property.
     * 
     */
    public void setIdUserEdit(int value) {
        this.idUserEdit = value;
    }

    /**
     * Gets the value of the universityKode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniversityKode() {
        return universityKode;
    }

    /**
     * Sets the value of the universityKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniversityKode(String value) {
        this.universityKode = value;
    }

    /**
     * Gets the value of the idUniversity property.
     * 
     */
    public int getIdUniversity() {
        return idUniversity;
    }

    /**
     * Sets the value of the idUniversity property.
     * 
     */
    public void setIdUniversity(int value) {
        this.idUniversity = value;
    }

    /**
     * Gets the value of the universityFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniversityFullName() {
        return universityFullName;
    }

    /**
     * Sets the value of the universityFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniversityFullName(String value) {
        this.universityFullName = value;
    }

    /**
     * Gets the value of the vartZvitPrevYearDenna property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVartZvitPrevYearDenna() {
        return vartZvitPrevYearDenna;
    }

    /**
     * Sets the value of the vartZvitPrevYearDenna property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVartZvitPrevYearDenna(BigDecimal value) {
        this.vartZvitPrevYearDenna = value;
    }

    /**
     * Gets the value of the vartZvitPrevYearZaoch property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVartZvitPrevYearZaoch() {
        return vartZvitPrevYearZaoch;
    }

    /**
     * Sets the value of the vartZvitPrevYearZaoch property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVartZvitPrevYearZaoch(BigDecimal value) {
        this.vartZvitPrevYearZaoch = value;
    }

    /**
     * Gets the value of the vartPlanCurYearDenna property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVartPlanCurYearDenna() {
        return vartPlanCurYearDenna;
    }

    /**
     * Sets the value of the vartPlanCurYearDenna property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVartPlanCurYearDenna(BigDecimal value) {
        this.vartPlanCurYearDenna = value;
    }

    /**
     * Gets the value of the vartPlanCurYearZaoch property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVartPlanCurYearZaoch() {
        return vartPlanCurYearZaoch;
    }

    /**
     * Sets the value of the vartPlanCurYearZaoch property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVartPlanCurYearZaoch(BigDecimal value) {
        this.vartPlanCurYearZaoch = value;
    }

    /**
     * Gets the value of the vartPrognozNextYearDenna property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVartPrognozNextYearDenna() {
        return vartPrognozNextYearDenna;
    }

    /**
     * Sets the value of the vartPrognozNextYearDenna property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVartPrognozNextYearDenna(BigDecimal value) {
        this.vartPrognozNextYearDenna = value;
    }

    /**
     * Gets the value of the vartPrognozNextYearZaoch property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVartPrognozNextYearZaoch() {
        return vartPrognozNextYearZaoch;
    }

    /**
     * Sets the value of the vartPrognozNextYearZaoch property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVartPrognozNextYearZaoch(BigDecimal value) {
        this.vartPrognozNextYearZaoch = value;
    }

    /**
     * Gets the value of the idRegulationDocument property.
     * 
     */
    public int getIdRegulationDocument() {
        return idRegulationDocument;
    }

    /**
     * Sets the value of the idRegulationDocument property.
     * 
     */
    public void setIdRegulationDocument(int value) {
        this.idRegulationDocument = value;
    }

    /**
     * Gets the value of the isVerified property.
     * 
     */
    public int getIsVerified() {
        return isVerified;
    }

    /**
     * Sets the value of the isVerified property.
     * 
     */
    public void setIsVerified(int value) {
        this.isVerified = value;
    }

    /**
     * Gets the value of the idRegulationDocumentVerificationHistoryType property.
     * 
     */
    public int getIdRegulationDocumentVerificationHistoryType() {
        return idRegulationDocumentVerificationHistoryType;
    }

    /**
     * Sets the value of the idRegulationDocumentVerificationHistoryType property.
     * 
     */
    public void setIdRegulationDocumentVerificationHistoryType(int value) {
        this.idRegulationDocumentVerificationHistoryType = value;
    }

    /**
     * Gets the value of the regulationDocumentVerificationHistoryTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegulationDocumentVerificationHistoryTypeName() {
        return regulationDocumentVerificationHistoryTypeName;
    }

    /**
     * Sets the value of the regulationDocumentVerificationHistoryTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegulationDocumentVerificationHistoryTypeName(String value) {
        this.regulationDocumentVerificationHistoryTypeName = value;
    }

    /**
     * Gets the value of the isExistFile property.
     * 
     */
    public int getIsExistFile() {
        return isExistFile;
    }

    /**
     * Sets the value of the isExistFile property.
     * 
     */
    public void setIsExistFile(int value) {
        this.isExistFile = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

}
