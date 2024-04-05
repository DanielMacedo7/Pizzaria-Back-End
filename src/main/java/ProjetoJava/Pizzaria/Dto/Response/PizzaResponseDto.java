package ProjetoJava.Pizzaria.Dto.Response;

import ProjetoJava.Pizzaria.Entity.Pizza;

public record PizzaResponseDto(Long id, String title, String image, int price) {

public PizzaResponseDto(Pizza pizza){
    this(pizza.getId(), pizza.getTitle(), pizza.getImage(), pizza.getPrice());

}


}
