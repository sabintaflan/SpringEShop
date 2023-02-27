package ro.itschool.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
