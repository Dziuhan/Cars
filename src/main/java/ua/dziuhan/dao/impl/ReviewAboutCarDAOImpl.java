package ua.dziuhan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.dziuhan.dao.ReviewAboutCarDAO;
import ua.dziuhan.entities.CarData;
import ua.dziuhan.entities.ReviewAboutCarData;

import java.util.List;

@Repository
public class ReviewAboutCarDAOImpl implements ReviewAboutCarDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addReviewAboutCar(ReviewAboutCarData reviewAboutCarData) {
        Session session= sessionFactory.getCurrentSession();
        session.persist(reviewAboutCarData);
    }

    @Override
    public List<ReviewAboutCarData> selectAllReviewsAboutCar(CarData carData) {
        Session session= sessionFactory.getCurrentSession();
        System.out.println(carData);
        String par=new String(String.valueOf(carData.getId()));
        return session.createQuery("from ReviewAboutCarData r where r.carData.id=:carData").setParameter("carData",carData.getId()).list();// Fix
    }

}
