package ProjetoJava.Pizzaria.Controller;

import ProjetoJava.Pizzaria.Dto.Request.UserRequestDto;
import ProjetoJava.Pizzaria.Dto.Response.UserResponseDto;
import ProjetoJava.Pizzaria.Entity.Pizza;
import ProjetoJava.Pizzaria.Entity.User;
import ProjetoJava.Pizzaria.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserRequestDto userRequestDto) {
        try {
            User user = new User(userRequestDto);
            userRepository.save(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody UserRequestDto Request) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();

                // Atualiza os campos da pizza com base nos dados recebidos na requisição
                user.setName(Request.name());
                user.setLogin(Request.login());
                user.setSenha(Request.senha());
                user.setTel(Request.tel());
                user.setAddress(Request.address());

                // Salva a pizza atualizada no banco de dados
                User userResp = userRepository.save(user);

                System.out.println("Cliente atualizado com sucesso!.");

                return ResponseEntity.ok().build();
            } else {
                System.out.println("ID do cliente não encontrado: " + id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Adicione logs para debug
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> remove(@PathVariable Long id) {
        try {
           Optional<User> userOptional = userRepository.findById(id);
           if (userOptional.isPresent()) {
               userRepository.deleteById(id);
               return ResponseEntity.ok().build();

           } else {
               return ResponseEntity.notFound().build();
           }
       }catch(Exception e){
           e.printStackTrace();//logs para debug
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//retorna erro http
       }

    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(){
        try{
            List<UserResponseDto> userList = userRepository.findAll().stream()
                    .map(UserResponseDto::new).toList();
            return ResponseEntity.ok(userList);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
