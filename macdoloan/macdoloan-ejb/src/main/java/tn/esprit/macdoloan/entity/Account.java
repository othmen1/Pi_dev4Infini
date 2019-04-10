package tn.esprit.macdoloan.entity;

import java.io.Serializable;
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
	public Account() {
		super();
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Withdrawal> getAccountWithdrawals() {
		return accountWithdrawals;
	}
	public void setAccountWithdrawals(Set<Withdrawal> accountWithdrawals) {
		this.accountWithdrawals = accountWithdrawals;
	}
	public Set<Deposit> getAccountDeposits() {
		return accountDeposits;
	}
	public void setAccountDeposits(Set<Deposit> accountDeposits) {
		this.accountDeposits = accountDeposits;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
