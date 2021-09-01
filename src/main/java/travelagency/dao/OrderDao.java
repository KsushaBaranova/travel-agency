package travelagency.dao;

import java.util.List;

import travelagency.models.OrderData;

public interface OrderDao {
	OrderData getOrderById (int id_order);
	List<OrderData> getOrdersForUser(int userId);
	boolean setOrder(OrderData orderData);
	List<OrderData> getAllOrders();
	boolean deleteOrder(int id_order);
	boolean updateOrder(OrderData orderData);
}
