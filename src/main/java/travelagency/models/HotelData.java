package travelagency.models;

public class HotelData {
	private int idHotel;
	private String nameHotel;
	private String descriptionHotel;
	private int idStar;
	private int idTypeFood;
	
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public String getNameHotel() {
		return nameHotel;
	}
	public void setNameHotel(String nameHotel) {
		this.nameHotel = nameHotel;
	}
	public String getDescriptionHotel() {
		return descriptionHotel;
	}
	public void setDescriptionHotel(String descriptionHotel) {
		this.descriptionHotel = descriptionHotel;
	}
	public int getIdStar() {
		return idStar;
	}
	public void setIdStar(int idStar) {
		this.idStar = idStar;
	}
	public int getIdTypeFood() {
		return idTypeFood;
	}
	public void setIdTypeFood(int idTypeFood) {
		this.idTypeFood = idTypeFood;
	}
	@Override
	public String toString() {
		return "HotelData [idHotel=" + idHotel + ", nameHotel=" + nameHotel + ", descriptionHotel=" + descriptionHotel
				+ ", idStar=" + idStar + ", idTypeFood=" + idTypeFood + "]" + "\n";
	}
}
