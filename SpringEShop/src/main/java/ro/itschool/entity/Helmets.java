package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "helmets")
public class Helmets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "helmet_name")
    private String helmetName;

    @Column(name = "helmet_type")
    private String helmetType;

    @Column(name = "helmet_price")
    private int helmetPrice;

    @Column(name = "helmet_size")
    private String helmetSize;


    @Column(name = "helmet_colour")
    private String helmetColour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userorder_helmets",
            joinColumns = @JoinColumn(name = "helmets_id"),
            inverseJoinColumns = @JoinColumn(name = "userorder_id"))
    private List<UserOrder> userOrder = new LinkedList<>();



    public Helmets(String helmetName, String helmetType, int helmetPrice, String helmetSize, String helmetColour) {
        this.helmetName = helmetName;
        this.helmetType = helmetType;
        this.helmetPrice = helmetPrice;
        this.helmetSize = helmetSize;
        this.helmetColour = helmetColour;
    }
}
