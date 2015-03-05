
package ua.edboservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dEDBOISUOreport_rvk83 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dEDBOISUOreport_rvk83">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_EDBO_report_rvk83" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_ISUO_report_rvk83" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UniversityKode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="report_year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="section_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="row_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C4" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C5" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C6" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C7" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C8" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C9" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C10" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C11" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C12" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C13" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C14" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C15" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C16" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C17" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C18" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C19" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C20" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C21" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="C22" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="S1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authority_tree_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_ISUO_ZNZ" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dEDBOISUOreport_rvk83", propOrder = {
    "idEDBOReportRvk83",
    "idISUOReportRvk83",
    "universityKode",
    "reportYear",
    "sectionId",
    "rowId",
    "c1",
    "c2",
    "c3",
    "c4",
    "c5",
    "c6",
    "c7",
    "c8",
    "c9",
    "c10",
    "c11",
    "c12",
    "c13",
    "c14",
    "c15",
    "c16",
    "c17",
    "c18",
    "c19",
    "c20",
    "c21",
    "c22",
    "s1",
    "authorityTreeId",
    "idISUOZNZ"
})
public class DEDBOISUOreportRvk83 {

    @XmlElement(name = "id_EDBO_report_rvk83")
    protected int idEDBOReportRvk83;
    @XmlElement(name = "id_ISUO_report_rvk83")
    protected int idISUOReportRvk83;
    @XmlElement(name = "UniversityKode")
    protected String universityKode;
    @XmlElement(name = "report_year")
    protected int reportYear;
    @XmlElement(name = "section_id")
    protected int sectionId;
    @XmlElement(name = "row_id")
    protected int rowId;
    @XmlElement(name = "C1")
    protected int c1;
    @XmlElement(name = "C2")
    protected int c2;
    @XmlElement(name = "C3")
    protected int c3;
    @XmlElement(name = "C4")
    protected int c4;
    @XmlElement(name = "C5")
    protected int c5;
    @XmlElement(name = "C6")
    protected int c6;
    @XmlElement(name = "C7")
    protected int c7;
    @XmlElement(name = "C8")
    protected int c8;
    @XmlElement(name = "C9")
    protected int c9;
    @XmlElement(name = "C10")
    protected int c10;
    @XmlElement(name = "C11")
    protected int c11;
    @XmlElement(name = "C12")
    protected int c12;
    @XmlElement(name = "C13")
    protected int c13;
    @XmlElement(name = "C14")
    protected int c14;
    @XmlElement(name = "C15")
    protected int c15;
    @XmlElement(name = "C16")
    protected int c16;
    @XmlElement(name = "C17")
    protected int c17;
    @XmlElement(name = "C18")
    protected int c18;
    @XmlElement(name = "C19")
    protected int c19;
    @XmlElement(name = "C20")
    protected int c20;
    @XmlElement(name = "C21")
    protected int c21;
    @XmlElement(name = "C22")
    protected int c22;
    @XmlElement(name = "S1")
    protected String s1;
    @XmlElement(name = "authority_tree_id")
    protected int authorityTreeId;
    @XmlElement(name = "Id_ISUO_ZNZ")
    protected int idISUOZNZ;

    /**
     * Gets the value of the idEDBOReportRvk83 property.
     * 
     */
    public int getIdEDBOReportRvk83() {
        return idEDBOReportRvk83;
    }

    /**
     * Sets the value of the idEDBOReportRvk83 property.
     * 
     */
    public void setIdEDBOReportRvk83(int value) {
        this.idEDBOReportRvk83 = value;
    }

    /**
     * Gets the value of the idISUOReportRvk83 property.
     * 
     */
    public int getIdISUOReportRvk83() {
        return idISUOReportRvk83;
    }

