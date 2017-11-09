//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.07 at 08:57:59 PM AEDT 
//


package IofXml30.java;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 *         The start list of a single class containing either individual start times or team start times.
 *       
 * 
 * <p>Java class for ClassStart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassStart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Class" type="{http://www.orienteering.org/datastandard/3.0}Class"/>
 *         &lt;element name="Course" type="{http://www.orienteering.org/datastandard/3.0}SimpleRaceCourse" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StartName" type="{http://www.orienteering.org/datastandard/3.0}StartName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PersonStart" type="{http://www.orienteering.org/datastandard/3.0}PersonStart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TeamStart" type="{http://www.orienteering.org/datastandard/3.0}TeamStart" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.orienteering.org/datastandard/3.0}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="timeResolution" type="{http://www.w3.org/2001/XMLSchema}double" default="1" />
 *       &lt;attribute name="modifyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassStart", propOrder = {
    "clazz",
    "course",
    "startName",
    "personStart",
    "teamStart",
    "extensions"
})
public class ClassStart {

    @XmlElement(name = "Class", required = true)
    protected Clazz clazz;
    @XmlElement(name = "Course")
    protected List<SimpleRaceCourse> course;
    @XmlElement(name = "StartName")
    protected List<StartName> startName;
    @XmlElement(name = "PersonStart")
    protected List<PersonStart> personStart;
    @XmlElement(name = "TeamStart")
    protected List<TeamStart> teamStart;
    @XmlElement(name = "Extensions")
    protected Extensions extensions;
    @XmlAttribute(name = "timeResolution")
    protected Double timeResolution;
    @XmlAttribute(name = "modifyTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifyTime;

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link Clazz }
     *     
     */
    public Clazz getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clazz }
     *     
     */
    public void setClazz(Clazz value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the course property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the course property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleRaceCourse }
     * 
     * 
     */
    public List<SimpleRaceCourse> getCourse() {
        if (course == null) {
            course = new ArrayList<SimpleRaceCourse>();
        }
        return this.course;
    }

    /**
     * Gets the value of the startName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StartName }
     * 
     * 
     */
    public List<StartName> getStartName() {
        if (startName == null) {
            startName = new ArrayList<StartName>();
        }
        return this.startName;
    }

    /**
     * Gets the value of the personStart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personStart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonStart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonStart }
     * 
     * 
     */
    public List<PersonStart> getPersonStart() {
        if (personStart == null) {
            personStart = new ArrayList<PersonStart>();
        }
        return this.personStart;
    }

    /**
     * Gets the value of the teamStart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the teamStart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTeamStart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TeamStart }
     * 
     * 
     */
    public List<TeamStart> getTeamStart() {
        if (teamStart == null) {
            teamStart = new ArrayList<TeamStart>();
        }
        return this.teamStart;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link Extensions }
     *     
     */
    public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extensions }
     *     
     */
    public void setExtensions(Extensions value) {
        this.extensions = value;
    }

    /**
     * Gets the value of the timeResolution property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getTimeResolution() {
        if (timeResolution == null) {
            return  1.0D;
        } else {
            return timeResolution;
        }
    }

    /**
     * Sets the value of the timeResolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTimeResolution(Double value) {
        this.timeResolution = value;
    }

    /**
     * Gets the value of the modifyTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifyTime() {
        return modifyTime;
    }

    /**
     * Sets the value of the modifyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifyTime(XMLGregorianCalendar value) {
        this.modifyTime = value;
    }

}
