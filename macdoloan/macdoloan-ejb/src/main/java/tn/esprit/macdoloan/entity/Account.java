package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity

@Table(name = "Account")
public class Account implements Serializable {
	@ManyToOne
	Client client ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="account")
	private Set<Withdrawal> accountWithdrawals;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="account")
	private Set<Deposit> accountDeposits;
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "Balance")
	private float balance;
	@Column(name = "Type")
	private String type;
	@Column(name = "RIB")
	private String RIB;
	@Column(name = "OpeningDate")
	@Temporal(TemporalType.DATE)
	private Date OpeningDate;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRIB() {
		return RIB;
	}
	public void setRIB(String rIB) {
		RIB = rIB;
	}
	public Date getOpeningDate() {
		return OpeningDate;
	}
	public void setOpeningDate(Date openingDate) {
		OpeningDate = openingDate;
	}
   
}
