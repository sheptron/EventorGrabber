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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *           &lt;element ref="{}EventClassId"/>
 *           &lt;element ref="{}EventClass"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}PersonStart"/>
 *           &lt;element ref="{}TeamStart"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="numberOfEntries" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eventClassId",
    "eventClass",
    "personStartOrTeamStart"
})
@XmlRootElement(name = "ClassStart")
public class ClassStart {

    @XmlElement(name = "EventClassId")
    protected EventClassId eventClassId;
    @XmlElement(name = "EventClass")
    protected EventClass eventClass;
    @XmlElements({
        @XmlElement(name = "PersonStart", type = PersonStart.class),
        @XmlElement(name = "TeamStart", type = TeamStart.class)
    })
    protected List<Object> personStartOrTeamStart;
    @XmlAttribute(name = "numberOfEntries")
    @XmlSchemaType(name = "anySimpleType")
    protected String numberOfEntries;

    /**
     * Gets the value of the eventClassId property.
     * 
     * @return
     *     possible object is
     *     {@link EventClassId }
     *     
     */
    public EventClassId getEventClassId() {
        return eventClassId;
    }

    /**
     * Sets the value of the eventClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventClassId }
     *     
     */
    public void setEventClassId(EventClassId value) {
        this.eventClassId = value;
    }

    /**
     * Gets the value of the eventClass property.
     * 
     * @return
     *     possible object is
     *     {@link EventClass }
     *     
     */
    public EventClass getEventClass() {
        return eventClass;
    }

    /**
     * Sets the value of the eventClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventClass }
     *     
     */
    public void setEventClass(EventClass value) {
        this.eventClass = value;
    }

    /**
     * Gets the value of the personStartOrTeamStart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personStartOrTeamStart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonStartOrTeamStart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonStart }
     * {@link TeamStart }
     * 
     * 
     */
    public List<Object> getPersonStartOrTeamStart() {
        if (personStartOrTeamStart == null) {
            personStartOrTeamStart = new ArrayList<Object>();
        }
        return this.personStartOrTeamStart;
    }

    /**
     * Gets the value of the numberOfEntries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfEntries() {
        return numberOfEntries;
    }

    /**
     * Sets the value of the numberOfEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfEntries(String value) {
        this.numberOfEntries = value;
    }

}
