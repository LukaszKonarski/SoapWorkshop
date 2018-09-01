package pl.soapworkshop.entity;

import javax.persistence.*;

@Entity
@Table(name="Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToMany ???
    private Integer orderId;
    private Integer telephoneNo;
    private String email;
    private String street;
    private String city;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(Integer telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
