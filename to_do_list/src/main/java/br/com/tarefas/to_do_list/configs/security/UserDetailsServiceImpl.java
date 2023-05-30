package br.com.tarefas.to_do_list.configs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tarefas.to_do_list.model.UserModel;
import br.com.tarefas.to_do_list.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username : " + username));
        // TODO Auto-generated method stub
        // return new User(userModel.getUsername(), userModel.getPassword(),true,true, true, true, null);
        System.out.println("ta aqui " + username);
        return userModel;
    }
    
}
