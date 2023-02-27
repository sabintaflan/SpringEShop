package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "userorder")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime date;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userorder_helmets",
            joinColumns = @JoinColumn(name = "userorder_id"),
            inverseJoinColumns = @JoinColumn(name = "helmets_id"))
    private List<Helmets> helmets = new LinkedList<>();

    public UserOrder(LocalDateTime date, boolean status, User user) {
        this.date = date;
        this.status = status;
        this.user = user;
    }
}
