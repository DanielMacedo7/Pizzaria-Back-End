package ProjetoJava.Pizzaria.Entity;

import ProjetoJava.Pizzaria.Dto.Request.UserRequestDto;
import jakarta.persistence.*;


@Entity
@Table(name = "cliente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String login;

    @Column(length = 150, nullable = false)
    private String senha;

    @Column(nullable = false)
    private Integer tel;

    @Column(length = 150, nullable = false)
    private String address;

    public User(){}

    public User(UserRequestDto Request){
        this.id = Request.id();
        this.name = Request.name();
        this.login = Request.login();
        this.senha = Request.senha();
        this.tel = Request.tel();
        this.address = Request.address();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
