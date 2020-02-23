package ua.dziuhan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.dziuhan.dao.CarDAO;
import ua.dziuhan.entities.CarData;


import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(CarData carData) {
        Session session= sessionFactory.getCurrentSession();
        session.persist(carData);
    }

    @Override
    public void updateCar(CarData carData) {
        Session session= sessionFactory.getCurrentSession();
        session.update(carData);
    }

    @Override
    public CarData selectCarById(int id) {
        Session session= sessionFactory.getCurrentSession();
        return (CarData) session.get(CarData.class,id);
    }

    @Override
    public List<String> selectAllProducersCar() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("select distinct producer from CarData ").list();
    }

    @Override
    public List<String> selectAllRanksCar() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("select distinct rank from CarData ").list();
    }

    @Override
    public List<CarData> selectAllCars() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("from CarData").list();
    }

    @Override
    public List<CarData> selectCarsByProducersRanks(String[] producers, String[] ranks) {
        Session session= sessionFactory.getCurrentSession();
        StringBuilder jpql = new StringBuilder("from CarData c where");
        if (producers != null) {
            jpql.append("(c.producer='" + producers[0] + "'");
            for (int i = 1; i < producers.length; i++) {
                 jpql.append("or c.producer='" + producers[i] + "'");
            }
            jpql.append(")");
            if (ranks != null) {
                jpql.append("AND");
                jpqlAppendRanks(jpql, ranks);
            }

        } else if (ranks != null) {
            jpqlAppendRanks(jpql, ranks);
        } else {
             return selectAllCars();
        }

        return session.createQuery(jpql.toString()).list();

    }

    private void jpqlAppendRanks(StringBuilder sql, String[] ranks) {
        sql.append("(c.rank='" + ranks[0] + "'");
        for (int i = 1; i < ranks.length; i++) {
            sql.append("or c.rank='" + ranks[i] + "'");
        }
        sql.append(")");
    }

    @Override
    public void deleteCarById(int id) {
        Session session= sessionFactory.getCurrentSession();
        CarData carData= (CarData) session.get(CarData.class,id);
        if(carData!=null){
            session.delete(carData);
        }
    }
}
