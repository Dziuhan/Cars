package ua.dziuhan.service;

import ua.dziuhan.entities.OrderData;

import java.util.List;

public interface OrderService {

    void addOrder(OrderData orderData, String login, int idCar);

    List<OrderData> selectAllOrders();

    List<OrderData> selectAllOrdersByLogin(String login);

    List<OrderData> selectOrdersByState(String state);

    void updateStateOrder(OrderData order, String accept_order);

    OrderData selectOrderById(int id);

    List<OrderData> selectMayCloseOrder();
}
