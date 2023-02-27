package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}
