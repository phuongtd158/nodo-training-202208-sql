package edu.hanoi.spring.springwebsocket.dao.impl;

import edu.hanoi.spring.springwebsocket.dao.GroupDAO;
import edu.hanoi.spring.springwebsocket.model.Group;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDAOImpl implements GroupDAO {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Group> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from Group ");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