    /**
     * Sets the value of the idISUOReportRvk83 property.
     * 
     */
    public void setIdISUOReportRvk83(int value) {
        this.idISUOReportRvk83 = value;
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
     * Gets the value of the reportYear property.
     * 
     */
    public int getReportYear() {
        return reportYear;
    }

    /**
     * Sets the value of the reportYear property.
     * 
     */
    public void setReportYear(int value) {
        this.reportYear = value;
    }

    /**
     * Gets the value of the sectionId property.
     * 
     */
    public int getSectionId() {
        return sectionId;
    }

    /**
     * Sets the value of the sectionId property.
     * 
     */
    public void setSectionId(int value) {
        this.sectionId = value;
    }

    /**
     * Gets the value of the rowId property.
     * 
     */
    public int getRowId() {
        return rowId;
    }

    /**
     * Sets the value of the rowId property.
     * 
     */
    public void setRowId(int value) {
        this.rowId = value;
    }

    /**
     * Gets the value of the c1 property.
     * 
     */
    public int getC1() {
        return c1;
    }

    /**
     * Sets the value of the c1 property.
     * 
     */
    public void setC1(int value) {
        this.c1 = value;
    }

    /**
     * Gets the value of the c2 property.
     * 
     */
    public int getC2() {
        return c2;
    }

    /**
     * Sets the value of the c2 property.
     * 
     */
    public void setC2(int value) {
        this.c2 = value;
    }

    /**
     * Gets the value of the c3 property.
     * 
     */
    public int getC3() {
        return c3;
    }

    /**
     * Sets the value of the c3 property.
     * 
     */
    public void setC3(int value) {
        this.c3 = value;
    }

    /**
     * Gets the value of the c4 property.
     * 
     */
    public int getC4() {
        return c4;
    }

    /**
     * Sets the value of the c4 property.
     * 
     */
    public void setC4(int value) {
        this.c4 = value;
    }

    /**
     * Gets the value of the c5 property.
     * 
     */
    public int getC5() {
        return c5;
    }

    /**
     * Sets the value of the c5 property.
     * 
     */
    public void setC5(int value) {
        this.c5 = value;
    }

    /**
     * Gets the value of the c6 property.
     * 
     */
    public int getC6() {
        return c6;
    }

    /**
     * Sets the value of the c6 property.
     * 
     */
    public void setC6(int value) {
        this.c6 = value;
    }

    /**
     * Gets the value of the c7 property.
     * 
     */
    public int getC7() {
        return c7;
    }

    /**
     * Sets the value of the c7 property.
     * 
     */
    public void setC7(int value) {
        this.c7 = value;
    }

    /**
     * Gets the value of the c8 property.
     * 
     */
    public int getC8() {
        return c8;
    }

    /**
     * Sets the value of the c8 property.
     * 
     */
    public void setC8(int value) {
        this.c8 = value;
    }

    /**
     * Gets the value of the c9 property.
     * 
     */
    public int getC9() {
        return c9;
    }

    /**
     * Sets the value of the c9 property.
     * 
     */
    public void setC9(int value) {
        this.c9 = value;
    }

    /**
     * Gets the value of the c10 property.
     * 
     */
    public int getC10() {
        return c10;
    }

    /**
     * Sets the value of the c10 property.
     * 
     */
    public void setC10(int value) {
        this.c10 = value;
    }

    /**
     * Gets the value of the c11 property.
     * 
     */
    public int getC11() {
        return c11;
    }

    /**
     * Sets the value of the c11 property.
     * 
     */
    public void setC11(int value) {
        this.c11 = value;
    }

    /**
     * Gets the value of the c12 property.
     * 
     */
    public int getC12() {
        return c12;
    }

    /**
     * Sets the value of the c12 property.
     * 
     */
    public void setC12(int value) {
        this.c12 = value;
    }

    /**
     * Gets the value of the c13 property.
     * 
     */
    public int getC13() {
        return c13;
    }

    /**
     * Sets the value of the c13 property.
     * 
     */
    public void setC13(int value) {
        this.c13 = value;
    }

    /**
     * Gets the value of the c14 property.
     * 
     */
    public int getC14() {
        return c14;
    }

    /**
     * Sets the value of the c14 property.
     * 
     */
    public void setC14(int value) {
        this.c14 = value;
    }

    /**
     * Gets the value of the c15 property.
     * 
     */
    public int getC15() {
        return c15;
    }

    /**
     * Sets the value of the c15 property.
     * 
     */
    public void setC15(int value) {
        this.c15 = value;
    }

    /**
     * Gets the value of the c16 property.
     * 
     */
    public int getC16() {
        return c16;
    }

    /**
     * Sets the value of the c16 property.
     * 
     */
    public void setC16(int value) {
        this.c16 = value;
    }

    /**
     * Gets the value of the c17 property.
     * 
     */
    public int getC17() {
        return c17;
    }

    /**
     * Sets the value of the c17 property.
     * 
     */
    public void setC17(int value) {
        this.c17 = value;
    }

    /**
     * Gets the value of the c18 property.
     * 
     */
    public int getC18() {
        return c18;
    }

    /**
     * Sets the value of the c18 property.
     * 
     */
    public void setC18(int value) {
        this.c18 = value;
    }

    /**
     * Gets the value of the c19 property.
     * 
     */
    public int getC19() {
        return c19;
    }

    /**
     * Sets the value of the c19 property.
     * 
     */
    public void setC19(int value) {
        this.c19 = value;
    }

    /**
     * Gets the value of the c20 property.
     * 
     */
    public int getC20() {
        return c20;
    }

    /**
     * Sets the value of the c20 property.
     * 
     */
    public void setC20(int value) {
        this.c20 = value;
    }

    /**
     * Gets the value of the c21 property.
     * 
     */
    public int getC21() {
        return c21;
    }

    /**
     * Sets the value of the c21 property.
     * 
     */
    public void setC21(int value) {
        this.c21 = value;
    }

    /**
     * Gets the value of the c22 property.
     * 
     */
    public int getC22() {
        return c22;
    }

    /**
     * Sets the value of the c22 property.
     * 
     */
    public void setC22(int value) {
        this.c22 = value;
    }

    /**
     * Gets the value of the s1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getS1() {
        return s1;
    }

    /**
     * Sets the value of the s1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setS1(String value) {
        this.s1 = value;
    }

    /**
     * Gets the value of the authorityTreeId property.
     * 
     */
    public int getAuthorityTreeId() {
        return authorityTreeId;
    }

    /**
     * Sets the value of the authorityTreeId property.
     * 
     */
    public void setAuthorityTreeId(int value) {
        this.authorityTreeId = value;
    }

    /**
     * Gets the value of the idISUOZNZ property.
     * 
     */
    public int getIdISUOZNZ() {
        return idISUOZNZ;
    }

    /**
     * Sets the value of the idISUOZNZ property.
     * 
     */
    public void setIdISUOZNZ(int value) {
        this.idISUOZNZ = value;
    }

}
