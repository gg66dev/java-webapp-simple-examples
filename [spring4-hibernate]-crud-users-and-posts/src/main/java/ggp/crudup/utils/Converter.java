package ggp.crudup.utils;

import ggp.crudup.entity.User;
import ggp.crudup.form.UserForm;

/**
 * Created by Gustavo Pfeifer on 18/05/2017.
 */
public class Converter {

    static public User convertTo(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPhone(userForm.getPhone());
        user.setStreet(user.getStreet());
        user.setSuite(userForm.getSuite());
        user.setCity(userForm.getCity());
        user.setZipCode(userForm.getZipCode());
        return user;
   }

}
