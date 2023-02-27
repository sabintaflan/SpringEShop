package ro.itschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.User;
import ro.itschool.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, User user) {
        User userUpdate = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("User with id %d doesn't exist", id)));
        userUpdate.setLastName(user.getLastName());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setEmail(user.getEmail());
        userRepository.save(userUpdate);
    }


    @Override
    public void deleteUser(Integer id) {
        boolean userExists = userRepository.existsById(id);
        if(!userExists){
            throw new IllegalStateException(String.format("User with id %d doesn't exist", id));
        }
        userRepository.deleteById(id);
    }

}


