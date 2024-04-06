package ProjetoJava.Pizzaria.Controller;

import ProjetoJava.Pizzaria.Dto.Request.PizzaRequestDto;
import ProjetoJava.Pizzaria.Dto.Response.PizzaResponseDto;
import ProjetoJava.Pizzaria.Entity.Pizza;
import ProjetoJava.Pizzaria.Repository.PizzaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pizza")
public class PizzaController {

    private final PizzaRepository repository;

    public PizzaController(PizzaRepository repository) {
        this.repository = repository;
    }

    //vou atualizar todos esse métodos para utilizarem ResponseEntity pois estamos lidando
    //com uma ApiRest

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PizzaRequestDto request) {
        try {
            Pizza pizza = new Pizza(request);
            repository.save(pizza);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PizzaRequestDto pizzaRequest) {
        try {
            Optional<Pizza> pizzaOptional = repository.findById(id);
            if (pizzaOptional.isPresent()) {
                Pizza pizza = pizzaOptional.get();

                // Logs para verificar os valores recebidos
                System.out.println("Dados recebidos para atualização:");
                System.out.println("Nome: " + pizza.getTitle());
                System.out.println("imagem: " + pizza.getImage());
                System.out.println("Preço: " + pizza.getPrice());

                // Atualiza os campos da pizza com base nos dados recebidos na requisição
                pizza.setTitle(pizza.getTitle());
                pizza.setImage(pizza.getImage());
                pizza.setPrice(pizza.getPrice());

                // Salva a pizza atualizada no banco de dados
                Pizza pizzaresp = repository.save(pizza);

                System.out.println("Pizza atualizada com sucesso.");

                return ResponseEntity.ok().build();
            } else {
                System.out.println("Pizza não encontrada com o ID: " + id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Adicione logs para debug
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        try {
            Optional<Pizza> pizzaOptional = repository.findById(id);
            if (pizzaOptional.isPresent()) {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Adicione logs para debug
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PizzaResponseDto>> getAll() {
        try {
            List<PizzaResponseDto> pizzaList = repository.findAll().stream()
                    .map(PizzaResponseDto::new)
                    .toList();

            return ResponseEntity.ok(pizzaList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}



