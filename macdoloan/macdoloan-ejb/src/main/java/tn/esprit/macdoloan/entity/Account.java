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
   
}
