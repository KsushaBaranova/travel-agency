package travelagency.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import travelagency.dao.UserDao;
import travelagency.dbutils.DbHelper;
import travelagency.models.UserData;

public class DefaultUserDao implements UserDao {
	public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id_user=?";
	public static final String SELECT_ALL_USER = "SELECT id_user, name_user, lastname, "
			+ "date_of_birthd, email FROM user";
	public static final String UPDATE_USER = "UPDATE user SET name_user = ?, lastname =?,"
			+ "date_of_birthd=?, email=?, password =? WHERE id_user = ?";
	private static final String INSERT_USER = "INSERT INTO user (name_user, lastname,"
			+ "date_of_birthd, email, password, id_role)"
			+ "VALUES (?, ?, ?, ?, ?, ?);";
	public static final String SELECT_CLIENT = "SELECT u.id_user, u.name_user, u.lastname "
			+ "FROM user u \r\n" + 
			"JOIN role r ON r.id_role=u.id_role WHERE r.id_role = 2;";
	private static final String SELECT_USER_PASSWORD_BY_EMAIL = "SELECT password, id_role FROM user \r\n" + 
			"WHERE email=?";
	private static final String DELETE_USER = "DELETE FROM user WHERE id_user = ?";
	
	private static DefaultUserDao instance;
	private DbHelper dbHelper;

	private DefaultUserDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static UserDao getInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	// Вся инфа о пользователе (кроме пароля)
	@Override
	public UserData getUserById(int id) {
		try {
			UserData userData = null;
			try (Connection conn = dbHelper.getConnection();
					PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID)) {
				statement.setInt(1, id);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						userData = new UserData();
						userData.setId(rs.getInt("id_user"));
						userData.setName(rs.getString("name_user"));
						userData.setLastName(rs.getString("lastname"));
						userData.setEmail(rs.getString("email"));
						userData.setDayOfBirthd(rs.getDate("date_of_birthd"));
						userData.setPassword(rs.getString("password"));
						userData.setIdRole(rs.getInt("id_role"));
					}
				}
			}
			return userData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Список всех пользователей (имя и фамилия)
	@Override
	public List<UserData> getAllUsers() {
		List<UserData> users = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USER)) {

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				UserData userData = new UserData();
				userData.setId(rs.getInt("id_user"));
				userData.setName(rs.getString("name_user"));
				userData.setLastName(rs.getString("lastname"));
				userData.setEmail(rs.getString("email"));
				userData.setDayOfBirthd(rs.getDate("date_of_birthd"));
				users.add(userData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return users;
	}

	// Обновление данных пользователя
	@Override
	public boolean updateUser(UserData userData) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_USER)) {
			statement.setInt(6, userData.getId());
			statement.setString(1, userData.getName());
			statement.setString(2, userData.getLastName());
			statement.setDate(3, userData.getDayOfBirthd());
			statement.setString(4, userData.getEmail());
			statement.setString(5, userData.getPassword());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Добавление пользователя
	@Override
	public boolean setUser(UserData userData) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(INSERT_USER)) {
			statement.setString(1, userData.getName());
			statement.setString(2, userData.getLastName());
			statement.setDate(3, userData.getDayOfBirthd());
			statement.setString(4, userData.getEmail());
			statement.setString(5, userData.getPassword());
			statement.setInt(6, userData.getIdRole());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//Список клиентов
	@Override
	public List<UserData> getClient() {
		List<UserData> users = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_CLIENT)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				UserData userData = new UserData();
				userData.setId(rs.getInt("id_user"));
				userData.setName(rs.getString("name_user"));
				userData.setLastName(rs.getString("lastname"));
				users.add(userData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return users;
	}

	//Возвращает пароль по email
	@Override
	public UserData getUserPasswordByEmail(String email) {
		try {
			UserData userData = null;
			try (Connection conn = dbHelper.getConnection();
					PreparedStatement statement = conn.prepareStatement(SELECT_USER_PASSWORD_BY_EMAIL)) {
				statement.setString(1, email);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						userData = new UserData();
						userData.setPassword(rs.getString("password"));
						userData.setIdRole(rs.getInt("id_role"));
					}
				}
			}
			return userData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deleteUser(int id) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USER)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}