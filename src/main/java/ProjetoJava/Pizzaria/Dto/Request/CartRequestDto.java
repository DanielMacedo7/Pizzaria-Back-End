package ProjetoJava.Pizzaria.Dto.Request;

import ProjetoJava.Pizzaria.Entity.Pizza;

import java.sql.Timestamp;

public record CartRequestDto(Long id, Pizza pizza, Timestamp status, String address) {

}
