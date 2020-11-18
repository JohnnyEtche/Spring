package ar.edu.unnoba.primero.service;

import ar.edu.unnoba.primero.Modelo.User;
import ar.edu.unnoba.primero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        if(repository.findByEmail(user.getEmail())==null){
            /*
            Guardamos la contraseña del usuario cifrada almacenando un hash en vez de la
            contraseña en texto plano
             */
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user = repository.save(user);
        }
        return user;
    }

//    @Override
//    public boolean create(User user) {
//
//        if (repository.findByEmail(user.getEmail()) == null) {
////            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//            user = repository.save(user);
//            return true;
//        } else {
//            return false;
//        }
//    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }
}


