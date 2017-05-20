package ggp.crudup.form;


/**
 * Created by Gustavo Pfeifer on 04/05/2017.
 */
public class UserForm {

    private String name;
    private String email;
    private String phone;
    private String street;
    private String suite;
    private String city;
    private String zipCode;

    public UserForm(){}

    public UserForm(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isValid() {
        return name != null && !name.equals("")  &&
                email != null && !email.equals("") &&
                phone != null && !phone.equals("");
    }
}
