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
	Client client;
	@ManyToOne
	Agent agentOppenAccount;
	@ManyToOne
	Agent agentCloseAccount;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private Set<Withdrawal> accountWithdrawals;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
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
	@Column(name = "IsClosed")
	private boolean isclosed;

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

	// rIB DOIT CONTENIR 13 DIGIT
	public void setRIB(String rIB) {
		RIB = "TN59 10 006 " + rIB + " 31";
	}

	public Date getOpeningDate() {
		return OpeningDate;
	}

	public void setOpeningDate(Date openingDate) {
		OpeningDate = openingDate;
	}

	public Agent getAgentOppenAccount() {
		return agentOppenAccount;
	}

	public void setAgentOppenAccount(Agent agentOppenAccount) {
		this.agentOppenAccount = agentOppenAccount;
	}

	public Agent getAgentCloseAccount() {
		return agentCloseAccount;
	}

	public void setAgentCloseAccount(Agent agentCloseAccount) {
		this.agentCloseAccount = agentCloseAccount;
	}

	public boolean isIsclosed() {
		return isclosed;
	}

	public void setIsclosed(boolean isclosed) {
		this.isclosed = isclosed;
	}
	
	

}
