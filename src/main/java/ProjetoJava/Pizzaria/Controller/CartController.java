package ProjetoJava.Pizzaria.Controller;

import ProjetoJava.Pizzaria.Dto.Request.CartRequestDto;
import ProjetoJava.Pizzaria.Dto.Request.PizzaRequestDto;
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
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CartRequestDto request) {
        try {
            // Encontra a pizza com o ID fornecido
            Pizza pizza = pizzaRepository.findById(request.pizza().getId())
                    .orElseThrow(() -> new RuntimeException("ID da pizza não encontrado, verifique-o"));



            if (pizza != null) {
                // Cria um novo carrinho com base na solicitação fornecida
                Cart cart = new Cart(request);
                // Define a pizza no carrinho
                cart.setPizza(pizza);
                cart.setCartEnum(request.cartEnum());
                cart.setAddress(request.address());
                // Salva o carrinho no repositório
                cartRepository.save(cart);
                // Retorna um status 200 OK se tudo ocorreu bem
                return ResponseEntity.ok().build();
            } else {
                // Retorna um status 404 Not Found se a pizza não foi encontrada
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            // Retorna um status 500 Internal Server Error se ocorrer uma exceção
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
