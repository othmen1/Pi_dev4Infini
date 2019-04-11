package tn.esprit.macdoloan.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Client extends User implements Serializable {
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Loan> clientLoans;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Appointment> clientAppointments;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Claim> clientClaims;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Account> clientAccounts;
	private static final long serialVersionUID = 1L;
	
	

}
