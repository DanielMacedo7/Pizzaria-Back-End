package ProjetoJava.Pizzaria.Dto.Request;

public record UserRequestDto
        (Long id, String name, String login,
         String senha, Integer tel, String address) {


    public String name() {
        return name;
    }

    // Método para obter a imagem
    public String login() {
        return login;
    }

    // Método para obter o preço
    public String senha() {
        return senha;
    }

    public Integer tel(){
        return tel;
    }

    public String address(){
        return address;
    }


}
