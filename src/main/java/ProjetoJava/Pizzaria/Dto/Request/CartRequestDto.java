package ProjetoJava.Pizzaria.Dto.Request;

import ProjetoJava.Pizzaria.Entity.Enum.CartEnum;
import ProjetoJava.Pizzaria.Entity.Pizza;

import java.sql.Timestamp;

public record CartRequestDto(Long id, Pizza pizza, CartEnum cartEnum, String address) {

    @Override
    public Long id() {
        return id;
    }

    @Override
    public Pizza pizza() {
        return pizza;
    }

    @Override
    public CartEnum cartEnum() {
        return cartEnum;
    }

    @Override
    public String address() {
        return address;
    }
}
