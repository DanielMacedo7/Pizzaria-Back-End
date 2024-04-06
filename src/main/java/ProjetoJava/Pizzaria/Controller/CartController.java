package ProjetoJava.Pizzaria.Controller;

import ProjetoJava.Pizzaria.Dto.Response.CartResponseDto;
import ProjetoJava.Pizzaria.Entity.Cart;
import ProjetoJava.Pizzaria.Entity.Pizza;
import ProjetoJava.Pizzaria.Repository.CartRepository;
import ProjetoJava.Pizzaria.Repository.PizzaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cart") // endpoit que será nossa tabela
public class CartController {

    private final CartRepository cartRepository;
    private final PizzaRepository pizzaRepository;

    public CartController(CartRepository cartRepository, PizzaRepository pizzaRepository) {
        this.cartRepository = cartRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/addPizza")
    public ResponseEntity<Void> addPizzaToCart(@RequestParam Long pizzaId){
        try {
            // Verificar se o carrinho já existe no banco de dados
            Optional<Cart> cartOptional = cartRepository.findById(1L); // Supondo que o ID do carrinho é 1

            if (cartOptional.isPresent()) {
                Cart cart = cartOptional.get();

                // Buscar a pizza pelo ID
                Optional<Pizza> pizzaOptional = pizzaRepository.findById(pizzaId);

                if (pizzaOptional.isPresent()) {
                    Pizza pizza = pizzaOptional.get();

                    // Adicionar a pizza ao carrinho
                    cart.addPizza(pizza);

                    // Salvar o carrinho atualizado no banco de dados
                    cartRepository.save(cart);

                    System.out.println("Pizza adicionada ao carrinho com sucesso.");

                    return ResponseEntity.ok().build();
                } else {
                    System.out.println("Pizza não encontrada com o ID: " + pizzaId);
                    return ResponseEntity.notFound().build();
                }
            } else {
                System.out.println("Carrinho não encontrado com o ID: 1"); // Se o carrinho com ID 1 não existir
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Adicione logs para debug
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping
   public ResponseEntity<List<CartResponseDto>> getAll() {
       try {
           List<CartResponseDto> cartList =
                   cartRepository.findAll().stream()
                           .map(CartResponseDto::new).toList();

           return ResponseEntity.ok(cartList);
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }

   }


}
