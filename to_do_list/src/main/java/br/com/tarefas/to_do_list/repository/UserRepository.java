package br.com.tarefas.to_do_list.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tarefas.to_do_list.model.UserModel;





public interface UserRepository extends JpaRepository<UserModel,Long>{
    int countById(Long id);
    
    Optional<UserModel> findByUsername(String username);
   Optional<UserModel> findByEmail(String email);
}
