package ProjetoJava.Pizzaria.Dto.Response;

import ProjetoJava.Pizzaria.Entity.User;

public record
UserResponseDto(Long id, String name, String login,
                              String senha, Integer tel, String address) {

public UserResponseDto(User user){
    this(user.getId(), user.getName(), user.getLogin(), user.getSenha(),
         user.getTel(), user.getAddress());
}




}
