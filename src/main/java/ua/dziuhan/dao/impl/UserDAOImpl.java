package ua.dziuhan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.dziuhan.dao.UserDAO;
import ua.dziuhan.entities.UserData;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private static final String SQL_SELECT_USER = "SELECT * FROM users left join roles on role_id=roles.id where login=";

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserData> selectAllUsers() {
        Session session= sessionFactory.getCurrentSession();
        return  session.createQuery("from UserData").list();
    }

    @Override
    public UserData selectUserByLogin(String login) {
        Session session= sessionFactory.getCurrentSession();
        return (UserData) session.createQuery("from UserData u where u.login=:login").setParameter("login",login).uniqueResult();
    }

    @Override
    public List<UserData> searchUserByLogin(String login) {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("from UserData u where u.login LIKE :login").setParameter("login",login).list();// Чиниить
    }

    @Override
    public void addUser(UserData user){
        Session session= sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(UserData userData) {
        Session session=sessionFactory.getCurrentSession();
        session.update(userData);
    }
}
