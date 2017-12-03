//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.03 at 09:33:02 PM AEDT 
//


package EventorApi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;element ref="{}StartNumber" minOccurs="0"/>
 *         &lt;element ref="{}BibNumber" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}CCardId"/>
 *           &lt;element ref="{}CCard"/>
 *         &lt;/choice>
 *         &lt;element ref="{}StartTime" minOccurs="0"/>
 *         &lt;element ref="{}TeamSequence" minOccurs="0"/>
 *         &lt;element ref="{}CourseLength"/>
 *         &lt;element ref="{}StartId" minOccurs="0"/>
 *         &lt;element ref="{}ModifyDate" minOccurs="0"/>
 *         &lt;element ref="{}ModifiedBy" minOccurs="0"/>
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
    "startNumber",
    "bibNumber",
    "cCardIdOrCCard",
    "startTime",
    "teamSequence",
    "courseLength",
    "startId",
    "modifyDate",
    "modifiedBy"
})
@XmlRootElement(name = "Start")
public class Start {

    @XmlElement(name = "StartNumber")
    protected StartNumber startNumber;
    @XmlElement(name = "BibNumber")
    protected BibNumber bibNumber;
    @XmlElements({
        @XmlElement(name = "CCardId", type = CCardId.class),
        @XmlElement(name = "CCard", type = CCard.class)
    })
    protected List<Object> cCardIdOrCCard;
    @XmlElement(name = "StartTime")
    protected StartTime startTime;
    @XmlElement(name = "TeamSequence")
    protected TeamSequence teamSequence;
    @XmlElement(name = "CourseLength", required = true)
    protected CourseLength courseLength;
    @XmlElement(name = "StartId")
    protected StartId startId;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;
    @XmlElement(name = "ModifiedBy")
    protected ModifiedBy modifiedBy;

    /**
     * Gets the value of the startNumber property.
     * 
     * @return
     *     possible object is
     *     {@link StartNumber }
     *     
     */
    public StartNumber getStartNumber() {
        return startNumber;
    }

    /**
     * Sets the value of the startNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartNumber }
     *     
     */
    public void setStartNumber(StartNumber value) {
        this.startNumber = value;
    }

    /**
     * Gets the value of the bibNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BibNumber }
     *     
     */
    public BibNumber getBibNumber() {
        return bibNumber;
    }

    /**
     * Sets the value of the bibNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BibNumber }
     *     
     */
    public void setBibNumber(BibNumber value) {
        this.bibNumber = value;
    }

    /**
     * Gets the value of the cCardIdOrCCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cCardIdOrCCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCCardIdOrCCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CCardId }
     * {@link CCard }
     * 
     * 
     */
    public List<Object> getCCardIdOrCCard() {
        if (cCardIdOrCCard == null) {
            cCardIdOrCCard = new ArrayList<Object>();
        }
        return this.cCardIdOrCCard;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link StartTime }
     *     
     */
    public StartTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartTime }
     *     
     */
    public void setStartTime(StartTime value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the teamSequence property.
     * 
     * @return
     *     possible object is
     *     {@link TeamSequence }
     *     
     */
    public TeamSequence getTeamSequence() {
        return teamSequence;
    }

    /**
     * Sets the value of the teamSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeamSequence }
     *     
     */
    public void setTeamSequence(TeamSequence value) {
        this.teamSequence = value;
    }

    /**
     * Gets the value of the courseLength property.
     * 
     * @return
     *     possible object is
     *     {@link CourseLength }
     *     
     */
    public CourseLength getCourseLength() {
        return courseLength;
    }

    /**
     * Sets the value of the courseLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseLength }
     *     
     */
    public void setCourseLength(CourseLength value) {
        this.courseLength = value;
    }

    /**
     * Gets the value of the startId property.
     * 
     * @return
     *     possible object is
     *     {@link StartId }
     *     
     */
    public StartId getStartId() {
        return startId;
    }

    /**
     * Sets the value of the startId property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartId }
     *     
     */
    public void setStartId(StartId value) {
        this.startId = value;
    }

    /**
     * Gets the value of the modifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link ModifyDate }
     *     
     */
    public ModifyDate getModifyDate() {
        return modifyDate;
    }

    /**
     * Sets the value of the modifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyDate }
     *     
     */
    public void setModifyDate(ModifyDate value) {
        this.modifyDate = value;
    }

    /**
     * Gets the value of the modifiedBy property.
     * 
     * @return
     *     possible object is
     *     {@link ModifiedBy }
     *     
     */
    public ModifiedBy getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the value of the modifiedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifiedBy }
     *     
     */
    public void setModifiedBy(ModifiedBy value) {
        this.modifiedBy = value;
    }

}