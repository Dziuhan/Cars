package ua.dziuhan.service.impl;

import org.springframework.stereotype.Service;
import ua.dziuhan.dao.OrderDAO;
import ua.dziuhan.dao.impl.CarDAOImpl;
import ua.dziuhan.dao.impl.UserDAOImpl;
import ua.dziuhan.entities.OrderData;
import ua.dziuhan.service.OrderService;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    private UserDAOImpl userDAO;

    private CarDAOImpl carDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void setCarDAO(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void addOrder(OrderData orderData, String login, int idCar) {
       orderData.setCarData(carDAO.selectCarById(idCar));
       orderData.setUserData(userDAO.selectUserByLogin(login));
       long days=(orderData.getFinishRent().getTime()-orderData.getStartRent().getTime())/ 1000 / 60 / 60 / 24 + 1;
       double priceTotal=days * (orderData.getCarData().getPrice());
       orderData.setPriceTotal(priceTotal);
       orderDAO.addOrder(orderData);
    }

    @Override
    public List<OrderData> selectAllOrders() {
        return orderDAO.selectAllOrders();
    }

    @Override
    public List<OrderData> selectAllOrdersByLogin(String login) {
        return orderDAO.selectAllOrdersByUser(userDAO.selectUserByLogin(login));

    }

    @Override
    public List<OrderData> selectOrdersByState(String state) {
        return orderDAO.selectAllOrdersByState(state);
    }

    @Override
    public void updateStateOrder(OrderData orderData, String state) {
        orderData.setState(state);
        orderDAO.updateOrder(orderData);
    }

    @Override
    public OrderData selectOrderById(int id) {
        return orderDAO.selectOrderById(id);
    }

    @Override
    public List<OrderData> selectMayCloseOrder() {
        return orderDAO.selectMaybeClosedOrders(new Date(Calendar.getInstance().getTimeInMillis()));
    }
}
