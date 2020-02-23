package ua.dziuhan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.dziuhan.dao.RoleDAO;
import ua.dziuhan.entities.RoleData;
@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RoleData selectRole(String role) {
        Session session= sessionFactory.getCurrentSession();
        return (RoleData) session.createQuery("from RoleData r where r.role=:role").setParameter("role",role).uniqueResult();
    }
}
