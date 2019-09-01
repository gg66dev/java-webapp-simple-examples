
package com.lavasoft;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetLocationResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getLocationResult"
})
@XmlRootElement(name = "GetLocationResponse")
public class GetLocationResponse {

    @XmlElement(name = "GetLocationResult")
    protected String getLocationResult;

    /**
     * Obtiene el valor de la propiedad getLocationResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetLocationResult() {
        return getLocationResult;
    }

    /**
     * Define el valor de la propiedad getLocationResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetLocationResult(String value) {
        this.getLocationResult = value;
    }

}
