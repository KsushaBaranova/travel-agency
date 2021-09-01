package travelagency.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import travelagency.dao.HotelDao;
import travelagency.dbutils.DbHelper;
import travelagency.models.HotelData;

public class DefaultHotelDao implements HotelDao {
	private static final String GET_HOTEL_FROM_CITY = "SELECT h.id_hotel, h.name_hotel FROM hotel h \r\n"
			+ "JOIN  tour t ON t.id_hotel = h.id_hotel\r\n" + "WHERE t.id_city = ?;";
	private static final String GET_HOTEL_TYPE_FOOD = "SELECT h.id_hotel, h.name_hotel FROM hotel h\r\n" + 
			"JOIN type_of_food t ON h.id_type_food = t.id_typefood\r\n" + 
			"WHERE t.id_typefood = ?";
	private static final String GET_HOTEL_STAR = "SELECT h.id_hotel, h.name_hotel FROM hotel h\r\n" + 
			"JOIN star_hotel s ON h.id_star = s.id_star\r\n" + 
			"WHERE s.id_star = ?";

	private static DefaultHotelDao instance;
	private DbHelper dbHelper;

	private DefaultHotelDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static HotelDao getInstance() {
		if (instance == null) {
			instance = new DefaultHotelDao();
		}
		return instance;
	}

	// Список отелей определённого города
	public List<HotelData> getHotelsFromCity(int hotelId) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_HOTEL_FROM_CITY)) {
			ps.setInt(1, hotelId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setIdHotel(rs.getInt("id_hotel"));
				hotelData.setNameHotel(rs.getString("name_hotel"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}

	//Список отелей по типу питания
	@Override
	public List<HotelData> getHotelsTypeFood(int typrFoodId) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_HOTEL_TYPE_FOOD)) {
			ps.setInt(1, typrFoodId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setIdHotel(rs.getInt("id_hotel"));
				hotelData.setNameHotel(rs.getString("name_hotel"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}

	//Список отелей по кол-ву звёзд
	@Override
	public List<HotelData> getHotelsStar(int starId) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_HOTEL_STAR)) {
			ps.setInt(1, starId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setIdHotel(rs.getInt("id_hotel"));
				hotelData.setNameHotel(rs.getString("name_hotel"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}
}
