
package de.particity.schemagen.impexpv100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OfferType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OfferType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="offerId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="workTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="workType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="socialStatus" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="updated" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="expires" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="publish" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="address" type="{http://github.com/fraunhoferfokus/particity/ImportExport}AddressType"/&gt;
 *         &lt;element name="contact" type="{http://github.com/fraunhoferfokus/particity/ImportExport}ContactType"/&gt;
 *         &lt;element name="sndContact" type="{http://github.com/fraunhoferfokus/particity/ImportExport}ContactType"/&gt;
 *         &lt;element name="contactAgency" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="categoryItem" type="{http://github.com/fraunhoferfokus/particity/ImportExport}CategoryEntryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfferType", propOrder = {
    "orgId",
    "offerId",
    "title",
    "description",
    "workTime",
    "workType",
    "type",
    "status",
    "socialStatus",
    "created",
    "updated",
    "expires",
    "publish",
    "address",
    "contact",
    "sndContact",
    "contactAgency",
    "categoryItem"
})
public class OfferType {

    protected long orgId;
    protected long offerId;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String workTime;
    @XmlElement(required = true)
    protected String workType;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String status;
    protected int socialStatus;
    protected long created;
    protected long updated;
    protected long expires;
    protected long publish;
    @XmlElement(required = true)
    protected AddressType address;
    @XmlElement(required = true)
    protected ContactType contact;
    @XmlElement(required = true)
    protected ContactType sndContact;
    protected boolean contactAgency;
    protected List<CategoryEntryType> categoryItem;

    /**
     * Gets the value of the orgId property.
     * 
     */
    public long getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     */
    public void setOrgId(long value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the offerId property.
     * 
     */
    public long getOfferId() {
        return offerId;
    }

    /**
     * Sets the value of the offerId property.
     * 
     */
    public void setOfferId(long value) {
        this.offerId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the workTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * Sets the value of the workTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkTime(String value) {
        this.workTime = value;
    }

    /**
     * Gets the value of the workType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * Sets the value of the workType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkType(String value) {
        this.workType = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the socialStatus property.
     * 
     */
    public int getSocialStatus() {
        return socialStatus;
    }

    /**
     * Sets the value of the socialStatus property.
     * 
     */
    public void setSocialStatus(int value) {
        this.socialStatus = value;
    }

    /**
     * Gets the value of the created property.
     * 
     */
    public long getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     */
    public void setCreated(long value) {
        this.created = value;
    }

    /**
     * Gets the value of the updated property.
     * 
     */
    public long getUpdated() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     * 
     */
    public void setUpdated(long value) {
        this.updated = value;
    }

    /**
     * Gets the value of the expires property.
     * 
     */
    public long getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     */
    public void setExpires(long value) {
        this.expires = value;
    }

    /**
     * Gets the value of the publish property.
     * 
     */
    public long getPublish() {
        return publish;
    }

    /**
     * Sets the value of the publish property.
     * 
     */
    public void setPublish(long value) {
        this.publish = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setContact(ContactType value) {
        this.contact = value;
    }

    /**
     * Gets the value of the sndContact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getSndContact() {
        return sndContact;
    }

    /**
     * Sets the value of the sndContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setSndContact(ContactType value) {
        this.sndContact = value;
    }

    /**
     * Gets the value of the contactAgency property.
     * 
     */
    public boolean isContactAgency() {
        return contactAgency;
    }

    /**
     * Sets the value of the contactAgency property.
     * 
     */
    public void setContactAgency(boolean value) {
        this.contactAgency = value;
    }

    /**
     * Gets the value of the categoryItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryEntryType }
     * 
     * 
     */
    public List<CategoryEntryType> getCategoryItem() {
        if (categoryItem == null) {
            categoryItem = new ArrayList<CategoryEntryType>();
        }
        return this.categoryItem;
    }

}
