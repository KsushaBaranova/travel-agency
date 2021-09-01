package travelagency.models;

import java.sql.Date;

public class TourData {
	private int idTour;
	private String nameTour;
	private String descriptionTour;
	private Date dateTour;
	private int price;
	private int city;
	private int hotel;
	
	public int getIdTour() {
		return idTour;
	}
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	public String getNameTour() {
		return nameTour;
	}
	public void setNameTour(String nameTour) {
		this.nameTour = nameTour;
	}
	public String getDescriptionTour() {
		return descriptionTour;
	}
	public void setDescriptionTour(String descriptionTour) {
		this.descriptionTour = descriptionTour;
	}
	public Date getDateTour() {
		return dateTour;
	}
	public void setDateTour(Date dateTour) {
		this.dateTour = dateTour;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "TourData [idTour=" + idTour + ", nameTour=" + nameTour + ", descriptionTour=" + descriptionTour
				+ ", dateTour=" + dateTour + ", price=" + price + ", city=" + city + ", hotel=" + hotel + "]";
	}
}
