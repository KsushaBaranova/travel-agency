package travelagency.dao;

import java.util.List;

import travelagency.models.UserData;

public interface UserDao {
	UserData getUserById(int id);
	List<UserData> getAllUsers();
	boolean updateUser(UserData userData);
	boolean setUser(UserData userData);
	List<UserData> getClient();
	UserData getUserPasswordByEmail(String email);
	boolean deleteUser(int id);
}
