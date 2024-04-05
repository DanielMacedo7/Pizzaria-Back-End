package ProjetoJava.Pizzaria.Repository;

import ProjetoJava.Pizzaria.Entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
