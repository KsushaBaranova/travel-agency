package travelagency.models;

public class CountryData {
	private int idCountry;
	private String nameCountry;
	
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	public String getNameCountry() {
		return nameCountry;
	}
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	@Override
	public String toString() {
		return "CountryData [idCountry=" + idCountry + ", nameCountry=" + nameCountry + "]";
	}
}
