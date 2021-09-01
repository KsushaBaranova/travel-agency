package travelagency.testjdbc;

import java.sql.SQLException;
import java.util.List;

import travelagency.dao.HotelDao;
import travelagency.dao.OrderDao;
import travelagency.dao.TourDao;
import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultHotelDao;
import travelagency.dao.impl.DefaultOrderDao;
import travelagency.dao.impl.DefaultTourDao;
import travelagency.dao.impl.DefaultUserDao;
import travelagency.models.HotelData;
import travelagency.models.OrderData;
import travelagency.models.TourData;
import travelagency.models.UserData;

public class TestJDBC {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

	//Вывод определённого пользователя
	UserDao userDao = DefaultUserDao.getInstance();
//	UserData user = userDao.getUserById(1);
//	System.out.println(user);
	
	//Вывод всех пользователей
	List<UserData> allUser = userDao.getAllUsers();
	System.out.println(allUser);
	
	//Удаление пользователя
	//System.out.println(userDao.deleteUser(8));
	
	//Изменение данных опр пользователя
	//System.out.println(userDao.updateUser(2, "Anastasia"));
	
	//Вывод определённого пользователя
	//UserData user1 = userDao.getUserById(2);
	//System.out.println(user1);
	
	//Вывод всех туров определёного пользователя
//	TourDao tourDao = DefaultTourDao.getInstance();
//	List<TourData> toursForUser = tourDao.getToursForUser(6);
//	System.out.println(toursForUser);
	
	//Вывод всех отелей определённого города
//	HotelDao hotelDao = DefaultHotelDao.getInstance();
//	List<HotelData> hotelFromCity = hotelDao.getHotelsFromCity(4);
//	System.out.println(hotelFromCity);
	
	//Добавление заказа
//	OrderDao orderDao = DefaultOrderDao.getInstance();
//	System.out.println(orderDao.setOrder(1, 1, true));

	//
//	OrderData order = orderDao.getOrderById(8);
//	System.out.println(order);

	//Вывод всех отелей в диапазоне стоимости
//	TourDao tourDao = DefaultTourDao.getInstance();
//	List<TourData> toursPrice = tourDao.getToursBetweenPrice(17000, 25000);
//	System.out.println(toursPrice);
	
	//Вывод всех отелей в диапазоне дат
//	TourDao tourDao = DefaultTourDao.getInstance();
//	List<TourData> toursPrice = tourDao.getToursBetweenDate(2019-01-02, 2019-12-11);
//	System.out.println(toursPrice);
	}
}