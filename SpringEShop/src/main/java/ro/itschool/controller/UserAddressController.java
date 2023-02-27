package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.User;
import ro.itschool.entity.UserAddress;
import ro.itschool.service.UserAddressService;

import java.util.List;

@RestController
@RequestMapping(path = "/address")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping(path = "/all")
    public List<UserAddress> getUser(){
        return userAddressService.getUsersAddress();
    }

    @PostMapping(path = "/post")
    public void createUserAddress(@RequestBody UserAddress userAddress){
        userAddressService.createUserAddress(userAddress);
    }

    @PutMapping(path = "/{id}" )
    public void updateUserAddress(@PathVariable Integer id, @RequestBody UserAddress userAddress){
        userAddressService.updateUserAddress(id, userAddress);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserAddress(@PathVariable Integer id){
        userAddressService.deleteUserAddress(id);
    }


}
