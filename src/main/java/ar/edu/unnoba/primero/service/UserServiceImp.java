package ar.edu.unnoba.primero.service;

import ar.edu.unnoba.primero.Modelo.User;
import ar.edu.unnoba.primero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        if(repository.findByEmail(user.getEmail())==null){
            user = repository.save(user);
        }
        return user;
    }
}


