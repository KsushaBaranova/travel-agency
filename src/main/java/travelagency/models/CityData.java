package travelagency.models;

public class CityData {
	private int idCity;
	private String nameCity;
	private int idCountry;
	
	public int getIdCity() {
		return idCity;
	}
	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}
	public String getNameCity() {
		return nameCity;
	}
	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	@Override
	public String toString() {
		return "CityData [idCity=" + idCity + ", nameCity=" + nameCity + ", idCountry=" + idCountry + "]";
	}
}
