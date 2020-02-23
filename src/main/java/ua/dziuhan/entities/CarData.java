package ua.dziuhan.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cars")
public class CarData implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String producer;

	private String make;

	@Column(name = "rang")
	private String rank;

	private int year;

	private double price;

	private String imageLocAdress;

	private boolean active; // Fix, not used

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "carData") //   ?????????????
	private Set<ReviewAboutCarData> reviewAboutCarDataSet;

	public Set<ReviewAboutCarData> getReviewAboutCarDataSet() {
		return reviewAboutCarDataSet;
	}
	public void setReviewAboutCarDataSet(Set<ReviewAboutCarData> reviewAboutCarDataSet) {
		this.reviewAboutCarDataSet = reviewAboutCarDataSet;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageLocAdress() {
		return imageLocAdress;
	}
	public void setImageLocAdress(String imageLocAdress) {
		this.imageLocAdress = imageLocAdress;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", producer=" + producer + ", make=" + make
				+ ", rank=" + rank + ", year=" + year + ", price=" + price
				+ ", imageLocAdress=" + imageLocAdress + "]";
	}

}
