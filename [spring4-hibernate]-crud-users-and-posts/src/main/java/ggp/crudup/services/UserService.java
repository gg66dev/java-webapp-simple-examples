package ggp.crudup.services;

import ggp.crudup.entity.User;

import java.util.List;

/**
 * Created by Gustavo Pfeifer on 17/05/2017.
 */
public interface UserService {

    void saveUser(User user);
    List<User> getUsers();
    User getUserByName(String value);
    User getUserByEmail(String value);

}
