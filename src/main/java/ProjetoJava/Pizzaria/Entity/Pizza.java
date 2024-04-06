package ProjetoJava.Pizzaria.Entity;

import ProjetoJava.Pizzaria.Dto.Request.PizzaRequestDto;
import jakarta.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 350, nullable = false)
    private String image;

    @Column(nullable = false)
    private int price;


    public Pizza(){}

    public Pizza(PizzaRequestDto Request) {
        this.id = Request.id();
        this.title = Request.title();
        this.image = Request.image();
        this.price = Request.price();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
