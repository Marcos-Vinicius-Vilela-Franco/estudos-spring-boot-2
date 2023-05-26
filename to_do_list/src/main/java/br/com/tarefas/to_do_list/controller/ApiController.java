package br.com.tarefas.to_do_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.to_do_list.model.Mensagem;
import br.com.tarefas.to_do_list.model.TarefaModel;
import br.com.tarefas.to_do_list.model.UserModel;
import br.com.tarefas.to_do_list.repository.TarefaRepository;
import br.com.tarefas.to_do_list.service.ApiService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private ApiService service;

    @PostMapping("/create")
    public ResponseEntity<UserModel> create(@Valid @RequestBody UserModel obj){
        return service.create(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mensagem> delete(@PathVariable Long id){
        return service.deleteUser(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserModel>>listAllUsers(){
        return service.listAllUsers();
    }

    @PostMapping("/create/task")
    public ResponseEntity<?> createTask(@Valid @RequestBody TarefaModel obj){
        return service.cereateTask(obj);
    }
    // @GetMapping("/list")
    // public List<UserModel> findAll(){
    //     return userRepository.findAll();
    // }

    // @PostMapping("/create/task")
    // public TarefaModel createTask(@Valid @RequestBody TarefaModel obj){
    //     return tarefaRepository.save(obj);
    // }

}
