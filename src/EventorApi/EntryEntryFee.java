//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.03 at 09:33:02 PM AEDT 
//


package EventorApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;choice>
 *           &lt;element ref="{}EntryFeeId"/>
 *           &lt;element ref="{}EntryFee"/>
 *         &lt;/choice>
 *         &lt;element ref="{}Sequence"/>
 *       &lt;/sequence>
 *       &lt;attribute name="eventRaceId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="isWholeEventFee" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="competitionUploadResultId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entryFeeId",
    "entryFee",
    "sequence"
})
@XmlRootElement(name = "EntryEntryFee")
public class EntryEntryFee {

    @XmlElement(name = "EntryFeeId")
    protected EntryFeeId entryFeeId;
    @XmlElement(name = "EntryFee")
    protected EntryFee entryFee;
    @XmlElement(name = "Sequence", required = true)
    protected Sequence sequence;
    @XmlAttribute(name = "eventRaceId")
    @XmlSchemaType(name = "anySimpleType")
    protected String eventRaceId;
    @XmlAttribute(name = "isWholeEventFee")
    protected Boolean isWholeEventFee;
    @XmlAttribute(name = "competitionUploadResultId")
    @XmlSchemaType(name = "anySimpleType")
    protected String competitionUploadResultId;

    /**
     * Gets the value of the entryFeeId property.
     * 
     * @return
     *     possible object is
     *     {@link EntryFeeId }
     *     
     */
    public EntryFeeId getEntryFeeId() {
        return entryFeeId;
    }

    /**
     * Sets the value of the entryFeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryFeeId }
     *     
     */
    public void setEntryFeeId(EntryFeeId value) {
        this.entryFeeId = value;
    }

    /**
     * Gets the value of the entryFee property.
     * 
     * @return
     *     possible object is
     *     {@link EntryFee }
     *     
     */
    public EntryFee getEntryFee() {
        return entryFee;
    }

    /**
     * Sets the value of the entryFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryFee }
     *     
     */
    public void setEntryFee(EntryFee value) {
        this.entryFee = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link Sequence }
     *     
     */
    public Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sequence }
     *     
     */
    public void setSequence(Sequence value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the eventRaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventRaceId() {
        return eventRaceId;
    }

    /**
     * Sets the value of the eventRaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventRaceId(String value) {
        this.eventRaceId = value;
    }

    /**
     * Gets the value of the isWholeEventFee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsWholeEventFee() {
        if (isWholeEventFee == null) {
            return false;
        } else {
            return isWholeEventFee;
        }
    }

    /**
     * Sets the value of the isWholeEventFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsWholeEventFee(Boolean value) {
        this.isWholeEventFee = value;
    }

    /**
     * Gets the value of the competitionUploadResultId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompetitionUploadResultId() {
        return competitionUploadResultId;
    }

    /**
     * Sets the value of the competitionUploadResultId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompetitionUploadResultId(String value) {
        this.competitionUploadResultId = value;
    }

}