package travelagency.dao;

import java.util.List;

import travelagency.models.HotelData;

public interface HotelDao {
	List<HotelData> getHotelsFromCity(int hotelId);
	List<HotelData> getHotelsTypeFood(int typrFoodId);
	List<HotelData> getHotelsStar(int starId);
}
