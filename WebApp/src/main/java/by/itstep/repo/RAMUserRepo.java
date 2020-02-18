package by.itstep.repo;

import by.itstep.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class RAMUserRepo implements UserRepo {

    Map<String, User> users = new HashMap<>();


    @Override
    public User saveUser(User user) {
        return users.put(user.getLogin(), user);
    }

    @Override
    public User getUserByLogin(String login) {
        return users.get(login);
    }

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    @Override
    public void delUserByLogin(String login) {
        users.remove(login);
    }
}
