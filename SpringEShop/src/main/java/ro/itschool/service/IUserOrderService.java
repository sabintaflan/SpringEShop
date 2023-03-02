package ro.itschool.service;

import ro.itschool.entity.Helmets;
import ro.itschool.entity.UserOrder;

import java.util.List;

public interface IUserOrderService {

    List<UserOrder> getUserOrder();

    void createUserOrder(UserOrder userOrder);

    void updateUserOrder(Integer id, UserOrder userOrder);

    void deleteUserOrder(Integer id);


}
