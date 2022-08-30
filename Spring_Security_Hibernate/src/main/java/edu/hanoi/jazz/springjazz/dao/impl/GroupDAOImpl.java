package edu.hanoi.jazz.springjazz.dao.impl;

import edu.hanoi.jazz.springjazz.dao.GroupDAO;
import edu.hanoi.jazz.springjazz.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    private static final Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(group);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save group " + group.getName() + " done !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Group> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("FROM Group");
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
    public void delete(Integer id) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            Group group = session.get(Group.class, id);
            if (group == null) {
                return;
            }
            session.delete(group);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save group " + group.getName() + " done !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void update(Group group) {
        Session session = sessionFactory.getObject().openSession();
        Group groupExist = (Group) session.merge(group);
        try {
            session.getTransaction().begin();
            session.save(groupExist);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Update group " + group.getName() + " success !");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Group get(Integer id) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(Group.class, id);
    }
}
