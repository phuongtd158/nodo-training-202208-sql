package edu.hanoi.spring.springwebsocket.dao.impl;

import edu.hanoi.spring.springwebsocket.dao.UserDAO;
import edu.hanoi.spring.springwebsocket.model.User;
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


    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> list() {
        try (Session session = sessionFactory.getObject().openSession()) {
            Query query = session.createQuery("from User order by age desc");
            System.out.println(query.list());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String insert(User user) {
        try (Session session = sessionFactory.getObject().openSession()) {
            session.getTransaction().begin();
            Serializable value = session.save(user);
            session.getTransaction().commit();
            return value.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User get(String username) {
        try (Session session = sessionFactory.getObject().openSession()) {
            return session.get(User.class, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String username) {
        try (Session session = sessionFactory.getObject().openSession()) {
            session.getTransaction().begin();
            User user = session.get(User.class, username);
            if (user != null) session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = sessionFactory.getObject().openSession()) {
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
