package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.UserOrder;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {
}
