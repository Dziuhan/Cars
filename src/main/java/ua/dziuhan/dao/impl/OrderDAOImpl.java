package ua.dziuhan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.dziuhan.dao.OrderDAO;
import ua.dziuhan.entities.OrderData;
import ua.dziuhan.entities.UserData;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;
@Repository
public class OrderDAOImpl implements OrderDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

      @Override
    public List<OrderData> selectAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderData").list();
    }

    @Override
    public List<OrderData> selectAllOrdersByUser(UserData userData) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderData o where o.userData.id=:id_user").setParameter("id_user",userData.getId()).list();
    }

    @Override
    public OrderData selectOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (OrderData) session.createQuery("from OrderData o where o.id=:id").setParameter("id",id).uniqueResult();
    }

    @Override
    public List<OrderData> selectAllOrdersByState(String state) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderData o where o.state=:state").setParameter("state",state).list();
    }

   @Override
    public void addOrder(OrderData orderData) {
       Session session = sessionFactory.getCurrentSession();
       session.persist(orderData);
   }

    @Override
    public void updateOrder(OrderData orderData) {
        Session session = sessionFactory.getCurrentSession();
        session.update(orderData);
    }

    @Override
    public List<OrderData> selectMaybeClosedOrders(Date date) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderData o where o.finishRent<:date and o.state='paid order'").setParameter("date",date).list();
    }
}
