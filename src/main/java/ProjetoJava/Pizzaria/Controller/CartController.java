package ProjetoJava.Pizzaria.Controller;

import ProjetoJava.Pizzaria.Dto.Request.CartRequestDto;
import ProjetoJava.Pizzaria.Dto.Response.CartResponseDto;
import ProjetoJava.Pizzaria.Entity.Cart;
import ProjetoJava.Pizzaria.Repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart") // endpoit que será nossa tabela
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void Save(@RequestBody CartRequestDto Request){
        Cart cart = new Cart(Request);
        cartRepository.save(cart);

   }


}
