package edu.hanoi.service.springhnservice.dao.impl;

import edu.hanoi.service.springhnservice.dao.UserDAO;
import edu.hanoi.service.springhnservice.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from User order by age desc");
            System.out.println(query.list());
            return query.list();
        } catch (Exception e) {
            LOGGER.error(e, e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public String insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            Serializable value = session.save(user);
            session.getTransaction().commit();
            return value.toString();
        } catch (Exception e) {
            LOGGER.error(e, e);
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
        try {
            return session.get(User.class, username);
        } catch (Exception e) {
            LOGGER.error(e, e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void delete(String username) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            User user = session.get(User.class, username);
            if (user != null) session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e, e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e, e);
        } finally {
            session.close();
        }
    }
}
