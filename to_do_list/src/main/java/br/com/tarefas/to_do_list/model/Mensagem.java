package br.com.tarefas.to_do_list.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Mensagem {
    
    private String mensagem;
}