//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.29 at 11:51:34 ���� CST 
//


package org.hi.metadata.hsc.context.service;

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
 *         &lt;element ref="{}entityName"/>
 *         &lt;element ref="{}entityType"/>
 *         &lt;element ref="{}tableName"/>
 *         &lt;element ref="{}entityLabel"/>
 *         &lt;element ref="{}entityBaseData"/>
 *         &lt;element ref="{}field" maxOccurs="unbounded"/>
 *         &lt;element ref="{}enumeration" maxOccurs="unbounded"/>
 *         &lt;element ref="{}childEntity" maxOccurs="unbounded"/>
 *         &lt;element ref="{}extendEntity"/>
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
    "entityName",
    "entityType",
    "tableName",
    "entityLabel",
    "entityBaseData",
    "field",
    "enumeration",
    "childEntity",
    "extendEntity"
})
@XmlRootElement(name = "entity")
public class Entity {

    @XmlElement(required = true)
    protected String entityName;
    protected int entityType;
    @XmlElement(required = true)
    protected String tableName;
    @XmlElement(required = true)
    protected String entityLabel;
    protected int entityBaseData;
    @XmlElement(required = true)
    protected List<Field> field;
    @XmlElement(required = true)
    protected List<Enumeration> enumeration;
    @XmlElement(required = true)
    protected List<ChildEntity> childEntity;
    @XmlElement(required = true)
    protected ExtendEntity extendEntity;

    /**
     * Gets the value of the entityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Sets the value of the entityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityName(String value) {
        this.entityName = value;
    }

    /**
     * Gets the value of the entityType property.
     * 
     */
    public int getEntityType() {
        return entityType;
    }

    /**
     * Sets the value of the entityType property.
     * 
     */
    public void setEntityType(int value) {
        this.entityType = value;
    }

    /**
     * Gets the value of the tableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the value of the tableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableName(String value) {
        this.tableName = value;
    }

    /**
     * Gets the value of the entityLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityLabel() {
        return entityLabel;
    }

    /**
     * Sets the value of the entityLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityLabel(String value) {
        this.entityLabel = value;
    }

    /**
     * Gets the value of the entityBaseData property.
     * 
     */
    public int getEntityBaseData() {
        return entityBaseData;
    }

    /**
     * Sets the value of the entityBaseData property.
     * 
     */
    public void setEntityBaseData(int value) {
        this.entityBaseData = value;
    }

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Field }
     * 
     * 
     */
    public List<Field> getField() {
        if (field == null) {
            field = new ArrayList<Field>();
        }
        return this.field;
    }

    /**
     * Gets the value of the enumeration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumeration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumeration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Enumeration }
     * 
     * 
     */
    public List<Enumeration> getEnumeration() {
        if (enumeration == null) {
            enumeration = new ArrayList<Enumeration>();
        }
        return this.enumeration;
    }

    /**
     * Gets the value of the childEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChildEntity }
     * 
     * 
     */
    public List<ChildEntity> getChildEntity() {
        if (childEntity == null) {
            childEntity = new ArrayList<ChildEntity>();
        }
        return this.childEntity;
    }

    /**
     * Gets the value of the extendEntity property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendEntity }
     *     
     */
    public ExtendEntity getExtendEntity() {
        return extendEntity;
    }

    /**
     * Sets the value of the extendEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendEntity }
     *     
     */
    public void setExtendEntity(ExtendEntity value) {
        this.extendEntity = value;
    }

}
