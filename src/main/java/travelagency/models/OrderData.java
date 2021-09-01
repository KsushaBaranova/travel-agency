package travelagency.models;

public class OrderData {
	private int idOrder;
	private int idUser;
	private int idTour;
	private boolean isPaid;
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdTour() {
		return idTour;
	}
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Override
	public String toString() {
		return "OrderData [idOrder=" + idOrder + ", idUser=" + idUser + ", idTour=" + idTour + ", isPaid=" + isPaid
				+ "]";
	}
}
