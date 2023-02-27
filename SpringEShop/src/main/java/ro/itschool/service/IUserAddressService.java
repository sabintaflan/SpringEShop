package ro.itschool.service;

import ro.itschool.entity.User;
import ro.itschool.entity.UserAddress;

import java.util.List;

public interface IUserAddressService {
    List<UserAddress> getUsersAddress();

    void createUserAddress(UserAddress userAddress);

    void updateUserAddress(Integer id, UserAddress userAddress);

    void deleteUserAddress(Integer id);
}
