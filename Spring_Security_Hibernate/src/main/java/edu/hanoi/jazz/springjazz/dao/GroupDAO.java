package edu.hanoi.jazz.springjazz.dao;

import edu.hanoi.jazz.springjazz.model.Group;

import java.util.List;

public interface GroupDAO {
    void insert(Group group);

    List<Group> list();

    List<Group> searchByName(String name);

    void delete(Integer id);

    void update(Group group);

    Group get(Integer id);
}
