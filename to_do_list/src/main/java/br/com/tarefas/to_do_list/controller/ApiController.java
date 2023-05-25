package br.com.tarefas.to_do_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.to_do_list.model.TarefaModel;
import br.com.tarefas.to_do_list.model.UserModel;
import br.com.tarefas.to_do_list.repository.TarefaRepository;
import br.com.tarefas.to_do_list.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
     
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/create")
    public UserModel create(@Valid @RequestBody UserModel obj){
        return userRepository.save(obj);
    }

    @GetMapping("/list")
    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/create/task")
    public TarefaModel createTask(@Valid @RequestBody TarefaModel obj){
        return tarefaRepository.save(obj);
    }

}
