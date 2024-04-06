package ProjetoJava.Pizzaria.Entity;

import ProjetoJava.Pizzaria.Dto.Request.CartRequestDto;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cart")
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


    public Cart(){

    }

    //quando utilizamos um record precisamos passar para nosso, construtor da classe
    //o request que será enviado no post.
    public Cart(CartRequestDto Request) {
        this.id = Request.id();
        this.pizza = Request.pizza();
        this.status = Request.status();
        this.address = Request.address();
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
