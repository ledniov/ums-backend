
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
 *         &lt;element name="SpecDirectionsSubjectsGet2Result" type="{http://edboservice.ua/}ArrayOfDSpecDirectionsSubjects" minOccurs="0"/>
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
    "specDirectionsSubjectsGet2Result"
})
@XmlRootElement(name = "SpecDirectionsSubjectsGet2Response")
public class SpecDirectionsSubjectsGet2Response {

    @XmlElement(name = "SpecDirectionsSubjectsGet2Result")
    protected ArrayOfDSpecDirectionsSubjects specDirectionsSubjectsGet2Result;

    /**
     * Gets the value of the specDirectionsSubjectsGet2Result property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDSpecDirectionsSubjects }
     *     
     */
    public ArrayOfDSpecDirectionsSubjects getSpecDirectionsSubjectsGet2Result() {
        return specDirectionsSubjectsGet2Result;
    }

    /**
     * Sets the value of the specDirectionsSubjectsGet2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDSpecDirectionsSubjects }
     *     
     */
    public void setSpecDirectionsSubjectsGet2Result(ArrayOfDSpecDirectionsSubjects value) {
        this.specDirectionsSubjectsGet2Result = value;
    }

}
