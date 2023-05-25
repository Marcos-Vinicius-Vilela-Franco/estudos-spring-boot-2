package br.com.tarefas.to_do_list.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insira um nome!")
    private String name;

    @NotBlank(message = "O campo e-mail é obrigatório")
    @Email(message = "O e-mail fornecido é inválido")
    private String email;

    
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<TarefaModel> tarefas;
}
