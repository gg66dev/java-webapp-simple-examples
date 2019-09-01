
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
 *         &lt;element name="GetCountryISO2ByNameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCountryISO2ByNameResult"
})
@XmlRootElement(name = "GetCountryISO2ByNameResponse")
public class GetCountryISO2ByNameResponse {

    @XmlElement(name = "GetCountryISO2ByNameResult")
    protected String getCountryISO2ByNameResult;

    /**
     * Obtiene el valor de la propiedad getCountryISO2ByNameResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCountryISO2ByNameResult() {
        return getCountryISO2ByNameResult;
    }

    /**
     * Define el valor de la propiedad getCountryISO2ByNameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCountryISO2ByNameResult(String value) {
        this.getCountryISO2ByNameResult = value;
    }

}
