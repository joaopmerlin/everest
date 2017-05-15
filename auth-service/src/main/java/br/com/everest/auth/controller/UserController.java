package br.com.everest.auth.controller;

import br.com.everest.auth.data.UserData;
import br.com.everest.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by joao on 11/05/17.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired private UserData userData;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("principal")
    public Principal principal(Principal principal) {
        return principal;
    }

    @GetMapping("logado")
    public User logado(Principal principal) {
        return userData.findByEmail(principal.getName()).get();
    }

    @GetMapping("{id}")
    public User findOne(@PathVariable Long id){
        return this.userData.findOne(id);
    }

    @GetMapping
    public List<User> findAll(){
        return this.userData.findAll();
    }

    @PostMapping
    public User save(@RequestBody @Valid User user) {
        if (user.getId() == null) {

            if (this.userData.findByEmail(user.getEmail()).isPresent()){
                throw new RuntimeException("user already exists");
            }

            if (user.getSenha() == null || user.getSenha().isEmpty()) {
                user.setSenha(bCryptPasswordEncoder.encode("123"));
            } else {
                user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
            }

        } else {

            User userAnt = this.userData.findOne(user.getId());
            user.setSenha(userAnt.getSenha());

        }
        return this.userData.save(user);
    }

    @DeleteMapping
    public void remove(@RequestBody User user, Principal principal){
        if (user.getEmail().equals(principal.getName())){
            throw new RuntimeException("Não é possível excluir o usuário logado");
        } else {
            this.userData.delete(user);
        }
    }
}
