package ProjetoJava.Pizzaria.Dto.Request;


public record PizzaRequestDto(Long id, String title, String image, int price) {


    public PizzaRequestDto(Long id, String title, String image, int price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public String title() {
        return title;
    }

    // Método para obter a imagem
    public String image() {
        return image;
    }

    // Método para obter o preço
    public int price() {
        return price;
    }

}




