package ua.dziuhan.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class OrderData implements Serializable {
	private static final long serialVersionUID = 2L;

	public static final String STATE_NEW_ORDER="new order";	
	public static final String STATE_WAITING_FOR_PAYMENT="waiting for payment";
	public static final String STATE_PAID="paid";
	public static final String STATE_REJECTED="rejected";
	public static final String STATE_CLOSED="closed";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private  UserData userData;
	@ManyToOne
	@JoinColumn(name = "car_id")
	private CarData carData;
	@Column(name = "start_rent" )
	private Date startRent;
	@Column(name = "finish_rent")
	private Date finishRent;
	private String state = "new order";
	private double priceTotal;
	private double priceCrush;
	private boolean driver;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	public CarData getCarData() {
		return carData;
	}
	public void setCarData(CarData carData) {
		this.carData = carData;
	}

	public Date getStartRent() {
		return startRent;
	}
	public void setStartRent(Date startRent) {
		this.startRent = startRent;
	}

	public Date getFinishRent() {
		return finishRent;
	}
	public void setFinishRent(Date finishRent) {
		this.finishRent = finishRent;
	}

	public boolean isDriver() {
		return driver;
	}
	public void setDriver(boolean driver) {
		this.driver = driver;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public double getPriceCrush() {
		return priceCrush;
	}
	public void setPriceCrush(double priceCrush) {
		this.priceCrush = priceCrush;
	}

	@Override
	public String toString() {
		return "OrderData{" +
				"id=" + id +
				", userData=" + userData +
				", carData=" + carData +
				", startRent=" + startRent +
				", finishRent=" + finishRent +
				", driver=" + driver +
				", state='" + state + '\'' +
				", priceTotal=" + priceTotal +
				", priceCrush=" + priceCrush +
				'}';
	}
}
