package ro.itschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.User;
import ro.itschool.entity.UserAddress;
import ro.itschool.repository.UserAddressRepository;

import java.util.List;

@Service
public class UserAddressService implements IUserAddressService{

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public List<UserAddress> getUsersAddress() {
        return userAddressRepository.findAll();
    }

    @Override
    public void createUserAddress(UserAddress userAddress) {

    }

    @Override
    public void updateUserAddress(Integer id, UserAddress userAddress) {
        UserAddress userAddressUpdate = userAddressRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("User with id %d doesn't exist", id)));
        userAddressUpdate.setStreetNumber(userAddress.getStreetNumber());
        userAddressUpdate.setStreet(userAddress.getStreet());
        userAddressUpdate.setPostCode(userAddress.getPostCode());
        userAddressRepository.save(userAddressUpdate);
    }

    @Override
    public void deleteUserAddress(Integer id) {
        boolean userAddressExists = userAddressRepository.existsById(id);
        if(!userAddressExists){
            throw new IllegalStateException(String.format("User with id %d doesn't exist", id));
        }
        userAddressRepository.deleteById(id);
    }
}
