package edu.hanoi.spring.springwebsocket.dao;


import edu.hanoi.spring.springwebsocket.model.User;

import java.util.List;

public interface UserDAO {
    List<User> list();

    String insert(User user);

    User get(String username);

    void delete(String username);

    void update(User user);
}
