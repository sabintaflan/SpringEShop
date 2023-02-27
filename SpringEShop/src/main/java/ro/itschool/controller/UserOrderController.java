package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.UserOrder;
import ro.itschool.service.UserOrderService;

import java.util.List;

@RestController
@RequestMapping(path = "/userorder")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping(path = "/all")
    public List<UserOrder> getUserOrder(){
        return userOrderService.getUserOrder();
    }

    @PostMapping(path = "/post")
    public void createUserOrder(@RequestBody UserOrder userOrder){
        userOrderService.createUserOrder(userOrder);
    }

    @PutMapping(path = "/{id}" )
    public void updateUserOrder(@PathVariable Integer id, @RequestBody UserOrder userOrder){
        userOrderService.updateUserOrder(id, userOrder);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserOrder(@PathVariable Integer id){
        userOrderService.deleteUserOrder(id);
    }

}
