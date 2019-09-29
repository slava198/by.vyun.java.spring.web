package by.itstep.service;

import by.itstep.model.RegistrationException;
import by.itstep.model.User;
import by.itstep.model.dto.UserDto;
import by.itstep.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(UserDto registration) throws RegistrationException {

        if (userRepository.getUserByLogin(registration.getLogin()) != null) {
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

        return userRepository.saveUser(user);
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
        return userRepository.getAllUsers();
    }

    public void delUserByLogin(String login) {
        userRepository.delUserByLogin(login);
    }

    public User auth(UserDto userDto){

        User user = userRepository.getUserByLogin(userDto.getLogin());
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


    //TODO
    public void changeLogin(){
        //add forms to change login and password
    }

    public void changePassword(){

    }



}
