package ar.edu.unnoba.primero.repository;

import ar.edu.unnoba.primero.Modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
}

