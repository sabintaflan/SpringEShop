package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstname", length = 50)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;


    @Column(name = "email")
    private String email;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_useraddress_id")
    private UserAddress userAddress;

    @OneToMany(mappedBy ="user")
    private List<UserOrder> userOrder = new ArrayList<>();







}
