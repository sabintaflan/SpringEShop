package ro.itschool.service;

import ro.itschool.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    void createUser(User user);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);
}
