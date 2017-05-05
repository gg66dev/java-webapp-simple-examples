package ggp.crudup.form;

/**
 * Created by Gustavo Pfeifer on 04/05/2017.
 */
public class UserForm {

    private String name;
    private String email;

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
}
