package by.itstep.repo;


// repo can be:
//1) in RAM
//2) in MySQL


import by.itstep.model.User;

import java.util.List;

public interface UserRepo {

    User saveUser(User user);

    User getUserByLogin(String login);

    List<User> getAllUsers();

    void delUserByLogin(String login);

}
