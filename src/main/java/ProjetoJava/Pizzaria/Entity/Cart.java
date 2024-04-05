package ProjetoJava.Pizzaria.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    private Pizza pizza;

    @Column(nullable = false)
    private Timestamp status;

    @Column(nullable = false)
    private String address;

    public Cart(){}

    public Cart(Long id, Pizza pizza, Timestamp status, String address) {
        this.id = id;
        this.pizza = pizza;
        this.status = status;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Timestamp getStatus() {
        return status;
    }

    public void setStatus(Timestamp status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
