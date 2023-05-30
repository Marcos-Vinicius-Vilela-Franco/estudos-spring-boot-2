package br.com.tarefas.to_do_list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tarefas.to_do_list.configs.security.WebSecurityConfig;
import br.com.tarefas.to_do_list.model.Mensagem;
import br.com.tarefas.to_do_list.model.TarefaModel;
import br.com.tarefas.to_do_list.model.UserModel;
import br.com.tarefas.to_do_list.repository.TarefaRepository;
import br.com.tarefas.to_do_list.repository.UserRepository;
import jakarta.validation.Valid;


@Service
public class ApiService {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    WebSecurityConfig webSecurityConfig;

    public ResponseEntity<UserModel> create(UserModel obj){
        obj.setPassword(webSecurityConfig.passwordEncoder().encode(obj.getPassword()));
        return new ResponseEntity<>(userRepository.save(obj), HttpStatus.CREATED);
    }

   
    public ResponseEntity<Mensagem> deleteUser(Long id){
        if(userRepository.countById(id)==0){
            mensagem.setMensagem("O ID fornecido não existe!");
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            userRepository.deleteById(id);
            mensagem.setMensagem("Deletado com sucesso!");
         return new ResponseEntity<Mensagem>(mensagem, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<UserModel>> listAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> cereateTask(TarefaModel obj){
        if(userRepository.countById(obj.getUser().getId())==0){
            mensagem.setMensagem("O ID fornecido não existe!");
            return new ResponseEntity<Mensagem>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
         return new ResponseEntity<>(tarefaRepository.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> updateUser(UserModel obj){
        return new ResponseEntity<>(userRepository.save(obj), HttpStatus.OK);
    }
    
}
