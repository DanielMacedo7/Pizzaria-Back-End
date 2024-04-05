package ProjetoJava.Pizzaria.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 180, nullable = false)
    private String image;

    @Column(nullable = false)
    private int price;


    public Pizza(){}

    public Pizza(Long id, String title, String image, int price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.price = price;

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
