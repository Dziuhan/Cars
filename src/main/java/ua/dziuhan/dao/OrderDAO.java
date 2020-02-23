package ua.dziuhan.dao;

import ua.dziuhan.entities.OrderData;
import ua.dziuhan.entities.UserData;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    List<OrderData> selectAllOrders();

    List<OrderData> selectAllOrdersByUser(UserData userData);

    OrderData selectOrderById(int id);

    List<OrderData> selectAllOrdersByState(String state);

    void addOrder(OrderData orderData);

    void updateOrder(OrderData orderData);

    List<OrderData> selectMaybeClosedOrders(Date date);
}
