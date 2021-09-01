package travelagency.dao;

import java.sql.Date;
import java.util.List;

import travelagency.models.TourData;

public interface TourDao {
	List<TourData> getToursForUser(int userId);
	List<TourData> getAllTours();
	boolean setTour(TourData tourData);
	List<TourData> getToursFromCity(int cityId);
	List<TourData> getToursFromCountry(int countryId);
	List<TourData> getToursBetweenDate(Date date_start, Date date_end);
	List<TourData> getToursBetweenPrice(int start_price, int end_price);
	boolean deleteTour(int id_tour);
	boolean updateTour(TourData tourData);
	TourData getTourById(int tourId);
}
