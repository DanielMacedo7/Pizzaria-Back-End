package ProjetoJava.Pizzaria.Dto.Request;

public record UserRequestDto
        (Long id, String name, String login,
         String senha, Integer tel, String address) {

}
