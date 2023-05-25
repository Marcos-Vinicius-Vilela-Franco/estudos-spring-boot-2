package br.com.tarefas.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarefas.to_do_list.model.TarefaModel;

public interface TarefaRepository extends JpaRepository<TarefaModel,Long>{
    
}
