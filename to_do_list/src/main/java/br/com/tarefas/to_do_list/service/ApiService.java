package br.com.tarefas.to_do_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.com.tarefas.to_do_list.model.UserModel;
import br.com.tarefas.to_do_list.repository.UserRepository;


@Service
public class ApiService {
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserModel> create(UserModel obj){
        return new ResponseEntity<>(userRepository.save(obj), HttpStatus.CREATED);
    }
}
