package ro.itschool.service;

import org.springframework.stereotype.Service;
import ro.itschool.entity.Helmets;
import ro.itschool.entity.UserOrder;
import ro.itschool.repository.UserOrderRepository;

import java.util.List;

@Service
public class UserOrderService implements IUserOrderService{

    private UserOrderRepository userOrderRepository;

    @Override
    public List<UserOrder> getUserOrder() {
        return userOrderRepository.findAll();
    }

    @Override
    public void createUserOrder(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public void updateUserOrder(Integer id, UserOrder userOrder) {
        UserOrder userOrderUpdate = userOrderRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("User with id %d doesn't exist", id)));
        userOrderUpdate.setStatus(userOrder.isStatus());
        userOrderRepository.save(userOrderUpdate);

    }

    @Override
    public void deleteUserOrder(Integer id) {
        boolean userOrderExists = userOrderRepository.existsById(id);
        if(!userOrderExists){
            throw new IllegalStateException(String.format("User with id %d doesn't exist", id));
        }
        userOrderRepository.deleteById(id);
    }
}
