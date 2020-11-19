package ar.edu.unnoba.primero.service;

import ar.edu.unnoba.primero.Modelo.User;

import java.util.List;

public interface IUserService {
    public User create(User user);
    public List<User> getUsers();
}
