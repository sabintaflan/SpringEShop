package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.yaml.snakeyaml.events.Event;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "useraddress")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String street;

    @Column
    private int streetNumber;

    @Column
    private int postCode;

    @Column
    private String country;


    public UserAddress(String street, int streetNumber, int postCode, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.country = country;
    }
}
