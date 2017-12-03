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
 *         &lt;element ref="{}ServiceRequestId"/>
 *         &lt;choice>
 *           &lt;element ref="{}ServiceId"/>
 *           &lt;element ref="{}Service"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{}EventId"/>
 *           &lt;element ref="{}Event"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{}PersonId"/>
 *           &lt;element ref="{}OrganisationId"/>
 *         &lt;/choice>
 *         &lt;element ref="{}PersonResult" minOccurs="0"/>
 *         &lt;element ref="{}ServiceRequestFee" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}RequestedQuantity"/>
 *         &lt;element ref="{}Comment" minOccurs="0"/>
 *         &lt;element ref="{}Data" minOccurs="0"/>
 *         &lt;element ref="{}OrderedBy" minOccurs="0"/>
 *         &lt;element ref="{}OrderedDate" minOccurs="0"/>
 *         &lt;element ref="{}CreatedBy" minOccurs="0"/>
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
    "serviceRequestId",
    "serviceId",
    "service",
    "eventId",
    "event",
    "personId",
    "organisationId",
    "personResult",
    "serviceRequestFee",
    "requestedQuantity",
    "comment",
    "data",
    "orderedBy",
    "orderedDate",
    "createdBy",
    "modifyDate",
    "modifiedBy"
})
@XmlRootElement(name = "ServiceRequest")
public class ServiceRequest {

    @XmlElement(name = "ServiceRequestId", required = true)
    protected ServiceRequestId serviceRequestId;
    @XmlElement(name = "ServiceId")
    protected ServiceId serviceId;
    @XmlElement(name = "Service")
    protected Service service;
    @XmlElement(name = "EventId")
    protected EventId eventId;
    @XmlElement(name = "Event")
    protected Event event;
    @XmlElement(name = "PersonId")
    protected PersonId personId;
    @XmlElement(name = "OrganisationId")
    protected OrganisationId organisationId;
    @XmlElement(name = "PersonResult")
    protected PersonResult personResult;
    @XmlElement(name = "ServiceRequestFee")
    protected List<ServiceRequestFee> serviceRequestFee;
    @XmlElement(name = "RequestedQuantity", required = true)
    protected RequestedQuantity requestedQuantity;
    @XmlElement(name = "Comment")
    protected Comment comment;
    @XmlElement(name = "Data")
    protected Data data;
    @XmlElement(name = "OrderedBy")
    protected OrderedBy orderedBy;
    @XmlElement(name = "OrderedDate")
    protected OrderedDate orderedDate;
    @XmlElement(name = "CreatedBy")
    protected CreatedBy createdBy;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;
    @XmlElement(name = "ModifiedBy")
    protected ModifiedBy modifiedBy;

    /**
     * Gets the value of the serviceRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRequestId }
     *     
     */
    public ServiceRequestId getServiceRequestId() {
        return serviceRequestId;
    }

    /**
     * Sets the value of the serviceRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRequestId }
     *     
     */
    public void setServiceRequestId(ServiceRequestId value) {
        this.serviceRequestId = value;
    }

    /**
     * Gets the value of the serviceId property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceId }
     *     
     */
    public ServiceId getServiceId() {
        return serviceId;
    }

    /**
     * Sets the value of the serviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceId }
     *     
     */
    public void setServiceId(ServiceId value) {
        this.serviceId = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setService(Service value) {
        this.service = value;
    }

    /**
     * Gets the value of the eventId property.
     * 
     * @return
     *     possible object is
     *     {@link EventId }
     *     
     */
    public EventId getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventId }
     *     
     */
    public void setEventId(EventId value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link Event }
     *     
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link Event }
     *     
     */
    public void setEvent(Event value) {
        this.event = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link PersonId }
     *     
     */
    public PersonId getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonId }
     *     
     */
    public void setPersonId(PersonId value) {
        this.personId = value;
    }

    /**
     * Gets the value of the organisationId property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationId }
     *     
     */
    public OrganisationId getOrganisationId() {
        return organisationId;
    }

    /**
     * Sets the value of the organisationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationId }
     *     
     */
    public void setOrganisationId(OrganisationId value) {
        this.organisationId = value;
    }

    /**
     * Gets the value of the personResult property.
     * 
     * @return
     *     possible object is
     *     {@link PersonResult }
     *     
     */
    public PersonResult getPersonResult() {
        return personResult;
    }

    /**
     * Sets the value of the personResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonResult }
     *     
     */
    public void setPersonResult(PersonResult value) {
        this.personResult = value;
    }

    /**
     * Gets the value of the serviceRequestFee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceRequestFee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceRequestFee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRequestFee }
     * 
     * 
     */
    public List<ServiceRequestFee> getServiceRequestFee() {
        if (serviceRequestFee == null) {
            serviceRequestFee = new ArrayList<ServiceRequestFee>();
        }
        return this.serviceRequestFee;
    }

    /**
     * Gets the value of the requestedQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedQuantity }
     *     
     */
    public RequestedQuantity getRequestedQuantity() {
        return requestedQuantity;
    }

    /**
     * Sets the value of the requestedQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedQuantity }
     *     
     */
    public void setRequestedQuantity(RequestedQuantity value) {
        this.requestedQuantity = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link Comment }
     *     
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comment }
     *     
     */
    public void setComment(Comment value) {
        this.comment = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link Data }
     *     
     */
    public Data getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Data }
     *     
     */
    public void setData(Data value) {
        this.data = value;
    }

    /**
     * Gets the value of the orderedBy property.
     * 
     * @return
     *     possible object is
     *     {@link OrderedBy }
     *     
     */
    public OrderedBy getOrderedBy() {
        return orderedBy;
    }

    /**
     * Sets the value of the orderedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderedBy }
     *     
     */
    public void setOrderedBy(OrderedBy value) {
        this.orderedBy = value;
    }

    /**
     * Gets the value of the orderedDate property.
     * 
     * @return
     *     possible object is
     *     {@link OrderedDate }
     *     
     */
    public OrderedDate getOrderedDate() {
        return orderedDate;
    }

    /**
     * Sets the value of the orderedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderedDate }
     *     
     */
    public void setOrderedDate(OrderedDate value) {
        this.orderedDate = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link CreatedBy }
     *     
     */
    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatedBy }
     *     
     */
    public void setCreatedBy(CreatedBy value) {
        this.createdBy = value;
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