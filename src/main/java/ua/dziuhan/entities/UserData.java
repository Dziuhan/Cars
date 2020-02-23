package ua.dziuhan.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="users")
public class UserData implements Serializable{
	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleData role;
	private boolean ban;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "userData")
	private List<OrderData> orders;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getLogin() {
		return login;
	}
	public void setLogin(java.lang.String login) {
		this.login = login;
	}

	public java.lang.String getPassword() {
		return password;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public RoleData getRole() {
		return role;
	}
	public void setRole(RoleData role) {
		this.role = role;
	}

	public boolean isBan() {
		return ban;
	}
	public void setBan(boolean ban) {
		this.ban = ban;
	}

	public List<OrderData> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderData> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "UserData{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				", ban=" + ban +
				", orders=" + orders +
				'}';
	}
}
