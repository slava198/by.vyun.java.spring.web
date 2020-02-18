package by.itstep.service;

import by.itstep.model.RegistrationException;
import by.itstep.model.User;
import by.itstep.model.dto.UserDto;
import by.itstep.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User registration(UserDto registration) throws RegistrationException {

        if (userRepo.getUserByLogin(registration.getLogin()) != null) {
            throw new RegistrationException("Login duplicate:" + registration.getLogin());
        }

        if (registration.getPassword().length() * registration.getLogin().length() == 0) {
            throw new RegistrationException("Empty login or password");
        }


        User user = new User();
        user.setLogin(registration.getLogin().trim());
        user.setPassword(getStringHash(registration.getPassword()));
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());

        return userRepo.saveUser(user);
    }

    private String getStringHash(String str) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            return new String(hash);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public void delUserByLogin(String login) {
        userRepo.delUserByLogin(login);
    }

    public User auth(UserDto userDto){

        User user = userRepo.getUserByLogin(userDto.getLogin());
        String password = getStringHash(userDto.getPassword());
        if (user == null) {
            return null;
        }

        if (password.equals(user.getPassword())) {
            return user;
        }
        else {
            return null;
        }



    }

    @PostConstruct
    void postConstruct() {
        User user = new User();
        user.setLogin("1");
        user.setPassword(getStringHash("1"));
        userRepo.saveUser(user);
    }

    //TODO
    public void changeLogin(){
        //add forms to change login and password
    }

    public void changePassword(){

    }



}
