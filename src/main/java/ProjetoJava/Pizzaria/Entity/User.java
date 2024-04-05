package ProjetoJava.Pizzaria.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_user")
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

    public User(Long id, String name, String login, String senha, Integer tel, String address){
        this.id = id;
        this.name = name;
        this.login = login;
        this.senha = senha;
        this.tel = tel;
        this.address = address;

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
