package edu.hanoi.jazz.springjazz.dao;

import edu.hanoi.jazz.springjazz.model.User;

import java.util.List;

public interface UserDAO {
    void insert(User user);

    List<User> list();

    List<User> searchByUserName(String username);

    void delete(String username);

    void update(User user);

    User get(String username);
}
