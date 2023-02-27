package ro.itschool.startup;

import jakarta.persistence.Column;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.Helmets;
import ro.itschool.entity.User;
import ro.itschool.entity.UserAddress;
import ro.itschool.entity.UserOrder;
import ro.itschool.repository.HelmetsRepository;
import ro.itschool.repository.UserAddressRepository;
import ro.itschool.repository.UserOrderRepository;
import ro.itschool.repository.UserRepository;

import java.time.LocalDateTime;

@Component
public class RunAtStartup {
    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;
    private final HelmetsRepository helmetsRepository;
    private final UserOrderRepository userOrderRepository;

    public RunAtStartup(UserRepository userRepository,
                        UserAddressRepository userAddressRepository,
                        HelmetsRepository helmetsRepository,
                        UserOrderRepository userOrderRepository) {
        this.userRepository = userRepository;
        this.userAddressRepository = userAddressRepository;
        this.helmetsRepository = helmetsRepository;
        this.userOrderRepository = userOrderRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAtStartup(){

        User user = new User();
        user.setLastName("Alfred");
        user.setFirstName("Moreno");
        user.setEmail("alfred@mail.com");
        user.setUserAddress(new UserAddress("Baker", 25, 112233, "Usa"));
        userRepository.save(user);

        User user2 = new User();
        user.setLastName("Thomas");
        user.setFirstName("Hardy");
        user.setEmail("thomas@mail.com");
        user.setUserAddress(new UserAddress("Hanover", 122, 223344, "UK"));
        userRepository.save(user2);

        Helmets helmet = new Helmets("Shoei", "street", 500, "large","black");
        helmetsRepository.save(helmet);
        Helmets helmet2 = new Helmets("Airoh", "offroad", 400, "medium", "white");
        helmetsRepository.save(helmet2);

        UserOrder userOrder = new UserOrder(LocalDateTime.now(), true, user);
        userOrderRepository.save(userOrder);
        UserOrder userOrder2 = new UserOrder(LocalDateTime.now(), true, user2);
        userOrderRepository.save(userOrder2);



    }
}
