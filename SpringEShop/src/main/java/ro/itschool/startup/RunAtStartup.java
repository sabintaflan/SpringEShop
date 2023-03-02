package ro.itschool.startup;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.Scheduled;
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
        user2.setLastName("Thomas");
        user2.setFirstName("Hardy");
        user2.setEmail("thomas@mail.com");
        user2.setUserAddress(new UserAddress("Hanover", 122, 223344, "UK"));
        userRepository.save(user2);

        User user3 = new User();
        user3.setLastName("Ernst");
        user3.setFirstName("Handel");
        user3.setEmail("handel@mail.com");
        user3.setUserAddress(new UserAddress("Walserweg", 5, 123456, "Germany"));
        userRepository.save(user3);

        User user4 = new User();
        user4.setLastName("Carine");
        user4.setFirstName("Accorti");
        user4.setEmail("accorti@mail.com");
        user4.setUserAddress(new UserAddress("Romero", 34, 1133, "Italy"));
        userRepository.save(user4);

        User user5 = new User();
        user5.setLastName("Bertrand");
        user5.setFirstName("Marie");
        user5.setEmail("bertrand@mail.com");
        user5.setUserAddress(new UserAddress("Charonne", 501, 226644, "France"));
        userRepository.save(user5);

        Helmets helmet1 = new Helmets("Shoei", "street", 500, "L", "black");
        helmetsRepository.save(helmet1);
        Helmets helmet2 = new Helmets("Airoh", "offroad", 400, "M", "white");
        helmetsRepository.save(helmet2);
        Helmets helmet3 = new Helmets("Agv", "street", 550, "M", "red");
        helmetsRepository.save(helmet3);

        UserOrder userOrder = new UserOrder();
        userOrder.setDate(LocalDateTime.now());
        userOrder.setStatus(true);
        userOrder.setUser(user4);
        userOrder.addHelmetsToUserOrder(new Helmets("Arai", "street", 450, "L", "blue"));
        userOrderRepository.save(userOrder);

        UserOrder userOrder2 = new UserOrder();
        userOrder2.setDate(LocalDateTime.now());
        userOrder2.setStatus(true);
        userOrder2.setUser(user2);
        userOrder2.addHelmetsToUserOrder(new Helmets("Airoh", "offroad", 400, "S", "grey"));
        userOrderRepository.save(userOrder2);

        UserOrder userOrder3 = new UserOrder();
        userOrder3.setDate(LocalDateTime.now());
        userOrder3.setStatus(false);
        userOrder3.setUser(user5);
        userOrder3.addHelmetsToUserOrder(new Helmets("Shoei", "street", 500, "L", "black"));
        userOrderRepository.save(userOrder3);

        UserOrder userOrder4 = new UserOrder();
        userOrder4.setDate(LocalDateTime.now());
        userOrder4.setStatus(true);
        userOrder4.setUser(user);
        userOrder4.addHelmetsToUserOrder(new Helmets("Fox", "offroad", 400, "M", "red"));
        userOrderRepository.save(userOrder4);






    }
}
