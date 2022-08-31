package edu.hanoi.jazz.springjazz.dao.impl;

import edu.hanoi.jazz.springjazz.dao.UserDAO;
import edu.hanoi.jazz.springjazz.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(user);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save user " + user.getUsername() + " done !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("FROM User");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<User> searchByUserName(String username) {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from User where username like :username");
            query.setParameter("username", "%" + username + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
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
            if (user == null) {
                return;
            }
            session.delete(user);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Delete user " + user.getUsername() + " done !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getObject().openSession();
        User userExist = (User) session.merge(user);
        try {
            session.getTransaction().begin();
            session.save(userExist);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Update group " + userExist.getUsername() + " success !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(User.class, username);
    }
}
