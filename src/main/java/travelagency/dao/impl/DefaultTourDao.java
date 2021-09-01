package travelagency.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import travelagency.dao.TourDao;
import travelagency.dbutils.DbHelper;
import travelagency.models.TourData;

public class DefaultTourDao implements TourDao {
	private static final String SELECT_TOURS_FOR_USER = "SELECT t.id_tour, t.name_tour, t.price"
			+ " FROM tour t \r\n JOIN orders o ON t.id_tour = o.id_tour\r\n" + 
			"WHERE o.id_user = ?";
	public static final String SELECT_ALL_TOURS = "SELECT * FROM tour";
	private static final String INSERT_TOUR = "INSERT INTO tour (name_tour, tour_description,"
			+ "date_tour, price, id_city, id_hotel)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_TOURS_FROM_CITY = "SELECT  t.id_tour, t.name_tour,"
			+ " t.tour_description, t.date_tour, t.price, t.id_hotel"
			+ " FROM tour t \r\n JOIN  city c ON c.id_city = t.id_city\r\n" + 
			"WHERE c.id_city = ?";
	private static final String SELECT_TOURS_FROM_COUNTRY = "SELECT t.id_tour, t.name_tour, "
			+ "t.tour_description, t.date_tour, t.price, t.id_hotel FROM tour t \r\n" + 
			"JOIN  city c ON c.id_city = t.id_city\r\n" + 
			"JOIN country con ON con.id_country=c.id_country\r\n" + 
			"WHERE con.id_country = ?";
	private static final String SELECT_TOUR_BETWEEN_DATE = "SELECT t.id_tour, t.name_tour, t.tour_description, t.date_tour, t.price, t.id_hotel \r\n" + 
			"FROM tour t \r\n" + 
			"WHERE t.date_tour BETWEEN '?' AND '?'";
	private static final String SELECT_TOUR_BETWEEN_PRICE = "SELECT * FROM tour t \r\n" + 
			"WHERE t.price BETWEEN ? AND ?";
private static final String DELETE_TOUR = "DELETE FROM tour WHERE id_tour = ?";
private static final String UPDATE_TOUR = "UPDATE tour SET name_tour = ?, tour_description =?, \r\n" + 
		"date_tour=?, price=?, id_city =?, id_hotel=?  WHERE id_tour = ?";
private static final String SELECT_TOUR_BY_ID = "SELECT * FROM tour WHERE id_tour=?";

	
	

	private static DefaultTourDao instance;
	private DbHelper dbHelper;

	private DefaultTourDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static TourDao getInstance() {
		if (instance == null) {
			instance = new DefaultTourDao();
		}
		return instance;
	}
	
	//Список туров определённого пользователя
	@Override
	public List<TourData> getToursForUser(int userId) {
		List<TourData> tours = new ArrayList<TourData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_TOURS_FOR_USER)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setNameTour(rs.getString("name_tour"));
				tours.add(tourData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tours;
	}
	
	//Список всех туров
	@Override
	public List<TourData> getAllTours(){
		List<TourData> tours = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_TOURS)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setNameTour(rs.getString("name_tour"));
				tourData.setDescriptionTour(rs.getString("tour_description"));
				tourData.setDateTour(rs.getDate("date_tour"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setCity(rs.getInt("id_city"));
				tourData.setHotel(rs.getInt("id_hotel"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}
	
	//Добавление тура
		@Override
		public boolean setTour(TourData tourData) {
			try (Connection conn = dbHelper.getConnection();
					PreparedStatement statement = conn.prepareStatement(INSERT_TOUR)) {
				statement.setString(1, tourData.getNameTour());
				statement.setString(2, tourData.getDescriptionTour());
				statement.setDate(3, tourData.getDateTour());
				statement.setInt(4, tourData.getPrice());
				statement.setInt(5, tourData.getCity());
				statement.setInt(6, tourData.getHotel());
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

    //Список туров из определёного города
	@Override
	public List<TourData> getToursFromCity(int cityId) {
		List<TourData> tours = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOURS_FROM_CITY)) {
			statement.setInt(1, cityId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setNameTour(rs.getString("name_tour"));
				tourData.setDescriptionTour(rs.getString("tour_description"));
				tourData.setDateTour(rs.getDate("date_tour"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setHotel(rs.getInt("id_hotel"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}
	
	//Список туров из определёной страны
	@Override
	public List<TourData> getToursFromCountry(int countryId) {
		List<TourData> tours = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOURS_FROM_COUNTRY)) {
			statement.setInt(1, countryId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setNameTour(rs.getString("name_tour"));
				tourData.setDescriptionTour(rs.getString("tour_description"));
				tourData.setDateTour(rs.getDate("date_tour"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setHotel(rs.getInt("id_hotel"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<TourData> getToursBetweenDate(Date date_start, Date date_end) {
		List<TourData> tours = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BETWEEN_DATE)) {
			statement.setDate(1, date_start);
			statement.setDate(2, date_end);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setNameTour(rs.getString("name_tour"));
				tourData.setDescriptionTour(rs.getString("tour_description"));
				tourData.setDateTour(rs.getDate("date_tour"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setCity(rs.getInt("id_city"));
				tourData.setHotel(rs.getInt("id_hotel"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	//Список туров по диапазону прайса
	@Override
	public List<TourData> getToursBetweenPrice(int start_price, int end_price) {
		List<TourData> tours = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BETWEEN_PRICE)) {
			statement.setInt(1, start_price);
			statement.setInt(2, end_price);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setNameTour(rs.getString("name_tour"));
				tourData.setDescriptionTour(rs.getString("tour_description"));
				tourData.setDateTour(rs.getDate("date_tour"));
				tourData.setPrice(rs.getInt("price"));
				tourData.setCity(rs.getInt("id_city"));
				tourData.setHotel(rs.getInt("id_hotel"));
				tours.add(tourData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public boolean deleteTour(int id_tour) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_TOUR)) {
			statement.setInt(1, id_tour);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTour(TourData tourData) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_TOUR)) {
			statement.setInt(7, tourData.getIdTour());
			statement.setString(1, tourData.getNameTour());
			statement.setString(2, tourData.getDescriptionTour());
			statement.setDate(3, tourData.getDateTour());
			statement.setInt(4, tourData.getPrice());
			statement.setInt(5, tourData.getCity());
			statement.setInt(6, tourData.getHotel());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public TourData getTourById(int tourId) {
		try {
			TourData tourData = null;
			try (Connection conn = dbHelper.getConnection();
					PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_ID)) {
				statement.setInt(1, tourId);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						tourData=new TourData();
						tourData.setIdTour(rs.getInt("id_tour"));
						tourData.setNameTour(rs.getString("name_tour"));
						tourData.setDescriptionTour(rs.getString("tour_description"));
						tourData.setDateTour(rs.getDate("date_tour"));
						tourData.setPrice(rs.getInt("price"));
						tourData.setCity(rs.getInt("id_city"));
						tourData.setHotel(rs.getInt("id_hotel"));
					}
				}
			}
			return tourData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
