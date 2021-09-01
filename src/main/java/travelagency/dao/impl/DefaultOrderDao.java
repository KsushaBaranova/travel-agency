package travelagency.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import travelagency.dao.OrderDao;
import travelagency.dbutils.DbHelper;
import travelagency.models.OrderData;

public class DefaultOrderDao implements OrderDao{
	public static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id_order=?";
	private static final String SELECT_ORDERS_FOR_USER = "SELECT o.id_order, o.id_tour, o.id_user "
			+ "FROM orders o \r\n" + 
			"JOIN user u ON o.id_user = u.id_user\r\n" + 
			"WHERE u.id_user = ?";
	private static final String INSERT_ORDER = "INSERT INTO orders (id_user, id_tour, is_paid)"
			+ "VALUES (?, ?, ?);";
	public static final String SELECT_ALL_ORDERS = "SELECT id_order, id_user, id_tour FROM orders";
	private static final String DELETE_ORDER = "DELETE FROM orders WHERE id_order = ?";
	private static final String UPDATE_ORDER = "UPDATE orders SET id_user = ?, id_tour =?, \r\n" + 
			"is_paid=?  WHERE id_order = ?";
	
	private static DefaultOrderDao instance;
	private DbHelper dbHelper;

	private DefaultOrderDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static OrderDao getInstance() {
		if (instance == null) {
			instance = new DefaultOrderDao();
		}
		return instance;
	}

	// Информация о заказе по id заказа
	@Override
	public OrderData getOrderById(int id_order) {
		try {
			OrderData orderData = null;
			try (Connection conn = dbHelper.getConnection();
					PreparedStatement statement = conn.prepareStatement(SELECT_ORDER_BY_ID)) {
				statement.setInt(1, id_order);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						orderData = new OrderData();
						orderData.setIdOrder(rs.getInt("id_order"));
						orderData.setIdUser(rs.getInt("id_user"));
						orderData.setIdTour(rs.getInt("id_tour"));
						orderData.setPaid(rs.getBoolean("is_paid"));
					}
				}
			}
			return orderData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//Список заказов определённого пользователя
	@Override
	public List<OrderData> getOrdersForUser(int userId) {
		List<OrderData> orders = new ArrayList<OrderData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_ORDERS_FOR_USER)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setIdOrder(rs.getInt("id_order"));
				orderData.setIdUser(rs.getInt("id_user"));
				orderData.setIdTour(rs.getInt("id_tour"));
				orders.add(orderData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return orders;
	}
	
	//Добавление заказа
	@Override
	public boolean setOrder(OrderData orderData) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(INSERT_ORDER)) {
			statement.setInt(1, orderData.getIdUser());
			statement.setInt(2, orderData.getIdTour());
			statement.setBoolean(3, orderData.isPaid());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Список всех заказов
	@Override
	public List<OrderData> getAllOrders(){
		List<OrderData> orders = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ORDERS)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				OrderData orderData = new OrderData();
				orderData.setIdOrder(rs.getInt("id_order"));
				orderData.setIdUser(rs.getInt("id_user"));
				orderData.setIdTour(rs.getInt("id_tour"));
				orders.add(orderData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return orders;
	}

	@Override
	public boolean deleteOrder(int id_order) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_ORDER)) {
			statement.setInt(1, id_order);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOrder(OrderData orderData) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_ORDER)) {
			statement.setInt(4, orderData.getIdOrder());
			statement.setInt(1, orderData.getIdUser());
			statement.setInt(2, orderData.getIdTour());
			statement.setBoolean(3, orderData.isPaid());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
