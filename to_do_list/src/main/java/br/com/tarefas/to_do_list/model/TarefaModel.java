package br.com.tarefas.to_do_list.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.tarefas.to_do_list.enums.StatusTarefa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "tarefas")
public class TarefaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Size(max = 250)
    @NotBlank
    private String task;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;
}
