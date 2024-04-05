package ProjetoJava.Pizzaria.Dto.Response;
import ProjetoJava.Pizzaria.Entity.Cart;
import ProjetoJava.Pizzaria.Entity.Pizza;

import java.sql.Timestamp;

public record CartResponseDto(Long id, Pizza pizza, Timestamp status, String address) {

public CartResponseDto(Cart cart){
    this(cart.getId(), cart.getPizza(), cart.getStatus(), cart.getAddress());
}


}
